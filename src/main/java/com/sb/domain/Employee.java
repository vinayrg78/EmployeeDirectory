package com.sb.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Employee {
	
	@Id
	private String id;
	
	private String name;
	private String project;
	private String motto;
	
	private String emailAddress;
	private String phoneNumber;
	private String address;
	
	private String hobbies;
	private String musicPreferences;
	private String webHangouts;
	
	private Date joiningDate;
	
	public Employee(){
	}
	
	public Employee(String name, String project, String motto) {
		super();
		this.name = name;
		this.project = project;
		this.motto = motto;
	}
	
	
	public Employee(String id, String name, String project, String motto,
			String emailAddress, String phoneNumber, String address,
			String hobbies, String musicPreferences, String webHangouts,
			Date joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
		this.motto = motto;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.hobbies = hobbies;
		this.musicPreferences = musicPreferences;
		this.webHangouts = webHangouts;
		this.joiningDate = joiningDate;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getMusicPreferences() {
		return musicPreferences;
	}

	public void setMusicPreferences(String musicPreferences) {
		this.musicPreferences = musicPreferences;
	}

	public String getWebHangouts() {
		return webHangouts;
	}

	public void setWebHangouts(String webHangouts) {
		this.webHangouts = webHangouts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}