package com.exoo.oee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class DailyReport {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String shift;
	
	@Column(name="date_report")
	private Date dateOfReport;
	
	private Integer actualOutput;
	
	@ManyToOne
	@JoinColumn(name="createdBy")
	private User reportCreatedBy;
	
	
	/** Getters & Setters **/
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Date getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public Integer getActualOutput() {
		return actualOutput;
	}

	public void setActualOutput(Integer actualOutput) {
		this.actualOutput = actualOutput;
	}

	public User getReportCreatedBy() {
		return reportCreatedBy;
	}

	public void setReportCreatedBy(User reportCreatedBy) {
		this.reportCreatedBy = reportCreatedBy;
	}

	@Override
	public String toString() {
		return "DailyReport [id=" + id + ", shift=" + shift + ", dateOfReport="
				+ dateOfReport + ", actualOutput=" + actualOutput
				+ ", reportCreatedBy=" + reportCreatedBy.getUsername() + "]";
	}

	
	
	

}
