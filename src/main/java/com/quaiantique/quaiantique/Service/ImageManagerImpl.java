package com.quaiantique.quaiantique.Service;

import org.springframework.stereotype.Service;
import java.util.stream.Stream;

import com.quaiantique.quaiantique.Entities.Image;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import com.quaiantique.quaiantique.DAO.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

import java.util.zip.InflaterInputStream;
import java.io.ByteArrayInputStream;

@Service 
public class ImageManagerImpl implements ImageManager{

    @Autowired
    private ImageDAO imageDAO;
    
    public void saveImage(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Image fileDB = new Image(fileName, file.getContentType(), file.getBytes());
		imageDAO.save(fileDB);	
	}

	public Stream<Image> getAllImages() {
     return imageDAO.findAll().stream();
	}

	public Image getImage(String id) {
		return imageDAO.findById(id).get();
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
	public static byte[] decompressBytes(byte[] bytes) {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read;
		try {
        while ((read = inflaterInputStream.read()) != -1) {
            byteArrayOutputStream.write(read);
        }
        inflaterInputStream.close();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
	}  catch (IOException e) {
	}
	return byteArrayOutputStream.toByteArray();
	}
}
