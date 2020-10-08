package com.example.betpawa.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
public class MyComments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	public MyComments(long id, String name, String commentTime, String commentData) {
		super();
		this.id = id;
		this.name = name;
		this.commentTime = commentTime;
		this.commentData = commentData;
	}
	public MyComments() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyComments [id=" + id + ", name=" + name + ", commentTime=" + commentTime + ", commentData="
				+ commentData + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentData() {
		return commentData;
	}
	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}
	private String name;
	private String commentTime;
	private String commentData;
}
