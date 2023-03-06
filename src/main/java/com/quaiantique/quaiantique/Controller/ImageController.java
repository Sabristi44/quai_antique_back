package com.quaiantique.quaiantique.Controller;

import com.quaiantique.quaiantique.Service.ImageManager;
import com.quaiantique.quaiantique.Entities.Image;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
public class ImageController {


    @Autowired
    private ImageManager imageManager;

    
    @PostMapping("/upload")
    public void uploadImage (@RequestBody MultipartFile image) throws IOException {
        imageManager.saveImage(image);
    }

    @GetMapping("/image")
    public List<Image> getAllImage () {
        return imageManager.getAllImages();
    }


}
