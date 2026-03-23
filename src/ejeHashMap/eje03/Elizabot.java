package ejeHashMap.eje03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Elizabot extends JFrame {
    private JTextArea areaChat;
    private JTextField campoEntrada;
    private HashMap<String, String> respuestas;

    public Elizabot() {
        // 1. Configuración de la Ventana
        setTitle("ELIZA Chatbot - Terapia Java");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 2. Inicializar Diccionario de Respuestas
        inicializarRespuestas();

        // 3. Componentes Visuales
        areaChat = new JTextArea();
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setWrapStyleWord(true);
        areaChat.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaChat.setBackground(new Color(245, 245, 245));
        
        JScrollPane scrollPane = new JScrollPane(areaChat);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());
        campoEntrada = new JTextField();
        JButton botonEnviar = new JButton("Enviar");

        panelInferior.add(campoEntrada, BorderLayout.CENTER);
        panelInferior.add(botonEnviar, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);

        // Mensaje de Bienvenida
        areaChat.append("ELIZA: Hola, soy tu terapeuta virtual. ¿En qué puedo ayudarte hoy?\n");

        // 4. Lógica de Eventos
        ActionListener accionEnviar = e -> procesarEntrada();
        botonEnviar.addActionListener(accionEnviar);
        campoEntrada.addActionListener(accionEnviar); // Permite enviar con 'Enter'

        setLocationRelativeTo(null); // Centrar ventana
    }

    private void inicializarRespuestas() {
        respuestas = new HashMap<>();
        // Saludos y Despedidas
        respuestas.put("hola", "Hola, soy ELIZA. ¿En qué puedo ayudarte hoy?");
        respuestas.put("buenos", "Hola. Espero que estés teniendo un buen día. ¿Qué te trae por aquí?");
        respuestas.put("adiós", "Ha sido un placer hablar contigo. ¡Cuídate mucho!");
        respuestas.put("gracias", "No hay de qué. Estoy aquí para escucharte.");
        
        // Emociones y Relaciones
        respuestas.put("madre", "¿Qué sentimientos afloran cuando piensas en tu madre?");
        respuestas.put("padre", "¿Cómo describirías la relación con tu padre?");
        respuestas.put("triste", "¿Por qué te sientes así en este momento?");
        respuestas.put("feliz", "Me alegra saberlo. ¿Qué crees que es lo que más te hace feliz hoy?");
        respuestas.put("miedo", "El miedo es natural. ¿A qué le temes exactamente?");
        respuestas.put("amor", "El amor es complejo. ¿Qué significa para ti en este momento?");
        
        // Análisis de palabras comunes
        respuestas.put("siempre", "¿Puedes pensar en algún ejemplo específico donde no sea así?");
        respuestas.put("nunca", "A veces las cosas cambian. ¿Por qué sientes que es algo definitivo?");
        respuestas.put("familia", "Háblame más de tu familia.");
        respuestas.put("problema", "Si pudieras solucionar ese problema, ¿qué harías?");
        respuestas.put("sueño", "¿Sueles tener ese tipo de sueños a menudo?");
        respuestas.put("trabajo", "¿Sientes que tu trabajo define quién eres realmente?");
        respuestas.put("amigo", "Háblame más sobre esa amistad. ¿Es alguien en quien confías?");
    }

    private void procesarEntrada() {
        String textoUsuario = campoEntrada.getText().trim();
        if (textoUsuario.isEmpty()) return;

        areaChat.append("Tú: " + textoUsuario + "\n");
        campoEntrada.setText("");

        // Lógica de búsqueda de ELIZA
        String respuestaBot = "Cuéntame más sobre eso..."; // Respuesta por defecto
        String inputLimpio = textoUsuario.toLowerCase();

        for (Map.Entry<String, String> entrada : respuestas.entrySet()) {
            if (inputLimpio.contains(entrada.getKey())) {
                respuestaBot = entrada.getValue();
                break; // Detener en la primera coincidencia
            }
        }

        areaChat.append("ELIZA: " + respuestaBot + "\n\n");
        
        // Si el usuario se despide, podríamos cerrar tras un delay, pero por ahora solo saludamos
        if (inputLimpio.contains("adiós") || inputLimpio.contains("salir")) {
            campoEntrada.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Elizabot().setVisible(true);
        });
    }
}