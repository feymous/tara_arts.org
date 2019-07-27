package com.organization.tara.visualobjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cascadeImages" })
public class ParticipantDashboardVO {

	@JsonProperty("cascadeImages")
	private List<CascadeImage> cascadeImages = null;

	@JsonProperty("cascadeImages")
	public List<CascadeImage> getCascadeImages() {
		return cascadeImages;
	}

	@JsonProperty("cascadeImages")
	public void setCascadeImages(List<CascadeImage> cascadeImages) {
		this.cascadeImages = cascadeImages;
	}

}