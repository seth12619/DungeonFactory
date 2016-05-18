/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mnmkami, seth, icon
 */

public class Game extends JFrame implements Observer {

    /**
     * @param args the command line arguments
     */
    static char [][] print;
    public static void main(String[] args) {
        Game start = new Game();
       
    }
    
    public JFrame thing = new JFrame();
    public static JPanel inventory = Inventory.createInventoryPanel();
    Game game = this;
    int currFloor = 1;
    Map map = new Map(game, currFloor);
    
    public static JPanel mapHUD = new JPanel();
    ImageLoader loader = new ImageLoader();
    
    
    int rows = map.getH();
    int cols = map.getV();
    
    JPanel menu = new JPanel(); //default starting menu
    JPanel inventoryMenu = new JPanel(); //When in Inventory mode Menu
    
    JButton inventoryB = new JButton("Inventory");
    
    Entity leave = new Entity('_', false, true);
    
    String temp;
    
    public Game() {
        
        
        //Helper obsHelp = new Helper();
        
       //Test Item adding
       Item a = new ArmorOne();
       Item b = new ArmorTwo();
        
       Inventory.addItem(a);
       Inventory.addItem(b);
        
        
        print = Helper.getPrintable (map.getMap());
        Helper.printMap(print);
        System.out.println("-------------------------------");

        print = Helper.getPrintable (map.getMap());
        Helper.printMap(print);
        

        inventoryMenu.setLayout(new BorderLayout());
        
        
        inventoryB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                toInventory();
            }
        }
        );
        menu.add(inventoryB);
        //inventoryMenu.add(inventoryB, BorderLayout.NORTH);
        
        
        JButton selectNextItem = new JButton("Next");
        selectNextItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectNext("next");
            }
        });
        JButton selectPrevItem = new JButton("Prev");
        selectPrevItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectNext("prev");
            }
        });
        inventoryMenu.add(selectPrevItem,BorderLayout.WEST);
        inventoryMenu.add(selectNextItem, BorderLayout.EAST);
        JButton removeItem = new JButton("Remove");
        removeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(selectedItem.getName().equals("No Item")) {
                    Actions.setNewText("No Item to Remove");
                } else {
                Inventory.removeItem(selectedItem);
                Inventory.update(11);
                Actions.setNewText("No Item");
                }
            }
        });
        inventoryMenu.add(removeItem, BorderLayout.SOUTH);
        
        
        GridLayout mapGrid = new GridLayout(rows,cols);
        mapGrid.setHgap(0);
        mapGrid.setVgap(0);
        mapHUD.setLayout(mapGrid);
        mapHUD.setSize(400, 400);
        
        
        
        thing.setLayout(new BorderLayout());
        thing.setTitle("Dungeon Factory");
        thing.setFocusable(true);
        thing.requestFocusInWindow();
        
                    
                    for (int i = 0; i < cols; i++){
                        for(int j = 0; j < rows; j++) {
                            //Where we fill up the gui grid
                            ImageIcon fill = loader.getImage(map.getMap()[i][j].getValue());
                            mapHUD.add(new JLabel(fill));
                        }  
                    }
        
        
        thing.addKeyListener(
            new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    if (e.getKeyCode() == KeyEvent.VK_W)
                    {
                        Helper.moveEntity( map.getCharacter(), -1, 0, map);
                        localUpdate();
                    }
                    
                    else if (e.getKeyCode() == KeyEvent.VK_S)
                    {
                        Helper.moveEntity( map.getCharacter(), 1, 0, map);
                        localUpdate();
                    }
                    
                    else if (e.getKeyCode() == KeyEvent.VK_A)
                    {
                        Helper.moveEntity( map.getCharacter(), 0, -1, map);
                        localUpdate();
                    }
                    
                    else if (e.getKeyCode() == KeyEvent.VK_D)
                    {
                        Helper.moveEntity( map.getCharacter(), 0, 1, map);
                        localUpdate();
                    }
                    else
                    {
                        //do nothing
                    }
                    if(Helper.checkDoor(map))
                    {
                        
                        currFloor = currFloor + 1;
                        map = new Map(game, currFloor);
                        cols = map.getV();
                        rows = map.getH();
                        Actions.appendAction("You've moved to floor " + currFloor + "!\n");
                        localUpdate();
                    }
                    else
                    {
                        Helper.doQueue(map.getQueue());
                    }
                    print = Helper.getPrintable (map.getMap());
                    System.out.println("-------------------------------");
                    Helper.printMap(print);
                    
                }
            });
        
        JPanel text = Actions.createTextArea();
        
        JPanel inventory = Inventory.createInventoryPanel();
        
        
        
        JPanel padRight = new JPanel();
        padRight.setEnabled(false);
        
        JPanel padNorth = new JPanel();
        padNorth.setEnabled(false);
        
        
        
        thing.add(mapHUD, BorderLayout.CENTER);
        thing.add(text, BorderLayout.SOUTH);
        thing.add(menu, BorderLayout.WEST);
        thing.add(padRight, BorderLayout.EAST);
        thing.add(padNorth, BorderLayout.NORTH);
        thing.setSize(625,625);
        thing.setVisible(true);
        thing.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {
        mapHUD.removeAll();
        for (int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++) {
                ImageIcon fill = loader.getImage(map.getMap()[i][j].getValue());
                 mapHUD.add(new JLabel(fill));
            }  
        }
        mapHUD.revalidate();
        localUpdate();
    }
    
    public void localUpdate() {
        mapHUD.removeAll();
        for (int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++) {
                ImageIcon fill = loader.getImage(map.getMap()[i][j].getValue());
                 mapHUD.add(new JLabel(fill));
            }  
        }
        mapHUD.revalidate();
    }
    
    public static boolean inventoryPress = false;
    
    public void toInventory() {
        if (inventoryPress == false) {
            
            temp = Actions.actions.getText();
            thing.remove(mapHUD);
            thing.remove(menu);
            
            Inventory.update(11);
            thing.add(inventory,BorderLayout.CENTER);
            
            inventoryMenu.add(inventoryB, BorderLayout.NORTH);
            thing.add(inventoryMenu, BorderLayout.WEST);
            
            inventIndex = 0;
            selectedItem = Inventory.selectItem(inventIndex);
            
            thing.revalidate();
            thing.repaint();
            inventoryPress = true;
            
            
            System.out.println("it is gonna add INVENTORY");
            
          
        } else {
            
            Actions.setNewText(temp);
            thing.remove(inventoryMenu);
            thing.remove(inventory);
            
            inventoryPress = false;
            
            localUpdate();
            
            
            menu.add(inventoryB);
            thing.add(menu, BorderLayout.WEST);
            
            
            System.out.println("it is gonna add MAP");
            
            thing.add(mapHUD,BorderLayout.CENTER);
            thing.revalidate();
            thing.repaint();
            thing.requestFocusInWindow();
        }
    }
    
    
    static int inventIndex = 0;
    static Item selectedItem = null;
    public static void selectNext(String direction) {
        if(direction.equals("prev")) {
            if(inventIndex == 0) {
                inventIndex = 9;
            } else {
                inventIndex--;     
            }
            selectedItem = Inventory.selectItem(inventIndex);

        } else {
            if(inventIndex == 9) {
                inventIndex = 0;
            } else {
                inventIndex++;
            }
            selectedItem = Inventory.selectItem(inventIndex);
            
        }
        

    }

}
