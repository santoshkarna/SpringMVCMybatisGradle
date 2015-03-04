package com.company.student.model;

/**
 * Domain class for Student model.
 * 
 * @author Santosh
 * 
 */
public class Student {
	private Long studentId;

	private String studentName;

	private Integer studentClass;

	private Integer studentRoll;

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentClass
	 */
	public Integer getStudentClass() {
		return studentClass;
	}

	/**
	 * @param studentClass
	 *            the studentClass to set
	 */
	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}

	/**
	 * @return the studentRoll
	 */
	public Integer getStudentRoll() {
		return studentRoll;
	}

	/**
	 * @param studentRoll
	 *            the studentRoll to set
	 */
	public void setStudentRoll(Integer studentRoll) {
		this.studentRoll = studentRoll;
	}

}
