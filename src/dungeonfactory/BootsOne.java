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
public class BootsOne extends Item{
    
    @Override
    public void setStats() {
        super.name = "Leather Boots";
        super.description = "Standard Leather Boots";
        super.type = "Boots";
        super.atk = 0;
        super.def= 1;
        super.hp = 6;
    }
}
