package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana2 extends JFrame{
    
    Ventana2(Boton jugar, Boton salir, Boton manual){
        this.setTitle("Memoria");
        this.getContentPane().setBackground(new Color(0x6E3700));
        this.setIconImage(new ImageIcon("imgsMc\\mesa.png").getImage());
        this.setMinimumSize(new Dimension(1000,600));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20,20));
        
        Panel panelCentro = new Panel(new ImageIcon("imgsMc\\inicio.png"), new Dimension(1000,600), new Color(0x6E3700), null);

        jugar.setBounds(291, 250, 420, 55);
        salir.setBounds(503, 440, 210, 55);
        manual.setBounds(291, 440, 210, 55);

        panelCentro.add(jugar);
        panelCentro.add(salir);
        panelCentro.add(manual);

        add(panelCentro);
    }
}

