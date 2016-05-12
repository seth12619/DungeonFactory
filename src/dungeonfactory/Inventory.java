/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Seth, Marco, Icon
 */
public class Inventory {
    public static ArrayList<Item> items = new ArrayList<>();
    public static JPanel theInventory = new JPanel();
    static int rows = 2;
    static int cols = 5;
    
    public Inventory() {
        
    }
    
    public static JPanel createInventoryPanel() {
        theInventory.setLayout(new GridLayout(rows,cols));
        
        return theInventory;
    }
    
    public static void addItem(Item e) {
        items.add(e);
    }
    
    public static void removeItem(Item e) {
        items.remove(e);
    }
    
    public static void update() {
        theInventory.removeAll();
        int number = 0;
        for (int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++) {
                try{
                ImageIcon fill = items.get(number).getImage();
                theInventory.add(new JLabel(fill));
                number++;
                } catch (IndexOutOfBoundsException e) {
                    theInventory.add(new JLabel("Empty"));
                }
            }  
        }
        theInventory.revalidate();
        
    }
    
}
