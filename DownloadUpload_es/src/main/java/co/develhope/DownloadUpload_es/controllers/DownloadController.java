package co.develhope.DownloadUpload_es.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/download")
public class DownloadController {
    @Value("{fileRepo}")
    private String fileRepo;

    @GetMapping
    public byte[] download(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        String extension = FilenameUtils.getExtension(fileName);

        // Switch-case per gestire diversi tipi di estensione
        switch (extension) {
            case "txt":
                response.setContentType(String.valueOf(MediaType.TEXT_PLAIN));
                break;

            case "doc":
            case "docx":
                response.setContentType(String.valueOf(MediaType.APPLICATION_OCTET_STREAM));
                break;

            case "jpg":
            case "jpeg":
                response.setContentType(String.valueOf(MediaType.IMAGE_JPEG));
                break;

            case "png":
                response.setContentType(String.valueOf(MediaType.IMAGE_PNG));
                break;

        }
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        File fileFromRepo = new File(fileRepo + "\\" + fileName);
        return IOUtils.toByteArray(new FileInputStream(fileFromRepo));
    }
}