package com.xiaoyaotu.shoopingdemo1.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileUtil {



    static SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");

    public static String savefile(MultipartFile file, String filename, String yyid) {
//        String path = "upload/";
        String path = "E://upload/";
        String filepath = "";
        if (!file.isEmpty()) {
            if (!StringUtil.isEmpty(yyid))
                filepath = yyid.concat("/");
            try {
                path = path + filepath + filename;
                File dest = new File(path);
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();// 新建文件夹
                }
                file.transferTo(dest);// 文件写入
                return filepath + filename;
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    public static String batchUpload(HttpServletRequest request, List<MultipartFile> files, String filename) {
        String path = request.getSession().getServletContext().getRealPath("upload/");
//        String path = "E://upload/";
        File fileDir = new File(path);
        if (!fileDir.exists()) {// 不存在就创建
            if (!fileDir.isDirectory()) {
                fileDir.mkdirs();
            }
        }

        MultipartFile file = null;
        BufferedOutputStream stream = null;

        int ss = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (filename != null && !filename.isEmpty()) {
            stringBuilder.append(filename).append(",");
//            String[] strold = filename.split(",");
//            String[] redix = strold[strold.length - 1].split(".");
//            try {
//                ss = Integer.valueOf(redix[0]);
//            } catch (Exception e) {
//                ss = 0;
//            }
        }
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
//                    byte[] bytes = file.getBytes();
                    String fileName = file.getOriginalFilename();
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String name = (ss + i + 1) + "." + fileName.substring(0, fileName.lastIndexOf(".")).concat("_" + formatter.format(new Date()).concat(suffix));
                    File dest = new File(path + name);
                    file.transferTo(dest);
//                    stream = new BufferedOutputStream(new FileOutputStream(new File(path + name)));
//                    stream.write(bytes);
//                    stream.close();
                    stringBuilder.append(name + ",");
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (stringBuilder != null && stringBuilder.length() != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static String setfile(HttpServletRequest request, String oldfilename) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            List<MultipartFile> files = multiRequest.getFiles("file");
            String filename;
            if (files != null && files.size() != 0) {
                filename = batchUpload(request, files, oldfilename);
                return filename;
            }
        }
        return oldfilename;
    }



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
