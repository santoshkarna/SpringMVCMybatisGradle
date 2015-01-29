package com.tpole.student.service;

import java.util.List;

import com.tpole.student.model.Student;

/**
 * Service class for Student domain.
 * 
 * @author Santosh
 * 
 */
public interface StudentService {

	/**
	 * This method is used to save student data.
	 * 
	 * @param student
	 */
	void insertStudent(Student student);

	/**
	 * This method is used to delete student data by id.
	 * 
	 * @param studentId
	 */
	void deleteStudent(Long studentId);

	/**
	 * This method is used to update student data by id.
	 * 
	 * @param studentId
	 * @param student
	 */
	void updateStudent(Long studentId, Student student);

	/**
	 * This method is used to get list student data by student name.
	 * 
	 * @param studentName
	 * @return list of student
	 */
	List<Student> getStudentByName(String studentName);

	/**
	 * This method is used to get list student data.
	 * 
	 * @return list of student
	 */
	List<Student> getAllStudent();

	/**
	 * This methos is used to get student dat by id.
	 * 
	 * @param studentId
	 * @return student information.
	 */
	Student getStudentById(Long studentId);
}
