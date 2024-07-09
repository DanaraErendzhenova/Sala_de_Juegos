/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.applet.*;
import java.io.File;
import java.net.MalformedURLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GuardarSnakeController {

    String line;
    File file = new File("mejoresResultados.txt");

    private final String goodbye = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_numero\\goodbye.wav";

    @FXML
    private void playSound(String filePath) {
        try {
            File file = new File(filePath);
            String url = file.toURI().toURL().toString();
            AudioClip audioClip = Applet.newAudioClip(new java.net.URL(url));
            audioClip.play();
        } catch (MalformedURLException e) {
            System.out.println("Error al cargar el archivo de audio: " + e.getMessage());
        }
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea mejores_resultados;

    @FXML
    private Button set_text_button;

    @FXML
    private TextField text_introducido;

    @FXML
    void set_text(ActionEvent event) {
        String entrada = text_introducido.getText().trim();
        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            pw.println(entrada);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void volver() throws IOException {
        playSound(goodbye);
        App.setRoot("start");
    }

    @FXML
    void initialize() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            content.append("Los mejores en Snake son:\n");

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            mejores_resultados.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
