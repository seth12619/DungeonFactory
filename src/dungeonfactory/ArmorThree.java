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
public class ArmorThree extends Item{
    

    @Override
    public void setStats() {
        super.name = "Dragon Armor";
        super.description = "Dragon Hide Armor. You feel stronger just by wearing it.";
        super.type = "Armor";
        super.atk = 1;
        super.def= 4;
        super.hp = 11;
        
    }
    
    
}
