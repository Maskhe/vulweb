package cn.bestsec.vulweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hjx
 * @since 2023/12/27
 * 文件上传服务
 */
@Service
public interface FileUploadService {
    /**
     *
     */
    void fileUpload(MultipartFile file) throws IOException;
}
