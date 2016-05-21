/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author mnmkami
 */
public class DragonAI implements Behavior{
    private Point character;
    private Point me;
    private Entity[][] map;
    Entity leave = new Entity('_', false, true);
    private ArrayList<Executable> queue;
    private Map level;
    boolean buffed = false;
    boolean enraged = false;
    public DragonAI (Point character, Point me, Map level)
    {
        this.map = level.getMap();
        this.queue = level.getQueue();
        this.level = level;
        this.character = level.getCharacter();
        this.me = me;
    }
    
    public void execute() {
        int myX = me.getX();
        int myY = me.getY();
        int hisX = character.getX();
        int hisY = character.getY();
        
        
        
        if(abs(myX-hisX) <=1 && abs(myY-hisY) <=1 && buffed == false && abs(myX-hisX) != abs(myY-hisY) )
        {
            Actions.appendAction("Dragon: MY SCALES ARE IRON!");
            Actions.appendAction("Dragon: NOW DIE MORTAL!");
          //  System.out.println("I AM BUFFED, MORTAL.");
            me.getContent().setDef(me.getContent().getDef() + 0);
            buffed = true;
        }
        
        if(me.getContent().getHp() < 100 && enraged == false)
        {
            me.getContent().setAtk(me.getContent().getAtk() + 5);
            me.getContent().setDef(me.getContent().getDef() + 5);
            enraged = true;
        }
        
        if(((myX == hisX && abs(myY-hisY) <=3) || ((myY == hisY && abs(myX-hisX) <=3))) && Helper.lineSight(me, character, level))
        {
            Helper.attack(me.getContent(), character.getContent(), level);
        }
        
        else
        {
            int first = abs(myY-hisY);
            int second = abs(myX-hisX);
            
            System.out.println(first +" and " + second);
            
            if (first <= second)
            {
                if(myX<hisX)
                {
                    Helper.moveEntity(me, 1, 0, level);
                }
                else if (myX>hisX)
                {
                    Helper.moveEntity(me, -1, 0, level);
                }
                else
                {
                    if(myY<hisY)
                    {
                        Helper.moveEntity(me, 0, 1, level);
                    }
                    else
                    {
                        Helper.moveEntity(me, 0, -1, level);
                    }
                }
            }
            else
            {
                if(myY<hisY)
                {
                    Helper.moveEntity(me, 0, 1, level);
                }
                else if (myY>hisY)
                {
                    Helper.moveEntity(me, 0, -1, level);
                }
                else
                {
                    if(myY<hisY)
                    {
                        Helper.moveEntity(me, 1, 0, level);
                    }
                    else
                    {
                        Helper.moveEntity(me, -1, 0, level);
                    }
                }
            }
        }
    }
}
