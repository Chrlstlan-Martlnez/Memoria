package memoria;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton{
    private String nombreBoton;
    private ImageIcon img;
    private boolean click;
    
    Boton(String nombre, ImageIcon imagen){
        nombreBoton = nombre;
        this.setIcon(imagen);
        img = imagen;
        click = false;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.setBackground(Color.BLACK);
    }
    
    Boton(String nombre, ImageIcon imagen, Dimension tamano){
        nombreBoton = nombre;
        this.setIcon(imagen);
        img = imagen;
        click = false;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.setBackground(Color.BLACK);
        this.setPreferredSize(tamano);
    }

    public String getNombre(){
        return nombreBoton;
    }
    
    public ImageIcon getImg(){
        return img;
    }
    
    public void setClick(boolean valor){
        click = valor;
    }
    
    public boolean getClick(){
        return click;
    }
}
