/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Seth, Marco, Icon
 */
public class ImageLoader {
    
    public ImageIcon getImage(char arrayText) {
        ImageIcon image = null;
        
            switch(arrayText) {
                case '_': image = new ImageIcon("src/dungeonfactory/Graphics/Floor.png");//("src/dungeonfactory/Images/stubGr.png");//
                    return image;
                case 'C': image = new ImageIcon("src/dungeonfactory/Images/stubCh.png");
                    return image;
                case 'E': image = new ImageIcon("src/dungeonfactory/Images/stubEn.png");
                    return image;
                case '-': image = new ImageIcon("src/dungeonfactory/Graphics/Wall.png");
                    return image;
                case 'S': image = new ImageIcon("src/dungeonfactory/Graphics/Stairs.png");
                    return image;
                case 'T': image = new ImageIcon("src/dungeonfactory/Graphics/Chest.png");
                    return image;
                default: image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");
                    return image;
            }

    }
    
    public static ImageIcon getImage(String text) {
        ImageIcon image = null;
        
        switch(text) {
            case "Iron Armor": image = new ImageIcon("src/dungeonfactory/Graphics/Armor1.png");
                break;
            case "Steel Armor": image = new ImageIcon("src/dungeonfactory/Graphics/Armor2.png");
                break;
            default: image = new ImageIcon("src/dungeonfactory/Graphics/Armor1.png");
                break;
        }
        Image img = image.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 4, -20, 70, 300, null);
        image = new ImageIcon(bi);
        return image;
    }
    
    
    
}
