package ejeArrayList.eje01;

import javax.swing.*;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class VentanaCarrera extends JFrame {
    private ArrayList<Coche> coches;
    private final int META = 800; // Píxeles para llegar a la meta
    private boolean carreraTerminada = false;
    private Timer timer;

    public VentanaCarrera() {
        setTitle("Simulación de Carrera de Coches");
        setSize(META+100, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializamos los coches con colores distintos
        coches = new ArrayList <Coche>();
        coches.add (new Coche("Ferrari", 300));
        coches.add (new Coche("600", 100));
        coches.add( new Coche("BMW", 220));
        coches.add( new Coche("Seat", 150));
        coches.add( new Coche("La Cabra", 10));
        
     // Test de pruebas para comprobar la detección de errores
    	
    		Coche c1 = coches.get(0);
    		Coche c2 = coches.get(1);
    		c1.acelera(10);
    		c2.frena(20);
    		c1.parar();
    		c2.recorre();
        
     // Arranquen los motores
     	for( Coche c:coches){
     			c.arrancar();
     	}

        // Panel de dibujo personalizado
        JPanel panelCarrera = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarCarrera(g);
            }
        };
        panelCarrera.setBackground(new Color(50, 50, 50)); // Asfalto
        add(panelCarrera);

        // Timer para la animación (cada 100ms refresca la pantalla)
        Random valor = new Random();
        timer = new Timer(50, e -> {
            if (!carreraTerminada) {
                for (Coche c : coches) {
                	c.acelera(valor.nextInt(30));
    				c.recorre();
    				c.frena(valor.nextInt(10));
                	
                    if (c.getKilometros() >= META) {
                        carreraTerminada = true;
                        timer.stop();
                        mostrarGanador(c.info());
                    }
                }
                repaint(); // Redibuja la escena
            } else {
            	// Reinicia la carrera
            	carreraTerminada = false;
            	for (Coche c : coches) {
            	   c.frena(1000);// Frena a tope
                   c.parar(); 
                   c.arrancar();  
                }
            }	
        });

        // Botón para iniciar
        JButton btnStart = new JButton("¡EMPEZAR CARRERA!");
        btnStart.addActionListener(e -> timer.start());
        add(btnStart, BorderLayout.SOUTH);
    }

    private void dibujarCarrera(Graphics g) {
        int y = 50;
        for (Coche c : coches) {
            // Dibujar carril
            g.setColor(Color.GRAY);
            g.drawLine(50, y + 25, META, y + 25);
            
            // Dibujar Meta
            g.setColor(Color.WHITE);
            g.fillRect(META, y, 5, 30);

            // Dibujar el "Coche" (un rectángulo con nombre)
            g.setColor(Color.RED);
            int xPos = 50 + c.getKilometros();
            g.fillRect(xPos, y, 40, 20);
            
            g.setColor(Color.LIGHT_GRAY);
            g.drawString(c.getModelo(), 50, y - 5);
            
            y += 70; // Espacio entre coches
        }
    }

    private void mostrarGanador(String nombre) {
        JOptionPane.showMessageDialog(this, "¡El ganador es: " + nombre + "!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaCarrera().setVisible(true);
        });
    }
}