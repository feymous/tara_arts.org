package com.organization.tara.visualobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "totalResults", "resultsPerPage" })
@Data
public class PageInfo {

	@JsonProperty("totalResults")
	public Integer totalResults;
	@JsonProperty("resultsPerPage")
	public Integer resultsPerPage;

}
