package com.exoo.oee.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy="user")
	private List<DailyReport> dailyReports;
	
	@OneToOne (mappedBy="user")
	private UserDetails userDetails;
	
	
	/** Getters & Setters **/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<DailyReport> getDailyReports() {
		return dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

}
