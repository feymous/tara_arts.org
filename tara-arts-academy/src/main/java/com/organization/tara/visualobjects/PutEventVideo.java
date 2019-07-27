package com.organization.tara.visualobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "url", "id", "videoType" })
@Data
public class PutEventVideo {

	@JsonProperty("url")
	private String url;
	@JsonProperty("id")
	private String id;
	@JsonProperty("videoType")
	private String videoType;

}