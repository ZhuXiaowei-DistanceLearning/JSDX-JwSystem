package com.zxw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import pojo.TSpecialty;

import java.util.List;

public interface SpecialtyMapper extends BaseMapper<TSpecialty> {

    @Select("SELECT DISTINCT s.`id`,s.`name`,s.`status`,s.`college_id`,c.`name` AS collegeName,c.`status` FROM `t_specialty` AS s,`t_college` AS c WHERE s.`college_id`=c.`id`")
    List<TSpecialty> selectMyPage();
}
