/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mnmkami
 */
public class Helper{
    public Helper(){}
    
    public static boolean lineSight(Point one, Point two, Map level)
    {
        int oneX = one.getX();
        int oneY = one.getY();
        int twoX = two.getX();
        int twoY = two.getY();
        boolean answer = false;
        Entity[][] map = level.getMap();
        
        int start;
        int distance;
        
        if (oneX == twoX)
        {
            System.out.println("You got in!");
            if (oneY < twoY)
            {
                start = oneY;
                distance = twoY - oneY + start;
            }
            else
            {
                start = twoY;
                distance = oneY - twoY +start;
            }
            
            for (int i = start + 1; i < distance; i++)
            {
                boolean walkable = map[oneX][i].isWalkable();
                if (walkable)
                {
                    answer = true;
                }
                else
                {
                    answer = false;
                    break;
                }
            }
        }
        else if (oneY == twoY)
        {
            System.out.println("You got in!");
            if (oneX < twoX)
            {
                start = oneX;
                distance = twoX - oneX + start;
            }
            else
            {
                start = twoX;
                distance = oneX - twoX +start;
            }
            
            for (int i = start + 1; i < distance; i++)
            {
                boolean walkable = map[i][oneY].isWalkable();
                if (walkable)
                {
                    answer = true;
                }
                else
                {
                    answer = false;
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
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
                Actions.appendAction(attacker.getValue() + " attacked " + defender.getValue() + " and killed it!");
                 System.out.println(attacker.getValue() + " attacked " + defender.getValue() + " and killed it!");
                    System.out.println("HP: " + attacker.getHp());
                    System.out.println("Atk: " + attacker.getAtk());
                    System.out.println("Def: " + attacker.getDef());
            }
        }
        else
        {
            defender.setHp(health);
            Actions.appendAction(attacker.getValue() + " attacked " + defender.getValue() + " and dealt " + damage + " damage!");
            System.out.println(attacker.getValue() + " attacked " + defender.getValue() + " and dealt " + damage + " damage!");
                System.out.println("HP: " + attacker.getHp());
                System.out.println("Atk: " + attacker.getAtk());
                System.out.println("Def: " + attacker.getDef());
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
        Entity leave = kill2.getLeave();
        map[x][y] = leave;
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
    
    public static Point characterMaker (int locX, int locY, Map level, int floor, int hp, int atk, int def)
    {
        Point answer = null;
        Entity[][] map = level.getMap();
        Entity me;
            if (floor == 1)
            {
                 me = new Entity('C', true, false, 50, 4, 0, 1);
            }
            
            else
            {
                 me = new Entity('C', true, false, hp, atk, def, 1);
            }
            map[locX][locY] = me;
            answer = new Point(locX,locY,me);
        
        return answer;
    }
    
    public static Executable enemyMaker(char type, int locX, int locY, Map level)
    {   
        Point character = level.getCharacter();
        Entity[][] map = level.getMap();
        ArrayList<Executable> queue = level.getQueue();
        Executable answer = null;
        {
            
            
            if (type == 'E')
            {
                Entity me = new Entity (type,true, false, 10, 2, 0, 2);
                map[locX][locY] = me;
                Point myLoc = new Point(locX,locY,me);
                GoblinAI myAI = new GoblinAI(character, myLoc, level);
                answer = new Executable(myLoc, myAI);
            }
            
            else if (type == 'B')
            {
                Entity me = new Entity (type,true, false, 5, 3, 0, 2);
                map[locX][locY] = me;
                Point myLoc = new Point(locX,locY,me);
                BirdAI myAI = new BirdAI(character, myLoc, level);
                answer = new Executable(myLoc, myAI);
            }
            
            else if (type == 'W')
            {
                Entity me = new Entity (type,true, false, 4, 3, 0, 2);
                map[locX][locY] = me;
                Point myLoc = new Point(locX,locY,me);
                WizardAI myAI = new WizardAI(character, myLoc, level);
                answer = new Executable(myLoc, myAI);
            }
            
            else if (type == 'Z')
            {
                Entity me = new Entity (type,true, false, 40, 4, 0, 2);
                map[locX][locY] = me;
                Point myLoc = new Point(locX,locY,me);
                DragonAI myAI = new DragonAI(character, myLoc, level);
                answer = new Executable(myLoc, myAI);
            }
            
            else
            {
                System.out.println("You did not select a valid enemy type!");
                answer = null;
            }
        }
        if (answer != null)
        {
            queue.add(answer);
        }
        return answer;
    }
    
    public static boolean checkDoor (Map level)
    {
        if (level.getCharacter().getX() == level.getDoor().getX() && level.getCharacter().getY() == level.getDoor().getY())
        {
            System.out.println("True Dicks");
            return true;
        }
        
        else
        {
            System.out.println("False Dicks");
            return false;
        }
    }
    
    public static boolean checkChest (Map level)
    {
        if (level.getCharacter().getX() == level.getChest().getX() && level.getCharacter().getY() == level.getChest().getY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static Item takeChest()
    {
        Item temp = null;
        int range = (25 - 1) + 1;     
        int check = (int) ((Math.random() * range) +1);
        System.out.println(check);
        if (check == 1)
        {
            temp =  new ArmorOne();
        }
        else if (check == 2)
        {
            temp =  new ArmorTwo();
        }
        else if (check == 3)
        {
            temp =  new ArmorThree();
        }
        else if (check == 4)
        {
            temp = new ArmorFour();
        }
        else if (check == 5)
        {
            temp =  new ArmorFive();
        }
        
        else if (check == 6)
        {
            temp =  new BootsOne();
        }
        else if (check == 7)
        {
            temp = new BootsTwo();
        }
        else if (check == 8)
        {
            temp =  new BootsThree();
        }
        else if (check == 9)
        {
            temp =  new BootsFour();
        }
        else if (check == 10)
        {
            temp =  new BootsFive();
        }
        else if (check == 11)
        {
            temp = new HelmetOne();
        }
        else if (check == 12)
        {
            temp = new HelmetTwo();
        }
        else if (check == 13)
        {
            temp =  new HelmetThree();
        }
        else if (check == 14)
        {
            temp =  new HelmetFour();
        }
        else if (check == 15)
        {
            temp =  new HelmetFive();
        }
        else if (check == 16)
        {
            temp = new ShieldOne();
        }
        else if (check == 17)
        {
            temp = new ShieldTwo();
        }
        else if (check == 18)
        {
            temp = new ShieldThree();
        }
        else if (check == 19)
        {
            temp = new ShieldFour();
        }
        else if (check == 20)
        {
            temp = new ShieldFive();
        }
        else if (check == 21)
        {
            temp = new WeaponOne();
        }
        else if (check == 22)
        {
            temp = new WeaponTwo();
        }
        else if (check == 23)
        {
            temp = new WeaponThree();
        }
        else if (check == 24)
        {
            temp = new WeaponFour();
        }
        else
        {
            temp = new WeaponFive();
        }
        
        return temp;
    }
    
    public static void unloadMap (Map level, Game game)
    {
        ArrayList<Executable> queue = level.getQueue();
        for (Executable a : queue)
        {
            a.deleteObserver(game);
            queue.remove(a);
        }
    }
    
    public static void moveEntity( Point coord, int x, int y, Map level)
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
            
            Entity temp = map[coord.getX()][coord.getY()];
            map[coord.getX()][coord.getY()] = coord.getContent();
            map[placeX][placeY] = coord.getLeave();
            coord.setLeave(temp);

            
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
