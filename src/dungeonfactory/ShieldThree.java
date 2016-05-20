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
public class ShieldThree extends Item{
    
    @Override
    public void setStats() {
        super.name = "Iron Shield";
        super.description = "Standard Iron Shield";
        super.type = "Shield";
        super.atk = 0;
        super.def= 5;
        super.hp = 8;
    }
}
