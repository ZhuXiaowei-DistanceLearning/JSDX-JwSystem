package com.zxw.web;

import com.zxw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pojo.Student_Role;
import pojo.TStudent;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/student")
public class StudentAction {

	@Autowired
	private StudentService studentService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/insertStudent")
	public void insertStudent(@RequestBody TStudent student){
//		FileInfo fileInfo = studentService.importXlsStudent(file, cid);
//		return fileInfo;
		studentService.insertStudent(student);
	}

	@PostMapping("/insertStudentRole")
	public void insertStudentRole(@RequestBody Student_Role student){
		studentService.insertStudentRole(student);
	}
	@RequestMapping("/pageQuery")
	public String pageQuery(Integer page, Integer rows) throws IOException {
		//EasyUIDataGridResult result = studentService.pageQuery(page, rows);
		return null;
	}

	@RequestMapping("/findStudentByclass")
	public String findStudentByclass(Integer page, Integer rows, HttpSession session) throws IOException {
		//String id = (String) session.getAttribute("classes_id");
		//EasyUIDataGridResult result = studentService.findStudentByclass(id, page, rows);
		return "";
	}
	
}
