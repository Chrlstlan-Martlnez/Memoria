package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    Ventana(String nombre, Color fondo, ImageIcon icono, Dimension tamano, int espacio){
        this.setTitle(nombre);
        this.getContentPane().setBackground(fondo);
        this.setIconImage(icono.getImage());
        this.setMinimumSize(tamano);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(espacio,espacio));
    }
}
