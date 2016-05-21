/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

/**
 *
 * @author mnmkami
 */
public class LevelOne {
    
    
    static char[][]oneULa = new char[][] { {'-','-','-','-'},
                                    {'-','T','-','_'},
                                    {'-','_','-','_'},
                                    {'_','_','_','_'}};
    static char[][]oneULb = new char[][] { {'T','_','_','_'},
                                    {'-','-','-','_'},
                                    {'E','_','_','_'},
                                    {'_','_','_','_'}};
    static char[][]oneULc = new char[][] { {'_','_','_','_'},
                                    {'B','_','_','_'},
                                    {'-','-','T','_'},
                                    {'_','_','_','_'}};
    static char[][]oneURa = new char[][] { {'_','_','_','D'},
                                    {'_','-','-','-'},
                                    {'_','E','_','_'},
                                    {'-','-','-','_'}};
    static char[][]oneURb = new char[][] { {'_','_','_','E'},
                                    {'_','-','D','_'},
                                    {'_','-','-','_'},
                                    {'_','_','_','_'}};
    static char[][]oneURc = new char[][] { {'_','_','_','_'},
                                    {'_','_','_','D'},
                                    {'B','_','_','_'},
                                    {'_','_','_','_'}};
    static char[][]oneLLa = new char[][] { {'-','_','_','_'},
                                    {'-','_','_','_'},
                                    {'-','C','_','_'},
                                    {'-','-','-','-'}};
    static char[][]oneLLb = new char[][] { {'_','_','_','_'},
                                    {'-','-','-','_'},
                                    {'-','C','-','_'},
                                    {'-','_','_','_'}};
    static char[][]oneLLc = new char[][] { {'_','_','_','_'},
                                    {'E','_','_','_'},
                                    {'_','-','_','_'},
                                    {'C','-','_','_'}};
    static char[][]oneLRa = new char[][] { {'_','E','_','-'},
                                    {'_','_','_','-'},
                                    {'_','_','B','-'},
                                    {'-','-','-','-'}};
    static char[][]oneLRb = new char[][] { {'_','_','_','E'},
                                    {'_','-','-','_'},
                                    {'_','-','-','_'},
                                    {'_','_','_','_'}};
    static char[][]oneLRc = new char[][] { {'_','_','B','_'},
                                    {'-','E','_','_'},
                                    {'-','_','_','_'},
                                    {'_','_','_','T'}};
    
    static char[][][]UL = new char[][][] {oneULa, oneULb, oneULc};
    static char[][][]UR = new char[][][] {oneURa, oneURb, oneURc};
    static char[][][]LL = new char[][][] {oneLLa, oneLLb, oneLLc};
    static char[][][]LR = new char[][][] {oneLRa, oneLRb, oneLRc};
    
    public LevelOne(){};
    
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
