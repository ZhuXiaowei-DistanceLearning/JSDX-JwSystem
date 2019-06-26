package com.zxw.web;

import com.zxw.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.TTeacher;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherAction {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/pageQuery")
	@ResponseBody
	public String pageQuery(Integer page, Integer rows) throws IOException {
//		EasyUIDataGridResult result = teacherService.pageQuery(page, rows);
		return "";
	}

	@RequestMapping("/listajax")
	@ResponseBody
	public List listajax() throws IOException {
//		List<TTeacher> list = teacherService.findListNoStatus();
		return null;
	}

	/**
	 * 添加用户
	 */
	@RequestMapping("/add")
	public String add(TTeacher teacher, String roleIds) {
//		teacherService.save(teacher, roleIds);
		return "/base/teacher";
	}

	@RequestMapping("/page")
	public String page() {
		return "/base/teacher";
	}

	@RequestMapping("/userinfo")
	public String userinfoPage() {
		return "/admin/userinfo";
	}
}
