package com.organization.tara.visualobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "url", "width", "height" })
@Data
public class Default {

	@JsonProperty("url")
	public String url;
	@JsonProperty("width")
	public Integer width;
	@JsonProperty("height")
	public Integer height;

}
