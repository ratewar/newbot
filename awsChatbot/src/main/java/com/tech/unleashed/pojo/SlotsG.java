package com.test.entity.response.format;

import java.util.HashMap;
import java.util.Map;

public class Slots {

	private String slotName;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
