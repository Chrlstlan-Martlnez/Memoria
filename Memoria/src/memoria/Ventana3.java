package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana3 extends JFrame{
    
    Ventana3(Boton jugar){
        this.setTitle("Memoria");
        this.getContentPane().setBackground(new Color(0x6E3700));
        this.setIconImage(new ImageIcon("imgsMc\\mesa.png").getImage());
        this.setMinimumSize(new Dimension(1000,600));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20,20));
        
        Panel panelCentro = new Panel(new ImageIcon("imgsMc\\manual.gif"), new Dimension(1000,600), new Color(0x6E3700), null);

        jugar.setBounds(800, 10, 175, 50);

        panelCentro.add(jugar);

        add(panelCentro);
    }
}


