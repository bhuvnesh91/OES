/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bebo.oes.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bbansal
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ID")
    @Id
    private int id;
    @Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
