package com.rapidapi.Tank01Team;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Teams {

	@JsonProperty("teamName")
	private String teamName;

	@JsonProperty("wins")
	private String wins;

	@JsonProperty("currentStreak")
	private CurrentStreak currentStreak;

	@JsonProperty("conference")
	private String conference;

	@JsonProperty("ppg")
	private String ppg;

	@JsonProperty("teamCity")
	private String teamCity;

	@JsonProperty("oppg")
	private String oppg;

	@JsonProperty("teamAbv")
	private String teamAbv;

	@JsonProperty("division")
	private String division;

	@JsonProperty("loss")
	private String loss;

	@JsonProperty("conferenceAbv")
	private String conferenceAbv;

	@JsonProperty("teamID")
	private String teamID;

	@JsonProperty("teamSchedule")
	private Object teamSchedule;

	public Object getTeamSchedule() {
		return teamSchedule;
	}

	public void setTeamSchedule(Object teamSchedule) {
		this.teamSchedule = teamSchedule;
	}
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setWins(String wins){
		this.wins = wins;
	}

	public String getWins(){
		return wins;
	}

	public void setCurrentStreak(CurrentStreak currentStreak){
		this.currentStreak = currentStreak;
	}

	public CurrentStreak getCurrentStreak(){
		return currentStreak;
	}

	public void setConference(String conference){
		this.conference = conference;
	}

	public String getConference(){
		return conference;
	}

	public void setPpg(String ppg){
		this.ppg = ppg;
	}

	public String getPpg(){
		return ppg;
	}

	public void setTeamCity(String teamCity){
		this.teamCity = teamCity;
	}

	public String getTeamCity(){
		return teamCity;
	}

	public void setOppg(String oppg){
		this.oppg = oppg;
	}

	public String getOppg(){
		return oppg;
	}

	public void setTeamAbv(String teamAbv){
		this.teamAbv = teamAbv;
	}

	public String getTeamAbv(){
		return teamAbv;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setLoss(String loss){
		this.loss = loss;
	}

	public String getLoss(){
		return loss;
	}

	public void setConferenceAbv(String conferenceAbv){
		this.conferenceAbv = conferenceAbv;
	}

	public String getConferenceAbv(){
		return conferenceAbv;
	}

	public void setTeamID(String teamID){
		this.teamID = teamID;
	}

	public String getTeamID(){
		return teamID;
	}

	@Override
	public String toString() {
		return "Teams{" +
				"teamName='" + teamName + '\'' +
				", wins='" + wins + '\'' +
				", currentStreak=" + currentStreak +
				", conference='" + conference + '\'' +
				", ppg='" + ppg + '\'' +
				", teamCity='" + teamCity + '\'' +
				", oppg='" + oppg + '\'' +
				", teamAbv='" + teamAbv + '\'' +
				", division='" + division + '\'' +
				", loss='" + loss + '\'' +
				", conferenceAbv='" + conferenceAbv + '\'' +
				", teamID='" + teamID + '\'' +
				", teamSchedule='" + teamSchedule + '\'' +
				'}';
	}
}