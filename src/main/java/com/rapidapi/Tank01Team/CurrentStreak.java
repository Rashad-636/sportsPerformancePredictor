package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentStreak{

	@JsonProperty("result")
	private String result;

	@JsonProperty("length")
	private String length;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setLength(String length){
		this.length = length;
	}

	public String getLength(){
		return length;
	}

	@Override
 	public String toString(){
		return 
			"CurrentStreak{" + 
			"result = '" + result + '\'' + 
			",length = '" + length + '\'' + 
			"}";
		}
}