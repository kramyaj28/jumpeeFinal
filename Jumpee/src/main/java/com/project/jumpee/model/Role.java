package com.project.jumpee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	public Role() {}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
//    private long userId;

    @Column(length = 60)
    private String roleName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String name) {
		this.roleName = name;
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
    
}