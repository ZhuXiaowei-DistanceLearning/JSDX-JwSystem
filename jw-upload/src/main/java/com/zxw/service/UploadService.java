package com.zxw.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.zxw.client.StudentClient;
import enums.ExceptionEnums;
import exception.JwException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pojo.Student_Role;
import pojo.TStudent;
import utils.ThreadUtils;
import vo.FileInfo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Service
public class UploadService {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(UploadService.class);

    public static final List<String> allowsType = Arrays.asList("xls", "xlsx", "application/octet-stream");

    private static final String destPath = "C:\\Users\\zxw\\Desktop\\fileupload";
    @Transactional
    public FileInfo importXlsStudent(MultipartFile file, String cid) {
        try {
            // 校验文件
            String type = file.getContentType();
            // 准备目标路径
            // 保存文件到本地
            // 返回路径
            String filename = file.getOriginalFilename();
            if (!allowsType.contains(type)) {
                throw new JwException(ExceptionEnums.INVAILD_FILE_TYPE);
            }
// 创建
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            // 左下角单元
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                int rowNum = row.getRowNum();
                if (rowNum == 0) {
                    continue;
                }
                XSSFCell cell = (XSSFCell) row.getCell(0);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                String sid = cell.getStringCellValue();
                String sname = row.getCell(1).getStringCellValue();
                /**
                 * 转换
                 */
                XSSFCell cell2 = (XSSFCell) row.getCell(2);
                cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
                String password = cell2.getStringCellValue();
                String sex = row.getCell(3).getStringCellValue();
                String scity = row.getCell(4).getStringCellValue();
                String roleId = "b762e0f84ec911e8bf5d34de1af4e65a";
                String qx = "学生";
                TStudent student = new TStudent();
                student.setSname(sname);
                student.setScity(scity);
                student.setAbsent(0);
                student.setClassesId(cid);
                student.setPassword(password);
                student.setQx(qx);
                student.setSid(sid);
                student.setSex(sex);
                studentClient.insertStudent(student);
                Student_Role role = new Student_Role();
                role.setStudent_id(sid);
                role.setRole_id(roleId);
                studentClient.insertStudentRole(role);
            }
            ObjectId objectId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), "");
            file.transferTo(new File("C:\\Users\\zxw\\Desktop/" + file.getOriginalFilename()));
            return new FileInfo(objectId.toString(), file.getOriginalFilename());
        } catch (IOException e) {
            throw new JwException(ExceptionEnums.FILE_UPLOAD_FAIL);
        }
    }

    public Map<String, Object> ViewXlsPage(String objectId) {
        Map<String, Object> model = new HashMap<>();
        try {
            GridFSFile fsFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(objectId)));
            GridFSDownloadStream fsDownloadStream = gridFSBucket.openDownloadStream(fsFile.getObjectId());
            GridFsResource fsResource = new GridFsResource(fsFile, fsDownloadStream);
            XSSFWorkbook workbook = new XSSFWorkbook(fsResource.getInputStream());
            // 左下角单元
            XSSFSheet sheet = workbook.getSheetAt(0);
            List<TStudent> list = new ArrayList<>();
            for (Row row : sheet) {
                int rowNum = row.getRowNum();
                if (rowNum == 0) {
                    continue;
                }
                XSSFCell cell = (XSSFCell) row.getCell(0);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                String sid = cell.getStringCellValue();
                String sname = row.getCell(1).getStringCellValue();
                /**
                 * 转换
                 */
                XSSFCell cell2 = (XSSFCell) row.getCell(2);
                cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
                String password = cell2.getStringCellValue();
                String sex = row.getCell(3).getStringCellValue();
                String scity = row.getCell(4).getStringCellValue();
                TStudent student = new TStudent();
                student.setSname(sname);
                student.setScity(scity);
                student.setPassword(password);
                student.setSid(sid);
                student.setSex(sex);
                list.add(student);
            }
            model.put("list",list);
            model.put("name",fsFile.getFilename());
            return model;
        } catch (Exception e) {
            throw new JwException(ExceptionEnums.FILE_VIEW_FAIL);
        }
    }

    public void createHtml(String objectId) {
        Map<String, Object> model = ViewXlsPage(objectId);
        Context context = new Context();
        context.setVariables(model);
        String name = model.get("name").toString();
        // 创建输出流,临时文件
        File temp = new File(name+".html");
        // 目标页面文件
        File dest = createPath(name);
        // 备份文件
        File bak = new File(name + "_bak.html");
        try (PrintWriter writer = new PrintWriter(temp, "UTF-8")) {
            templateEngine.process("ViewXls", context, writer);
            if(dest.exists()){
                dest.renameTo(bak);
            }
            FileCopyUtils.copy(temp,dest);
            bak.delete();
        } catch (IOException e) {
            // 失败后，将备份页面恢复
            bak.renameTo(dest);
            // 重新抛出异常，声明页面生成失败
            throw new JwException(ExceptionEnums.FILE_IS_ESIXT);
        } finally {
            // 删除临时页面
            if (temp.exists()) {
                temp.delete();
            }
        }
    }

    private File createPath(String name) {
        if (name == null || name == "") {
            return null;
        }
        File dest = new File(this.destPath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        return new File(dest, name + ".html");
    }

    /**
     * 判断某个商品的页面是否存在
     * @return
     */
    public boolean exists(String name){
        return this.createPath(name).exists();
    }

    /**
     * 异步创建html页面
     */
    public void syncCreateHtml(String name){
        ThreadUtils.execute(() -> {
            try {
                createHtml(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
