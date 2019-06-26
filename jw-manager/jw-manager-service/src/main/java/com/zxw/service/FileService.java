package com.zxw.service;

import com.zxw.mapper.FileRepository;
import document.ImpXls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public void save(){
        ImpXls impXls = new ImpXls();
        impXls.setAliases("学生信息模板");
        impXls.setCreateDate(new Date());
        impXls.setFilename("软件7班");
        fileRepository.save(impXls);
    }

    public List<ImpXls> findAll(){
        List<ImpXls> all = fileRepository.findAll();
        return all;
    }


}
