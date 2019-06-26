package com.zxw.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.mapper.CollegeMapper;
import enums.ExceptionEnums;
import exception.JwException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.TCollege;
import vo.PageResult;

import java.util.List;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    public PageResult<TCollege> queryCollegeByPage(Integer page, Integer rows) {
        Page<TCollege> pageHelper = new Page<>(page, rows);
        QueryWrapper<TCollege> wrapper = new QueryWrapper<>();
        wrapper.orderBy(true, true, "id+0");
        IPage<TCollege> info = collegeMapper.selectPage(pageHelper, wrapper);
        List<TCollege> list = collegeMapper.selectList(wrapper);
        return new PageResult<>(info.getTotal(), info.getRecords());
    }

    public void saveCollege(TCollege college) {
        QueryWrapper<TCollege> wrapper = new QueryWrapper<>();
        wrapper.eq("name", college.getName());
        TCollege tCollege = collegeMapper.selectOne(wrapper);
        if (tCollege != null) {
            throw new JwException(ExceptionEnums.COLLEGE_ALREADY_EXIST);
        }
        collegeMapper.insert(college);
    }

    public void updateById(TCollege college) {
        QueryWrapper<TCollege> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", college.getId());
        TCollege tCollege = collegeMapper.selectOne(queryWrapper);
        if (tCollege == null) {
            throw new JwException(ExceptionEnums.COLLEGE_ALREADY_EXIST);
        }
        collegeMapper.updateById(college);
    }

    public void deleteById(String id) {
        QueryWrapper<TCollege> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        TCollege college = collegeMapper.selectOne(queryWrapper);
        if (college == null) {
            throw new JwException(ExceptionEnums.COLLEGE_ALREADY_EXIST);
        }
        UpdateWrapper<TCollege> wrapper = new UpdateWrapper(college);
        wrapper.set("status", "1");
        collegeMapper.update(college, wrapper);
    }

    public List<TCollege> listajax() {
        QueryWrapper<TCollege> wrapper = new QueryWrapper<>();
        List<TCollege> list = collegeMapper.selectList(wrapper);
        return list;
    }
}
