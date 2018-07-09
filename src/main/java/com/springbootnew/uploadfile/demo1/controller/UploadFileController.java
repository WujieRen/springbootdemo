package com.springbootnew.uploadfile.demo1.controller;

import com.springbootnew.uploadfile.demo1.util.ParseFileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by renwujie on 2018/06/28 at 17:41
 */
@Controller
public class UploadFileController {
    @GetMapping("/gouploading")
    public String goUploading() {
        return "uploading";
    }

    @PostMapping("/testuploadimg")
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {

        System.out.println(file.getOriginalFilename()+"~~~");

        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("alg/upload/");
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath + fileName));
            //FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            ParseFileUtil.resolveCompressUploadFile(request, file, filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传出错");
        }



        return "uploading success";
    }
}
