package com.hairgely.admin.article.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

	@Id	@GeneratedValue
	private int id;

	private String nickname;

	@JsonIgnore // 비밀번호는 client에 전달이 안되도록 한다.(jackson annotation)
	private String password;

	private String content;
	
	private Date addDate = new Date();

	@ManyToOne
	@JoinColumn(name = "ARTICLE_ID")
	private Article article;

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
