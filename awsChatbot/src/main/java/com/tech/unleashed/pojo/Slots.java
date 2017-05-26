package com.tech.unleashed.pojo;

public class Slot {
	private String PickupDate;
	private String PickupTime;
	private String FlowerType;
	public String getPickupDate() {
		return PickupDate;
	}
	public void setPickupDate(String pickupDate) {
		PickupDate = pickupDate;
	}
	public String getPickupTime() {
		return PickupTime;
	}
	public void setPickupTime(String pickupTime) {
		PickupTime = pickupTime;
	}
	public String getFlowerType() {
		return FlowerType;
	}
	public void setFlowerType(String flowerType) {
		FlowerType = flowerType;
	}
	public String toString(){
		return "PickupDate : " + PickupDate.toString() + " PickUpTime : " + PickupTime + " FlowerType : " + FlowerType;
	}
}
