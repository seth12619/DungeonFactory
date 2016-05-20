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
public class HelmetThree extends Item{
   
    
    @Override
    public void setStats() {
        super.name = "Full Steel Helmet";
        super.description = "Protect thy head with thick alloy.";
        super.type = "Helmet";
        super.atk = 0;
        super.def= 4;
        super.hp = 7;
    }
}
