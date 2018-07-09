package com.springbootnew.uploadfile.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by renwujie on 2018/06/28 at 23:22
 */
public class ParseFileUtil {
    public static String resolveCompressUploadFile(HttpServletRequest request, MultipartFile file, String path) throws Exception {
        if(file.isEmpty()) {
            throw new Exception("文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        int pos = fileName.lastIndexOf(".");
        String extName = fileName.substring(pos + 1).toLowerCase();
        //判断上传文件必须是zip或者是rar否则不允许上传
        if (!extName.equals("zip") && !extName.equals("rar")) {
                throw new Exception("上传文件格式错误，请重新上传");
        }

        /// 文件全名
        String saveName = fileName.substring(0, pos) + "." + extName;
        //文件名
        String saveFileName = saveName.substring(0, saveName.lastIndexOf("."));
        // 根据服务器的文件保存地址和原文件名创建目录文件全路径
        File pushFile = new File(path + "/" + saveName);

        File descFile = new File(path);
        if (!descFile.exists()) {
            descFile.mkdirs();
        }
        //解压目的文件到descRir
        String descDir = path + "/";

        file.transferTo(pushFile);

        //开始解压zip
        if (extName.equals("zip")) {
            UnComprassFileUtil2.unZipFiles(pushFile, descDir);
        } else if (extName.equals("rar")) {
            //开始解压rar
            System.out.println(pushFile.getAbsolutePath()+"---");

            UncomprassFileUtil.unRarFile(pushFile.getAbsolutePath(), descDir);
        } else {
            try {
                throw new Exception("文件格式不正确不能解压");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //遍历文件夹
        boolean isExist = checkIndexHtml(descDir + saveFileName);
        if (!isExist) {
            try {
                throw new Exception("文件中缺少index.html");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return saveFileName;
    }

    /**
     * 检查是否有index.html
     *
     * @param strPath
     * @return
     */
    public static boolean checkIndexHtml(String strPath) {

        System.out.println(strPath+"0000000000");

        boolean flag = false;
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                if ("index.html".equals(fileName)) { // 判断是否有index.html
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
