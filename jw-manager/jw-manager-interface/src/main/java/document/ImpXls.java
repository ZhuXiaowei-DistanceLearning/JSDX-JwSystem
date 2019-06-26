package document;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ImpXls {
    private Date createDate;
    private Date updateDate;
    private String filename;
    private String aliases;
    private String contentType;
    private String md5;
}
