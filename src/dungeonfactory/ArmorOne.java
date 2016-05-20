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
public class ArmorOne extends Item{
   

    
    public ArmorOne() {
    }
    
    @Override
    public void setStats() {
        super.name = "Iron Armor";
        super.description = "Standard Iron Armor";
        super.type = "Armor";
        super.atk = 0;
        super.def= 1;
        super.hp = 5;
    }
}
