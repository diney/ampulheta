package com.teste.ampulheta.dto;

import java.io.Serializable;

import com.teste.ampulheta.domain.Project;

public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer project_id;
	private String title;
	
	public ProjectDTO() {
		
	}
	
	public ProjectDTO(Project obj) {
		project_id = obj.getproject_id();
		title = obj.getTitle();
		
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
