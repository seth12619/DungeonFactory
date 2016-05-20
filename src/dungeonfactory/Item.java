/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import javax.swing.ImageIcon;

/**
 *
 * @author Seth, Icon, Marco
 */
public abstract class Item {
    String name = "No Item";
    String description = "What description";
    String type = "newType Gundam";
    int atk = 0;
    int def = 0;
    int hp = 0;
    
    public Item() {
        setStats();
    }

    public abstract void setStats();
    
    
    //The rest are stuff that everything has
    public final String getName() {
        return name;
    }
    
    public final String getType() {
        return type;
    }
    
    public final String getDescription() {
        return description;
    }
    
    public final int getAtk() {
        return atk;
    }
    
    public final int getDef() {
        return def;
    }
    
    public final int getHP(){
        return hp;
    }
    

}
