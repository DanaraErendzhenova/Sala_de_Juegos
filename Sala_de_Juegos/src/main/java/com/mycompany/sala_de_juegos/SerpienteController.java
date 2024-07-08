/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mañanas
 */
public class SerpienteController {
 
    private Game game;

    @FXML
    private Canvas canvas;
    @FXML
    private Text text;
    
    private Timeline timeline;
    
    
    @FXML
    private void exitAction(ActionEvent event) throws IOException {
        App.setRoot("start");
    }

    @FXML
    private void newAction(ActionEvent event) {
        game = new Game();
        repaint();
    }
    
    @FXML
    private void showColorPicker(ActionEvent event) {
        VBox box = new VBox();
        ColorPicker colorPicker = new ColorPicker();
        Button ok = new Button("Ok");
        
        box.getChildren().addAll(colorPicker, ok);
        Scene scene = new Scene(box);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ok.setOnMouseClicked((MouseEvent event1) -> {
            SnakePart.setColor(colorPicker.getValue());
            stage.close();
        });
        
    }
    @FXML
    private void keyHandler(KeyEvent e) {
        if (e.getCode() == KeyCode.RIGHT) {
            game.snake.setDirection(0);
        }
        else if(e.getCode() == KeyCode.UP) {
            game.snake.setDirection(1);
        }
        else if(e.getCode() == KeyCode.LEFT) {
            game.snake.setDirection(2);
        }
        else if(e.getCode() == KeyCode.DOWN) {
            game.snake.setDirection(3);
        }
    }
    @FXML

    public void repaint() {
        Duration duration = Duration.millis(250);
        timeline = new Timeline(new KeyFrame(duration, (ActionEvent event) -> {
            text.setText("Tu resultado es: "+String.valueOf(game.getScore()));
            GraphicsContext context = canvas.getGraphicsContext2D();
            if ( !game.isGameOver() ) {
                context.setFill(Color.AQUA);
                context.fillRect(0, 0, 400, 400);
                
                game.snake.getSnake().stream().forEach((part) -> {
                    context.setFill(SnakePart.getColor());
                    context.fillRect(part.getX(), part.getY(), SnakePart.getWidth(), SnakePart.getHeight());
                });
                context.setFill(Food.getColor());
                context.fillRect(game.food.getX(), game.food.getY(), SnakePart.getWidth(), SnakePart.getHeight());
            }
            else {
                context.setFill(Color.AQUA);
                context.fillRect(0, 0, 400, 400);
                context.setFill(Color.BLACK);
                context.setFont(new Font(24));
                context.setTextAlign(TextAlignment.CENTER);
                context.fillText("Game Over!", 200, 200);
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
 @FXML
    void initialize() {
          Alert alert = new Alert(Alert.AlertType.INFORMATION, "Utiliza las flechas del teclado para mover la serpiente \n"
                  + "y hacerla crecer al comer manzanas.\n\n" +
                    "Evita chocar contra las paredes o \n"
                  + "contra tu propia cola para no perder.\n\n" +
                    "Gana puntos al comer manzanas y aumenta \n"
                  + "tu dificultad al hacer crecer a la serpiente. " , ButtonType.OK);
            alert.showAndWait(); 
     

    }
    }
    
    
    
    
   
    
    
    
    
    
    

   



