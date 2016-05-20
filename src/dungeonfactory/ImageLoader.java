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
        ImageIcon image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");;
        
            switch(arrayText) {
                case '_': image = new ImageIcon("src/dungeonfactory/Graphics/Floor.png");//("src/dungeonfactory/Images/stubGr.png");//
                    break;
                case 'C': image = new ImageIcon("src/dungeonfactory/Graphics/Hero_Down (F).png");
                    break;
                case 'E': image = new ImageIcon("src/dungeonfactory/Graphics/Goblin_Down (F).png");
                    break;
                case '-': image = new ImageIcon("src/dungeonfactory/Graphics/Wall.png");
                    break;
                case 'S': image = new ImageIcon("src/dungeonfactory/Graphics/Stairs.png");
                    break;
                case 'T': image = new ImageIcon("src/dungeonfactory/Graphics/Chest.png");
                    break;
                default: image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");
                    break;
            }
        Image img = image.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, 120, 120, null);  //values to be changed (img, 0, 0, Width, Height, null) //do not change the rest
        image = new ImageIcon(bi); 
        return image;

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
