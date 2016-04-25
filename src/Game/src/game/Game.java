/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author mnmkami
 */

public class Game {

    /**
     * @param args the command line arguments
     */
    static char [][] print;
    public static void main(String[] args) {
        
        Entity [][] map = new Entity [5][5];
        ArrayList<Executable> queue = new ArrayList<>();
        
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                Entity temp = new Entity ('_');
                map[i][j] = temp;
            }
        }
        
        map [3][1] = new Entity ('C');
        map [1][3] = new Entity ('E');
        print = getPrintable (map);
        printMap(print);
        System.out.println("-------------------------------");
        Entity character = map[3][1];
        Point important = new Point (3,1,character);
        Point enemyLoc = new Point (1,3, map[1][3]);
        GoblinAI acting = new GoblinAI (important, enemyLoc);
        queue.add(new Executable(enemyLoc, acting));
        Entity leave = new Entity('_');
        
        moveEntity( important, 0, 1, leave, map);
        print = getPrintable (map);
        printMap(print);
        
        JFrame thing = new JFrame();
        thing.addKeyListener(
            new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {

                    if(e.getKeyCode() == KeyEvent.VK_W)
                    {

                        moveEntity( important, -1, 0, leave, map);
                        
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_S)
                    {

                        moveEntity( important, 1, 0, leave, map);
                        
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_A)
                    {
                        moveEntity( important, 0, -1, leave, map);
                        
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_D)
                    {
                        moveEntity( important, 0, 1, leave, map);
                        
                    }
                    doQueue(queue);
                    print = getPrintable (map);
                    System.out.println("-------------------------------");
                    
                    printMap(print);
                }
            });
        thing.setVisible(true);
    }
    

    
    public static char[][] getPrintable(Entity[][] map)
    {
        int rows = map.length;
        int cols = map[0].length;
        
        char [][] answer = new char[rows][cols];
        
        for (int i = 0; i < rows; i++)
        {
           for (int j = 0; j < cols; j++)
           {
               answer [i][j] = map[i][j].getValue();
           }
        }
        return answer;
    }
    
    public static void printMap(char[][] map)
    {
        
        int rows = map.length;
        int cols = map[0].length;
        for (int i = 0; i < rows; i++)
        {
            System.out.println(map[i]);
        }
    }
    
    public static void moveEntity(Point coord, int x, int y, Entity leave, Entity[][] map)
    {
        int limitX = map.length;
        int limitY = map[0].length;
        int newX = coord.getX() + x;
        int newY = coord.getY() + y;
        
        if(newX >= limitX || newY >= limitY || newX <0 || newY < 0)
        {
            System.out.println("ERROR. YOU TRIED MOVING IT OUT OF BOUNDS!");
        }
        
        else if (map[newX][newY].getValue() != '_')
        {
            System.out.println("ERROR. YOU TRIED MOVING INTO ANOTHER THING!");
        }
        else
        {
            int placeX = coord.getX();
            int placeY = coord.getY();
            coord.setX(newX);
            coord.setY(newY);

            map[coord.getX()][coord.getY()] = coord.getContent();
            map[placeX][placeY] = leave;
        }
    }
    
    public static void doQueue (ArrayList<Executable> queue)
    {
        for (Executable a : queue)
        {
            a.doBehavior();
        }
    }
    
}
