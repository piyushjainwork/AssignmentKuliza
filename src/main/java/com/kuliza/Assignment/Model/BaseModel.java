package com.kuliza.Assignment.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OrderBy(clause = "id ASC")
	private long id;

	@CreationTimestamp
	private Date created;

	@UpdateTimestamp
	private Date modified;

	@Column(nullable = false)
	private Boolean isDeleted = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@JsonIgnore
	public Date getCreated() {
		return created == null ? null : (Date) created.clone();
	}

	@JsonIgnore
	public Date getModified() {
		return modified == null ? null : (Date) modified.clone();
	}

}
