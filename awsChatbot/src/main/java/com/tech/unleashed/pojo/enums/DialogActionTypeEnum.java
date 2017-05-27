package com.tech.unleashed.pojo.enums;

public enum DialogActionTypeEnum {
	ELICIT_SLOT("ElicitSlot");
	private String actionType;
	DialogActionTypeEnum(String dialogActionType){
		actionType = dialogActionType;
	}
	public String getType(){
		return actionType;
	}
}
