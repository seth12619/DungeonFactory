/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

/**
 *
 * @author mnmkami
 */
public class GoblinAI implements Behavior{
    private Point character;
    private Point me;
    public GoblinAI (Point character, Point me)
    {
        this.character = character;
        this.me = me;
    }
    
    @Override
    public void execute() {
        System.out.println("I did a thing!");
    }
    
}
