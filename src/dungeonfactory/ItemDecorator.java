/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

/**
 *
 * @author Seth, Marco, Icon
 */
public abstract class ItemDecorator extends Item {
    
   private ItemDecorator thisDecor;
   
   public ItemDecorator() {
       
   }
   
   public ItemDecorator(ItemDecorator id) {
       this.thisDecor = id;
   }
   
   public ItemDecorator getDecor() {
       return thisDecor;
   }
    
   public void removeDecorator(ItemDecorator a) {
       if(thisDecor == null) {
       } else if (thisDecor.equals(a)) {
           thisDecor = thisDecor.getDecor();
       } else {
           thisDecor.removeDecorator(a);
       }
   }
    
}
