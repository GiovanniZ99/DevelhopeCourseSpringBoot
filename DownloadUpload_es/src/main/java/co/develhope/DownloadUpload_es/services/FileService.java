package co.develhope.DownloadUpload_es.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileService {

    @Value("${fileRepo}")
    private String fileRepo;

    public String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Empty file");
        }

        // ci prendiamo l'estensione per preservarla e controllarla
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(extension != null) {
            switch (extension.toLowerCase()) {
                case "jpg":
                case "jpeg":
                case "png":
                    break; // avrei potuto mettere anche docx, pdf, txt ecc.
                default:
                    throw new IOException("Invalid file type"); // classe di eccezioni per errori di input/output, inclusi i file
            }
        }else{
            throw new IOException("Invalid file type");
        }
        // Costruiamo il nuovo nome del file con un uuid per non avere casi di omonimia + . + estensione
        String newFileName = UUID.randomUUID() + "." + extension;

        // creiamo la directory partendo con il percorso del .properties
        Files.createDirectories(Paths.get(fileRepo));

        // costruiamo il percorso completo del file con dentro il file, usiamo File.Separator per interporre uno /
        File finalFile = new File(fileRepo + File.separator + newFileName);
        // e lo trasferiamo nel percorso
        file.transferTo(finalFile);

        // ritorniamo il file singolo
        return newFileName;
    }


        public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
            // Costruiamo il percorso completo del file come prima
            String filePath = fileRepo + File.separator + fileName;
            File toDownload = new File(filePath);

            // Controlliamo se il file esiste
            if (!toDownload.exists()) {
                throw new FileNotFoundException("File " + fileName + " not found");
            }

            // Determina l'estensione del file
            String extension = FilenameUtils.getExtension(fileName);

            // Imposta il tipo di contenuto in base all'estensione del file
            MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

            switch (extension.toLowerCase()) {
                case "txt":
                    mediaType = MediaType.TEXT_PLAIN;
                    break;
                case "doc":
                case "docx":
                    mediaType = MediaType.APPLICATION_OCTET_STREAM;
                    break;
                case "jpg":
                case "jpeg":
                    mediaType = MediaType.IMAGE_JPEG;
                    break;
                case "png":
                    mediaType = MediaType.IMAGE_PNG;
                    break;
            }

            // Leggiamo i byte del file
            byte[] fileContent;
            try (FileInputStream fis = new FileInputStream(toDownload)) {
                fileContent = IOUtils.toByteArray(fis);
            } catch (IOException e) {
                throw new IOException("Error reading file: " + fileName, e);
            }

            // Imposta l'header Content-Disposition per indicare che il file è da scaricare
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(mediaType);
            headers.setContentDispositionFormData("attachment", fileName);

            // Crea e ritorna ResponseEntity con i byte del file, gli header appropriati e lo stato http 200
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        }
}
