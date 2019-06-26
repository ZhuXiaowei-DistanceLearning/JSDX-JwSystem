package pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("student_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student_Role {
    @TableId
    private String role_id;

    @TableId
    private String student_id;
}
