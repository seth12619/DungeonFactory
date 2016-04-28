/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import javax.swing.ImageIcon;

/**
 *
 * @author Seth, Marco, Icon
 */
public class ImageLoader {
    
    public ImageIcon getImage(char arrayText) {
        ImageIcon image = null;
        
            switch(arrayText) {
                case '-': image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");
                    return image;
                case 'C': image = new ImageIcon("src/dungeonfactory/Images/stubCh.png");
                    return image;
                case 'E': image = new ImageIcon("src/dungeonfactory/Images/stubEn.png");
                    return image;
                default: image = new ImageIcon("src/dungeonfactory/Images/stubGr.png");
                    return image;
            }

    }
    
}
