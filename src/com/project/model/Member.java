package com.project.model;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Member {
	
	private Integer id;
	@NotNull
	@Email
	private String email;
	private String pwd;
	private String name;
	private String nickname;
	private Date birthdate;
	private String regi_ip;
	private Date regidate;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getRegi_ip() {
		return regi_ip;
	}
	
	public void setRegi_ip(String regi_ip) {
		this.regi_ip = regi_ip;
	}
	
	public Date getRegidate() {
		return regidate;
	}
	
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
		
}