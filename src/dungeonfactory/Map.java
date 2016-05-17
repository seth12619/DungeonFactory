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
    ArrayList<Executable> queue = new ArrayList<>();
    public Map(int sizeV, int sizeH, int charX, int charY)
    {
        this.sizeV = sizeV;
        this.sizeH = sizeH;
        map = new Entity [sizeV][sizeH];
        for (int i = 0; i < sizeV; i++)
        {
            for (int j = 0; j < sizeH; j++)
            {
                Entity temp = new Entity ('_', false, true);
                map[i][j] = temp;
            }
        }
        this.character = Helper.characterMaker(charX, charY, this);
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
