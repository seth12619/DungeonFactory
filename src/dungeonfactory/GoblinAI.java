/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.util.Observable;

/**
 *
 * @author mnmkami
 */
public class GoblinAI extends Observable implements Behavior{
    private Point character;
    private Point me;
    private Entity[][] map;
    Entity leave = new Entity('-');
    public GoblinAI (Point character, Point me, Entity[][] map)
    {
        this.character = character;
        this.me = me;
        this.map = map;
    }
    
    @Override
    public void execute() {
        System.out.println( me.getContent().getValue() + " did a thing!");
        
        int myX = me.getX();
        int myY = me.getY();
        int hisX = character.getX();
        int hisY = character.getY();
        
        
        
        if (myX < hisX-1)
        {
            Helper.moveEntity(me, 1, 0, leave, map);
            setChanged();
        }
        
        else if (myX > hisX+1)
        {
            Helper.moveEntity(me, -1, 0, leave, map);
            setChanged();
        }
        
        else if (myY < hisY-1)
        {
            Helper.moveEntity(me, 0, 1, leave, map);
            setChanged();
        }
        
        else if (myY > hisY+1)
        {
            Helper.moveEntity(me, 0, -1, leave, map);
            setChanged();
        }
        
        else
        {
            System.out.println("I did nothing!");
        }
        notifyObservers();
        //System.out.println("Adjacent? " + Helper.checkAdjacent(character, me));
    }
    
}
