package com.organization.tara.visualobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"kind",
"etag",
"id",
"snippet"
})
@Data
public class Item {

@JsonProperty("kind")
public String kind;
@JsonProperty("etag")
public String etag;
@JsonProperty("id")
public String id;
@JsonProperty("snippet")
public Snippet snippet;

}

