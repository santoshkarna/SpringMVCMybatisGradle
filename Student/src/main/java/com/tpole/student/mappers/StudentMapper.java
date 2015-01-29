package com.tpole.student.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tpole.student.model.Student;

/**
 * Mapper class for Student domain.
 * 
 * @author Santosh
 * 
 */
public interface StudentMapper {

	final String INSERT = "INSERT INTO tp_table(student_name, student_class, student_roll) VALUES"
			+ "(#{studentName},#{studentClass}, #{studentRoll})";
	final String UPDATE = "UPDATE tp_table SET student_name = #{student.studentName},student_roll = #{student.studentRoll},"
			+ "student_class = #{student.studentClass} WHERE student_id = #{studentId}";
	final String DELETE = "DELETE FROM tp_table WHERE student_id = #{studentId}";
	final String SELECT_BY_NAME = "SELECT student_id as studentId,student_name as studentName, student_class as studentClass, "
			+ "student_roll as studentRoll "
			+ "FROM tp_table WHERE student_name = #{studentName}";
	final String SELECT_ALL = "SELECT * FROM tp_table";
	final String SELECT_BY_ID = "SELECT * FROM tp_table WHERE student_id = #{studentId}";

	/**
	 * This method is used to save student data.
	 * 
	 * @param student
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "student_id", flushCache = true, keyColumn = "student_id")
	void insertStudent(Student student);

	/**
	 * This method is used to update student data by id.
	 * 
	 * @param studentId
	 * @param student
	 */
	@Update(UPDATE)
	void updateStudent(@Param("studentId") Long studentId,
			@Param("student") Student student);

	/**
	 * This method is used to delete student data by id.
	 * 
	 * @param studentId
	 */
	@Delete(DELETE)
	void deleteStudentById(Long studentId);

	/**
	 * This method is used to get list student data by student name.
	 * 
	 * @param studentName
	 * @return list of student
	 */
	@Select(SELECT_BY_NAME)
	List<Student> getStudentByName(String studentName);

	/**
	 * This method is used to get list student data.
	 * 
	 * @return list of student
	 */
	@Select(SELECT_ALL)
	@Results(value = { @Result(property = "studentId", column = "student_id"),
			@Result(property = "studentName", column = "student_name"),
			@Result(property = "studentRoll", column = "student_roll"),
			@Result(property = "studentClass", column = "student_class") })
	List<Student> getAllStudent();

	/**
	 * This methos is used to get student dat by id.
	 * 
	 * @param studentId
	 * @return student information.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = { @Result(property = "studentId", column = "student_id"),
			@Result(property = "studentName", column = "student_name"),
			@Result(property = "studentRoll", column = "student_roll"),
			@Result(property = "studentClass", column = "student_class") })
	Student getStudentById(Long studentId);

}
