/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author mnmkami
 */
public class GoblinAI implements Behavior{
    private Point character;
    private Point me;
    private Entity[][] map;
    Entity leave = new Entity('_', false, true);
    private ArrayList<Executable> queue;
    private Map level;
    public GoblinAI (Point character, Point me, Map level)
    {
        this.map = level.getMap();
        this.queue = level.getQueue();
        this.level = level;
        this.character = level.getCharacter();
        this.me = me;
    }
    
    @Override
    public void execute() {
        System.out.println( me.getContent().getValue() + " did a thing!");
        
        int myX = me.getX();
        int myY = me.getY();
        int hisX = character.getX();
        int hisY = character.getY();
        
        
        
        if (myX < hisX)
        {
            Helper.moveEntity(me, 1, 0, level);
        //    setChanged();
        }
        
        else if (myX > hisX)
        {
            Helper.moveEntity(me, -1, 0, level);
        //    setChanged();
        }
        
        else if (myY < hisY)
        {
            Helper.moveEntity(me, 0, 1, level);
        //    setChanged();
        }
        
        else if (myY > hisY)
        {
            Helper.moveEntity(me, 0, -1, level);
         //   setChanged();
        }
        
        else
        {
            System.out.println("I did nothing!");
        }
       // notifyObservers();
        //System.out.println("Adjacent? " + Helper.checkAdjacent(character, me));
    }
    
}
