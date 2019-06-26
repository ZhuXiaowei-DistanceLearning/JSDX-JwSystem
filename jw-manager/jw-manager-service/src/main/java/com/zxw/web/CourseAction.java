package com.zxw.web;

import com.zxw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/course")
public class CourseAction {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/pageQuery")
	@ResponseBody
	public ResponseEntity pageQuery(Integer page, Integer rows) throws IOException {
		//EasyUIDataGridResult result = courseService.pageQuery(page, rows);
		return null;
	}

	/**
	 * subject获取对象
	 * @return courseAndStudent
	 * @param natureId
	 * @return
	 */
	@RequestMapping("/add")
	public String add(String sectionId, String weekId, String teacherTid, String natureId) {
	/*	model.setSectionId(sectionId);
		model.setWeekId(weekId);
		model.setTeacherId(teacherTid);
		model.setNatureId(natureId);
		courseService.add(model);*/
		return "/base/courseInfo";
	}

	@RequestMapping("/findCourseByteacherId")
	@ResponseBody
	public ResponseEntity findCourseByteacherId(HttpSession session, Integer page, Integer rows){
		//TTeacher teacher = (TTeacher) SecurityUtils.getSubject().getPrincipal();
		//EasyUIDataGridResult result = courseService.findCourseByteacherId(page, rows, teacher.getTid());
		//session.setAttribute("courseAndStudent", result);
		//return result;
		return null;
	}

	@RequestMapping("/page")
	public String page() {
		return "/base/course";
	}

	@RequestMapping("/techaerPage")
	public String findCourseByteacherId() {
		return "/teacher/course";
	}

	@RequestMapping("/studentPage")
	public String findCourseByStudent() {
		return "/student/course";
	}

	/**
	 * findById
	 * session
	 * RETURN addStudentScore
	 * @return
	 */
	@RequestMapping("/pageInfo")
	public String pageInfo() {
		return "/base/courseInfo";
	}

	@RequestMapping("/addScorePage")
	public String addScorePage(String courseid, HttpSession session) {
		//TCourse course = courseService.findById(courseid);
		//session.setAttribute("addStudentScore", course);
		return "/teacher/score";
	}
}
