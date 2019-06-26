package com.zxw.web;

import com.zxw.service.ClassesSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.TClasses;
import pojo.TStudent;
import vo.PageResult;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassesAction {
	@Autowired
	private ClassesSerivce classesSerivce;


	@GetMapping("/pageQuery")
	public ResponseEntity<PageResult<TClasses>> queryCollegeByPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
		PageResult<TClasses> result = classesSerivce.queryCollegeByPage(page, rows);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/saveClasses")
	public ResponseEntity saveCollege(@RequestBody TClasses college) {
		classesSerivce.saveCollege(college);
		return ResponseEntity.ok("");
	}

	@PutMapping("/update")
	public ResponseEntity updateById(@RequestBody TClasses college) {
		classesSerivce.updateById(college);
		return ResponseEntity.ok("");
	}

	@DeleteMapping("/delete")
	public ResponseEntity deleteById(@RequestParam("id") String id) {
		classesSerivce.deleteById("id");
		return ResponseEntity.ok("");
	}

	@GetMapping("/ViewXlsPage/{objectId}")
	public String ViewXlsPage(@PathVariable("objectId") String objectId, Model model){
		List<TStudent> list = classesSerivce.ViewXlsPage(objectId);
		System.out.println(list);
		model.addAttribute("list",list);
		return "/xls/ViewXls";
	}

//	@GetMapping("/listajax")
//	public ResponseEntity<List<TClasses>> listajax(){
//		return ResponseEntity(classesSerivce.listajax());
//	}

}
