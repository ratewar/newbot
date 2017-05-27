package com.tech.unleashed.pojo.response;

import java.util.HashMap;
import java.util.Map;
public class Button {
	private String text;
	private String value;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
