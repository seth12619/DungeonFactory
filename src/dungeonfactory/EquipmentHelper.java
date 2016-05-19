/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

/**
 *
 * @author Seth Legaspi
 */
public class EquipmentHelper {
    
    public static Item bodyArmor = new NoItem();
    public static Item helmet = new NoItem();
    public static Item weapon = new NoItem();
    
    static int addAtk = 0;
    static int addDef = 0;
    static int addHP = 0;
    
    public EquipmentHelper() {
        
    }
    
    public static void setEquipment(Item toEquip) {
        System.out.println("HERE: " + toEquip.getName());
        switch(toEquip.getType()) {
            case "Armor": bodyArmor = toEquip;
                break;
            case "Helmet": helmet = toEquip;
                break;
            case "Weapon": weapon = toEquip;
                break;
            case "newType Gundam": Actions.appendAction("No item to equip!");
                break;
            default: Actions.appendAction("Invalid Item!");
                break;
            
        }
        refreshAdditional();
    }
    
    public static void refreshAdditional() {
        addAtk = weapon.getAtk() + helmet.getAtk() + bodyArmor.getAtk();
        addDef = weapon.getDef() + helmet.getDef() + bodyArmor.getDef();
        addHP = weapon.getHP() + helmet.getHP() + bodyArmor.getHP();
    }
    
    public static void updateStats(Point chara) {
        chara.getContent().setAtk(chara.getContent().getAtk() + addAtk);
        chara.getContent().setDef(chara.getContent().getDef() + addDef);
        chara.getContent().setHp(chara.getContent().getHp() + addHP);
    }
    
}
