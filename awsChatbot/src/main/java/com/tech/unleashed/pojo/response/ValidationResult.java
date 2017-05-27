package com.tech.unleashed.pojo.response;

public class ValidationResult {
	private Message message;
	private String violatedSlot;
	private boolean isValid;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getViolatedSlot() {
		return violatedSlot;
	}
	public void setViolatedSlot(String violatedSlot) {
		this.violatedSlot = violatedSlot;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
