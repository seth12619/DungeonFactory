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
public class HelmetFour extends Item{
   
    
    @Override
    public void setStats() {
        super.name = "Goggles";
        super.description = "Low protection, but helps you make better attacks.";
        super.type = "Helmet";
        super.atk = 2;
        super.def= 1;
        super.hp = 5;
    }
}
