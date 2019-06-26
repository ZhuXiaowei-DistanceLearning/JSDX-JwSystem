package com.zxw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.AuthFunction;

import java.util.List;

public interface FunctionMapper extends BaseMapper<AuthFunction> {
    @Select("SELECT\n" +
            "\t\tDISTINCT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id`\n" +
            "\t\tLEFT OUTER JOIN `user_role` ON ar.`id`=\n" +
            "\t\t`user_role`.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_user` ON\n" +
            "\t\t`user_role`.`user_id`=`t_user`.`id`\n" +
            "\t\tWHERE\n" +
            "\t\t`t_user`.`id`=#{id} AND\n" +
            "\t\tf.`generatemenu` = '1' ORDER\n" +
            "\t\tBY f.`zindex`\n" +
            "\t\tDESC;")
    List<AuthFunction> findMenuByUserid(@Param("id") String id);

    @Select("SELECT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id`\n" +
            "\t\tLEFT OUTER JOIN `teacher_role` ON ar.`id`=\n" +
            "\t\tteacher_role.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_teacher` ON\n" +
            "\t\tteacher_role.`teacher_id`=t_teacher.`tid`\n" +
            "\t\tWHERE\n" +
            "\t\tt_teacher.`tid`=#{id} AND f.`generatemenu` = '1' ORDER\n" +
            "\t\tBY f.`zindex`\n" +
            "\t\tDESC;")
    List<AuthFunction> findMenuByTeacherid(@Param("id") String id);

    @Select("SELECT\n" +
            "\t\tf.`id`,f.NAME,f.CODE,f.description,f.page,f.generatemenu,f.zindex,f.pid\n" +
            "\t\tFROM\n" +
            "\t\t`auth_function` f LEFT OUTER JOIN\n" +
            "\t\t`role_function` r ON\n" +
            "\t\tr.`function_id`=f.`id`\n" +
            "\t\tLEFT OUTER JOIN `auth_role`\n" +
            "\t\tar ON\n" +
            "\t\tr.`role_id`=ar.`id`\n" +
            "\t\tLEFT OUTER JOIN `student_role` ON ar.`id`=\n" +
            "\t\tstudent_role.`role_id`\n" +
            "\t\tLEFT OUTER JOIN `t_student` ON\n" +
            "\t\tstudent_role.`student_id`=t_student.`sid`\n" +
            "\t\tWHERE\n" +
            "\t\tt_student.`sid`=#{id} AND f.`generatemenu` = '1' ORDER\n" +
            "\t\tBY f.`zindex`\n" +
            "\t\tDESC;")
    List<AuthFunction> findMenuByStudentid(@Param("id") String id);
}
