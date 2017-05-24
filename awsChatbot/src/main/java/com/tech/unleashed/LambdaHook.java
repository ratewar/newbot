package com.tech.unleashed;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.tech.unleashed.pojo.Request;
import com.tech.unleashed.pojo.Response;

public class LambdaHook implements RequestHandler<Request, Response> {

	public Map<String,Object> elicitSlot(){
		
		return null;
	}
	public Map<String,Object> confirmIntent(){
		return null;
	}
	public Map<String,Object> close(){
		return null;
	}
	public Map<String,Object> delegate(){
		return null;
	}
	public Map<String,Object> buildResponseCard(){
		return null;
	}
	private int parseInt(String number){
		return 0;
	}
	private int incrementTimeByThirtyMinutes() {
		return 0;
	}
	private int getRandomInt(){
		return 0;
	}
	public List<String> getAvailabilities(){
		return null;
	}
	private boolean isValidDate(){
		return false;
	}
	private boolean isAvailable(){
		return false;
	}
	private void getDuration(){
		
	}
	private void getAvailabilitiesForDuration(){
	
	}
	private void buildValidationResults(){
		
	}
	private void validateBookAppointment(){
		
	}
	private void buildTimeOutputString(){
		
	}
	private void buildAvailableTimeString(){
		
	}
	private void buildOptions(){
		
	}
	private void makeAppointment(){
		
	}
	public void dispatch(){
		
	}
	@Override
	public Response handleRequest(Request objRequest, Context context) {
		LambdaLogger logger = context.getLogger();
	    logger.log("This is a val-1" + objRequest.getVal1());
	    logger.log("This is a val-2" + objRequest.getVal2());
	    logger.log("This is a val-3" + objRequest.getVal3());
	    Response objResponse = new Response();
	    objResponse.setName1("Vikas Bajaj");
	    objResponse.setName2(10101976);
	    contextToString(context);
	    return objResponse;
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
