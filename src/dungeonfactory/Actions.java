/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonfactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Seth, Marco, Icon
 */
public class Actions {
        public static JTextArea actions = new JTextArea(10, 40);
        public static JScrollPane scroll = new JScrollPane(actions);
    public Actions() {

    }
    
    public static JPanel createTextArea() {
        JPanel theArea = new JPanel();
        
        theArea.setLayout(new BorderLayout());
        
        actions.setEditable(false);
        actions.setEnabled(false);
        
        actions.setLineWrap(true);
        
        actions.setDisabledTextColor(Color.BLACK);
        
        theArea.add(new JLabel("                                 "), BorderLayout.WEST);
        theArea.add(scroll, BorderLayout.CENTER);
        theArea.add(new JLabel("   "), BorderLayout.EAST);
        theArea.add(new JLabel(" "), BorderLayout.SOUTH);

        
        return theArea;
        
        
    }

    public static void appendAction(String action) {
        actions.append(action + "\n");
    }
    
    public static void setNewText(String action) {
        actions.setText(action);
    }
}
