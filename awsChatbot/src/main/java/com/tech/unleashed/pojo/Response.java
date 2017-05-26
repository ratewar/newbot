package com.tech.unleashed.pojo;

import java.util.HashMap;
import java.util.Map;

public class Response {

	private SessionAttributes sessionAttributes;
	private DialogAction dialogAction;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public SessionAttributes getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(SessionAttributes sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public DialogAction getDialogAction() {
		return dialogAction;
	}

	public void setDialogAction(DialogAction dialogAction) {
		this.dialogAction = dialogAction;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
