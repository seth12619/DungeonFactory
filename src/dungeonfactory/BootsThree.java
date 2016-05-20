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
public class BootsThree extends Item{
    
    @Override
    public void setStats() {
        super.name = "Iron Boots";
        super.description = "Standard Iron Boots";
        super.type = "Boots";
        super.atk = 0;
        super.def= 4;
        super.hp = 8;
    }
}
