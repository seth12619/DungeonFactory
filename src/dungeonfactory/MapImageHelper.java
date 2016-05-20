/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Seth, Marco, Icon
 */
public class MapImageHelper extends JPanel {

    
    public MapImageHelper(ImageIcon image) {
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
       
        
        setSize(150,150);
        
        JLabel toAdd = new JLabel(image);
        add(toAdd);
        
        setVisible(true);
    }

    
    
}
