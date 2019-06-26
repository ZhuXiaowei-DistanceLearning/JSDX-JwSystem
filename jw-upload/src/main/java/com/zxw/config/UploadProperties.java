package com.zxw.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;

@ConfigurationProperties(prefix = "jw.upload")
@Data
public class UploadProperties {
    private String basicPath;
    private String uploadPath;

    @PostConstruct
    public void init(){
        System.out.println("------------");
        System.out.println("    ****    ");
        System.out.println("------------");

        System.out.println("初始化文件上传地址");
        File file = new File(basicPath);
        if(!file.exists()){
            file.mkdir();
        }

        System.out.println("初始化地址成功");
    }
}
