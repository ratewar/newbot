package com.tech.unleashed.pojo.enums;

public enum DialogActionTypeEnum {
	ELICIT_SLOT("ElicitSlot"), DELEGATE("Delegate"),CLOSE("Close");
	private String actionType;
	DialogActionTypeEnum(String dialogActionType){
		actionType = dialogActionType;
	}
	public String getType(){
		return actionType;
	}
}
