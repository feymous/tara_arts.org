package com.organization.tara.visualobjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "kind", "etag", "pageInfo", "items" })
@Data
public class VideoYoutubeAPI {

	@JsonProperty("kind")
	public String kind;
	@JsonProperty("etag")
	public String etag;
	@JsonProperty("pageInfo")
	public PageInfo pageInfo;
	@JsonProperty("items")
	public List<Item> items = null;

}