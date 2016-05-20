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
public class HelmetTwo extends Item{
   
    
    @Override
    public void setStats() {
        super.name = "Iron Mask";
        super.description = "Your everyday iron mask";
        super.type = "Helmet";
        super.atk = 0;
        super.def= 2;
        super.hp = 5;
    }
}
