package com.zxw.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.mapper.SpecialtyMapper;
import enums.ExceptionEnums;
import exception.JwException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.TSpecialty;
import vo.PageResult;

import java.util.List;

@Service
@Transactional
public class SpecialtyService {
    @Autowired
    private SpecialtyMapper specialtyMapper;

    public PageResult<TSpecialty> queryCollegeByPage(Integer page, Integer rows) {
        Page<TSpecialty> pageHelper = new Page<>(page, rows);
        QueryWrapper<TSpecialty> wrapper = new QueryWrapper<>();
        wrapper.orderBy(true, true, "id+0");
        List<TSpecialty> list = specialtyMapper.selectMyPage();
        IPage<TSpecialty> info = specialtyMapper.selectPage(pageHelper, wrapper);
        info.setRecords(list);
        System.out.println(info);
        return new PageResult<>(info.getTotal(), info.getRecords());
    }

    public void saveCollege(TSpecialty college) {
        QueryWrapper<TSpecialty> wrapper = new QueryWrapper<>();
        wrapper.eq("name", college.getName());
        TSpecialty tCollege = specialtyMapper.selectOne(wrapper);
        if (tCollege != null) {
            throw new JwException(ExceptionEnums.COLLEGE_ALREADY_EXIST);
        }
        specialtyMapper.insert(college);
    }

    public void updateById(TSpecialty college) {
        QueryWrapper<TSpecialty> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", college.getId());
        TSpecialty tCollege = specialtyMapper.selectOne(queryWrapper);
        if (tCollege == null) {
            throw new JwException(ExceptionEnums.COLLEGE_ALREADY_EXIST);
        }
        specialtyMapper.updateById(college);
    }

    public void deleteById(String id) {
        QueryWrapper<TSpecialty> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        TSpecialty college = specialtyMapper.selectOne(queryWrapper);
        if (college == null) {
            throw new JwException(ExceptionEnums.COLLEGE_ALREADY_EXIST);
        }
        UpdateWrapper<TSpecialty> wrapper = new UpdateWrapper(college);
        wrapper.set("status", "1");
        specialtyMapper.update(college, wrapper);
    }

}
