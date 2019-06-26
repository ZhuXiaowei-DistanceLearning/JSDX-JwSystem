package com.zxw.web;

import com.zxw.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @GetMapping("/exportModel")
    public void ExportXlsModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        exportService.ExportXlsModel(request, response);
    }

    @GetMapping("/exportStudent")
    public void ExportXlsStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        exportService.ExportXlsStudent(request, response);
    }

    @GetMapping("/ViewXlsPage/{objectId}")
    public String ViewXlsPage(@PathVariable("objectId") String objectId, Model model){
       exportService.ViewXlsPage(objectId,model);
       return "/xls/ViewXls";
    }
    /**
     * 导入学生信息
     */
    public void ImportXlsStudent() throws FileNotFoundException, IOException {
    }
}
