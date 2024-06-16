package co.develhope.DownloadUpload_es.controllers;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Value("${fileRepo}")
    private String fileRepo;

    @PostMapping
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {
        // preserviamo l'estensione ma...
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        // facciamo in modo che i nomi dei file non siano gli stessi assegnandogli un uuid
        String newFileName = UUID.randomUUID().toString()+ extension;

        File finalFolder = new File("{fileRepo}" + newFileName);
        file.transferTo(finalFolder);

        return newFileName;
    }
}
