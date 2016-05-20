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
public class HelmetOne extends Item{
   
    
    @Override
    public void setStats() {
        super.name = "Iron Crown";
        super.description = "An Iron Crown that most generic heroes wear";
        super.type = "Helmet";
        super.atk = 0;
        super.def= 1;
        super.hp = 3;
    }
}
