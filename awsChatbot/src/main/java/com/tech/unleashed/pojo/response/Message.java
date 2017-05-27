package com.tech.unleashed.pojo.response;

import java.util.HashMap;
import java.util.Map;

public class Message {

	private String contentType;
	private String content;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
