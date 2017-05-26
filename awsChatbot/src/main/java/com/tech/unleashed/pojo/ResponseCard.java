package com.test.entity.response.format;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseCard {

	private Integer version;
	private String contentType;
	private List<GenericAttachment> genericAttachments = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<GenericAttachment> getGenericAttachments() {
		return genericAttachments;
	}

	public void setGenericAttachments(List<GenericAttachment> genericAttachments) {
		this.genericAttachments = genericAttachments;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
