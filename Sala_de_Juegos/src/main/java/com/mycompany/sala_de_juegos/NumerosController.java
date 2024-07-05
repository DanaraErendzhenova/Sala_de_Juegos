
package com.mycompany.sala_de_juegos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import java.applet.* ;
import java.io.File;
import java.net.MalformedURLException;


public class NumerosController {
    
   //Declaramos las variables sonidos:
    private final String correcto = "C:\\Users\\Mañanas\\Documents\\NetBeansProjects\\AdivinaFX\\src\\main\\resources\\sonidos\\correct.wav";
    private final String error = "C:\\Users\\Mañanas\\Documents\\NetBeansProjects\\AdivinaFX\\src\\main\\resources\\sonidos\\error.wav";
    private final String hehe = "C:\\Users\\Mañanas\\Documents\\NetBeansProjects\\AdivinaFX\\src\\main\\resources\\sonidos\\hehemerindo.wav";
    private final String newgame = "C:\\Users\\Mañanas\\Documents\\NetBeansProjects\\AdivinaFX\\src\\main\\resources\\sonidos\\newgame.wav";
    private final String goodbye = "C:\\Users\\Mañanas\\Documents\\NetBeansProjects\\AdivinaFX\\src\\main\\resources\\sonidos\\goodbye.wav";
    
    

    //Creo ramdon para luego llamarlo en el int y crear un número aleatorio lo primero
    public final Random random = new Random();
    
    // Generar un número secreto entre 1 y 100
    int numeroSecreto = random.nextInt(100) +1; 
    int intentos = 0;

    
    @FXML
    private ResourceBundle resources;

    @FXML
    private Button button_comprobar;
    
    
    @FXML
    private URL location;

    @FXML
    private TextField numerointroducido;

    @FXML
    private Text pista;

    @FXML
    private Button button_rindo;
    
    @FXML
    private Button button_new;
    
    @FXML
    private Button button_volver;

    
    //Metodo que ejecuta audio mediante Applet
    
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
    
   
    //Aqui creo un método comprobar para poder evaluar el número que me dará el usuario 
    @FXML
    private void comprobar() throws IOException {
        
        

        
        /*previamente he creado int numeroSecreto = random.nextInt(100) +1;  que lo que hace es generar un número aleatorio 
        y meterlo en variable int numeroSecreto*/
        
        /*Luego tengo numerointroducido que es un TextField que es donde le pido al usuario que introduzca el número*/
        
        /*En lo siguiente lo que hago es meter el numerointroducido por el usuario en la variable tipo entero de número
        Y parseo lo que contiene en modo texto a entero y con el trim le quito los espacios*/
        
        
        intentos ++;
        
        try { int numero =   Integer.parseInt(numerointroducido.getText().trim()) ;
        
        //Aqui quiero que evalue que el número no es menor que 1 o mayor que 100 
        
        //Si se cumple la condicion de que el numero este entre 1 y 100 va hacer lo siguiente
        
        if(numero >= 1 && numero <= 100){
            
            
           
            if (numero == numeroSecreto) {
                
               
                pista.setText("WINNER!! Enhorabuena número correcto!! \nTras " + intentos + " intentos acertaste.");
                playSound(correcto);
            }
            
            else {
            
            
                if (numero < numeroSecreto) {
                    
                    playSound(error);
                    pista.setText("Tu número es MENOR que el secreto!! \nTu número de intentos es: \t" + intentos);
                    
                }
                
                else {
                    
                    playSound(error);
                    pista.setText("Tu número es MAYOR que el secreto!! \nTu número de intentos es: \t" + intentos);
                    
                }
                
                

            }
            
        }
        //Si no cumple hara esto
        //Pedir otro número 
        //Volver a empezar
        
        else {
            
        pista.setText("El número no es correcto!! Prueba otra vez");
        
        
        }
           
        
          
        }
        
        catch (NumberFormatException e) {
        // Manejo de la excepción si el usuario ingresa algo que no es un número
        playSound(error);
        pista.setText("ERROR: Me estas dando letras!! \nDale a nuevo juego y escribe un número válido comprendido entre 1 y 100!!");
            }
    }
    
    
       @FXML
    private void rindo() {
        playSound(hehe);
        pista.setText("El número secreto era: " + numeroSecreto);
    }
    
    
    
      @FXML
    private void nuevo() {
        playSound(newgame);
        pista.setText("Juego nuevo!!!");
        numerointroducido.setText("");
        intentos=0;
        numeroSecreto = random.nextInt(100) +1; 
        
    }

    @FXML
    private void volver() throws IOException {
    playSound(goodbye);
    App.setRoot("start");
    }
    
    
    
    
    
}
