package com.epg.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "program")
public class Program {
	private String id;
	private String channelId;
	private String imageUrl;
	private String title;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public Program(String channelId, String imageUrl, String title, String description, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.channelId = channelId;
		this.imageUrl = imageUrl;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getChannelId() {
		return channelId;
	}
	
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
}
