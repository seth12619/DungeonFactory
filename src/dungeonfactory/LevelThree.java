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
public class LevelThree {
    
    
    static char[][]oneULa = new char[][] {  //TREASURE
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneULb = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneULc = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneURa = new char[][] {  //STAIRS STAIRS STAIRS
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneURb = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneURc = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneLLa = new char[][] { //CHARACTER SPAWN POINT
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneLLb = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneLLc = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneLRa = new char[][] { //WHATEVER WE WANT
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneLRb = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    static char[][]oneLRc = new char[][] { 
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'},
                                    {'_','_','_','_','_','_'}};
    
    static char[][][]UL = new char[][][] {oneULa, oneULb, oneULc};
    static char[][][]UR = new char[][][] {oneURa, oneURb, oneURc};
    static char[][][]LL = new char[][][] {oneLLa, oneLLb, oneLLc};
    static char[][][]LR = new char[][][] {oneLRa, oneLRb, oneLRc};
    
    public LevelThree(){};
    
    public static char[][] getUL()
    {
        int size = UL.length;
        int range = (size - 1) + 1;     
        int check = (int) ((Math.random() * range) +1)-1;
        return UL[check];
    }
    
    public static char[][] getUR()
    {
        int size = UR.length;
        int range = (size - 1) + 1;     
        int check = (int) ((Math.random() * range) +1)-1;
        
        return UR[check];
    }
    
    public static char[][] getLL()
    {
        int size = LL.length;
        int range = (size - 1) + 1;     
        int check = (int) ((Math.random() * range) +1)-1;
        
        return LL[check];
    }
    
    public static char[][] getLR()
    {
        int size = LR.length;
        int range = (size - 1) + 1;     
        int check = (int) ((Math.random() * range +1) -1);
        
        return LR[check];
    }
}
