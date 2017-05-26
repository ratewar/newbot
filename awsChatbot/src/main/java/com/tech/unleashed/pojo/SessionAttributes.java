package com.test.entity.response.format;

import java.util.HashMap;
import java.util.Map;

public class SessionAttributes {

	private String key1;
	private String key2;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
