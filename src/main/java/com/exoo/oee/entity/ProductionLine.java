package com.exoo.oee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductionLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true, nullable=false)
	private String name;
	

	@ManyToOne
	@JoinColumn(name="createdBy")
	private User productionLineCreatedBy;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getProductionLineCreatedBy() {
		return productionLineCreatedBy;
	}

	public void setProductionLineCreatedBy(User productionLineCreatedBy) {
		this.productionLineCreatedBy = productionLineCreatedBy;
	}

	

}
