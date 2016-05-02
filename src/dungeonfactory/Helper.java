/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.util.ArrayList;

/**
 *
 * @author mnmkami
 */
public class Helper {
    public Helper(){}
    
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
        
        else if (map[newX][newY].getValue() != '-')
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
    

    
    public static void doQueue (ArrayList<Executable> queue)
    {
        for (Executable a : queue)
        {
            a.doBehavior();
        }
    }
    
    public static boolean checkAdjacent (Point a, Point b)
    {
        boolean answer = false;
        
        int aX = a.getX();
        int aY = a.getY();
        int bX = a.getX();
        int bY = a.getY();
        
        if (aX - 1 == bX || aX + 1 == bX || aY - 1 == bY || aY + 1 == bY|| bX -1 == aX || bX+1 == aX || bY +1 == aY || bY -1 == aY)
        {
            answer = true;
        }
        
        return answer;
    }
}
