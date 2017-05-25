package com.tech.unleashed.pojo;

import java.util.Map;

public class Request {
	private CurrentIntent currentIntent;
	private Bot bot;
	private String userId;
	private String invocationSource;
	private String outputDialogMode;
	private String messageVersion;
	private Map<String,String> sessionAttributes;
	
	public CurrentIntent getCurrentIntent() {
		return currentIntent;
	}
	public void setCurrentIntent(CurrentIntent currentIntent) {
		this.currentIntent = currentIntent;
	}
	public Bot getBot() {
		return bot;
	}
	public void setBot(Bot bot) {
		this.bot = bot;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInvocationSource() {
		return invocationSource;
	}
	public void setInvocationSource(String invocationSource) {
		this.invocationSource = invocationSource;
	}
	public String getOutputDialogMode() {
		return outputDialogMode;
	}
	public void setOutputDialogMode(String outputDialogMode) {
		this.outputDialogMode = outputDialogMode;
	}
	public String getMessageVersion() {
		return messageVersion;
	}
	public void setMessageVersion(String messageVersion) {
		this.messageVersion = messageVersion;
	}
	public Map<String, String> getSessionAttributes() {
		return sessionAttributes;
	}
	public void setSessionAttributes(Map<String, String> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
}
