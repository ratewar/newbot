package com.tech.unleashed.pojo.response;

import java.util.HashMap;
import java.util.Map;

import com.tech.unleashed.pojo.common.Slots;

public class DialogAction {
	private String type;
	private String fulfillmentState;
	private Message message;
	private String intentName;
	private Slots slots;
	private String slotToElicit;
	private ResponseCard responseCard;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFulfillmentState() {
		return fulfillmentState;
	}

	public void setFulfillmentState(String fulfillmentState) {
		this.fulfillmentState = fulfillmentState;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public ResponseCard getResponseCard() {
		return responseCard;
	}

	public void setResponseCard(ResponseCard responseCard) {
		this.responseCard = responseCard;
	}

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public Slots getSlots() {
		return slots;
	}

	public void setSlots(Slots slots) {
		this.slots = slots;
	}

	public String getSlotToElicit() {
		return slotToElicit;
	}

	public void setSlotToElicit(String slotToElicit) {
		this.slotToElicit = slotToElicit;
	}
}
