
package com.organization.tara.visualobjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "url", "uploadedDate", "thumbnails", "videoType" })
@Data
public class GetEventVideoVO {

	@JsonProperty("id")
	public String id;
	@JsonProperty("url")
	public String url;
	@JsonProperty("uploadedDate")
	public Date uploadedDate;
	@JsonProperty("thumbnails")
	public Thumbnails thumbnails;
	@JsonProperty("videoType")
	public String videoType;

}