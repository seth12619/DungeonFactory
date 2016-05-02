/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author mnmkami, seth, icon
 */

public class Game {

    /**
     * @param args the command line arguments
     */
    static char [][] print;
    public static void main(String[] args) {
        
        //Helper help = new Helper();
        
        Entity [][] map = new Entity [5][5];
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
        print = Helper.getPrintable (map);
        Helper.printMap(print);
        System.out.println("-------------------------------");
        Entity character = map[3][1];
        Point important = new Point (3,1,character);
        Point enemyLoc = new Point (1,3, map[1][3]);
        GoblinAI acting = new GoblinAI (important, enemyLoc, map);
        queue.add(new Executable(enemyLoc, acting));
        Entity leave = new Entity('-');
        
        Helper.moveEntity( important, 0, 1, leave, map);
        print = Helper.getPrintable (map);
        Helper.printMap(print);
        
        JFrame thing = new JFrame();
        thing.addKeyListener(
            new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {

                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            Helper.moveEntity( important, -1, 0, leave, map);
                            break;
                        case KeyEvent.VK_S:
                            Helper.moveEntity( important, 1, 0, leave, map);
                            break;
                        case KeyEvent.VK_A:
                            Helper.moveEntity( important, 0, -1, leave, map);
                            break;
                        case KeyEvent.VK_D:
                            Helper.moveEntity( important, 0, 1, leave, map);
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
        thing.setVisible(true);
    }

}
