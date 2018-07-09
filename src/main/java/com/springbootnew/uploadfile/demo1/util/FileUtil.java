package com.springbootnew.uploadfile.demo1.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by renwujie on 2018/06/28 at 17:46
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
