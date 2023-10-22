package memoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Memoria {
    
    static Ventana disenoVentanaJuego(Panel panelTablero, Panel panelIzquierda, Panel panelDerecha, Label turno, Label versus, Boton salir, Boton manual, Boton sonidos, Boton musica){
        Ventana ventanaPrincipal = new Ventana("Memoria", new Color(0x6E3700), new ImageIcon("imgsMc\\mesa.png"), new Dimension(1000,600), 20);
        
        Panel panelSuperior = new Panel(new Dimension(70,70), new Color(0x6E3700));
        Panel panelInferior = new Panel(new Dimension(70,70), new Color(0x6E3700));
        Panel panelCentro = new Panel(new ImageIcon("imgsMc\\inventario.png"), new Dimension(0,0), new Color(0x6E3700), new GridBagLayout());
        
        Panel panelMarcador = new Panel(new Dimension(0,0), new Color(0x6E3700), true, BorderFactory.createLineBorder(new Color(0x3D1F00), 10, true), new BorderLayout());
        Panel panelLogo = new Panel(new Dimension(250,250), new Color(0x6E3700));
        Panel panelFinalizar = new Panel(new Dimension(250,250), new Color(0x6E3700));
        
        Panel panelTurnos = new Panel(new Dimension(0,0), new Color(0x6E3700), true, BorderFactory.createLineBorder(new Color(0x3D1F00), 10, true), new BorderLayout());
        Panel panelManual = new Panel(new Dimension(175,175), new Color(0x6E3700));
        Panel panelSonido = new Panel(new Dimension(175,175), new Color(0x6E3700), new FlowLayout(FlowLayout.CENTER,10,0));
        
        Label j1Puntos = new Label("STEVE", new Color(0xA86E34), new Color(0X000099), new Dimension(150,50), new ImageIcon("imgsMc\\steve.png"));
        Label j2Puntos = new Label("ALEX", new Color(0xA86E34), new Color(0X990000), new Dimension(150,50), new ImageIcon("imgsMc\\alex.png"));
        
        Label logo = new Label(new ImageIcon("imgsMc\\logo.png"), new Color(0x6E3700), new Dimension(100,100));
        
        panelCentro.add(panelTablero, new GridBagConstraints());
        panelTurnos.add(turno);
        turno.setHorizontalAlignment(Label.CENTER);
        turno.setFont(new Font("MS Gothic", Font.BOLD, 30));
        
        panelLogo.add(logo, BorderLayout.CENTER);
        logo.setHorizontalAlignment(Label.CENTER);
        logo.setFont(new Font("MS Gothic", Font.PLAIN, 40));
        
        panelFinalizar.add(salir);
        panelManual.add(manual);
        panelSonido.add(sonidos);
        panelSonido.add(musica);
        
        panelMarcador.add(j1Puntos, BorderLayout.WEST);
        j1Puntos.setHorizontalTextPosition(Label.RIGHT);
        j1Puntos.setHorizontalAlignment(Label.LEFT);
        j1Puntos.setFont(new Font("MS Gothic", Font.BOLD, 30));
        panelMarcador.add(j2Puntos, BorderLayout.EAST);
        j2Puntos.setHorizontalTextPosition(Label.LEFT);
        j2Puntos.setHorizontalAlignment(Label.RIGHT);
        j2Puntos.setFont(new Font("MS Gothic", Font.BOLD, 30));
        panelMarcador.add(versus, BorderLayout.CENTER);
        versus.setHorizontalAlignment(Label.CENTER);
        versus.setFont(new Font("MS Gothic", Font.BOLD  , 30));
        
        panelSuperior.add(panelMarcador, BorderLayout.CENTER);
        panelSuperior.add(panelLogo, BorderLayout.WEST);
        panelSuperior.add(panelFinalizar, BorderLayout.EAST);
        
        panelInferior.add(panelTurnos, BorderLayout.CENTER);
        panelInferior.add(panelManual, BorderLayout.WEST);
        panelInferior.add(panelSonido, BorderLayout.EAST);
        
        ventanaPrincipal.add(panelSuperior, BorderLayout.NORTH);
        ventanaPrincipal.add(panelInferior, BorderLayout.SOUTH);
        ventanaPrincipal.add(panelIzquierda, BorderLayout.WEST);
        ventanaPrincipal.add(panelDerecha, BorderLayout.EAST);
        ventanaPrincipal.add(panelCentro, BorderLayout.CENTER);
        
        return ventanaPrincipal;
    } 
    
    static void funcionesBotones(Boton jugar, Boton manualInicio, Boton salirInicio, Boton manual, Boton jugarManual, Boton salir, Boton salirFinal, Ventana ventanaJuego, Ventana2 ventanaInicio, Ventana3 ventanaManual){
        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaJuego.setVisible(true);
                ventanaManual.setVisible(false);
                ventanaInicio.setVisible(false);
            }
        });
        manualInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaJuego.setVisible(false);
                ventanaManual.setVisible(true);
                ventanaInicio.setVisible(false);
            }
        });
        salirInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        manual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaManual.setVisible(true);
                ventanaJuego.setVisible(false);
                ventanaInicio.setVisible(false);
            }
        });
        jugarManual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaManual.setVisible(false);
                ventanaJuego.setVisible(true);
                ventanaInicio.setVisible(false);
            }
        });
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        salirFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    static void definirPrimerJugador(Cola colaJugadores, Jugador jugador1, Jugador jugador2){
        Random primerTurno = new Random();
        int primerJugador = primerTurno.nextInt(2);
        
        if (primerJugador == 0){
            colaJugadores.encolar(jugador1);
            colaJugadores.encolar(jugador2);
        }
        else {
            colaJugadores.encolar(jugador2);
            colaJugadores.encolar(jugador1);
        }
        
    }

    static void llenarTablerorConBotones(BotonCarta[] botonesTablero, ImageIcon espacioVacio, Panel panelTablero){
        for (int i = 0; i < 24; i++) {
            botonesTablero[i] = new BotonCarta(espacioVacio, new Color(0x111111), new Dimension(80,80));
            panelTablero.add(botonesTablero[i]);
        }
        
    }

    static void asignarLabelsParejasJugador(LabelCarta[] LabelsParejasJ1, LabelCarta[] LabelsParejasJ2, Panel parejasJ1, Panel parejasJ2){
        for (int i = 0; i < 7; i++) {
            LabelsParejasJ1[i] =new LabelCarta(new Color(139,139,139), new Dimension(72,56));
            LabelsParejasJ2[i] =new LabelCarta(new Color(139,139,139), new Dimension(72,56));
            parejasJ1.add(LabelsParejasJ1[i]);
            parejasJ2.add(LabelsParejasJ2[i]);
        }
    }

    static void llenarPilaCartas(Pila pilaCartas){
        pilaCartas.agregarPar(new Carta(1, new ImageIcon("iconos\\wither.png"), 1));
        pilaCartas.agregar(new Carta(1, new ImageIcon("iconos\\wither.png"), 1));
        pilaCartas.agregarPar(new Carta(2, new ImageIcon("iconos\\huevo.png"), 1.5));
        pilaCartas.agregarPar(new Carta(3, new ImageIcon("iconos\\ojo.png"), 1));
        pilaCartas.agregarPar(new Carta(4, new ImageIcon("iconos\\carne.png"), -1));
        pilaCartas.agregarPar(new Carta(5, new ImageIcon("iconos\\manzana.png"), 1));
        pilaCartas.agregarPar(new Carta(6, new ImageIcon("iconos\\creeper.png"), 1));
        pilaCartas.agregarPar(new Carta(7, new ImageIcon("iconos\\diamante.png"), 1.5));
        pilaCartas.agregarPar(new Carta(8, new ImageIcon("iconos\\mesa.png"), 1));
        pilaCartas.agregarPar(new Carta(9, new ImageIcon("iconos\\espada.png"), 1));
        pilaCartas.agregarPar(new Carta(10, new ImageIcon("iconos\\hierro.png"), 1));
        pilaCartas.agregarPar(new Carta(11, new ImageIcon("iconos\\cama.png"), 1));
        
    }

    static void asignarCartasTablero(Pila pilaC, BotonCarta[] arregloBotones){
        Random r = new Random();
        
        for (int i = 0; i < 23; i++) {
            Carta aux = pilaC.sacarPrimera();
            int pos = r.nextInt(24);
            
            if (aux != null){
                while (arregloBotones[pos].numero != 0){
                    pos = r.nextInt(24);
                }
                
                arregloBotones[pos].img = aux.getImagen();
                arregloBotones[pos].setNumero(aux.getNumero());
                arregloBotones[pos].setPuntos(aux.getPuntos());
                
            }
        }
    }
    
    static boolean arregloCartasVacio(BotonCarta[] arregloBotones, boolean listaVacia){
        for (int i = 0; i < 24; i++) {
            if (arregloBotones[i].numero != 0 ){
                listaVacia = false;
                arregloBotones[i].setEnabled(true);
            }
            else if (arregloBotones[i].numero == 0){
                arregloBotones[i].setEnabled(false);
            }
        }
        return listaVacia;
    }
    
    static void deshabilitarCartasSiPuntua(BotonCarta[] arregloBotones, int primeraCarta) throws InterruptedException{
        for (int k = 0; k <= 23; k++) {
            if ((arregloBotones[k].numero != arregloBotones[primeraCarta].numero)) {
                arregloBotones[k].setEnabled(false);
            }
        }
        Thread.sleep(1000);
    }
    
    static void deshabilitarCartas(BotonCarta[] arregloBotones, int primeraCarta, int segundaCarta) throws InterruptedException{
        for (int k = 0; k <= 23; k++) {
            if (((arregloBotones[k].numero != arregloBotones[primeraCarta].numero) 
                    && (arregloBotones[k].numero != arregloBotones[segundaCarta].numero) 
                    || (( k != primeraCarta) && ( k != segundaCarta)))) {
                
                arregloBotones[k].setEnabled(false);
            }
        }
        Thread.sleep(1000);
    }
    
    static void deshabilitarCartasConWither(BotonCarta[] arregloBotones, int primeraCarta, int segundaCarta, int terceraCarta) throws InterruptedException{
        for (int k = 0; k <= 23; k++) {
            if (((arregloBotones[k].numero != arregloBotones[primeraCarta].numero) 
                    && (arregloBotones[k].numero != arregloBotones[segundaCarta].numero) 
                        || (( k != primeraCarta) && ( k != segundaCarta) && ( k != terceraCarta)))) {
                arregloBotones[k].setEnabled(false);
            }
        }
        Thread.sleep(1000);
    }
    
    static void voltearCartas(BotonCarta[] arregloBoton, int primeraCarta, int segundaCarta){
        arregloBoton[primeraCarta].setClick(false);
        arregloBoton[segundaCarta].setClick(false);
    }
    
    static void eliminarCartaDeTablero(Jugador jugadorActual, BotonCarta[] arregloBotones, LabelCarta[] arregloLabels, int primeraCarta, int segundaCarta, boolean manzanaOro){
        for (int i = 0; i < 7; i++) {
            if (arregloLabels[i].getNumero() == 0){
                arregloLabels[i].setNumero(arregloBotones[primeraCarta].numero);
                arregloLabels[i].setIcon(arregloBotones[primeraCarta].img);
                arregloLabels[i].setIcon(arregloBotones[primeraCarta].img);
                if ((manzanaOro) && (arregloBotones[primeraCarta].numero == 4)) {
                    break;
                }
                else{
                    jugadorActual.sumarPuntosPareja(arregloBotones[primeraCarta].puntos);
                    break;
                }
            }
        }
        arregloBotones[primeraCarta].setNumero(0);
        arregloBotones[segundaCarta].setNumero(0);
    }
    
    static void eliminarWitherDeTablero(Jugador jugadorActual, BotonCarta[] arregloBotones, LabelCarta[] arregloLabels, int primeraCarta, int segundaCarta, int terceraCarta){
        for (int i = 0; i < 7; i++) {
            if (arregloLabels[i].getNumero() == 0){
                arregloLabels[i].setNumero(arregloBotones[primeraCarta].numero);
                arregloLabels[i].setIcon(arregloBotones[primeraCarta].img);
                jugadorActual.sumarPuntosTrio(arregloBotones[primeraCarta].puntos);
                break;
            }
        }
        
        arregloBotones[primeraCarta].setNumero(0);
        arregloBotones[segundaCarta].setNumero(0);
        arregloBotones[terceraCarta].setNumero(0);
    }
    
    static void terceraCabezaWither(BotonCarta[] arregloBotones, LabelCarta[] arregloLabel, int primeraCarta, int segundaCarta, int terceraCarta, Cola colaJugadores){
        eliminarWitherDeTablero(colaJugadores.getPrimero(), arregloBotones, arregloLabel, primeraCarta, segundaCarta, terceraCarta);
        voltearCartas(arregloBotones, primeraCarta, segundaCarta);
        arregloBotones[terceraCarta].setClick(false);
    }
    
    static void parejaEncontrada(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores, boolean manzanaOro) throws InterruptedException{
        deshabilitarCartasSiPuntua(botonesTablero, primerIterador);
        eliminarCartaDeTablero(colaJugadores.getPrimero(), botonesTablero, colaJugadores.getPrimero().getArreglo(), primerIterador, segundoIterador, manzanaOro);
        voltearCartas(botonesTablero, primerIterador, segundoIterador);
        colaJugadores.getPrimero().sumarPareja();
    }
    
    static void parejaNoEncontrada(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        deshabilitarCartas(botonesTablero, primerIterador, segundoIterador);
        voltearCartas(botonesTablero, primerIterador, segundoIterador);
        colaJugadores.getPrimero().sumarTurno();
        colaJugadores.encolar(colaJugadores.desencolar());
    }
    
    static void tercerWitherEncontrado(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, int tercerIterador, Cola colaJugadores) throws InterruptedException{
        deshabilitarCartasSiPuntua(botonesTablero, primerIterador);
        terceraCabezaWither(botonesTablero, colaJugadores.getPrimero().getArreglo(), primerIterador, segundoIterador, tercerIterador, colaJugadores);
        colaJugadores.getPrimero().sumarPareja();
    }
    
    static void tercerWitherNoEncontrado(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, int tercerIterador, Cola colaJugadores) throws InterruptedException{
        deshabilitarCartasConWither(botonesTablero, primerIterador, segundoIterador, tercerIterador);
        voltearCartas(botonesTablero, primerIterador, segundoIterador);
        botonesTablero[tercerIterador].setClick(false);
        colaJugadores.getPrimero().sumarTurno();
        colaJugadores.encolar(colaJugadores.desencolar());
    }
    
    static void buscarUltimoWither(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, int tercerIterador, Cola colaJugadores) throws InterruptedException{
        if (((botonesTablero[tercerIterador].numero == 1) && (botonesTablero[tercerIterador].click)) && (tercerIterador!=primerIterador)) {
            tercerWitherEncontrado(botonesTablero, primerIterador, segundoIterador, tercerIterador, colaJugadores);
            colaJugadores.getPrimero().setCartasPorVoltear(0);
        }
        else if ((botonesTablero[tercerIterador].numero != 1) && (botonesTablero[tercerIterador].click)) {
            tercerWitherNoEncontrado(botonesTablero, primerIterador, segundoIterador, tercerIterador, colaJugadores);
            colaJugadores.getPrimero().setCartasPorVoltear(0); 
        }
    }
    
    static void segundoWitherEncontrado(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        while (colaJugadores.getPrimero().getCartasPorVoltear() != 0) {
            for (int k = segundoIterador+1; k <= 23; k++) {
                buscarUltimoWither(botonesTablero, primerIterador, segundoIterador, k, colaJugadores);
            }
            for (int k = segundoIterador-1; k >= 0; k--) {
                buscarUltimoWither(botonesTablero, primerIterador, segundoIterador, k, colaJugadores);
            }
        }
    }
    
    static void ojosEnderEncontrados(BotonCarta[] botonesTablero) throws InterruptedException{
        for (int i = 0; i < 23; i++) {
            if (botonesTablero[i].numero == 2){
                botonesTablero[i].setClick(true);
                Thread.sleep(1000);
                botonesTablero[i].setClick(false);
                break;
            }
        }
    }
    
    static void carnePodrida(LabelCarta[] parejasJugador, BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException{
        for (int i = 0; i < 11; i++) {
            if (parejasJugador[i].getNumero() == 5){
                parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, true);
                break;
            }
            else{
                parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, false);
                break;
            }
        }
    }
    
    static void buscarSegundaCarta(BotonCarta[] botonesTablero, int primerIterador, int segundoIterador, Cola colaJugadores) throws InterruptedException, IOException, IOException, IOException{
        if ((botonesTablero[primerIterador].numero == botonesTablero[segundoIterador].numero) && (botonesTablero[segundoIterador].click)){
            switch(botonesTablero[primerIterador].numero){
                case 1:{
                    colaJugadores.getPrimero().setCartasPorVoltear(1);
                    segundoWitherEncontrado(botonesTablero, primerIterador, segundoIterador, colaJugadores);
                    break;
                }
                case 3:{
                    ojosEnderEncontrados(botonesTablero);
                    parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, false);
                    break;
                }
                case 4:{
                    carnePodrida(colaJugadores.getPrimero().getArreglo(), botonesTablero, primerIterador, segundoIterador, colaJugadores);
                    break;
                }
                default:{
                    parejaEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores, false);
                    break;
                }
            }
        }
        else if ((botonesTablero[primerIterador].numero != botonesTablero[segundoIterador].numero) && botonesTablero[segundoIterador].click){
            colaJugadores.getPrimero().setCartasPorVoltear(0);
            parejaNoEncontrada(botonesTablero, primerIterador, segundoIterador, colaJugadores);
        }
    }
    
    static void registroDeVictorias(Cola colaJugadores) throws IOException{
        File archivoGanadores = new File("Ganadores.txt");
        String saltoLinea = System.lineSeparator();
        
        if (!archivoGanadores.exists()) {
            FileWriter escritor = new FileWriter("Ganadores.txt");
            escritor.write("Registros de Duelos" + saltoLinea + "Registros con todos los duelos de memoria entre Steve y Alex" + saltoLinea + saltoLinea);
            escritor.close();
        }
        if (archivoGanadores.exists()){
            FileReader lector = new FileReader("Ganadores.txt");
            FileWriter temp = new FileWriter("temp.txt");
            
            int dato = lector.read();
            while (dato != -1){
                temp.write((char)dato);
                dato = lector.read();
            }
            
            temp.append(saltoLinea + colaJugadores.getPrimero().getNombre() + " gana a " + colaJugadores.getUltimo().getNombre());
            temp.append(saltoLinea + "Consiguió " + colaJugadores.getPrimero().getPuntos() + " puntos.");
            temp.append(saltoLinea + "Con " + colaJugadores.getPrimero().getParejas() + " cartas.");
            temp.append(saltoLinea + "En " + colaJugadores.getPrimero().getTurnos() + " turnos." + saltoLinea);
            temp.close();
            lector.close();
            
            FileWriter escritor = new FileWriter("Ganadores.txt");
            FileReader lectorTemp = new FileReader("temp.txt");
            dato = lectorTemp.read();
            while (dato != -1){
                escritor.write((char)dato);
                dato = lectorTemp.read();
            }
            escritor.close();
            lectorTemp.close();
            File archivoTemp = new File("temp.txt");
            archivoTemp.delete();
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        
            boolean tableroVacio;
            Pila pilaCartas = new Pila();
            Cola colaJugadores = new Cola();
            ImageIcon espacioVacio = new ImageIcon("iconos\\cartaVacia.png");

            Panel panelTablero = new Panel(new Dimension(510,330), new Color(0x111111), false, new GridLayout(4,6));
            Panel panelJ1Cartas = new Panel(new Dimension(100,100), new Color(139,139,139), true, BorderFactory.createLineBorder(new Color(0x3D1F00), 10, false), new FlowLayout(5));
            Panel panelJ2Cartas = new Panel(new Dimension(100,100), new Color(139,139,139), true, BorderFactory.createLineBorder(new Color(0x3D1F00), 10, false), new FlowLayout(5));

            Label turno = new Label(" ", new Color(0xA86E34), new Color(0xffffff), new Dimension(50,50));
            Label versus = new Label(" ", new Color(0xA86E34), new Color(0xffffff), new Dimension(50,50));

            Boton salir = new Boton("salir", new ImageIcon("imgsMc\\quit.jpg"));
            Boton manual = new Boton("manual", new ImageIcon("imgsMc\\manual.png"));
            Boton sonidos = new Boton("sonidos", new ImageIcon("imgsMc\\sonidos.png"), new Dimension(62,62));
            Boton musica = new Boton("musica", new ImageIcon("imgsMc\\musica.png"), new Dimension(62,62));

            Boton jugar = new Boton("jugar", new ImageIcon("imgsMc\\botonJugar.png"));
            Boton salirInicio = new Boton("salir", new ImageIcon("imgsMc\\quit2.png"));
            Boton manualInicio = new Boton("manual", new ImageIcon("imgsMc\\manual2.png"));

            Boton jugarManual = new Boton("jugarManual", new ImageIcon("imgsMc\\botonJugarManual.png"));
            
            Boton salirFinal = new Boton("salirFinal", new ImageIcon("imgsMc\\quit.jpg"));

            BotonCarta botonesTablero[] = new BotonCarta[24];
            LabelCarta LabelsParejasJ1[] = new LabelCarta[11];
            LabelCarta LabelsParejasJ2[] = new LabelCarta[11];

            Jugador jugador1 = new Jugador("Steve", new Color(0,0,255), 0, LabelsParejasJ1);
            Jugador jugador2 = new Jugador("Alex", new Color(255,0,0), 0, LabelsParejasJ2);

            definirPrimerJugador(colaJugadores, jugador1, jugador2);
            llenarTablerorConBotones(botonesTablero, espacioVacio, panelTablero);
            asignarLabelsParejasJugador(LabelsParejasJ1, LabelsParejasJ2, panelJ1Cartas, panelJ2Cartas);

            llenarPilaCartas(pilaCartas);
            asignarCartasTablero(pilaCartas, botonesTablero);
            Ventana ventanaJuego = disenoVentanaJuego(panelTablero, panelJ1Cartas, panelJ2Cartas, turno, versus, salir, manual, sonidos, musica);
            Ventana2 ventanaInicio = new Ventana2(jugar, salirInicio, manualInicio);
            Ventana3 ventanaManual = new Ventana3(jugarManual);

            ventanaInicio.setVisible(true);
            funcionesBotones(jugar, manualInicio, salirInicio, manual, jugarManual, salir, salirFinal, ventanaJuego, ventanaInicio, ventanaManual);
            
            do {
                turno.setText("Turno de " + colaJugadores.getPrimero().getNombre());
                versus.setText(String.valueOf((int)jugador1.getPuntos()) + " vs " + String.valueOf((int)jugador2.getPuntos()));
                tableroVacio = true;
                tableroVacio = arregloCartasVacio(botonesTablero, tableroVacio);

                for (int i = 0; i < 23; i++) {
                    if (botonesTablero[i].click){
                        for (int j = i+1; j <= 23; j++) {
                            buscarSegundaCarta(botonesTablero, i, j, colaJugadores);
                        }
                        for (int j = i-1; j >= 0; j--) {
                            buscarSegundaCarta(botonesTablero, i, j, colaJugadores);
                        }
                    }
                }
            } while ((!tableroVacio) && ((colaJugadores.getPrimero().getPuntos() < 12.5) && (colaJugadores.getUltimo().getPuntos() < 12.5)));
            for (int i = 0; i < 24; i++) {
                botonesTablero[i].setEnabled(false);
            }
            if (colaJugadores.getPrimero().getPuntos() < 11) {
                colaJugadores.encolar(colaJugadores.desencolar());
            }
            registroDeVictorias(colaJugadores);
            String texto = "Ganador: "+colaJugadores.getPrimero().getNombre();
            String texto1 = "Turnos: "+String.valueOf(colaJugadores.getPrimero().getTurnos());
            String texto2 = "Puntos: "+String.valueOf((int)colaJugadores.getPrimero().getPuntos());
            
            
            Ventana4 ventanaFinal = new Ventana4(salirFinal,texto, texto1, texto2);
            
            ventanaFinal.setVisible(true);
            ventanaJuego.setVisible(false);
            ventanaInicio.setVisible(false);
            ventanaManual.setVisible(false);
           
    }
}
