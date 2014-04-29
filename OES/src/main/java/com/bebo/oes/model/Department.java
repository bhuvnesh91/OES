package com.bebo.oes.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dept")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "name")
	String name;
	@OneToMany(mappedBy="department")
	private Set<Question> questionLIst;

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

	/**
	 * @return the questionLIst
	 */
	public Set<Question> getQuestionLIst() {
		return questionLIst;
	}

	/**
	 * @param questionLIst the questionLIst to set
	 */
	public void setQuestionLIst(Set<Question> questionLIst) {
		this.questionLIst = questionLIst;
	}
	
}
