package com.tech.unleashed.pojo;

public class CurrentIntent {
	private Slot slots;
	private String name;
	private String confirmationStatus;
	public Slot getSlots() {
		return slots;
	}
	public void setSlots(Slot slots) {
		this.slots = slots;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfirmationStatus() {
		return confirmationStatus;
	}
	public void setConfirmationStatus(String confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}
}
