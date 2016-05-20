/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

/**
 *
 * @author Seth, Marco, Icon
 */
public class NoItem extends Item {

    @Override
    public void setStats() {
        super.name = "None";
        super.description = "None";
        super.type = "N/A";
        super.atk = 0;
        super.def= 0;
        super.hp = 0;
    }

 
    
}
