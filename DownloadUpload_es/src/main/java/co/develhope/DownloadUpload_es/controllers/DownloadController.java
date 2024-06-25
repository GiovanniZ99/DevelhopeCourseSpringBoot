package co.develhope.DownloadUpload_es.controllers;

import co.develhope.DownloadUpload_es.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/* per scaricare lo stesso file che abbiamo caricato in precedenza, basta copiare nella get
il nome del file univoco che viene restituito nella post del medesimo file */

@RestController
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    FileService fileService;

    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        try {
            return fileService.downloadFile(fileName);
        } catch (IOException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}