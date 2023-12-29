package cn.bestsec.vulweb.controller;


import cn.bestsec.vulweb.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/fileupload")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;

    @RequestMapping("/level1")
    public String level1(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.fileUpload(file);
        return "123";
    }
}
