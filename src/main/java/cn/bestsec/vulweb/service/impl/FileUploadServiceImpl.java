package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public void fileUpload(MultipartFile file) throws IOException {
        File uploadDir = new File("C:\\Users\\hjx\\tmp\\");
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String filePath = uploadDir + fileName;
        System.out.println(filePath);
        file.transferTo(new File(filePath));
    }
}
