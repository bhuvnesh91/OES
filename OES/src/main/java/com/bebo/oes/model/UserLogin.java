/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bbansal
 */
@Entity
@Table(name = "user_login")
public class UserLogin implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ID")
    @Id
    private int id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ENABLED")
    private boolean enabled;
    @OneToOne
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
}