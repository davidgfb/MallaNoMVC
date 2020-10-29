/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

//<editor-fold defaultstate="collapsed" desc="imports">
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.out;
import javax.swing.JPanel;
//</editor-fold>

/**
 *
 * @author David
 */
public class PanelMalla extends JPanel implements MouseListener {
    
    //<editor-fold defaultstate="collapsed" desc="vars">
    int filasM = 0,
        columnasM = 0,
        anchoP = 0,
        altoP = 0;
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
        this.filasM = filas;
    }

    private void setColumnas(int columnas) {
        this.columnasM = columnas;
    }

    private void setCuadrado(boolean cuadrado) {
        this.cuadrado = cuadrado;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="pintacomponente">
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        anchoP = getWidth();
        altoP = getHeight();
        dibujaCuadricula(g, filasM, columnasM, anchoP, altoP, cuadrado);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="dibujaCuadricula">
    void dibujaCuadricula(Graphics g, int filas, int columnas, int anchoP, int altoP, boolean cuadrado) {
        
        //<editor-fold defaultstate="collapsed" desc="vars">
        /* ancho panel anchoP, alto panel altoP
         * por defecto no es cuadrado
        */
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
            g.drawLine(altoP, 0, altoP, altoP);
        } 
        //*********************************************************
//</editor-fold>
    }           

//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="tostring">
    @Override
    public String toString() {
        return "PanelMalla{" + "filas=" + filasM + ", columnas=" + columnasM + '}';
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="mouse listener">
    
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), 
            y = e.getY();
        //añadeCelda(devuelveCuadranteX(x, ancho), devuelveCuadranteY(y, alto));
        
        //anchoP=altoP
        if (cuadrado) {
            int xMax = altoP;
            
            if (x>xMax) {
                x = xMax;
            }
            
            out.println("xMax: "+xMax+", x: "+x+", y: "+y+", filaC: " + getFilaCelda(y, altoP, filasM)+", columnaC: "+getColumnaCelda(x, altoP, columnasM));
        }
        
        //out.println("x: "+x+", y: "+y+", fila: "+getCeldaX(x,anchoP,filasM) + ", columna: " + columnasM);
    }
    
    //<editor-fold defaultstate="collapsed" desc="mL no usado">
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
//</editor-fold>
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="devuelveCuadrantes">
    int getColumnaCelda(int x, int anchoP, int columnasM) {
        //x *= columnasM/anchoP;
        //anchoP no puede ser 0
        return x * columnasM / anchoP; 
    }
    
    int getFilaCelda(int y, int altoP, int filasM) {
        //y *= filasM/altoP;
        //filasM no puede ser 0
        return getColumnaCelda(y, altoP, filasM); //y * filasM / altoP; 
    }
//</editor-fold>
}
