package com.zxw;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.zxw.mapper.Student_RoleMapper;
import com.zxw.service.*;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.AuthFunction;
import pojo.Student_Role;
import pojo.TCollege;
import pojo.TSpecialty;
import vo.LoginUser;
import vo.PageResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    private FunctionService functionService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private ClassesSerivce classesSerivce;

    @Autowired
    private FileService fileService;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Autowired
    private Student_RoleMapper student_roleMapper;

    public static void main(String[] args) {
        String a = "软开1537班学生名单";
        String b= "软开1537";
        boolean b1 = a.contains(b);
        System.out.println(b1);
        Map<String,String> map = new HashMap<>();
        map.put("软开7班学生名单","123");
        boolean contains = map.keySet().contains("软开7班学生名单");
        boolean key = map.containsKey("软开7班学生名单");
        System.out.println(key);
        System.out.println(contains);
    }

    @org.junit.Test
    public void test1() {
        LoginUser loginUser = new LoginUser();
        loginUser.setId("1525123701");
        loginUser.setQx("学生");
        loginUser.setUsername("a");
        List<AuthFunction> list = functionService.findMenu(loginUser);
        System.out.println(list);
    }

    @org.junit.Test
    public void test2(){
        PageResult<TCollege> result = collegeService.queryCollegeByPage(1, 5);
        System.out.println(result);
    }

    @org.junit.Test
    public void test3(){
        TCollege college = new TCollege();
        college.setName("测试");
        college.setStatus("1");
        collegeService.saveCollege(college);
    }

    @org.junit.Test
    public void test4(){
        TCollege college = new TCollege();
        college.setId("1");
        college.setName("测试");
        college.setStatus("1");
        collegeService.updateById(college);
    }

    @org.junit.Test
    public void test5(){
        collegeService.deleteById("1");
    }

    @org.junit.Test
    public void test6(){
        PageResult<TSpecialty> result = specialtyService.queryCollegeByPage(1, 5);
    }

    @org.junit.Test
    public void test7(){
    }

    @org.junit.Test
    public void test8() throws Exception {
//        fileService.save();
//        List<ImpXls> all = fileService.findAll();
//        System.out.println(all);
        File file = new File("C:\\Users\\zxw\\Desktop/a.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "软件7班学生名单", "");
        String s = objectId.toString();
        System.out.println(s);
    }

    @org.junit.Test
    public void test9() throws IOException {
        String fileId = "5d108abbaf8d8604e47a2f3bd";
        // 根据id查文件
        GridFSFile file = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        // 打开下载流对象
        GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(file.getObjectId());
        // 创建gridResource,用户获取对象
        GridFsResource gridFsResource = new GridFsResource(file,downloadStream);
        // 获取流中的数据
        String s = IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");
        byte[] bytes = downloadStream.getGridFSFile().toString().getBytes();
        System.out.println(bytes);
        //System.out.println(s);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\zxw\\Desktop/b.xlsx");
        gridFSBucket.downloadToStream(file.getObjectId(),fos);
    }

    @org.junit.Test
    public void test10(){
        Student_Role student_role = new Student_Role();
        student_role.setRole_id("b762e0f84ec911e8bf5d34de1af4e65a");
        student_role.setStudent_id("1525123703");
        student_roleMapper.insert(student_role);
    }

    @org.junit.Test
    public void text11(){
        GridFSFindIterable fsFiles = gridFsTemplate.find(Query.query(Criteria.where("")));
        for (GridFSFile fsFile : fsFiles) {
            System.out.println(fsFile.getFilename().contains("软件7班"));
        }
    }


}
