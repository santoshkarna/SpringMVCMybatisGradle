package com.company.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.student.mappers.StudentMapper;
import com.company.student.model.Student;

/**
 * Implementation class for UserService.
 * 
 * @author Santosh
 * 
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.student.service.StudentService#insertStudent(com.company.student.
	 * model.Student)
	 */
	@Override
	public void insertStudent(Student student) {
		this.studentMapper.insertStudent(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.student.service.StudentService#deleteStudentById(java.lang.
	 * Long)
	 */
	@Override
	public void deleteStudent(Long studentId) {
		this.studentMapper.deleteStudentById(studentId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.student.service.StudentService#updateStudent(java.lang.Long,
	 * com.company.student. model.Student)
	 */
	@Override
	public void updateStudent(Long studentId, Student student) {
		this.studentMapper.updateStudent(studentId, student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.student.service.StudentService#getStudentByName(java.lang.String
	 * )
	 */
	@Override
	public List<Student> getStudentByName(String studentName) {
		return this.studentMapper.getStudentByName(studentName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.company.student.service.StudentService#getAllStudent()
	 */
	@Override
	public List<Student> getAllStudent() {
		return this.studentMapper.getAllStudent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.student.service.StudentService#getStudentById(java.lang.Long)
	 */
	@Override
	public Student getStudentById(Long studentId) {
		return this.studentMapper.getStudentById(studentId);
	}

}
