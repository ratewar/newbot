package com.tech.unleashed;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHook implements RequestHandler<Map<String, Object>,String> {

	
	public String handleRequest(Map<String, Object> input, Context context) {
		LambdaLogger logger = context.getLogger();
	    logger.log("Hello World");

	    logger.log("This is a Developer 2");
	    logger.log("This is the new ear of king kong changed by developer-1");
		return null;
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
