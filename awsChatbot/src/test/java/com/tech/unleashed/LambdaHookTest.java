package com.tech.unleashed;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.unleashed.pojo.common.Slots;
import com.tech.unleashed.pojo.response.Message;
import com.tech.unleashed.pojo.response.Response;

public class LambdaHookTest {

	@Test
	public void testElicitSlot() {
		StringBuilder builder = new StringBuilder();
		/*
		builder.append("\"dialogAction\": {");
		builder.append("\"type\": \"ElicitSlot\",");
		builder.append("\"message\": {");
		builder.append("\"contentType\": \"PlainText\",");
		builder.append("\"content\": \"message to convey to the user, i.e. What size pizza would you like?\"");
		builder.append("},");
		builder.append("\"intentName\": \"intent-name\",");
		builder.append("\"slots\": {");
		builder.append("\"slot-name\": \"value\",");
		builder.append("\"slot-name\": \"value\",");
		builder.append("\"slot-name\": \"value\"");  
		builder.append("},");
		builder.append("\"slotToElicit\" : \"slot-name\",");
		*/
		LambdaHook lambdaHook = new LambdaHook();
		Map<String,String> sessionAttributes  = new HashMap<String,String>();
		sessionAttributes.put("key1", "Value1");
		sessionAttributes.put("key2", "Value2");
		String intentName = "OrderFlowers";
		Slots slots = new Slots();
		slots.setFlowerType("roses");
		String violatedSlot = "PickupDate";
		Message message = new Message();
		message.setContent("I did not understand that, what date would you like to pick the flowers up?");
		message.setContentType("PlainText");
		Response responseObject = lambdaHook.elicitSlot(sessionAttributes, intentName, slots, violatedSlot, message);
		
		ObjectMapper mapper = new ObjectMapper();
		// Convert object to JSON string and pretty print
		String jsonInString = null;
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseObject);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonInString);
		assertEquals("test",jsonInString);
	}

}
