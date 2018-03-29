package com.teste.ampulheta.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Time implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date started_at;
	private Date ended_at;
	
	public Time(Integer id, Date started_at, Date ended_at) {
		super();
		this.id = id;
		this.started_at = started_at;
		this.ended_at = ended_at;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}

	public Date getEnded_at() {
		return ended_at;
	}

	public void setEnded_at(Date ended_at) {
		this.ended_at = ended_at;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
