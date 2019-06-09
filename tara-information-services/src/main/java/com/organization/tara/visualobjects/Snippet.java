package com.organization.tara.visualobjects;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "publishedAt", "channelId", "title", "description", "thumbnails", "channelTitle", "tags",
		"categoryId", "liveBroadcastContent", "localized", "defaultAudioLanguage" })
@Data
public class Snippet {

	@JsonProperty("publishedAt")
	public String publishedAt;
	@JsonProperty("channelId")
	public String channelId;
	@JsonProperty("title")
	public String title;
	@JsonProperty("description")
	public String description;
	@JsonProperty("thumbnails")
	public Thumbnails thumbnails;
	@JsonProperty("channelTitle")
	public String channelTitle;
	@JsonProperty("tags")
	public List<String> tags = null;
	@JsonProperty("categoryId")
	public String categoryId;
	@JsonProperty("liveBroadcastContent")
	public String liveBroadcastContent;
	@JsonProperty("localized")
	public Localized localized;
	@JsonProperty("defaultAudioLanguage")
	public String defaultAudioLanguage;

}
