package pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("t_classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TClasses {
    @TableId
    private String id;

    private String classname;

    @TableField(exist = false)
    private String specName;

    @TableField(exist = false)
    private String collName;

    @TableField(exist = false)
    private Integer isExist;

    @TableField(exist = false)
    private String objectId;

    @TableField(exist = false)
    private String fileName;

    @TableField(exist = false)
    private String path;
}