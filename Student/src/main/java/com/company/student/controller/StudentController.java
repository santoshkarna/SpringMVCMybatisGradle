package com.company.student.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.company.student.model.Student;
import com.company.student.service.StudentService;

/**
 * Controller class for Student domain.
 * 
 * @author Santosh
 * 
 */
@Controller
@SessionAttributes("student")
public class StudentController {

	private static final Logger logger = LoggerFactory
			.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;

	/**
	 * This methoed is used to render index page.
	 * 
	 * @return index page
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	/**
	 * This method is used to render the form to add the student data.
	 * 
	 * @param student
	 * @param result
	 * @return student form model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("command") Student student,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		Student stu = new Student();
		model.put("student", stu);
		return new ModelAndView("addStudent", model);
	}

	/**
	 * This methos is used to save student data.
	 * 
	 * @param student
	 * @param result
	 * @return student list model
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command") Student student,
			BindingResult result) {
		studentService.insertStudent(student);
		return new ModelAndView("redirect:students.html");
	}

	/**
	 * This method is used to show list of students.
	 * 
	 * @return student list model
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView listStudents() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", studentService.getAllStudent());
		model.put("searchStudent", new Student());
		return new ModelAndView("studentsList", model);
	}

	/**
	 * This method is used to delete student by id.
	 * 
	 * @param student
	 * @param result
	 * @return student list model
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(
			@ModelAttribute("command") Student student, BindingResult result) {
		studentService.deleteStudent(student.getStudentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", studentService.getAllStudent());
		return new ModelAndView("studentsList", model);
	}

	/**
	 * This method is used to render update form.
	 * 
	 * @param student
	 * @param result
	 * @return update form model
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command") Student student,
			BindingResult result) {
		Student stud = studentService.getStudentById(student.getStudentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", stud);
		return new ModelAndView("updateStudent", model);
	}

	/**
	 * This method is used to update the student data by id.
	 * 
	 * @param student
	 * @param result
	 * @return student list model
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(
			@ModelAttribute("command") Student student, BindingResult result) {
		studentService.updateStudent(student.getStudentId(), student);
		return new ModelAndView("redirect:students.html");
	}

	/**
	 * This method is used to search student by name.
	 * 
	 * @param student
	 * @param result
	 * @param action
	 * @return student list model
	 */
	@RequestMapping(value = "/studentslist", method = RequestMethod.POST)
	public ModelAndView searchStudentsByName(
			@ModelAttribute("searchStudent") Student student,
			BindingResult result, @RequestParam String action) {
		Map<String, Object> model = new HashMap<String, Object>();
		switch (action.toLowerCase()) {
		case "submit":
			model.put("students",
					studentService.getStudentByName(student.getStudentName()));
			break;
		case "reset":
			model.put("students", studentService.getAllStudent());
			break;
		}
		return new ModelAndView("studentsList", model);
	}

}
