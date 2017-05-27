package com.tech.unleashed.pojo.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseCard {

	private Integer version;
	private String contentType;
	private List<GenericAttachment> genericAttachments = null;
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
}
