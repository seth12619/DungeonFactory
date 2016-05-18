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
    ArrayList<Executable> queue = new ArrayList<>();
    char[][]a = new char[][] { {'W','W','W','W','W','W','W','W','W','W'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','E','_','_','_','_','_'}};
    char[][]b = new char[][] { {'W','W','W','W','W','W','W','W','W','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}};
    char[][]d = new char[][] { {'W','_','_','_','_','C','_','D','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','_','_','_','_','_','_','_','_'}, {'W','_','E','_','_','_','_','_','_','_'}, {'W','W','W','W','W','W','W','W','W','W'}};
    char[][]c = new char[][] { {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'_','_','_','_','_','_','_','_','_','W'}, {'W','W','W','W','W','W','W','W','W','W'}};
    
    char[][]e = new char[][] { {'W','W','W'}, {'W','_','_'}, {'W','E','_'}};
    char[][]h = new char[][] { {'W','C','_'}, {'W','_','_'}, {'W','W','W'}};
    char[][]g = new char[][] { {'_','_','W'}, {'_','D','W'}, {'W','W','W'}};
    char[][]f = new char[][] { {'W','W','W'}, {'_','_','W'}, {'_','_','W'}};
    public Map(Game game, int level)
    {
        
        char[][] l;
        char[][] m;
        char[][] n;
        char[][] o;
        
        if (level == 1)
        {
            l = e;
            m = f;
            n = g;
            o = h;
        }
        
        else
        {
            l = a;
            m = b;
            n = c;
            o = d;
        }
        
        this.sizeV = l.length*2;
        this.sizeH = l[0].length*2;
        
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
                    this.character = Helper.characterMaker(z, y, this);
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
                
                else if (input[i][j] == 'W')
                {
                    map[i][j] = new Entity ('W', false, false);
                }
                
                else if (input[i][j] == 'C')
                {
                    //do nothing. This is just to catch "extra" C's.
                }
                
                else if (input [i][j] == 'D')
                {
                    map[i][j] = new Entity ('T', false, true);
                    this.door = new Point (i,j,map[i][j]);
                }
                
                else if (input[i][j] == 'E')
                {
                    Executable stubA = Helper.enemyMaker('E', i, j, this);
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
            
}
