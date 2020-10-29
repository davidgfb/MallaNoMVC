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
    boolean cuadrado = false;
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor">
    public PanelMalla(int filas, int columnas, boolean cuadrado) {
        setFilas(filas);
        setColumnas(columnas);
        setCuadrado(cuadrado);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="setters">
    private void setFilas(int filas) {
        this.filas = filas;
    }

    private void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    private void setCuadrado(boolean cuadrado) {
        this.cuadrado = cuadrado;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="pintacomponente">
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        dibujaCuadricula(g, filas, columnas, cuadrado);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="dibujaCuadricula">
    void dibujaCuadricula(Graphics g, int filas, int columnas, boolean cuadrado) {
        
        //<editor-fold defaultstate="collapsed" desc="vars">
        /* ancho panel anchoP, alto panel altoP
         * por defecto no es cuadrado
         */
        int anchoP = getWidth(),
            altoP = getHeight();
        
        if (cuadrado) {
            anchoP = altoP;
        } 
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="dibuja lineas">
        /* las lineas empiezan desde 1 para no dibujar los margenes laterales cuando los origenes son 0
         * siempre se pintan n-1 lineas para dar lugar a n huecos
         * si es cuadrado dibujamos la columna lateral derecha (e izda?) que delimita la malla
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
        
        if (cuadrado) {
            g.drawLine(columnas*anchoP/columnas, 0, columnas*anchoP/columnas, altoP);
        } 
        //*********************************************************
//</editor-fold>
    }           

//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="tostring">
    @Override
    public String toString() {
        return "PanelMalla{" + "filas=" + filas + ", columnas=" + columnas + '}';
    }
//</editor-fold>
}
