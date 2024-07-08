/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;
import javafx.geometry.Dimension2D;
/**
 *
 * @author Mañanas
 */
public class Game {
 public Food food;
    public final Snake snake;
    private final Dimension2D fieldSize;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGameOver() {
        if (snake.update(food, fieldSize.getWidth(), fieldSize.getHeight())) {
            if (food.isEated()) {
                score++;
                food = new Food();
            }
            return false;
        }
        return true;
    }

    public Game() {
        score = 0;
        fieldSize = new Dimension2D(400, 400);
        snake = new Snake();
        food = new Food();
    }   
}
