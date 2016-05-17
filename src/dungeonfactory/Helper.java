/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mnmkami
 */
public class Helper{
    public Helper(){}
    
    public static void attack(Entity attacker, Entity defender, Map level)
    {
        Entity[][] map = level.getMap();
        ArrayList<Executable> queue = level.getQueue();
        int attack = attacker.getAtk();
        int defense = defender.getDef();
        int damage = attack - defense/2;
        int health = defender.getHp() - damage;
        if (health <= 0)
        {
            if(defender.getValue() == 'C')
            {
                 System.out.println("You died!");
                System.exit(1);
            }
            else
            {
                Helper.killThis(defender, level);
                Actions.appendAction(attacker.getValue() + " attacked " + defender.getValue() + " and killed it!\n");
                 System.out.println(attacker.getValue() + " attacked " + defender.getValue() + " and killed it!");
            }
        }
        else
        {
            defender.setHp(health);
            Actions.appendAction(attacker.getValue() + " attacked " + defender.getValue() + " and dealt " + damage + " damage!\n");
            System.out.println(attacker.getValue() + " attacked " + defender.getValue() + " and dealt " + damage + " damage!");
        }
    }
    
    public static void killThis(Entity dying, Map level)
    {
        Entity[][] map = level.getMap();
        ArrayList<Executable> queue = level.getQueue();
        Executable kill = findExec(dying, level);
        Point kill2 = kill.getPoint();
        int x = kill2.getX();
        int y = kill2.getY();
        map[x][y] = new Entity ('_', false, true);
        queue.remove(kill);
    }
    
    public static Executable findExec(Entity query, Map level)
    {
        ArrayList<Executable> queue = level.getQueue();
        Executable answer = null;
        for (Executable a : queue)
        {
            Point first = a.getPoint();
            Entity second = first.getContent();
            if (query == second)
            {
                answer = a;
                break;
            }
        }
        return answer;
    }
    
    public static Point characterMaker (int locX, int locY, Map level)
    {
        Point answer = null;
        Entity[][] map = level.getMap();
        if (map[locX][locY].isWalkable())
        {
            Entity me = new Entity('C', true, false, 50, 4, 0, 1);
            map[locX][locY] = me;
            answer = new Point(locX,locY,me);
        }
        
        return answer;
    }
    
    public static Executable enemyMaker(char type, int locX, int locY, Map level)
    {   
        Point character = level.getCharacter();
        Entity[][] map = level.getMap();
        ArrayList<Executable> queue = level.getQueue();
        Executable answer = null;
        if (map[locX][locY].isWalkable())
        {
            
            
            if (type == 'E')
            {
                Entity me = new Entity (type,true, false, 10, 2, 0, 2);
                map[locX][locY] = me;
                Point myLoc = new Point(locX,locY,me);
                GoblinAI myAI = new GoblinAI(character, myLoc, level);
                answer = new Executable(myLoc, myAI);
            }
            
            else
            {
                System.out.println("You did not select a valid enemy type!");
                answer = null;
            }
        }
        else
        {
            System.out.println("Error! You tried spawning me on no floor.");
        }
        if (answer != null)
        {
            queue.add(answer);
        }
        return answer;
    }
    
    public static void moveEntity( Point coord, int x, int y, Entity leave, Map level)
    {
        Entity[][] map = level.getMap();
        ArrayList<Executable> queue = level.getQueue();
        int limitX = map.length;
        int limitY = map[0].length;
        int newX = coord.getX() + x;
        int newY = coord.getY() + y;
        
        if(newX >= limitX || newY >= limitY || newX <0 || newY < 0)
        {
            System.out.println("ERROR. YOU TRIED MOVING IT OUT OF BOUNDS!");
        }
        
        else if (!map[newX][newY].isWalkable())
        {
            System.out.println("ERROR. YOU TRIED MOVING INTO ANOTHER THING!");
            
            if(map[newX][newY].isAttackable() && (coord.getContent().getAlign() != map[newX][newY].getAlign()))
            {
                Helper.attack(coord.getContent(), map[newX][newY], level);
            }
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
