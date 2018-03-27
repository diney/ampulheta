package com.teste.ampulheta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer project_id;
	private String title;
	private String description;
	
	@JsonManagedReference
	@ManyToMany(mappedBy="projects")
	private List<User> user_id = new ArrayList<>();
	
	public Project() {
	}
	
	
	public Project(Integer project_id, String title, String description) {
		super();
		this.project_id = project_id;
		this.title = title;
		this.description = description;
	}
	public Integer getproject_id() {
		return project_id;
	}
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public void setproject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUser_id() {
		return user_id;
	}
	public void setUser_id(List<User> user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((project_id == null) ? 0 : project_id.hashCode());
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
		Project other = (Project) obj;
		if (project_id == null) {
			if (other.project_id != null)
				return false;
		} else if (!project_id.equals(other.project_id))
			return false;
		return true;
	}
	
	
	

}
