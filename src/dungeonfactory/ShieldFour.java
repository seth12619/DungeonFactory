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
public class ShieldFour extends Item{
    
    @Override
    public void setStats() {
        super.name = "Night Guard Shield";
        super.description = "Commissioned by Princess Luna herself to defend against the monsters of night";
        super.type = "Shield";
        super.atk = 0;
        super.def= 7;
        super.hp = 12;
    }
}
