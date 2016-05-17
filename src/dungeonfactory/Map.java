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
    ArrayList<Executable> queue = new ArrayList<>();
    char[][]a = new char[][] { {'B','B','B','B','B','B','B','B','B','B'}, {'B','_','E','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}};
    char[][]b = new char[][] { {'B','B','B','B','B','B','B','B','B','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','E','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}};
    char[][]c = new char[][] { {'B','_','_','_','_','C','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','_','_','_','_','_','_','_','_','_'}, {'B','B','B','B','B','B','B','B','B','B'}};
    char[][]d = new char[][] { {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'_','_','_','_','_','_','_','_','_','B'}, {'B','B','B','B','B','B','B','B','B','B'}};
    
    public Map(int sizeV, int sizeH, Game game)
    {
        char[][] input = new char[sizeV][sizeH];
        
        for (int p = 0; p < sizeV; p++)
        {
            for (int q = 0; q < sizeH; q++)
            {
                   if (p < 10 && q < 10)
                   {
                       input[p][q] = a[p][q];
                   }
                   else if (p < 10 && q >= 10)
                   {
                       input[p][q] = b[p][q-10];
                   }
                   else if (p >= 10 && q >= 10)
                   {
                       input[p][q] = d[p-10][q-10];
                   }
                   else if (p >= 10 && q < 10)
                   {
                       input[p][q] = c[p-10][q];
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
                
                else if (input[i][j] == 'B')
                {
                    map[i][j] = new Entity ('-', false, false);
                }
                
                else if (input[i][j] == 'C')
                {
                    //do nothing. This is just to catch "extra" C's.
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
            
}
