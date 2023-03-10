package com.quaiantique.quaiantique.Service;
import com.quaiantique.quaiantique.Entities.Image;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.stream.Stream;

public interface ImageManager {
    
    void saveImage(MultipartFile imageInfo) throws IOException;
    Stream<Image> getAllImages();
    Image getImage(String id);
}
