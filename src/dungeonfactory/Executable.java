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
public class Executable extends Observable{
    private Point point;
    private Behavior behavior;
    
    public Executable (Point point, Behavior behavior)
    {
        this.point = point;
        this.behavior = behavior;
    }
    
    public void doBehavior()
    {
        this.behavior.execute();
        setChanged();
        notifyObservers();
    }
    
    public Point getPoint()
    {
        return this.point;
    }
}
