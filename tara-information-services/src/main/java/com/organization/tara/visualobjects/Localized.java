package com.organization.tara.visualobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "title", "description" })
@Data
public class Localized {

	@JsonProperty("title")
	public String title;
	@JsonProperty("description")
	public String description;

}
