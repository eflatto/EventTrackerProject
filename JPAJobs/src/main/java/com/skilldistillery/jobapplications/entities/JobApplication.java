package com.skilldistillery.jobapplications.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_application")
public class JobApplication {
	
	//id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//company_name
	@Column(name="company_name")
	private String companyName;

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobApplication other = (JobApplication) obj;
		return id == other.id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public JobApplication() {
		super();
	}

	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", companyName=" + companyName + "]";
	}

}
