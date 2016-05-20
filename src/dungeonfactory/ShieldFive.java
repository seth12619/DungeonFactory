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
public class ShieldFive extends Item{
    
    @Override
    public void setStats() {
        super.name = "Blessed Day Shield";
        super.description = "Commissioned by Princess Celestia during the fight against Discord";
        super.type = "Shield";
        super.atk = 0;
        super.def= 9;
        super.hp = 15;
    }
}
