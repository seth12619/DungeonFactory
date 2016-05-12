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
public class Entity{
    char value;
    private boolean attackable;
    private boolean walkable;
    private int hp;
    private int def;
    private int atk;
    
    public Entity (char value, boolean attackable, boolean walkable)
    {
        this.value = value;
        this.attackable = attackable;
        this.walkable = walkable;
    }
    
    public Entity (char value, boolean attackable, boolean walkable, int hp, int atk, int def)
    {
        this.value = value;
        this.attackable = attackable;
        this.walkable = walkable;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }
    
    public void setValue (char value)
    {
        this.value = value;

    }
    
    public char getValue ()
    {
        return value;
    }
    
    public boolean isWalkable()
    {
        return walkable;
    }
    
    public boolean isAttackable()
    {
        return attackable;
    }
    
    public int getAtk()
    {
        return atk;
    }
    
    public int getDef()
    {
        return def;
    }
    
    public int getHp()
    {
        return hp;
    }
    
    public void setAtk(int atk)
    {
        this.atk = atk;
    }
    
    public void setDef(int def)
    {
        this.def = def;
    }
    
    public void setHp (int hp)
    {
        this.hp = hp;
    }
}
