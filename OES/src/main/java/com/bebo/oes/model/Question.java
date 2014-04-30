package com.bebo.oes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "Questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "Question_Desc")
	private String questionDesc;
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Option> optionList;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "dept_id")
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	/**
	 * @return the optionList
	 */
	public List<Option> getOptionList() {
		return optionList;
	}

	/**
	 * @param optionList
	 *            the optionList to set
	 */
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

}
