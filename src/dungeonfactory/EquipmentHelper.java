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
    public static Item shield = new NoItem();
    public static Item boots = new NoItem();
    
    static int addAtk = 0;
    static int addDef = 0;
    static int addHP = 0;
    
    public EquipmentHelper() {
        
    }
    
    public static void setEquipment(Point chara, Item toEquip) {
        System.out.println("HERE: " + toEquip.getName());
        switch(toEquip.getType()) {
            case "Armor": removeItem(chara, bodyArmor);
                bodyArmor = toEquip;
                break;
            case "Helmet": removeItem(chara, helmet);
                helmet = toEquip;
                break;
            case "Weapon": removeItem(chara, weapon);
                weapon = toEquip;
                break;
            case "Boots": removeItem(chara, boots);
                boots = toEquip;
                break;
            case "Shield": removeItem(chara, shield);
                shield = toEquip;
                break;
            case "newType Gundam": Actions.appendAction("No item to equip!");
                break;
            default: Actions.appendAction("Invalid Item!");
                break;
            
        }
        refreshAdditional();
        updateStats(chara);
    }
    
    public static String getArmor() {
        return bodyArmor.getName();
    }
    
    public static String getWep() {
        return weapon.getName();
    }
    
    public static String getHelm() {
        return helmet.getName();
    }
    
    public static String getBoots() {
        return boots.getName();
    }
    
    public static String getShield() {
        return shield.getName();
    }
    
    public static void removeItem(Point chara, Item toRemove) {
        chara.getContent().setAtk(chara.getContent().getAtk() - toRemove.getAtk());
        chara.getContent().setDef(chara.getContent().getDef() - toRemove.getDef());
        //chara.getContent().setHp(chara.getContent().getHp() - toRemove.getHP());
    }
    
    public static void refreshAdditional() {
        addAtk = weapon.getAtk() + helmet.getAtk() + bodyArmor.getAtk() + boots.getAtk() + shield.getAtk();
        addDef = weapon.getDef() + helmet.getDef() + bodyArmor.getDef() + boots.getDef() + shield.getDef();
        addHP = weapon.getHP() + helmet.getHP() + bodyArmor.getHP() + boots.getHP() + shield.getHP();
    }
    
    public static void updateStats(Point chara) {
        chara.getContent().setAtk(chara.getContent().getAtk() + addAtk);
        chara.getContent().setDef(chara.getContent().getDef() + addDef);
        chara.getContent().setHp(chara.getContent().getHp() + addHP);
    }
    
}
