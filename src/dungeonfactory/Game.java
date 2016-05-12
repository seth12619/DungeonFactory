/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
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
    
    
    
    int sizeVertical = 5;
    int sizeHorizontal = 5;
    
    JPanel mapHUD = new JPanel();
    ImageLoader loader = new ImageLoader();
    
    Entity [][] map = new Entity [sizeVertical][sizeHorizontal];
    
    
    int rows = map.length;
    int cols = map[0].length;
    
    public Game() {
        
        
        //Helper obsHelp = new Helper();
        
       
        
        
        ArrayList<Executable> queue = new ArrayList<>();
        
        
        
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                Entity temp = new Entity ('-', false, true);
                map[i][j] = temp;
            }
        }
        
        
        Point important = Helper.characterMaker(3, 1, map);
        Executable stubA = Helper.enemyMaker('E', important, 1, 3, map);
        print = Helper.getPrintable (map);
        Helper.printMap(print);
        System.out.println("-------------------------------");
        stubA.addObserver(this);
        queue.add(stubA);
        Entity leave = new Entity('-', false, true);
        print = Helper.getPrintable (map);
        Helper.printMap(print);
        

        
        JFrame thing = new JFrame();
        
        
        GridLayout mapGrid = new GridLayout(sizeVertical,sizeHorizontal);
        mapGrid.setHgap(0);
        mapGrid.setVgap(0);
        mapHUD.setLayout(mapGrid);
        mapHUD.setSize(400, 400);
       
        
        
        thing.setLayout(new BorderLayout());
        thing.setTitle("Dungeon Factory");
        
                    
                    for (int i = 0; i < cols; i++){
                        for(int j = 0; j < rows; j++) {
                            //Where we fill up the gui grid
                            ImageIcon fill = loader.getImage(map[i][j].getValue());
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
                            Helper.moveEntity( important, -1, 0, leave, map);
                            localUpdate();
                            break;
                        case KeyEvent.VK_S:
                            Helper.moveEntity( important, 1, 0, leave, map);
                            localUpdate();
                            break;
                        case KeyEvent.VK_A:
                            Helper.moveEntity( important, 0, -1, leave, map);
                            localUpdate();
                            break;
                        case KeyEvent.VK_D:
                            Helper.moveEntity( important, 0, 1, leave, map);
                            localUpdate();
                            break;
                        default:
                            break;
                    }
                    Helper.doQueue(queue);
                    print = Helper.getPrintable (map);
                    System.out.println("-------------------------------");
                    
                    Helper.printMap(print);
                }
            });
        TextArea actions = new TextArea();
        actions.setEditable(false);
        actions.setEnabled(false);
        JPanel text = new JPanel();
        text.add(actions);
        text.setEnabled(false);
        
        JPanel padLeft = new JPanel();
        padLeft.setEnabled(false);
        
        JPanel padRight = new JPanel();
        padRight.setEnabled(false);
        
        JPanel padNorth = new JPanel();
        padNorth.setEnabled(false);
        
        
        
        thing.add(mapHUD, BorderLayout.CENTER);
        thing.add(text, BorderLayout.SOUTH);
        thing.add(padLeft, BorderLayout.EAST);
        thing.add(padRight, BorderLayout.WEST);
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
                ImageIcon fill = loader.getImage(map[i][j].getValue());
                 mapHUD.add(new JLabel(fill));
            }  
        }
        mapHUD.revalidate();
    }
    
    public void localUpdate() {
        mapHUD.removeAll();
        for (int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++) {
                ImageIcon fill = loader.getImage(map[i][j].getValue());
                 mapHUD.add(new JLabel(fill));
            }  
        }
        mapHUD.revalidate();
    }

}
