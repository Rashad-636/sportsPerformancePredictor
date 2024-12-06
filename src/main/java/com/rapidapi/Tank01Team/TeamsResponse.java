package com.rapidapi.Tank01Team;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamsResponse {

	@JsonProperty("body")
	private List<Teams> body;

	@JsonProperty("statusCode")
	private int statusCode;

	public void setBody(List<Teams> body){
		this.body = body;
	}

	public List<Teams> getBody(){
		return body;
	}

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	@Override
 	public String toString(){
		return 
			"Teams{" + 
			"body = '" + body + '\'' + 
			",statusCode = '" + statusCode + '\'' + 
			"}";
		}
}