package com.organization.tara.visualobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "default", "medium", "high", "standard", "maxres" })
@Data
public class Thumbnails {

	@JsonProperty("default")
	public Default _default;
	@JsonProperty("medium")
	public Medium medium;
	@JsonProperty("high")
	public High high;
	@JsonProperty("standard")
	public Standard standard;
	@JsonProperty("maxres")
	public Maxres maxres;

}
