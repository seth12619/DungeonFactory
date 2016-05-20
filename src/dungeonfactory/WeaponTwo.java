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
public class WeaponTwo extends Item{
    

    @Override
    public void setStats() {
        super.name = "Twin Iron Swords";
        super.description = "Standard Twin Iron Swords";
        super.type = "Weapon";
        super.atk = 7;
        super.def= 3;
        super.hp = 1;
        
    }
    
    
}
