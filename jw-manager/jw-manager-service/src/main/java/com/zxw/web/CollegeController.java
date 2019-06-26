package com.zxw.web;

import com.zxw.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.TCollege;
import vo.PageResult;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/pageQuery")
    public ResponseEntity<PageResult<TCollege>> queryCollegeByPage(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        PageResult<TCollege> result = collegeService.queryCollegeByPage(page, rows);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/saveCollege")
    public ResponseEntity saveCollege(@RequestBody TCollege college) {
        collegeService.saveCollege(college);
        return ResponseEntity.ok("");
    }

    @PutMapping("/update")
    public ResponseEntity updateById(@RequestBody TCollege college) {
        collegeService.updateById(college);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam("id") String id) {
        collegeService.deleteById("id");
        return ResponseEntity.ok("");
    }

    @GetMapping("/listajax")
    public ResponseEntity<List<TCollege>> listajax(){
        return ResponseEntity.ok(collegeService.listajax());
    }
}
