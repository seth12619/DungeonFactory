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
public class ArmorFour extends Item{
    

    @Override
    public void setStats() {
        super.name = "Holy Royal Armor";
        super.description = "From the royal treasurey. Said to be crafted from the stone that held the sword that chooses the king.";
        super.type = "Armor";
        super.atk = 0;
        super.def= 15;
        super.hp = 20;
        
    }
    
    
}
