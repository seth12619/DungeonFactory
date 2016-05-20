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
public class BootsFive extends Item{
    
    @Override
    public void setStats() {
        super.name = "Fortress Boots";
        super.description = "Boots worn by a fortress commander. What is it doing here?";
        super.type = "Boots";
        super.atk = 0;
        super.def= 7;
        super.hp = 14;
    }
}
