/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import static dungeonfactory.Helper.score;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
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
    int charAtk;
    int charDef;
    int charHP;
    Map map = new Map(game, currFloor);
    
    public static JPanel mapHUD = new JPanel();
    
    
    
    int rows = map.getH();
    int cols = map.getV();
    
    ImageLoader loader = new ImageLoader();
    
    boolean inMenu = false;
    JPanel menu = new JPanel(); //default starting menu
    JPanel inventoryMenu = new JPanel(); //When in Inventory mode Menu
    
    JLabel HP = new JLabel(" HP: " + map.getCharacter().getContent().getHp());
    JLabel def = new JLabel(" Def: " + map.getCharacter().getContent().getDef());
    JLabel atk = new JLabel(" Atk: " + map.getCharacter().getContent().getAtk());
    JLabel wep = new JLabel("<html><body>\' Weapon:  <br>- " + EquipmentHelper.getWep() + "</body></html>");
    JLabel shield = new JLabel("<html><body>\' Shield:  <br>- " + EquipmentHelper.getShield() + "</body></html>");
    JLabel helm = new JLabel("<html><body>\' Helmet: <br>- " + EquipmentHelper.getHelm() + "</body></html>");
    JLabel armor = new JLabel("<html><body>\' Armor: <br>- " + EquipmentHelper.getArmor() + "</body></html>");
    JLabel boots = new JLabel("<html><body>\' Boots:  <br>- " + EquipmentHelper.getBoots() + "</body></html>");
    JLabel highScore = new JLabel("<html><body>\' High Score: <br>- "+ Integer.toString(HighScore.getInstance().readHighScore()) + "</body></html>");
    JLabel currScore = new JLabel("Score: " + Helper.getCurrScore());
    
    JButton inventoryB = new JButton("Inventory");
    JButton toMap = new JButton("To Map");
    
    Entity leave = new Entity('_', false, true);
    
    String temp;
    
    
    public Game() {
        
        
        //Helper obsHelp = new Helper();
        
       //Test Item adding
       
        BoxLayout menuLayout = new BoxLayout(menu, BoxLayout.Y_AXIS);
        
        menu.setLayout(menuLayout);
        
        menu.setPreferredSize(new Dimension(100, 800));
        menu.setMaximumSize(menu.getPreferredSize());
        
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
        
        toMap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                toInventory();
            }
        });
        
        menu.add(inventoryB);
        menu.add(highScore);
        menu.add(currScore);
        menu.add(new JLabel(" Stats:"));
        menu.add(atk);
        menu.add(HP);
        menu.add(def);
        menu.add(new JLabel(" "));
        menu.add(new JLabel(" Equipment:"));
        menu.add(wep);
        menu.add(new JLabel(" "));
        menu.add(shield);
        menu.add(new JLabel(" "));
        menu.add(helm);
        menu.add(new JLabel(" "));
        menu.add(armor);
        menu.add(new JLabel(" "));
        menu.add(boots);
        
        
        
        inventoryMenu.add(toMap, BorderLayout.NORTH);
        
        
        JButton selectNextItem = new JButton("Next");
        selectNextItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                selectNext("next");
            }
        });
        JButton selectPrevItem = new JButton("Prev");
        selectPrevItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                selectNext("prev");
            }
        });
        inventoryMenu.add(selectPrevItem,BorderLayout.WEST);
        inventoryMenu.add(selectNextItem, BorderLayout.EAST);
        
        JButton equipItem = new JButton("Equip");  //EQUIP ITEMS
        equipItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               EquipmentHelper.setEquipment(map.getCharacter(), selectedItem);
              
               Inventory.removeItem(selectedItem);
               Inventory.update(11);
               
               wep.setText("<html><body>\' Weapon:  <br>- " + EquipmentHelper.getWep() + "</body></html>");
               shield.setText("<html><body>\' Shield:  <br>- " + EquipmentHelper.getShield() + "</body></html>");
               helm.setText("<html><body>\' Helmet: <br>- " + EquipmentHelper.getHelm() + "</body></html>");
               armor.setText("<html><body>\' Armor: <br>- " + EquipmentHelper.getArmor() + "</body></html>");
               boots.setText("<html><body>\' Boots: <br>- " + EquipmentHelper.getBoots() + "</body></html>");
           }
        });
        inventoryMenu.add(equipItem, BorderLayout.CENTER);
        JButton removeItem = new JButton("Remove");
        removeItem.addActionListener(new ActionListener() {
            @Override
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
        mapHUD.setSize(150, 150);
        
        
        
        thing.setLayout(new BorderLayout());
        thing.setTitle("Dungeon Factory");
        thing.setFocusable(true);
        thing.requestFocusInWindow();
        
        localUpdate();            
        
        
        thing.addKeyListener(
            new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    if (inMenu == false)
                    {
                        if (e.getKeyCode() == KeyEvent.VK_W)
                        {
                            if(map.character.getX() > 0)
                            {
                                if(Helper.checkChest(map, map.character.getX()-1, map.character.getY()))
                                {
                                    Item temp = Helper.takeChest(map,map.character.getX()-1, map.character.getY());
                                    Actions.appendAction("You got a " + temp.getName() + " from the chest!");
                                    Inventory.addItem(temp);
                                }
                            }
                            Helper.moveEntity( map.getCharacter(), -1, 0, map);
                            localUpdate();
                        }

                        else if (e.getKeyCode() == KeyEvent.VK_S)
                        {
                            if(map.character.getX() < rows-1)
                            {
                                if(Helper.checkChest(map, map.character.getX()+1, map.character.getY()))
                                {
                                    Item temp = Helper.takeChest(map,map.character.getX()+1, map.character.getY());
                                    Actions.appendAction("You got a " + temp.getName() + " from the chest!");
                                    Inventory.addItem(temp);
                                }
                            }
                            Helper.moveEntity( map.getCharacter(), 1, 0, map);
                            localUpdate();
                        }

                        else if (e.getKeyCode() == KeyEvent.VK_A)
                        {
                            if(map.character.getY() > 0)
                            {
                                if(Helper.checkChest(map, map.character.getX(), map.character.getY()-1))
                                {
                                    Item temp = Helper.takeChest(map,map.character.getX(), map.character.getY()-1);
                                    Actions.appendAction("You got a " + temp.getName() + " from the chest!");
                                    Inventory.addItem(temp);
                                }
                            }
                            Helper.moveEntity( map.getCharacter(), 0, -1, map);
                            localUpdate();
                        }

                        else if (e.getKeyCode() == KeyEvent.VK_D)
                        {
                            if(map.character.getY() < rows-1)
                            {
                                if(Helper.checkChest(map, map.character.getX(), map.character.getY()+1))
                                {
                                    Item temp = Helper.takeChest(map,map.character.getX(), map.character.getY()+1);
                                    Actions.appendAction("You got a " + temp.getName() + " from the chest!");
                                    Inventory.addItem(temp);
                                }
                            }
                            Helper.moveEntity( map.getCharacter(), 0, 1, map);
                            localUpdate();
                        }
                        else
                        {
                            //do nothing
                        }
                        //Inventory.addItem(Helper.takeChest());
                        if(Helper.checkDoor(map))
                        {
                            charHP = map.character.getContent().getHp();
                            charAtk = map.character.getContent().getAtk();
                            charDef = map.character.getContent().getDef();
                            currFloor = currFloor + 1;
                            if (currFloor == 8)
                            {
                                //insert code that prints a score and a "you've won" screen
                                score = score + map.character.getContent().getHp() * 10 + map.character.getContent().getAtk() * 15 + map.character.getContent().getDef()*5;
                                if(HighScore.getInstance().readHighScore()<score) {
                                    HighScore.getInstance().noteDownHighScore(score);
                                }
                                System.out.println("You've won!");
                                System.exit(1);
                            }
                            map = new Map(game, currFloor);
                            cols = map.getV();
                            rows = map.getH();
                            thing.remove(mapHUD);
                            GridLayout mapGrid2 = new GridLayout(rows,cols);
                            mapGrid.setHgap(0);
                            mapGrid.setVgap(0);
                            mapHUD = new JPanel();
                            mapHUD.setLayout(mapGrid2);
                            mapHUD.setSize(400, 400);
                            thing.add(mapHUD,BorderLayout.CENTER);

                            Actions.appendAction("You've moved to floor " + currFloor + "!");
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
                }
            });
        
        JPanel text = Actions.createTextArea();
        //Actions.appendAction("You are a Mighty Freelancer! You may equip ANYTHING! Yes, even if it occuppies the same slot! These dungeon items are magical! They inherit the power of ALL previously equipped  items. Keep equipping. You'll need it!");
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
        localUpdate();
    }
    
    public void localUpdate() {
        mapHUD.removeAll();
        for (int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++) {
                ImageIcon fill = loader.getImage(currFloor,map.getMap()[i][j].getValue());
                //JPanel toAdd = new MapImageHelper(fill);
                JLabel toAdd = new JLabel("nothing");
                toAdd.setIcon(fill);
                
                mapHUD.add(toAdd);
            }  
        }
        mapHUD.revalidate();
        mapHUD.repaint();
        
        HP.setText(" HP: " + map.getCharacter().getContent().getHp());
        def.setText(" Def: " + map.getCharacter().getContent().getDef());
        atk.setText(" Atk: " + map.getCharacter().getContent().getAtk());
        highScore.setText("<html><body>\' High Score: <br>- "+ HighScore.getInstance().readHighScore() + "</body></html>");
        currScore.setText("Score: " + Helper.getCurrScore());
    }
    
    public static boolean inventoryPress = false;
    
    public void toInventory() {
        if (inventoryPress == false) {
            inMenu = true;
            temp = Actions.actions.getText();
            thing.remove(mapHUD);
            thing.remove(menu);
            
            Inventory.update(11);
            thing.add(inventory,BorderLayout.CENTER);
            
            
            thing.add(inventoryMenu, BorderLayout.WEST);
            
            inventIndex = 0;
            selectedItem = Inventory.selectItem(inventIndex);
            
            thing.revalidate();
            thing.repaint();
            inventoryPress = true;
            
            
            System.out.println("it is gonna add INVENTORY");
            
          
        } else {
            inMenu = false;
            Actions.setNewText(temp);
            thing.remove(inventoryMenu);
            thing.remove(inventory);
            
            inventoryPress = false;
            
            localUpdate();
            
            
            
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
