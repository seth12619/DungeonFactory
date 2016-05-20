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
public class ArmorFive extends Item{
    

    @Override
    public void setStats() {
        super.name = "Awesome Cape";
        super.description = "Yes! Just the Cape! You feel more powerful wearing this! Yep, literally just the cape";
        super.type = "Armor";
        super.atk = 15;
        super.def= 0;
        super.hp = 5;
        
    }
    
    
}
