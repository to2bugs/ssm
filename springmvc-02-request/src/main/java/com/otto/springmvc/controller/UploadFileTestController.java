package com.otto.springmvc.controller;

import com.otto.springmvc.bean.Person;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 文件上传
 * 注意：只要请求数据不是json格式的字符串，就可以使用@RequestParam注解
 * 1, @RequestParam 取出文件项，并封装为MultipartFile，就可以拿到文件
 * 2, @RequestPart 与 @RequestParam 在文件上传时的使用方法一致
 */
@RestController
public class UploadFileTestController {

    private String uploadsDir = "/Users/to2bagezero/Desktop/uploads";

    @SneakyThrows
    @PostMapping("/handle08")
    public String handle08(
            Person person,
            @RequestParam("headerImg") MultipartFile headerImgFile,
            @RequestPart("lifeImg") List<MultipartFile> lifeImgFileList
    ) {
        System.out.println("person = " + person);

        // 1, 获取原始文件名称，包含扩展名
        String originalFilename = headerImgFile.getOriginalFilename();
        // 2, 获取文件大小
        long fileSize = headerImgFile.getSize();
        // 3, 获取文件流
        InputStream inputStream = headerImgFile.getInputStream();
        // 4, 文件保存
        headerImgFile.transferTo(new File(uploadsDir + File.separator + originalFilename));
        System.out.println(originalFilename + " : " + fileSize);

        System.out.println("========== 以上处理头像 ==========");
        System.out.println("========== 下面处理生活照 ==========");

        if (!lifeImgFileList.isEmpty()) {

            for (MultipartFile lifeImgFile : lifeImgFileList) {
                lifeImgFile.transferTo(new File(uploadsDir + File.separator + lifeImgFile.getOriginalFilename()));
            }
        }

        return "upload file success";
    }
}
