package com.alibaba.jiangstorage.param;

import lombok.Data;

/**
 * @ClassName FileParam
 * @Description: 文件上传返回给前端的对象
 * @Author jiang
 * @Date 2020/8/18 16:56
 **/
@Data
public class FileParam {
    private Long id;
    private String fileName;
    private String url;
}
