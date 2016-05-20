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
public class WeaponFour extends Item{
    

    @Override
    public void setStats() {
        super.name = "Steel Sabre";
        super.description = "A royal guard's standard issue sabre. 100% steel alloy.";
        super.type = "Weapon";
        super.atk = 12;
        super.def= 0;
        super.hp = 7;
        
    }
    
    
}
