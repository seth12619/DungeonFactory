/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

/**
 *
 * @author Seth, Icon, Marco
 */
public class ArmorTwo extends Item{
    
    public ArmorTwo() {
        setStats();
    }

        @Override
    public void setStats() {
        super.name = "Steel Armor";
        super.description = "Standard Steel Armor";
        super.type = "Armor";
        super.atk = 0;
        super.def= 2;
        super.hp = 7;
        
    }
    
    
}
