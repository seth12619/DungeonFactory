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
public class Point {
        private int xcoord;
        private int ycoord;
        private Entity content;
        
        public Point(int x, int y, Entity type)
        {
            this.xcoord = x;
            this.ycoord = y;
            this.content = type;
        }
        
        public int getX()
        {
            return this.xcoord;
        }
        
        public int getY()
        {
            return this.ycoord;
        }
        
        public void setX(int x)
        {
            this.xcoord = x;
        }
        
        public void setY(int y)
        {
            this.ycoord = y;
        }
        
        public void setContent(Entity temp)
        {
            this.content = temp;
        }
        
        public Entity getContent()
        {
            return content;
        }
}
