package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana4 extends JFrame{
    
    Ventana4(Boton salir, String texto, String texto1, String texto2){
        this.setTitle("Memoria");
        this.getContentPane().setBackground(new Color(0x6E3700));
        this.setIconImage(new ImageIcon("imgsMc\\mesa.png").getImage());
        this.setMinimumSize(new Dimension(1000,600));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20,20));
        
        Panel panelCentro = new Panel(new ImageIcon("imgsMc\\final.png"), new Dimension(1000,600), new Color(0x6E3700), null);
        Label ganador = new Label(texto, new Color(0xA86E34), new Color(0X000000), new Dimension(150,50));
        Label ganador1 = new Label(texto1, new Color(0xA86E34), new Color(0X000000), new Dimension(150,50));
        Label ganador2 = new Label(texto2, new Color(0xA86E34), new Color(0X000000), new Dimension(150,50));
        ganador.setFont(new Font("MS Gothic", Font.BOLD, 30));
        ganador.setBounds(350, 235, 300, 50);
        ganador1.setFont(new Font("MS Gothic", Font.BOLD, 30));
        ganador1.setBounds(350, 285, 300, 50);
        ganador2.setFont(new Font("MS Gothic", Font.BOLD, 30));
        ganador2.setBounds(350, 335, 300, 50);
        salir.setBounds(400, 450, 175, 50);

        panelCentro.add(ganador);
        panelCentro.add(ganador2);
        panelCentro.add(ganador1);
        panelCentro.add(salir);

        add(panelCentro);
    }
}



