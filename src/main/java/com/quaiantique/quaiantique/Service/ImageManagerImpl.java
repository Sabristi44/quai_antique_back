package com.quaiantique.quaiantique.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.quaiantique.quaiantique.Entities.Image;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.quaiantique.quaiantique.DAO.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;

@Service 
public class ImageManagerImpl implements ImageManager{

    @Autowired
    private ImageDAO imageDAO;
    
    public void saveImage(MultipartFile file) throws IOException {
        final Image image = new Image(file.getOriginalFilename(),compressBytes(file.getBytes()),file.getContentType());
		imageDAO.save(image);	
	}

	public List<Image> getAllImages() {
        final List<Image> retrievedImages = imageDAO.findAll();
        List<Image> images = new ArrayList<Image>();
        
        for(Image image : retrievedImages) {
            final Image imageDecompressed = new Image(image.getTitle(),decompressBytes(image.getImage()), image.getType());
            images.add(imageDecompressed);
        }

        return images;

	}

    // compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}


    // uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
