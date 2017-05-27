package com.tech.unleashed.pojo.response;

import java.util.Map;

public class Response {

	private Map<String,String> sessionAttributes;
	private DialogAction dialogAction;
	public DialogAction getDialogAction() {
		return dialogAction;
	}

	public void setDialogAction(DialogAction dialogAction) {
		this.dialogAction = dialogAction;
	}
	public Map<String, String> getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(Map<String, String> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
}
