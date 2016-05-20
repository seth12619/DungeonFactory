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
public class BootsTwo extends Item{
    
    @Override
    public void setStats() {
        super.name = "Cured Leather Boots";
        super.description = "Cured Leather Boots. Dried at Appleloosa.";
        super.type = "Boots";
        super.atk = 0;
        super.def= 3;
        super.hp = 6;
    }
}
