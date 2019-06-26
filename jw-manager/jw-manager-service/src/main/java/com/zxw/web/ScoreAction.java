package com.zxw.web;

import com.zxw.service.CourseService;
import com.zxw.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 获取subject
 * 设置Score
 * save
 * addPeople方法i,ids
 */
@Controller
@RequestMapping("/score")
public class ScoreAction {

	@Autowired
	private ScoreService scoreService;
	@Autowired
	private CourseService courseService;

	/**
	 * 选课实现
	 * 
	 * @param ids
	 * @param people
	 * @return
	 */
	@RequestMapping("/save")
	public String save(String ids, Integer people) {
//		Subject subject = SecurityUtils.getSubject();
////		TStudent student = (TStudent) subject.getPrincipal();
////		TScore score = new TScore();
////		score.setStudentId(student.getSid());
////		score.setCourseId(ids);
////		scoreService.save(score);
////		int i = people + 1;
////		courseService.addPeople(i, ids);
		return "/student/course";

	}
	
	
	/**
	 * session获取addStudentScore
	 * addScore
	 * @param studentId
	 */
	@RequestMapping("/findStudent")
	@ResponseBody
	public List findStudent(String studentId) throws IOException {
//		List<TScore> list = scoreService.findStudent(studentId);
		return null;
	}
	
	/**
	 * 获取平和期
	 * 设置最终
	 * 保存
	 * @throws IOException
	 */
	@RequestMapping("/findTeacherCourseStudent")
	@ResponseBody
	public String findTeacherCourseStudent(Integer page, Integer rows, HttpSession session){
//		TCourse course = (TCourse) session.getAttribute("addStudentScore");
//		EasyUIDataGridResult result = scoreService.addScore(page, rows, course.getId());
		return "";
	}

	/**
	 * 获取subject
	 * findStudentExit
	 * @param score
	 * @return
	 */
	@RequestMapping("/addStudentScore")
	public String addStudentScore() {
//		String peaceTime = score.getPeacetime();
//		String endTime = score.getEndtime();
//		if (peaceTime.equals("A+") && endTime.equals("A+")) {
//			score.setScore("A+");
//		} else if (peaceTime.equals("A") && endTime.equals("A")) {
//			score.setScore("A");
//		} else if (peaceTime.equals("B+") && endTime.equals("B+")) {
//			score.setScore("B+");
//		} else if (peaceTime.equals("B") && endTime.equals("B")) {
//			score.setScore("B");
//		} else if (peaceTime.equals("C+") && endTime.equals("C+")) {
//			score.setScore("C+");
//		} else if (peaceTime.equals("C") && endTime.equals("C")) {
//			score.setScore("C");
//		} else if (peaceTime.equals("D+") && endTime.equals("D+")) {
//			score.setScore("D");
//		} else if (peaceTime.equals("D") && endTime.equals("D")) {
//			score.setScore("D");
//		} else if (peaceTime.equals("F") && endTime.equals("F")) {
//			score.setScore("F");
//		} else if (peaceTime.equals("F") && endTime.equals("A")) {
//			score.setScore("F");
//		}
//		scoreService.saveScore(score);
		return "/teacher/course";
	}

	/**
	 * 获取subject调用方法名
	 * setattribute
	 * SESSIONallCourse
	 * 转发到schedulePage
	 * @throws IOException
	 */
	@RequestMapping("/findIdExist")
	@ResponseBody
	public String findIdExist(HttpSession session, String ids) throws IOException {
//		TStudent student = (TStudent) SecurityUtils.getSubject().getPrincipal();
//		String flag = "0";
//		List<TScore> exit = scoreService.findStudentExit(student.getSid(), ids);
//		if (exit.size() == 0) {
//			return flag;
//		} else {
//			flag = "1";
//			return flag;
//		}
	return "";
	}
	
	/**
	 * 转发到学生中的日期英语
	 */
	@RequestMapping("/findAllCourseByStudentId")
	public String findAllCourseByStudentId(HttpServletRequest request) {
//		Subject subject = SecurityUtils.getSubject();
//		TStudent student = (TStudent) subject.getPrincipal();
//		List<TScore> list = scoreService.findAllCourseByStudentId(student.getSid());
//		request.setAttribute("allCourse", list);
		return "forward:/score/schedulePage.action";
	}

	/**
	 * 获取用户，调用方法名
	 * @return
	 */
	@RequestMapping("/schedulePage")
	public String schedulePage() {
		return "/student/schedule";
	}
	
	/**
	 * 调用方法，转发带参数到学生添加缺勤中
	 * @return
	 */
	@RequestMapping("/findStudentScore")
	@ResponseBody
	public List findStudentScore() {
//		Subject subject = SecurityUtils.getSubject();
//		TStudent student = (TStudent) subject.getPrincipal();
//		List<TScore> list = scoreService.findStudentScore(student.getSid());
		return null;
	}

	/**
	 * 跳转到student中
	 * @return
	 */
	@RequestMapping("/addAbsent")
	public String addAbsent(String[] lateStudentId, String cid) {
//		scoreService.addAbsent(lateStudentId, cid);
		return "forward:/student/addStudentAbsent.action?lateStudentId=" + lateStudentId;
	}
}
