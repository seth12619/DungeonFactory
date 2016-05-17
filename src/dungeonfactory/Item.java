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
    int atk = 0;
    int def = 0;
    int hp = 0;
    
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getAtk() {
        return atk;
    }
    
    public int getDef() {
        return def;
    }
    
    public int getHP(){
        return hp;
    }
    
    
    public abstract int atk();
    public abstract int def();
    public abstract int hp();
}
