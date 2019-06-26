package com.zxw.web;

import com.zxw.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vo.FileInfo;

@Controller
@RequestMapping("/import")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/importXlsStudent")
    public FileInfo ImportXlsStudent(@RequestParam("file") MultipartFile file, @RequestParam("cid") String cid) {
        FileInfo fileInfo = uploadService.importXlsStudent(file,cid);
        return fileInfo;
    }

    @GetMapping("/ViewXlsPage/{objectId}")
    public String ViewXlsPage(@PathVariable("objectId") String objectId, Model model){
        uploadService.createHtml(objectId);
        return "/xls/ViewXls";
    }
}
