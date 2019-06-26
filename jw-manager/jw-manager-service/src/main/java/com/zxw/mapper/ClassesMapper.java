package com.zxw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import pojo.TClasses;

import java.util.List;

public interface ClassesMapper extends BaseMapper<TClasses> {

    @Select("SELECT DISTINCT class.`id`,class.`classname`,s.`name` as specName,c.`name` collName FROM `t_specialty` AS s,`t_college` AS c,`t_classes` as class WHERE s.`college_id`=c.`id` and class.`specialty_id` = s.`id`;")
    List<TClasses> selectMyPage();
}
