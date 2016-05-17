/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
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
    public JPanel inventory = Inventory.createInventoryPanel();
    
    Map map = new Map(20,20,3,1);
    
    public static JPanel mapHUD = new JPanel();
    ImageLoader loader = new ImageLoader();
    
    
    int rows = map.getH();
    int cols = map.getV();
    
    
    
    public Game() {
        
        
        //Helper obsHelp = new Helper();
        
       Item a = new ArmorOne();
        
       Inventory.addItem(a);
        
        
        Executable stubA = Helper.enemyMaker('E', 1, 3, map);
        Executable stubB = Helper.enemyMaker('E', 2, 3, map);
        print = Helper.getPrintable (map.getMap());
        Helper.printMap(print);
        System.out.println("-------------------------------");
        stubA.addObserver(this);
        stubB.addObserver(this);
        Entity leave = new Entity('_', false, true);
        print = Helper.getPrintable (map.getMap());
        Helper.printMap(print);
        

        JPanel menu = new JPanel();
        
        JButton inventoryB = new JButton("Inventory");
        inventoryB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                toInventory();
            }
        }
        );
        menu.add(inventoryB);
        
        
        
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

                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            Helper.moveEntity( map.getCharacter(), -1, 0, leave, map);
                            localUpdate();
                            break;
                        case KeyEvent.VK_S:
                            Helper.moveEntity( map.getCharacter(), 1, 0, leave, map);
                            localUpdate();
                            break;
                        case KeyEvent.VK_A:
                            Helper.moveEntity( map.getCharacter(), 0, -1, leave, map);
                            localUpdate();
                            break;
                        case KeyEvent.VK_D:
                            Helper.moveEntity( map.getCharacter(), 0, 1, leave, map);
                            localUpdate();
                            break;
                        default:
                            break;
                    }
                    Helper.doQueue(map.getQueue());
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
            thing.add(inventory,BorderLayout.CENTER);
            thing.revalidate();
            Inventory.update();
            inventoryPress = true;
            System.out.println("it is gonna add INVENTORY");
        } else {
            thing.add(mapHUD,BorderLayout.CENTER);
            
            inventoryPress = false;
            thing.revalidate();
            localUpdate();
            thing.requestFocusInWindow();
            
            System.out.println("it is gonna add MAP");
        }
    }

}
