/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
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
        if (items.size() < 10) {
        items.add(e);
        } else {
            Actions.appendAction("You have reached the maximum number of items (10). Discarding Picked up item.");
        }
    }
    
    public static void removeItem(Item e) {
        items.remove(e);
    }
    
    public static Item selectItem(int a) {
        Actions.setNewText("");
        try {
        Actions.appendAction(" Item Selected: " + items.get(a).getName());
        Actions.appendAction(" Description: " + items.get(a).getDescription());
        Actions.appendAction(" Type: " + items.get(a).getType());
        Actions.appendAction(" Atk: " + items.get(a).getAtk());
        Actions.appendAction(" Def: " + items.get(a).getDef());
        Actions.appendAction(" HP: " + items.get(a).getHP());
        } catch (NullPointerException e) {
            Actions.appendAction("No Item");
            Item none = new NoItem();
            update(a);
            return none;
        } catch (IndexOutOfBoundsException e) {
            Actions.appendAction("No Item");
            Item none = new NoItem();
            update(a);
            return none;
        }
        update(a);
        
        return items.get(a);
    }
    
    public static void update(int g) {
        theInventory.removeAll();
        
        for (int i = 0; i < 10; i++){
            JLabel putIn = new JLabel("nothing");
                try {   
                if(i == g) {
                    putIn.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
                } else {
                    putIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                ImageIcon fill = ImageLoader.getImage(items.get(i).getName());
                putIn.setIcon(fill);
                theInventory.add(putIn);
                } catch (NullPointerException e) {
                    putIn.setText("          No Item");
                    theInventory.add(putIn);
                } catch (IndexOutOfBoundsException e) {
                    putIn.setText("          No Item");
                    theInventory.add(putIn);
                }
            
                
            
        }
        
        theInventory.revalidate();
        
    }
    
}
