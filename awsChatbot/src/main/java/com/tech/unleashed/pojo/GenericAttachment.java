package com.test.entity.response.format;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericAttachment {

	private String title;
	private String subTitle;
	private String imageUrl;
	private String attachmentLinkUrl;
	private List<Button> buttons = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAttachmentLinkUrl() {
		return attachmentLinkUrl;
	}

	public void setAttachmentLinkUrl(String attachmentLinkUrl) {
		this.attachmentLinkUrl = attachmentLinkUrl;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
