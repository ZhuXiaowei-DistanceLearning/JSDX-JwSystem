package com.zxw.service;

import com.zxw.client.ClassesClient;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import utils.FileUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ExportService {

    @Autowired
    private ClassesClient classesClient;


    public void ExportXlsModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个sheet页
        XSSFSheet sheet = workbook.createSheet("学生信息模板");
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 第一行表头
        XSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("学号");
        headRow.createCell(1).setCellValue("姓名");
        headRow.createCell(2).setCellValue("密码");
        headRow.createCell(3).setCellValue("性别");
        headRow.createCell(4).setCellValue("户籍");
        String filename = "学生信息模板.xlsx";
        String agent = request.getHeader("User-Agent");
        filename = FileUtils.encodeDownloadFilename(filename, agent);
        // 一个流两个头
        ServletOutputStream out = response.getOutputStream();
        String contentType = request.getSession().getServletContext().getMimeType(filename);
        response.setContentType(contentType);
        response.setHeader("content-disposition", "attchment;filename=" + filename);
        workbook.write(out);
    }

    public void ExportXlsStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void ViewXlsPage(String objectId, Model model) {
        this.classesClient.ViewXlsPage(objectId, model);
    }
}
