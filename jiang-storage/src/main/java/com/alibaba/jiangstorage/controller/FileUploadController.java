package com.alibaba.jiangstorage.controller;

import com.alibaba.jiangstorage.config.DfsConfig;
import com.alibaba.jiangstorage.model.SysFile;
import com.alibaba.jiangstorage.param.FileParam;
import com.alibaba.jiangstorage.service.SysFileService;
import com.jiang.api.ApiResult;
import com.jiang.util.FileUploadUtils;
import com.jiang.util.FileUtils;
import com.jiang.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @ClassName FileUploadController
 * @Description: 文件管理
 * @Author jiang
 * @Date 2020/8/18 16:05
 **/
@Slf4j
@RestController
@RequestMapping("file/")
public class FileUploadController {
    @Autowired
    private DfsConfig dfsConfig;
    @Autowired
    private SysFileService sysFileService;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("download")
    public void download(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.isValidFilename(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = dfsConfig.getPath() + fileName;
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("upload")
    public ApiResult upload(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = dfsConfig.getPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = dfsConfig.getDomain() + fileName;
            // 封装返回对象
            FileParam param = new FileParam();
            param.setFileName(fileName);
            param.setUrl(url);
            // 上传记录持久化 TODO返回对象id需要添加记录才能拿到
            SysFile sysFile = new SysFile();
            sysFile.setCreateTime(LocalDateTime.now());
            sysFile.setFileName(fileName);
            sysFile.setUrl(url);
            Long id = sysFileService.save(sysFile);
            param.setId(id);
            return ApiResult.success(param);
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return ApiResult.failed(e.getMessage());
        }
    }
}
