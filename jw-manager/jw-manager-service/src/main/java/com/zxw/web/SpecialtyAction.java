package com.zxw.web;

import com.zxw.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.TSpecialty;
import vo.PageResult;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyAction {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/pageQuery")
    public ResponseEntity<PageResult<TSpecialty>> queryCollegeByPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        PageResult<TSpecialty> result = specialtyService.queryCollegeByPage(page, rows);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/saveSpecialty")
    public ResponseEntity saveSpecialty(@RequestBody TSpecialty college) {
        specialtyService.saveCollege(college);
        return ResponseEntity.ok("");
    }

    @PutMapping("/updateById")
    public ResponseEntity updateById(@RequestBody TSpecialty college) {
        specialtyService.updateById(college);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity deleteById(@RequestParam("id") String id) {
        specialtyService.deleteById("id");
        return ResponseEntity.ok("");
    }

    @RequestMapping("/listajax")
    @ResponseBody
    public List<TSpecialty> listajax() throws IOException {
        //List<TSpecialty> list = specialtyService.listajax();
        return null;
    }

}
