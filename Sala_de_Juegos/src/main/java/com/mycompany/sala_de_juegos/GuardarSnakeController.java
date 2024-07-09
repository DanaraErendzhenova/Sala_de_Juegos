/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Mañanas
 */
public class GuardarSnakeController {
    
    String line;
    File file =new File ("mejoresResultados.txt");
    
    
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
    void set_text(ActionEvent event) throws FileNotFoundException {
     String entrada=text_introducido.getText().trim();
     PrintWriter pw=new PrintWriter (file);
     pw.println(entrada);
    }

   @FXML
    private void volver() throws IOException {
    App.setRoot("start");
    }

    @FXML
    void initialize() {
        BufferedReader br=null;
      try{
          
          if(!file.exists()){
          file.createNewFile();
          
          PrintWriter pw=new PrintWriter (file);
          pw.println("Los mejores en Snake son:");
          
          br = new BufferedReader (new FileReader ("mejoresResultados.txt"));
          while ((line=br.readLine()) != null){
          System.out.print(line);}
          }
      }catch (IOException e){
      System.out.print("Error:" + e);
  }
      }  

    }


