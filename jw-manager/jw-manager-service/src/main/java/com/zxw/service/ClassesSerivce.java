package com.zxw.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.zxw.mapper.ClassesMapper;
import enums.ExceptionEnums;
import exception.JwException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import pojo.TClasses;
import pojo.TStudent;
import vo.FileInfo;
import vo.PageResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesSerivce {

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public PageResult<TClasses> queryCollegeByPage(Integer page, Integer rows) {
        Page<TClasses> p = new Page<>(page, rows);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderBy(true, true, "id+0");
        List<TClasses> list = classesMapper.selectMyPage();
        IPage info = classesMapper.selectPage(p, wrapper);
        List<FileInfo> fileList = new ArrayList<>();
        GridFSFindIterable files = gridFsTemplate.find(Query.query(Criteria.where("")));
        for (GridFSFile file : files) {
            fileList.add(new FileInfo(file.getObjectId().toString(), file.getFilename()));
//            fileList.add(map);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < fileList.size(); j++) {
                if (fileList.get(j).getFileName().contains(list.get(i).getClassname())) {
                    list.get(i).setObjectId(fileList.get(j).getObjectId());
                    list.get(i).setFileName(fileList.get(j).getFileName());
                    list.get(i).setIsExist(1);
                    fileList.remove(list.get(j));
                    break;
                }
            }
        }
        info.setRecords(list);
        return new PageResult<>(info.getTotal(), info.getRecords());
    }

    public void saveCollege(TClasses college) {
    }

    public void updateById(TClasses college) {
    }

    public void deleteById(String id) {
    }

    public List<TStudent> ViewXlsPage(String objectId) {
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
            return list;
        } catch (Exception e) {
            throw new JwException(ExceptionEnums.FILE_VIEW_FAIL);
        }
    }
}