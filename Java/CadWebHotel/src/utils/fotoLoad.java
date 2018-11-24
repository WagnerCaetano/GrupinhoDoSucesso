/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 00
 */
public class fotoLoad {
    
    public static BufferedImage load(String fotoHotel) {
	try {
                BufferedImage img = ImageIO.read(new File(fotoHotel));
                return img;
	} catch (FileNotFoundException e) {
		System.out.println("Image not found" + e);
	} catch (IOException ioe) {
		System.out.println("Exception while reading the Image " + ioe);
	}
        return null;
    }
}
