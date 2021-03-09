package com.example.demo.services;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class ImageService {

	public byte[] resize(byte[] bytesIn, int scaledWidth, int scaledHeight, String formatName)
            throws IOException {
		

        // reads input image
		InputStream is = new ByteArrayInputStream(bytesIn);
        BufferedImage inputImage = ImageIO.read(is);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(outputImage, formatName, baos);
        byte[] bytesOut = baos.toByteArray();
        
        return bytesOut;
    }
 
}
