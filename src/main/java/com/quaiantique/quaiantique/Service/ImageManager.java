package com.quaiantique.quaiantique.Service;
import java.util.List;
import com.quaiantique.quaiantique.Entities.Image;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


public interface ImageManager {
    
    void saveImage(MultipartFile imageInfo) throws IOException;
    List<Image> getAllImages();

}
