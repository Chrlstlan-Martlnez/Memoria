package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Panel extends JPanel{
    private ImageIcon img;
    
    Panel(Dimension tamano, Color fondo){
        this.setLayout(new BorderLayout(20,20));
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
    }
    
    Panel(Dimension tamano, Color fondo, LayoutManager tipoLayout){
        this.setLayout(tipoLayout);
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
        
        if (tipoLayout == new BorderLayout()) {
            Panel centro = new Panel(new Dimension(10,10), fondo);
            this.add(centro, BorderLayout.CENTER);
        }
    }
    
    Panel(ImageIcon img, Dimension tamano, Color fondo, LayoutManager tipoLayout){
        this.img = img;
        this.setLayout(tipoLayout);
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
        
        if (tipoLayout == new BorderLayout()) {
            Panel centro = new Panel(new Dimension(10,10), fondo);
            this.add(centro, BorderLayout.CENTER);
        }
    }
    
    Panel(Dimension tamano, Color fondo, boolean transparente, Border borde, LayoutManager tipoLayout){
        this.setLayout(tipoLayout);
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
        this.setBorder(borde);
        this.setOpaque(transparente);
        
        if (tipoLayout == new BorderLayout()) {
            Panel centro = new Panel(new Dimension(10,10), fondo);
            this.add(centro, BorderLayout.CENTER);
        }
    }
    
    Panel(Dimension tamano, Color fondo, boolean transparente, LayoutManager tipoLayout){
        this.setLayout(tipoLayout);
        this.setPreferredSize(tamano);
        this.setBackground(fondo);
        this.setOpaque(transparente);
        
        if (tipoLayout == new BorderLayout()) {
            Panel centro = new Panel(new Dimension(10,10), fondo);
            this.add(centro, BorderLayout.CENTER);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    
}
