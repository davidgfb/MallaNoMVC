/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//<editor-fold defaultstate="collapsed" desc="imports">
import static java.lang.System.out;
import javax.swing.JFrame;
import vista.PanelMalla;
//</editor-fold>

/**
 *
 * @author David
 */
public class Main {
    
    //<editor-fold defaultstate="collapsed" desc="main">
    public static void main(String[] args) {
        //********* vista   *************
        PanelMalla p = new PanelMalla(4, 4, true);
        out.println(p.toString());
        JFrame f = new JFrame();
        
        f.setSize(800, 600);
        f.add(p);
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
        //*******************************
    }
    //</editor-fold>
}
