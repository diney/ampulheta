package com.teste.ampulheta.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teste.ampulheta.domain.enums.Perfil;
@Entity
public class User implements Serializable {	
	private static final long serialVersionUID = 1L;
	
		
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_id;
	@NotEmpty(message="Preenchimento é obrigatório")	
	private String name;
	@NotEmpty(message="Preenchimento é obrigatório")
	private String email;
	@NotEmpty(message="Preenchimento é obrigatório")
	private String login;
	@JsonIgnore
	private String password;
	@JsonIgnore 
	@ManyToMany
		@JoinTable(name = "USER_PROJECT",
				joinColumns = @JoinColumn(name = "userId"),
	    inverseJoinColumns = @JoinColumn(name = "projectId")
		)
	private List<Project> projects = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	public User() {
		addPerfil(Perfil.USUARIO);
		
	}
	
	public User(Integer user_id, String name, String email, String login,  String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.password = password;
		addPerfil(Perfil.USUARIO);
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x->Perfil.toEnum(x)).collect(Collectors.toSet());		
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
	
	
}
