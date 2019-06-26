package com.zxw.web;

import com.zxw.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionAction {
	@Autowired
	private SectionService sectionService;

	@RequestMapping("/listajax")
	@ResponseBody
	public List listajax() throws IOException {
//		List<TSection> list = sectionService.findAll();
		return null;
	}
}
