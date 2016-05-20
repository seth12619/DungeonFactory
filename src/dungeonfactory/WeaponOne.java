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
public class WeaponOne extends Item{
    

    @Override
    public void setStats() {
        super.name = "Iron Sword";
        super.description = "Standard Iron Sword";
        super.type = "Weapon";
        super.atk = 5;
        super.def= 0;
        super.hp = 2;
        
    }
    
    
}
