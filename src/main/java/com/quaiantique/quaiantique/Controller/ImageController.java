package com.quaiantique.quaiantique.Controller;

import com.quaiantique.quaiantique.Service.ImageManager;
import com.quaiantique.quaiantique.Entities.ResponseFile;
import com.quaiantique.quaiantique.Entities.Image;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ImageController {


    @Autowired
    private ImageManager imageManager;

    
    @PostMapping("/upload")
    public void uploadImage (@RequestParam("file") MultipartFile file) throws IOException {
        imageManager.saveImage(file);
    }

    @GetMapping("/image")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = imageManager.getAllImages().map(dbFile -> {
    String fileDownloadUri = ServletUriComponentsBuilder
                  .fromCurrentContextPath()
                  .path("/image/")
                  .path(dbFile.getTitle())
                  .toUriString();
        
              return new ResponseFile(
                  dbFile.getTitle(),
                  fileDownloadUri,
                  dbFile.getType(),
                  dbFile.getImage().length);
            }).collect(Collectors.toList());
        
            return ResponseEntity.status(HttpStatus.OK).body(files);
          }

          @GetMapping("/image/{id}")
          public ResponseEntity<byte[]> getFile(@PathVariable String id) {
            Image image = imageManager.getImage(id);
            
        
            return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getTitle() + "\"")
                .body(image.getImage());
          }
    }
