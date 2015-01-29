package com.tpole.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tpole.student.mappers.StudentMapper;
import com.tpole.student.model.Student;
import com.tpole.student.service.StudentServiceImpl;

/**
 * @author Santosh
 *
 */
public class StudentServiceTest {

	@Mock
	private StudentMapper studentMapper;
	@InjectMocks
	private StudentServiceImpl studentServiceImpl;

	private Student student;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		this.student = new Student();
		this.student.setStudentId(1L);
		this.student.setStudentName("Santosh");
		this.student.setStudentClass(11);
		this.student.setStudentRoll(1);

	}

	/**
	 * 
	 */
	@Test
	public void testGetStudentById() {
		Mockito.when(this.studentMapper.getStudentById(this.student.getStudentId()))
				.thenReturn(this.student);
		Student returnedStudent = this.studentMapper.getStudentById(this.student
				.getStudentId());
		Assert.assertNotNull(returnedStudent);

	}

	/**
	 * 
	 */
	@Test
	public void testGetStudentByName() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(this.student);

		Mockito.when(this.studentMapper.getStudentByName(this.student.getStudentName()))
				.thenReturn(studentList);
		List<Student> returnedStudentList = this.studentMapper
				.getStudentByName(this.student.getStudentName());
		Assert.assertNotNull(returnedStudentList.size());
		Assert.assertEquals(returnedStudentList.size(), studentList.size());

	}

	/**
	 * 
	 */
	@Test
	public void testGetAllStudent() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(this.student);

		Mockito.when(this.studentMapper.getAllStudent()).thenReturn(studentList);
		List<Student> returnedStudentList = this.studentMapper.getAllStudent();
		Assert.assertNotNull(returnedStudentList.size());
		Assert.assertEquals(returnedStudentList.size(), studentList.size());

	}

}
