package pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("t_specialty")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TSpecialty {
    @TableId
    private String id;

    private String name;

    @TableField(value = "college_id")
    private String collegeId;

    private String status = "0";

    @TableField(value="collegeName",exist = false)
    private String collegeName;

}