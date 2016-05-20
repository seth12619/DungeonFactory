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
public class ShieldOne extends Item{
    
    @Override
    public void setStats() {
        super.name = "Coffin Shield";
        super.description = "Made of the a wooden coffin lid";
        super.type = "Shield";
        super.atk = 0;
        super.def= 1;
        super.hp = 3;
    }
}
