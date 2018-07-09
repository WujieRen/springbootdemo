package com.springbootnew.uploadfile.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by renwujie on 2018/07/09 at 12:55
 * <p>
 * 上传文件逻辑
 */
@SpringBootApplication
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/fileUpload/{fileHtml}")
    public String uploadFile(@PathVariable("fileHtml") String name) {
        return name;
    }

    @RequestMapping("/uploadFilesAndOneFile")
    public String ArrayFilesAndOneFile(@RequestParam("myfiles") MultipartFile[] myfiles, MultipartFile myfile, String name, String age, Model map) throws IOException {
        //用于接收文件
        //多个文件
        for (MultipartFile file : myfiles) {
            if(file.isEmpty()) continue;
            String fileName = file.getOriginalFilename();
            File filePath = new File("W:\\opt\\up\\mutiple\\" + fileName);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            file.transferTo(filePath);
            //FileUtils.copyInputStreamToFile(file.getInputStream(), filePath);
        }


        //处理单个文件
        String fileName = myfile.getOriginalFilename();
        File file = new File("W:\\opt\\up\\single\\" + fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        myfile.transferTo(file);
        //FileUtils.copyInputStreamToFile(myfile.getInputStream(), file);
        System.out.println("" +
                "接收到的name： " + name +
                ", age: " + age +
                " 多文件文件名： [" +
                //builder.toString().substring(0, builder.toString().length()-2) +
                "]" +
                " 单文件名：" + fileName);
        map.addAttribute("result", "succeed");

        return "result";
    }
}
