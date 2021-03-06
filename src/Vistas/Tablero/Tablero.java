package Vistas.Tablero;

import Vistas.CrearPartido.CrearPartido;
import Vistas.CrearPartido.FrameCrearPartido;
import Vistas.SubirDatos.FrameSubirDatos;
import Vistas.TablaPosiciones.FrameTablaPosiciones;
import Vistas.TablaPosiciones.TablaPosiciones;
import Vistas.VerJugadores.FrameVerJugadores;
import Vistas.VerJugadores.VerJugadores;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Tablero {
    
    public JPanel panel;
    public FrameVerJugadores verJugadoresFrame;
    public FrameSubirDatos subirDatosFrame;
    public JFrame tablaPosicionesFrame;
    public FrameCrearPartido crearPartido;
    FrameTablero frame;
    private JButton subirDatosPartidoButton;
    private JButton verJugadoresButton;
    private JButton TablaPosicionesButton;
    private JButton off;
    
    public Tablero() {
        try {
            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(ImageIO.read(getClass()
                    .getResource("../../Img/cursor.png")), new Point(panel.getX(),
                    panel.getY()), "img"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        off.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        verJugadoresButton.addActionListener(e -> {
            FrameTablero frame = (FrameTablero) SwingUtilities.getWindowAncestor(verJugadoresButton);
            verJugadoresFrame = new FrameVerJugadores("Ver jugadores | Mundial Russia 2018", frame.getEquipos());
            verJugadoresFrame.setContentPane(new VerJugadores().esp);
            verJugadoresFrame.pack();
            verJugadoresFrame.setIconImage(Toolkit.getDefaultToolkit().
                    getImage(Tablero.class.getResource("../../Img/ico.png")));
            verJugadoresFrame.setLocationRelativeTo(null);
            verJugadoresFrame.setVisible(true);
            verJugadoresFrame.setResizable(false);
            verJugadoresFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        });
        subirDatosPartidoButton.addActionListener(l -> {
            FrameTablero frame = (FrameTablero) SwingUtilities.getWindowAncestor(subirDatosPartidoButton);
            crearPartido = new FrameCrearPartido("Crear partido | Mundial Russia 2018", frame.getEquipos());
            crearPartido.setContentPane(new CrearPartido().panel);
            crearPartido.pack();
            crearPartido.setIconImage(Toolkit.getDefaultToolkit().
                    getImage(Tablero.class.getResource("../../Img/ico.png")));
            crearPartido.setLocationRelativeTo(null);
            crearPartido.setVisible(true);
            crearPartido.setResizable(false);
            crearPartido.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        });
        
        TablaPosicionesButton.addActionListener(e -> {
            frame = (FrameTablero) SwingUtilities.getWindowAncestor(TablaPosicionesButton);
            tablaPosicionesFrame = new FrameTablaPosiciones("Tabla de posiciones | Mundial Russia 2018", frame.getJuegos(), frame.getEquipos());
            tablaPosicionesFrame.setContentPane(new TablaPosiciones().panel);
            tablaPosicionesFrame.pack();
            tablaPosicionesFrame.setIconImage(Toolkit.getDefaultToolkit().
                    getImage(Tablero.class.getResource("../../Img/ico.png")));
            tablaPosicionesFrame.setLocationRelativeTo(null);
            tablaPosicionesFrame.setVisible(true);
            tablaPosicionesFrame.setResizable(false);
            tablaPosicionesFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        });
        
        
        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = (FrameTablero) SwingUtilities.getWindowAncestor(panel);
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }
    
    private void createUIComponents() {
        panel = new TableroPanel();
    }
    
}
