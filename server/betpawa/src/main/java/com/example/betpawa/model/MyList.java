package com.example.betpawa.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
public class MyList {
    public MyList(long id, String title, String priority, String day, String month, String year, String description,
			List<MyComments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.priority = priority;
		this.day = day;
		this.month = month;
		this.year = year;
		this.description = description;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "MyList [id=" + id + ", title=" + title + ", priority=" + priority + ", day=" + day + ", month=" + month
				+ ", year=" + year + ", description=" + description + ", comments=" + comments + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MyComments> getComments() {
		return comments;
	}

	public void setComments(List<MyComments> comments) {
		this.comments = comments;
	}

	public MyList() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String priority;
    private String day;
    private String month;
    private String year;
    private String description;

    @OneToMany
    @JoinColumn(name = "list_id")
    private List<MyComments> comments;
}
