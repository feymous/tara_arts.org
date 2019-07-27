package com.organization.tara.visualobjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "url", "uploadedDate", "imageType" })
public class CascadeImage {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("url")
	private String url;
	@JsonProperty("uploadedDate")
	private Date uploadedDate;
	@JsonProperty("imageType")
	private String imageType;

}