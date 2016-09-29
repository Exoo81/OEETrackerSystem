package com.exoo.oee.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private boolean enabled;
	
	@ManyToMany
	@JoinTable
	private List<Role> roles ;//= new ArrayList<Role>();
	
	@OneToMany(mappedBy="reportCreatedBy")
	private List<DailyReport> dailyReports;
	
	@OneToOne (mappedBy="user")
	private UserDetails userDetails;
	
	@OneToMany(mappedBy="productionLineCreatedBy")
	private List<ProductionLine> createdProductionLines;
	
	
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<ProductionLine> getCreatedProductionLines() {
		return createdProductionLines;
	}

	public void setCreatedProductionLines(
			List<ProductionLine> createdProductionLines) {
		this.createdProductionLines = createdProductionLines;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", enabled=" + enabled + ", roles=" + roles
				+ ", userDetails=" + userDetails + "]";
	}

	


}
