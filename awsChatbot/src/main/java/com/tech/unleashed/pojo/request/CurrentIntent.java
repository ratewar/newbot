package com.tech.unleashed.pojo.request;

import com.tech.unleashed.pojo.common.Slots;

public class CurrentIntent {
	private Slots slots;
	private String name;
	private String confirmationStatus;
	public Slots getSlots() {
		return slots;
	}
	public void setSlots(Slots slots) {
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
