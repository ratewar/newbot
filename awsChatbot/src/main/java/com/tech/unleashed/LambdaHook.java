package com.tech.unleashed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.tech.unleashed.pojo.common.Slots;
import com.tech.unleashed.pojo.enums.DialogActionTypeEnum;
import com.tech.unleashed.pojo.enums.InvocationSourceEnum;
import com.tech.unleashed.pojo.request.Request;
import com.tech.unleashed.pojo.response.DialogAction;
import com.tech.unleashed.pojo.response.Message;
import com.tech.unleashed.pojo.response.Response;
import com.tech.unleashed.pojo.response.ValidationResult;

public class LambdaHook implements RequestHandler<Request, Response> {
	LambdaLogger logger;
	public ValidationResult validateOrderFlowers(String flowerType, String date, String time){
		List<String> flowerTypes = getFlowerTypes();
		if (flowerType == null || !flowerTypes.contains(flowerType.toLowerCase())){
			return buildValidationResult(false, "FlowerType", "We do not have " + flowerType + ", would you like a different type of flower?  Our most popular flowers are roses");
		}
		if (date != null && date.trim().length() > 0){
			if (!isValidDate(date))
			{
				return buildValidationResult(false, "PickupDate", "I did not understand that, what date would you like to pick the flowers up?");
			}
			if (parseDate(date).compareTo(new Date()) == -1 || parseDate(date).compareTo(new Date()) ==0)
			{
				return buildValidationResult(false, "PickupDate", "You can pick up the flowers from tomorrow onwards.  What day would you like to pick them up?");
			}
		}
		if (time != null && time.trim().length() > 0){
			if (time.length() != 5) {
				// Not a valid time; use a prompt defined on the build-time model.
				return buildValidationResult(false, "PickupTime", null);
			}
			String[] timeArray = time.split(":");
			int hour = Integer.parseInt(timeArray[0]);
			int minute = Integer.parseInt(timeArray[1]);
			if (hour < 10 || hour > 16) {
				// Outside of business hours
				return buildValidationResult(false, "PickupTime", "Our business hours are from ten a m. to five p m. Can you specify a time during this range?");
			}
		}
		return buildValidationResult(true, null, null);
	}
	private List<String> getFlowerTypes() {
		List<String> flowerTypes= new ArrayList<String>();
		flowerTypes.add("lilies");
		flowerTypes.add("roses");
		flowerTypes.add("tulips");
		return flowerTypes;
	}
	public boolean isValidDate(String date) {
		try {
			parseDate(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Date parseDate(String date) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date1;
	}
	private ValidationResult buildValidationResult(boolean isValid, String violatedSlot, String messageContent) {
		ValidationResult validationResult = new ValidationResult();

		if(messageContent != null)
		{
			Message message = new Message();
			message.setContent(messageContent);
			message.setContentType("PlainText");
			validationResult.setMessage(message);
		}
		validationResult.setValid(isValid);
		validationResult.setViolatedSlot(violatedSlot);
		return validationResult;
	}
	/**
	 * Performs dialog management and fulfillment for ordering flowers.
	 * Beyond fulfillment, the implementation of this intent demonstrates the use of the elicitSlot dialog action
	 * in slot validation and re-prompting.
	 * @param requestObject
	 * @return responseObject
	 */
	public Response orderFlowers(Request requestObject) {
		Slots slots = requestObject.getCurrentIntent().getSlots();
		String flowerType = slots.getFlowerType();
		String date = slots.getPickupDate();
		String time = slots.getPickupTime();
		String invocationSource = requestObject.getInvocationSource();
		if(invocationSource.equalsIgnoreCase(InvocationSourceEnum.DIALOG_CODE_HOOK.getInvocationSource()))
		{
			ValidationResult validationResult = validateOrderFlowers(flowerType, date, time);
			if(!validationResult.isValid())
			{
				if(validationResult.getViolatedSlot().equalsIgnoreCase("FlowerType"))
				{
					slots.setFlowerType(null);
				}
				else if (validationResult.getViolatedSlot().equalsIgnoreCase("PickupDate"))
				{
					slots.setPickupDate(null);
				}
				else if(validationResult.getViolatedSlot().equalsIgnoreCase("PickupTime"))
				{
					slots.setPickupTime(null);
				}
				return elicitSlot(requestObject.getSessionAttributes(),
						requestObject.getCurrentIntent().getName(),
						slots,
						validationResult.getViolatedSlot(),
						validationResult.getMessage());
			}
			Map<String,String> outputSessionAttributes = requestObject.getSessionAttributes();
			if(flowerType != null && flowerType.trim().length() > 0)
			{
				String price = String.valueOf(flowerType.length() * 5);
				outputSessionAttributes.put("Price", price); // Elegant pricing model
			}
			return delegate(outputSessionAttributes, slots);

		}
		return close(requestObject.getSessionAttributes(),
				"Fulfilled",
				"Thanks, your order for " + flowerType + " has been placed and will be ready for pickup by " + time + " on " + date);
	}
	public Response close(Map<String, String> outputSessionAttributes, String fulfillmentState,String messageContent)
	{
		Response responseObject = new Response();
		responseObject.setSessionAttributes(outputSessionAttributes);
		DialogAction dialogAction = new DialogAction();
		dialogAction.setType(DialogActionTypeEnum.CLOSE.getType());
		dialogAction.setFulfillmentState(fulfillmentState);
		Message message = new Message();
		message.setContentType("Plain/Text");
		message.setContent("messageContent");
		dialogAction.setMessage(message);
		responseObject.setDialogAction(dialogAction);
		return responseObject;
	}
	public Response delegate(Map<String, String> outputSessionAttributes, Slots slots) {
		Response responseObject = new Response();
		responseObject.setSessionAttributes(outputSessionAttributes);
		DialogAction dialogAction = new DialogAction();
		dialogAction.setType(DialogActionTypeEnum.DELEGATE.getType());
		dialogAction.setSlots(slots);
		responseObject.setDialogAction(dialogAction);
		return responseObject;
	}
	public Response elicitSlot(Map<String, String> sessionAttributes,
							   String intentName,
							   Slots slots,
							   String violatedSlot,
							   Message message) {
		Response responseObject = new Response();
		responseObject.setSessionAttributes(sessionAttributes);
		DialogAction dialogAction = new DialogAction();
		dialogAction.setType(DialogActionTypeEnum.ELICIT_SLOT.getType());
		dialogAction.setIntentName(intentName);
		dialogAction.setSlots(slots);
		dialogAction.setSlotToElicit(violatedSlot);
		dialogAction.setMessage(message);
		responseObject.setDialogAction(dialogAction);
		return responseObject;
	}
	public Response dispatch(Request requestObject){
		String intentName = requestObject.getCurrentIntent().getName();
		logger.log("Method dispatch - " + requestObject.getUserId() + " CurrentIntent : " + intentName);
		if(intentName != null && intentName.equalsIgnoreCase("OrderFlowers"))
		{
			return orderFlowers(requestObject);
		}
		throw new RuntimeException("Intent with name - " + intentName + " not supported");
	}
	@Override
	public Response handleRequest(Request requestObject, Context context) {
		Response responseObject = null;
		try{
			logger = context.getLogger();
			logger.log("Bot Name : " + requestObject.getBot().getName());
			responseObject = dispatch(requestObject);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseObject;
	}

	/**
	 * Converts the context to a String.
	 * @param context Context to be converted.
	 * @return String containing the context parameters.
	 */
	public static String contextToString(Context context) {
		//this is a sample code
		StringBuilder sb = new StringBuilder();
		sb.append("{awsRequestId=").append(context.getAwsRequestId()).append("},");
		sb.append("{functionName=").append(context.getFunctionName()).append("},");
		sb.append("{functionVersion=").append(context.getFunctionVersion()).append("},");
		sb.append("{invokedFunctionArn=").append(context.getInvokedFunctionArn()).append("},");
		sb.append("{logGroupName=").append(context.getLogGroupName()).append("},");
		sb.append("{logStreamName=").append(context.getLogStreamName()).append("},");
		sb.append("{memoryLimitMB=").append(context.getMemoryLimitInMB()).append("},");
		sb.append("{remainingTimeInMillis=").append(context.getRemainingTimeInMillis()).append("}");
		return sb.toString();
	}
}