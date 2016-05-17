/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import javax.swing.ImageIcon;

/**
 *
 * @author Seth, Icon, Marco
 */
public class ArmorOne extends ItemDecorator{
    Item item;
    String name = "Iron Armor";
    String description = "Standard Iron Armor";
    ImageIcon image = new ImageIcon("src/dungeonfactory/Graphics/Armor1.png");
    int atk = 0;
    int def = 1;
    int hp = 5;
    
    public ArmorOne() {
        
    }

    public ArmorOne(ItemDecorator id) {
        super(id);
    }

    @Override
    public int atk() {
        return item.getAtk() + atk;
    }

    @Override
    public int def() {
        return item.getDef() + def;
    }

    @Override
    public int hp() {
        return item.getHP() + hp;
    }

    
    
}
