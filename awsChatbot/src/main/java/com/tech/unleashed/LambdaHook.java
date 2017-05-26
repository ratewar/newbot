package com.tech.unleashed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.test.entity.InvocationSourceEnum;
import com.test.entity.Request;
import com.test.entity.Slot;
import com.test.entity.ValidationResult;
import com.test.entity.response.format.Response;

public class LambdaHook implements RequestHandler<Request, Response> {
	LambdaLogger logger;
	private ValidationResult validateOrderFlowers(String flowerType, String date, String time){
		List<String> flowerTypes= new ArrayList<String>();
		flowerTypes.add("lilies");
		flowerTypes.add("roses");
		flowerTypes.add("tulips");
		if (!flowerTypes.contains(flowerType.toLowerCase())) {
	        return buildValidationResult(false, "FlowerType", "We do not have " + flowerType + ", would you like a different type of flower?  Our most popular flowers are roses");
	    }
		if (date != null && date.trim().length() > 0) {
	        if (!isValidDate(date)) {
	            return buildValidationResult(false, "PickupDate", "I did not understand that, what date would you like to pick the flowers up?");
	        }
	        if (parseDate(date).compareTo(new Date()) == -1 || parseDate(date).compareTo(new Date()) ==0) {
	            return buildValidationResult(false, "PickupDate", "You can pick up the flowers from tomorrow onwards.  What day would you like to pick them up?");
	        }
	    }
		if (time != null && time.trim().length() > 0) {
	        if (time.length() != 5) {
	            // Not a valid time; use a prompt defined on the build-time model.
	            return buildValidationResult(false, "PickupTime", null);
	        }
	        int hour = Integer.parseInt(time.substring(0, 2));
	        int minute = Integer.parseInt(time.substring(3));
	        if (hour < 10 || hour > 16) {
	            // Outside of business hours
	            return buildValidationResult(false, "PickupTime", "Our business hours are from ten a m. to five p m. Can you specify a time during this range?");
	        }
		}
		return buildValidationResult(true, null, null);
	}
	private boolean isValidDate(String date) {
	    try {
	    	parseDate(date);
	    	return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	private Date parseDate(String date) {
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
			validationResult.setMessage(messageContent);
		validationResult.setValid(isValid);
		validationResult.setViolatedSlot(violatedSlot);
		return validationResult;
	}
	public Response orderFlowers(Request requestObject) {
		String flowerType = requestObject.getCurrentIntent().getSlots().getFlowerType();
		String date = requestObject.getCurrentIntent().getSlots().getFlowerType();
		String time = requestObject.getCurrentIntent().getSlots().getFlowerType();
		String source = requestObject.getInvocationSource();
		if(source.equalsIgnoreCase(InvocationSourceEnum.DIALOG_CODE_HOOK.getInvocationSource()))
		{
			Slot slot = requestObject.getCurrentIntent().getSlots();
			ValidationResult validationResult = validateOrderFlowers(flowerType, date, time);
			if(!validationResult.isValid()) {
				if(validationResult.getViolatedSlot().equalsIgnoreCase("FlowerType"))
				{
					slot.setFlowerType(null);
				}
				else if (validationResult.getViolatedSlot().equalsIgnoreCase("PickupDate"))
				{
					slot.setPickupDate(null);
				}
				else if(validationResult.getViolatedSlot().equalsIgnoreCase("PickupTime"))
				{
					slot.setPickupTime(null);
				}
				return elicitSlot(requestObject.getSessionAttributes(), requestObject.getCurrentIntent().getName(), slot, validationResult.getViolatedSlot(), validationResult.getMessage());
			}
			Map<String,String> outputSessionAttributes = requestObject.getSessionAttributes();
			if(flowerType != null && flowerType.trim().length() > 0)
			{
				String price = String.valueOf(flowerType.length() * 5);  
				outputSessionAttributes.put("Price", price); // Elegant pricing model
			}
			delegate(outputSessionAttributes, requestObject.getCurrentIntent().getSlots());
			return;
		}
		close(requestObject.getSessionAttributes(), "Fulfilled",  { contentType: 'PlainText', content: `Thanks, your order for ${flowerType} has been placed and will be ready for pickup by ${time} on ${date}` }));
	}
	private void delegate(Map<String, String> outputSessionAttributes, Slot slots) {
		// TODO Auto-generated method stub
		
	}
	private Response elicitSlot(Map<String, String> sessionAttributes, String name, Slot slot, String violatedSlot, String message) {
	
		return null;
	}
	public Response dispatch(Request requestObject){
		String intentName = requestObject.getCurrentIntent().getName();
		logger.log("Method dispatch - " + requestObject.getUserId() + " CurrentIntent : " + intentName);
		if(intentName.equalsIgnoreCase("OrderFlowers"))
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
			responseObject = dispatch(requestObject,responseObject);
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

