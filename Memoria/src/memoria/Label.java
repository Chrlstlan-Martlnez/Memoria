package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label extends JLabel {
    
    Label(String texto, Color fondo, Color fuente, Dimension tamano){
        this.setLayout(new BorderLayout());
        this.setText(texto);
        this.setBackground(fondo);
        this.setForeground(fuente);
        this.setOpaque(true);
        this.setPreferredSize(tamano);
    }
    
    Label(String texto, Color fondo, Color fuente, Dimension tamano, Border borde){
        this.setLayout(new BorderLayout());
        this.setText(texto);
        this.setBackground(fondo);
        this.setForeground(fuente);
        this.setOpaque(true);
        this.setPreferredSize(tamano);
        this.setBorder(borde);
    }

    Label(ImageIcon imagen, Color fondo, Dimension tamano){
        this.setLayout(new BorderLayout());
        this.setBackground(fondo);
        this.setIcon(imagen);
        this.setOpaque(true);
        this.setPreferredSize(tamano);
        
    }
    
    Label(String texto, Color fondo, Color fuente, Dimension tamano, ImageIcon imagen){
        this.setLayout(new BorderLayout());
        this.setText(texto);
        this.setBackground(fondo);
        this.setForeground(fuente);
        this.setIcon(imagen);
        this.setOpaque(true);
        this.setPreferredSize(tamano);
    }
}
