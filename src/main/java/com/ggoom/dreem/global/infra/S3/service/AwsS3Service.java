package com.ggoom.dreem.global.infra.S3.service;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.Copy;
import com.ggoom.dreem.global.infra.S3.config.AwsProperties;
import com.ggoom.dreem.global.infra.S3.config.AwsS3Config;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AwsS3Service {

    private final AwsProperties awsProperties;

    private final AwsS3Config amazonS3;


    public String uploadFile(MultipartFile multipartFile) {
        String fileName = createFileName(multipartFile.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.amazonS3Client().putObject(new PutObjectRequest(awsProperties.getBucket(), fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드에 실패했습니다.");
        }

        return awsProperties.getUrl() + fileName;
    }

    public void deleteFiles(List<String> imgUrls) {
        imgUrls.forEach(this::deleteFile);
    }

    public void deleteFile(String imgUrl) {
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
        amazonS3.amazonS3Client().deleteObject(new DeleteObjectRequest(awsProperties.getBucket(), fileName));
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception e) {
            throw new RuntimeException("잘못된 형식의 파일입니다.");
        }
    }
}
