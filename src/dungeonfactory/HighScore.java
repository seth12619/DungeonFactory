/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Seth, Marco, Icon
 */
public class HighScore {
    
    private static HighScore uniqueInstance = new HighScore();;
    
    private HighScore() {
        
    }
    
    public static HighScore getInstance() {
        return uniqueInstance;
    }
    
    protected int readHighScore() {
        int hs = 0;
        String theNum = "0";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/dungeonfactory/score/dfScore.txt"));
            while ((theNum = br.readLine()) != null) {
                hs = Integer.parseInt(theNum);
            }
        } catch (FileNotFoundException ex) {
            return 0;
        } catch (IOException ex) {
            return 0;
        }
        
        
        
        return hs;
    }
    
    protected void noteDownHighScore(int score) {
        try {
            FileWriter writer = new FileWriter("src/dungeonfactory/score/dfScore.txt");
            BufferedWriter out = new BufferedWriter(writer);
            String toWrite = Integer.toString(score);
            out.write(toWrite);
            out.close();
            writer.close();
            
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
