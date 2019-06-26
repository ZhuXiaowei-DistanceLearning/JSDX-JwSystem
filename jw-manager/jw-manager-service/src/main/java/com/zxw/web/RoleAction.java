package com.zxw.web;

import com.zxw.service.RoleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleAction {
	@Autowired
	private RoleSerivce roleSerivce;

	@RequestMapping("/add")
	public String add(String ids) {
		//roleSerivce.save(role, ids);
		return "/admin/role";
	}

	@RequestMapping("/pageQuery")
	@ResponseBody
	public String pageQuery(Integer page, Integer rows) throws IOException {
		//EasyUIDataGridResult result = roleSerivce.pageQuery(page, rows);
		return "";
	}

	@RequestMapping("/listajax")
	@ResponseBody
	public List listajax() throws IOException {
		//List<AuthRole> list = roleSerivce.findAll();
		return null;
	}

}
