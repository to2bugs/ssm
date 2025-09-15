package com.otto.springmvc.controller;

import lombok.SneakyThrows;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * 文件下载
 *   需要在响应头中告诉浏览器，此次响应不是普通的响应，而是下载响应。浏览器就会自动的下载文件的
 *   即http强制规定的内容处理方式
 *
 *  HttpEntity: 拿到整个请求数据，其包含请求头、请求体
 *  ResponseEntity: 拿到整个响应数据，其包含响应头、响应体、状态码
 *      ResponseEntity<byte[]>: 响应体中的数据是字节流
 *      ResponseEntity<Person>: 响应体中的数据是Person对象，会自动的转换为JSON字符串
 */
@RestController
public class DownLoadTestController {

    private String downFilePath = "/Users/to2bagezero/Desktop/uploads";

    /**
     * 以下的写法会有小bug:
     * 1, 中文的文件名会出现乱码
     *      需要对文件名进行编码
     * 2，文件太大会出现内存溢出，因为是一次性的获取到文件的字节流fileInputStream.readAllBytes()
     */
    // @SneakyThrows
    // @RequestMapping("/download")
    // public ResponseEntity<byte[]> downLoad() {
    //     // 获取文件的输入流
    //     File file = new File(downFilePath + File.separator + "github.png");
    //     FileInputStream fileInputStream = new FileInputStream(file);
    //
    //     // 获取文件的字节流
    //     byte[] allBytes = fileInputStream.readAllBytes();
    //
    //     // 这样写，浏览器会打开下载的文件，会出现乱码
    //     // return ResponseEntity.ok(allBytes);
    //     // 需要在响应头中告诉浏览器，此次响应不是普通的响应，而是下载响应
    //     return ResponseEntity.ok()
    //             .header("Content-Disposition", "attachment; filename="+ file.getName()) // http强制规定的内容处理方式
    //             .contentType(MediaType.APPLICATION_OCTET_STREAM) // 内容类型: 8位的字节流
    //             .contentLength(allBytes.length) // 内容文件的大小
    //             .body(allBytes);


    /**
     *
     * 文件下载的固定写法，唯一需要修改的是下载哪个文件
     *
     * 1, 中文的文件名会出现乱码
     *      需要对文件名进行编码
     * 2，文件太大会出现内存溢出，因为是一次性的获取到文件的字节流fileInputStream.readAllBytes()
     *      。将返回的类型由 ResponseEntity<byte[]> 修改为 ResponseEntity<InputStreamResource>
     *      。使用 InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream)读取文件字节流
     *      。返回 .body(inputStreamResource)
     */
    @SneakyThrows
    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> downLoad() {
        // 获取文件的输入流
        File file = new File(downFilePath + File.separator + "github.png");
        FileInputStream fileInputStream = new FileInputStream(file);



        // **** update: 对文件名进行编码，防止中文的文件名出现乱码，浏览器不识别的问题
        String filename = URLEncoder.encode("给你个美女.png", "UTF-8");


        // 一次性的获取文件的所有字节流，当文件很大时会出现内存溢出
        // 解决的办法是一边读，一边返回
        // 将返回的类型由 ResponseEntity<byte[]> 修改为 ResponseEntity<InputStreamResource>
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);


        // 这样写，浏览器会打开下载的文件，会出现乱码
        // return ResponseEntity.ok(allBytes);
        // 需要在响应头中告诉浏览器，此次响应不是普通的响应，而是下载响应
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename="+ filename) // http强制规定的内容处理方式
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // 内容类型: 8位的字节流
                .contentLength(fileInputStream.available()) // 内容文件的大小
                .body(inputStreamResource);
    }
}
