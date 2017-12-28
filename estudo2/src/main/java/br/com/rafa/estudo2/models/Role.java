package br.com.rafa.estudo2.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "role")
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;
	private String permission;
	@ManyToMany(fetch = FetchType.LAZY)  
	@JoinTable(
				name = "user_role", 				
				joinColumns = { 
							@JoinColumn(
										name = "role_id",
										nullable = false,  
										updatable =  false) }, 
	 			inverseJoinColumns = {  
							@JoinColumn(
										name = "user_id", 
										nullable = false, 
										updatable = false) }
	)  
	private Set<User> user = new HashSet<User>();

	public String getPermission() {
		return permission;
	}

	public void setPermission(String  permission) {
		this. permission =  permission;
	}

	public Set<User> getUser() {
		return user;
	}


}
