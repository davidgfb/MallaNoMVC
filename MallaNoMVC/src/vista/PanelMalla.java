/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

//<editor-fold defaultstate="collapsed" desc="imports">
import java.awt.Graphics;
import javax.swing.JPanel;
//</editor-fold>

/**
 *
 * @author David
 */
public class PanelMalla extends JPanel {
    
    //<editor-fold defaultstate="collapsed" desc="vars">
    int filas = 0,
            columnas = 0;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor">
    public PanelMalla(int filas, int columnas) {
        setFilas(filas);
        setColumnas(columnas);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="setters">
    private void setFilas(int filas) {
        this.filas = filas;
    }

    private void setColumnas(int columnas) {
        this.columnas = columnas;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="pintacomponente">
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        dibujaCuadricula(g, filas, columnas);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="dibujaCuadricula">
    void dibujaCuadricula(Graphics g, int filas, int columnas) {
        //ancho panel anchoP, alto panel altoP
        int anchoP = getWidth(),
            altoP = getHeight();
        
        /* las lineas empiezan desde 1 para no dibujar los margenes laterales cuando los origenes son 0
        * siempre se pintan n-1 lineas para dar lugar a n huecos
        */
        //*************     filas   *************************
        for (int fila = 1; fila<filas; fila++) {
            g.drawLine(0,fila*altoP/filas,anchoP,fila*altoP/filas);
        }
        //*************************************************
    
        //**************    columnas    *****************************
        for (int columna = 1; columna<columnas; columna++) {
            g.drawLine(columna*anchoP/columnas, 0, columna*anchoP/columnas, altoP);
        }
        //*********************************************************
    }   
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="tostring">
    @Override
    public String toString() {
        return "PanelMalla{" + "filas=" + filas + ", columnas=" + columnas + '}';
    }
//</editor-fold>
}
