/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author mnmkami
 */
public class Entity {
    char value;
    
    public Entity (char value)
    {
        this.value = value;
    }
    
    public void setValue (char value)
    {
        this.value = value;
    }
    
    public char getValue ()
    {
        return value;
    }
}
