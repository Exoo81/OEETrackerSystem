package com.exoo.oee.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Role {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="role_name", unique=true)
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	

	/** Getters & Setters **/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
