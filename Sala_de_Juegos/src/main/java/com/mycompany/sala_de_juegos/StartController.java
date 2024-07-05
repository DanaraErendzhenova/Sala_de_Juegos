/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;

import java.io.IOException;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Mañanas
 */
public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button button_switchToNUMEROS;

    @FXML
    private Button button_switchToPIANO;

    @FXML
    private Button button_switchToSERPIENTE;

    @FXML
    private Button button_switchToX_O;
    
    
    
    

    @FXML
    private void switchToNUMEROS() throws IOException {
        App.setRoot("numeros");
    }

    @FXML
    private void switchToPIANO() throws IOException {
        App.setRoot("piano");
    }

    @FXML
    private void switchToSERPIENTE() throws IOException {
        App.setRoot("serpiente");
    }

    @FXML
    private void switchToX_O() throws IOException {
        App.setRoot("x_o");
    }

}
