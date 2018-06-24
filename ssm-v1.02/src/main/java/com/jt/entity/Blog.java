package com.jt.entity;
import java.io.Serializable;
import java.util.Date;
public class Blog implements Serializable{
	private static final long serialVersionUID = -4512284398252375293L;
	private Integer id;
	private String title;
	private String content;
	private Date  createdTime;
	private String authorId;
	public Blog() {}
	public Blog(Integer id){
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setId(Integer id) {
		//System.out.println("setId");
		this.id = id;
	}
	public String getTitle() {
		System.out.println("getTitle()");
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", createdTime=" + createdTime + "]";
	}
	
}
