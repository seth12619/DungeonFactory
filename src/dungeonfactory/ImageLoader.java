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
    
    public ImageIcon getImage(int rows, int cols, char arrayText) {
        ImageIcon image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");;
        boolean ifCharacter = false;
            switch(arrayText) {
                case '_': image = new ImageIcon("src/dungeonfactory/Graphics/Floor.png");//("src/dungeonfactory/Images/stubGr.png");//
                    break;
                case 'C': image = new ImageIcon("src/dungeonfactory/Graphics/Hero_Down (F).png");
                    ifCharacter = true;
                    break;
                case 'E': image = new ImageIcon("src/dungeonfactory/Graphics/Goblin_Down (F).png");
                    ifCharacter = true;
                    break;
                case '-': image = new ImageIcon("src/dungeonfactory/Graphics/Wall.png");
                    break;
                case 'S': image = new ImageIcon("src/dungeonfactory/Graphics/Stairs.png");
                    ifCharacter = true;
                    break;
                case 'T': image = new ImageIcon("src/dungeonfactory/Graphics/Chest.png");
                    ifCharacter = true;
                    break;
                case 'B': image = new ImageIcon("src/dungeonfactory/Graphics/Bird_Down (F).png");
                    ifCharacter = true;
                    break;
                case 'W': image = new ImageIcon("src/dungeonfactory/Graphics/EnemyMage.png");
                    ifCharacter = true;
                    break;
                default: image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");
                    break;
            }
        if(ifCharacter) {
        Image img = image.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 25, 400/(cols), 400/(rows), null);//g.drawImage(img, 0, 25, 82, 70, null);  //values to be changed (img, distFromLeft, distanceFromAbove, Width, Height, null) //do not change the rest
        image = new ImageIcon(bi); 
        }
        return image;

    }
    
    public static ImageIcon getImage(String text) {
        ImageIcon image = null;
        
        switch(text) {
            case "Iron Armor": image = new ImageIcon("src/dungeonfactory/Graphics/Armor1.png");
                break;
            case "Steel Armor": image = new ImageIcon("src/dungeonfactory/Graphics/Armor2.png");
                break;
            case "Dragon Armor": image = new ImageIcon("src/dungeonfactory/Graphics/Armor3.png");
                break;
            case "Holy Royal Armor": image = new ImageIcon("src/dungeonfactory/Graphics/Armor4.png");
                break;
            case "Awesome Cape": image = new ImageIcon("src/dungeonfactory/Graphics/Armor5.png");
                break;
            case "Iron Sword": image = new ImageIcon("src/dungeonfactory/Graphics/Weapon1.png");
                break;
            case "Twin Iron Swords": image = new ImageIcon("src/dungeonfactory/Graphics/Weapon2.png");
                break;
            case "Iron Axe": image = new ImageIcon("src/dungeonfactory/Graphics/Weapon3.png");
                break;
            case "Steel Sabre": image = new ImageIcon("src/dungeonfactory/Graphics/Weapon4.png");
                break;
            case "Sacred Twin Swords": image = new ImageIcon("src/dungeonfactory/Graphics/Weapon5.png");
                break;
            case "Iron Crown": image = new ImageIcon("src/dungeonfactory/Graphics/Helmet1.png");
                break;
            case "Iron Mask": image = new ImageIcon("src/dungeonfactory/Graphics/Helmet2.png");
                break;
            case "Full Steel Helmet": image = new ImageIcon("src/dungeonfactory/Graphics/Helmet3.png");
                break;
            case "Goggles": image = new ImageIcon("src/dungeonfactory/Graphics/Helmet4.png");
                break;
            case "Holy Crown": image = new ImageIcon("src/dungeonfactory/Graphics/Helmet5.png");
                break;
            case "Leather Boots": image = new ImageIcon("src/dungeonfactory/Graphics/Boots1.png");
                break;
            case "Cured Leather Boots": image = new ImageIcon("src/dungeonfactory/Graphics/Boots2.png");
                break;
            case "Iron Boots": image = new ImageIcon("src/dungeonfactory/Graphics/Boots3.png");
                break;
            case "Military Boots": image = new ImageIcon("src/dungeonfactory/Graphics/Boots4.png");
                break;
            case "Fortress Boots": image = new ImageIcon("src/dungeonfactory/Graphics/Boots5.png");
                break;
            case "Coffin Shield": image = new ImageIcon("src/dungeonfactory/Graphics/Shield1.png");
                break;
            case "Glass Shield": image = new ImageIcon("src/dungeonfactory/Graphics/Shield2.png");
                break;
            case "Iron Shield": image = new ImageIcon("src/dungeonfactory/Graphics/Shield3.png");
                break;
            case "Night Guard Shield": image = new ImageIcon("src/dungeonfactory/Graphics/Shield4.png");
                break;
            case "Blessed Day Shield": image = new ImageIcon("src/dungeonfactory/Graphics/Shield5.png");
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
