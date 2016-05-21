/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.util.ArrayList;

/**
 *
 * @author mnmkami
 */


public class Map {
    Entity[][] map;
    Point character;
    int sizeV;
    int sizeH;
    Game game;
    Point door;
    Point chest;
    ArrayList<Executable> queue = new ArrayList<>();
    char[][]a = new char[][] { {'-','-','-','-','-','-','-','-','-','-'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','Z','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}};
    char[][]b = new char[][] { {'-','-','-','-','-','-','-','-','-','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','-','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}};
    char[][]d = new char[][] { {'-','_','_','_','_','C','_','D','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','_','_','_','_','_','_','_','_','_'}, {'-','-','-','-','-','-','-','-','-','-'}};
    char[][]c = new char[][] { {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'_','_','_','_','_','_','_','_','_','-'}, {'-','-','-','-','-','-','-','-','-','-'}};
    
    char[][]e = new char[][] { {'-','-','-'}, {'-','_','_'}, {'-','E','B'}};
    char[][]h = new char[][] { {'-','C','_'}, {'-','_','_'}, {'-','-','-'}};
    char[][]g = new char[][] { {'_','T','-'}, {'_','D','-'}, {'-','-','-'}};
    char[][]f = new char[][] { {'-','-','-'}, {'_','_','-'}, {'_','_','-'}};
    
    
    public Map(Game game, int level)
    {
        
        char[][] l;
        char[][] m;
        char[][] n;
        char[][] o;
        
        if (level == 1)
        {
            
            l = LevelOne.getUL();
            m = LevelOne.getUR();
            n = LevelOne.getLR();
            o = LevelOne.getLL();
            
        } 
        else if (level == 2) {
            l = LevelTwo.getUL();
            m = LevelTwo.getUR();
            n = LevelTwo.getLR();
            o = LevelTwo.getLL();
        }    
        else if (level == 3) {
            l = LevelThree.getUL();
            m = LevelThree.getUR();
            n = LevelThree.getLR();
            o = LevelThree.getLL();
        }
        else if (level == 4) {
            l = LevelFour.getUL();
            m = LevelFour.getUR();
            n = LevelFour.getLR();
            o = LevelFour.getLL();
        }
        else if (level == 7)
        {
            l = LevelSeven.getUL();
            m = LevelSeven.getUR();
            n = LevelSeven.getLR();
            o = LevelSeven.getLL();
        }
        
        else
        {
            l = e;
            m = e;
            n = g;
            o = h;
        }
        
        this.sizeV = l.length*2;
        System.out.println(sizeV);
        this.sizeH = l[0].length*2;
        System.out.println(sizeH);
        
        char[][] input = new char[sizeV][sizeH];
        for (int p = 0; p < sizeV; p++)
        {
            for (int q = 0; q < sizeH; q++)
            {
                   if (p < sizeV/2 && q < sizeH/2)
                   {
                       input[p][q] = l[p][q];
                   }
                   else if (p < sizeV/2 && q >= sizeH/2)
                   {
                       input[p][q] = m[p][q-sizeH/2];
                   }
                   else if (p >= sizeV/2 && q >= sizeH/2)
                   {
                       input[p][q] = n[p-sizeV/2][q-sizeH/2];
                   }
                   else if (p >= sizeV/2 && q < sizeH/2)
                   {
                       input[p][q] = o[p-sizeV/2][q];
                   }
            }
        }
        this.game = game;
        this.sizeV = sizeV;
        this.sizeH = sizeH;
        map = new Entity [sizeV][sizeH];
        for (int z = 0; z < sizeV; z++)
        {
            for (int y = 0; y < sizeH; y++)
            {
                if (input[z][y] == 'C')
                {
                    this.character = Helper.characterMaker(z, y, this,game.currFloor, game.charHP, game.charAtk, game.charDef);
                    map[z][y] = this.character.getContent();
                    break;
                }
            }
        }
        for (int i = 0; i < sizeV; i++)
        {
            for (int j = 0; j < sizeH; j++)
            {
                if (input[i][j] == '_')
                {
                    map[i][j] = new Entity ('_', false, true);
                }
                    
                else if (input[i][j] == '-')
                {
                    map[i][j] = new Entity ('-', false, false);
                }
                
                else if (input[i][j] == 'C')
                {
                    //do nothing. This is just to catch "extra" C's.
                }
                
                else if (input [i][j] == 'D')
                {
                    map[i][j] = new Entity ('S', false, true);
                    this.door = new Point (i,j,map[i][j]);
                }
                else if (input [i][j] == 'T')
                {
                    map[i][j] = new Entity ('T', false, true);
                    this.chest = new Point (i,j,map[i][j]);
                }
                else if (input[i][j] == 'E')
                {
                    Executable stubA = Helper.enemyMaker('E', i, j, this,game.currFloor);
                    stubA.addObserver(game);
                }
                
                else if (input[i][j] == 'B')
                {
                    Executable stubA = Helper.enemyMaker('B', i, j, this,game.currFloor);
                    stubA.addObserver(game);
                }
                
                else if (input[i][j] == 'W')
                {
                    Executable stubA = Helper.enemyMaker('W', i, j, this,game.currFloor);
                    stubA.addObserver(game);
                }
                
                else if (input[i][j] == 'Z')
                {
                    Executable stubA = Helper.enemyMaker('Z', i, j, this,game.currFloor);
                    stubA.addObserver(game);
                }
                
                
            }
        }
        
    }
    
    public Entity[][] getMap()
    {
        return this.map;
    }
    
    public ArrayList<Executable> getQueue()
    {
        return this.queue;
    }
    
    public Point getCharacter()
    {
        return this.character;
    }
    
    public int getV()
    {
        return this.sizeV;
    }
    
    public int getH()
    {
        return this.sizeH;
    }
    
    public Point getDoor()
    {
        return this.door;
    }
    public Point getChest()
    {
        return this.door;
    }
            
}
