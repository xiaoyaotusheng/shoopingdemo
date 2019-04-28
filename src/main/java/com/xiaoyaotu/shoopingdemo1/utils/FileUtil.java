package com.xiaoyaotu.shoopingdemo1.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class FileUtil {

    /**
     *  上传文件
     */
    public static String addFile(HttpServletRequest request, String wjlj, MultipartFile file) throws IOException {
        String path = request.getSession().getServletContext().getRealPath(wjlj);
        String realPath = DateUtils.getStringByDateForDay3(new Date()) + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
        File dest = new File(path + realPath);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        file.transferTo(dest);
        return realPath;
    }
    /**
     *  上传文件,需要传递时间
     */
    public static void  uploadFile( String path,String filename, MultipartFile file)throws IOException{
        File dest = new File(path + filename);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        file.transferTo(dest);
    }


    /**
     *  上传多个文件 返回文件列表
     */
    public static List<MultipartFile> getfile(HttpServletRequest request) {
        List<MultipartFile> files = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            files = multiRequest.getFiles("file");
        }
        return files;
    }


}
