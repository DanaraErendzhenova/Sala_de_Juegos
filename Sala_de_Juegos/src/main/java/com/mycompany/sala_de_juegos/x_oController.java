/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;



import java.io.IOException;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Mañanas
 */
public class x_oController {
    int contador = 0;
    char currentSymbol;
    private char campo [][] = new char [3] [3];
    private boolean en_juego =true;
    
    @FXML
    private Button button_volver;
    
     @FXML
    private Button button_de_nuevo;
    
    @FXML
    private void volver() throws IOException {
    App.setRoot("start");
    }
    
     @FXML
    void de_nuevo(ActionEvent event) throws IOException {
    App.setRoot("x_o");
    }
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void click(ActionEvent event) {
        Button btn =((Button)event.getSource()); 
        if (!en_juego||btn.getText()!="") return;
        
        contador ++;
        if (contador%2 ==0){
        currentSymbol = 'O';
        }else {currentSymbol = 'X';}
        
        
        
        btn.setText(String.valueOf(currentSymbol));
        
        int linea_index = GridPane.getRowIndex(btn)== null? 0:GridPane.getRowIndex(btn);
        int columna_index = GridPane.getColumnIndex(btn)== null? 0:GridPane.getColumnIndex(btn);
        System.out.println("linea" + linea_index);
        System.out.println("columna" + columna_index);
        
        campo [linea_index][columna_index] = currentSymbol;
        
        if (campo[0][0]==campo[0][1] && campo[0][0]==campo[0][2]&& (campo[0][0]=='X'|| campo[0][0]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}
        if (campo[1][0]==campo[1][1] && campo[1][0]==campo[1][2]&& (campo[1][0]=='X'|| campo[1][0]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait(); 
            en_juego=false;}
        if (campo[2][0]==campo[2][1] && campo[2][0]==campo[2][2]&& (campo[2][0]=='X'|| campo[2][0]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}
        if (campo[0][0]==campo[1][0] && campo[0][0]==campo[2][0]&& (campo[0][0]=='X'|| campo[0][0]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}
        if (campo[0][1]==campo[1][1] && campo[0][1]==campo[2][1]&& (campo[0][1]=='X'|| campo[0][1]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}
        if (campo[0][2]==campo[1][2] && campo[0][2]==campo[2][2]&& (campo[0][2]=='X'|| campo[0][2]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}
        if (campo[0][0]==campo[1][1] && campo[0][0]==campo[2][2]&& (campo[0][0]=='X'|| campo[0][0]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}
        if (campo[0][2]==campo[1][1] && campo[0][2]==campo[2][0]&& (campo[0][2]=='X'|| campo[0][2]=='O')){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ha ganado " + btn.getText() + "!", ButtonType.OK);
            alert.showAndWait();
            en_juego=false;}

    }

    @FXML
    void initialize() {
          Alert alert = new Alert(Alert.AlertType.INFORMATION, "Este es el clásico juego de 3 en línea:\n\n" +

"\n- Turnos:\n" +
"En cada turno, el jugador coloca su símbolo \n"
                  + "en una casilla vacía del tablero.\n" +
"\n- Colocación de símbolos:\n" +
"Los jugadores se turnan colocando sus símbolos\n"
                  + " en las casillas del tablero.\n" +
"Solo se puede colocar un símbolo por casilla \n"
                  + "y no se puede colocar en una casilla ya ocupada.\n" +
"\n- Línea ganadora:\n" +
"El primer jugador que coloque tres de sus símbolos \n"
                  + "en línea recta (horizontal, vertical o diagonal) gana la partida." , ButtonType.OK);
            alert.showAndWait(); 
     

    }

  
    
}
