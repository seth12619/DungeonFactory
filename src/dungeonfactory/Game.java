/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.GridLayout;
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
        
        
        Helper help = new Helper();
        
        
        ArrayList<Executable> queue = new ArrayList<>();
        
       
        
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                Entity temp = new Entity ('-');
                map[i][j] = temp;
            }
        }
        
        map [3][1] = new Entity ('C');
        map [1][3] = new Entity ('E');
        print = help.getPrintable (map);
        help.printMap(print);
        System.out.println("-------------------------------");
        Entity character = map[3][1];
        Point important = new Point (3,1,character);
        Point enemyLoc = new Point (1,3, map[1][3]);
        GoblinAI acting = new GoblinAI (important, enemyLoc);
        queue.add(new Executable(enemyLoc, acting));
        Entity leave = new Entity('-');
        
        help.moveEntity( important, 0, 1, leave, map);
        print = help.getPrintable (map);
        help.printMap(print);
        help.addObserver(this);
        
        JFrame thing = new JFrame();
        
        
        GridLayout mapGrid = new GridLayout(sizeVertical,sizeHorizontal);
        mapGrid.setHgap(0);
        mapGrid.setVgap(0);
        mapHUD.setLayout(mapGrid);
        
        
        thing.setLayout(new GridLayout(sizeVertical,sizeHorizontal));
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

                    if(e.getKeyCode() == KeyEvent.VK_W)
                    {

                        help.moveEntity( important, -1, 0, leave, map);
                        
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_S)
                    {

                        help.moveEntity( important, 1, 0, leave, map);
                        
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_A)
                    {
                        help.moveEntity( important, 0, -1, leave, map);
                        
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_D)
                    {
                        help.moveEntity( important, 0, 1, leave, map);
                        
                    }
                    help.doQueue(queue);
                    print = help.getPrintable (map);
                    System.out.println("-------------------------------");
                    
                    help.printMap(print);
                   
                    
                    
                }
            });
        thing.add(mapHUD);
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

}
