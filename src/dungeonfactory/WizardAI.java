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
public class WizardAI implements Behavior{
    private Point character;
    private Point me;
    private Entity[][] map;
    Entity leave = new Entity('_', false, true);
    private ArrayList<Executable> queue;
    private Map level;
   
    public WizardAI (Point character, Point me, Map level)
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
        
        if(((myX == hisX && abs(myY-hisY) >=4) || ((myY == hisY && abs(myX-hisX) >=4))) && Helper.lineSight(me, character, level) )
        {
            Helper.attack(me.getContent(), character.getContent(), level);
        }
        
        else
        {
            int first = abs(myX-hisX);
            int second = abs(myY-hisY);
            
            if (first <= second)
            {
                if(myX<hisX)
                {
                    Helper.moveEntity(me, 1, 0, level);
                }
                else
                {
                    Helper.moveEntity(me, -1, 0, level);
                }
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
    }
}
