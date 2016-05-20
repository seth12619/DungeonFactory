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
public class HelmetFive extends Item{
   
    
    @Override
    public void setStats() {
        super.name = "Holy Crown";
        super.description = "Emits a sacred aura that protects one from attacks";
        super.type = "Helmet";
        super.atk = 0;
        super.def= 6;
        super.hp = 10;
    }
}
