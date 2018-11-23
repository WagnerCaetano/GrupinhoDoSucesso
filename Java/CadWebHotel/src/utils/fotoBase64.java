/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author 00
 */
public class fotoBase64 {
    
    public static String encoder(String imagePath) {
	String base64Image = "";
	File file = new File(imagePath);
	try (FileInputStream imageInFile = new FileInputStream(file)) {
		// Reading a Image file from file system
		byte imageData[] = new byte[(int) file.length()];
		imageInFile.read(imageData);
		base64Image = Base64.getEncoder().encodeToString(imageData);
            } catch (FileNotFoundException e) {
		System.out.println("Image not found" + e);
            } catch (IOException ioe) {
		System.out.println("Exception while reading the Image " + ioe);
            }
        return base64Image;
        }
    
    public static BufferedImage decoder(String base64Image) {
	try {
		// Converting a Base64 String into Image byte array
		byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageByteArray));
                return img;
	} catch (FileNotFoundException e) {
		System.out.println("Image not found" + e);
	} catch (IOException ioe) {
		System.out.println("Exception while reading the Image " + ioe);
	}
        return null;
    }
}
