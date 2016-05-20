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
public class WeaponThree extends Item{
    

    @Override
    public void setStats() {
        super.name = "Iron Axe";
        super.description = "Standard Iron Axe";
        super.type = "Weapon";
        super.atk = 8;
        super.def= 0;
        super.hp = 5;
        
    }
    
    
}
