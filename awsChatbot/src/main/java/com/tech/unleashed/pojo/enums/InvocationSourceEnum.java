package com.tech.unleashed.pojo.enums;

public enum InvocationSourceEnum {
	DIALOG_CODE_HOOK("DialogCodeHook");
	private String invocationSource;
	InvocationSourceEnum(String invocSource) {
		invocationSource = invocSource;
	}
	public String getInvocationSource(){
		return invocationSource;
	}
}
