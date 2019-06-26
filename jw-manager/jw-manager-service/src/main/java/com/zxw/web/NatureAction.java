package com.zxw.web;

import com.zxw.service.NatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/nature")
public class NatureAction {
	@Autowired
	private NatureService natureService;

	@RequestMapping("/listajax")
	@ResponseBody
	public List listajax() throws IOException {
//		List<TNature> list = natureService.findAll();
		return null;
	}
}
