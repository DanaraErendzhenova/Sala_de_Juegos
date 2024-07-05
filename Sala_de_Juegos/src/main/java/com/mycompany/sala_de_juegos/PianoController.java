/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sala_de_juegos;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.applet.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mañanas
 */
public class PianoController {

    Random random = new Random();
    ArrayList<String> comprobacion = new ArrayList<>();
    int contador = 0;
    int x;
    List<String> combinacion_correcta = new ArrayList<>();
    List<String> ultimosTres = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_escuchar;

    @FXML
    private Button button_escuchar_de_nuevo;
    
    @FXML
    private Button button_volver;

    @FXML
    private Button tecla1;

    @FXML
    private Button tecla2;

    @FXML
    private Button tecla3;

    @FXML
    private Button tecla4;

    @FXML
    private Button tecla5;

    @FXML
    private Button tecla6;

    @FXML
    private Button tecla7;

    @FXML
    private Button tecla8;

    private final String sonidoDoMenor = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\do_menor.wav";
    private final String sonidoRe = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\re.wav";
    private final String sonidoMi = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\mi.wav";
    private final String sonidoFa = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\fa.wav";
    private final String sonidoSol = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\sol.wav";
    private final String sonidoLa = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\la.wav";
    private final String sonidoSi = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\si.wav";
    private final String sonidoDoMayor = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\do_mayor.wav";
    private final String correcto = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\correct.wav";
    private final String falso = "C:\\Users\\Puesto 5\\Danara\\GitHub\\Sala_de_Juegos\\Sala_de_Juegos\\src\\main\\resources\\sonidos_piano\\error.wav";
    
    @FXML
    private void volver() throws IOException {
    App.setRoot("start");
    }
    
    @FXML
    void initialize() {

        tecla1.setOnAction(event -> {
            playSound(sonidoDoMenor);
            comprobacion.add(sonidoDoMenor);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla2.setOnAction(event -> {
            playSound(sonidoRe);
            comprobacion.add(sonidoRe);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla3.setOnAction(event -> {
            playSound(sonidoMi);
            comprobacion.add(sonidoMi);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla4.setOnAction(event -> {
            playSound(sonidoFa);
            comprobacion.add(sonidoFa);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla5.setOnAction(event -> {
            playSound(sonidoSol);
            comprobacion.add(sonidoSol);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla6.setOnAction(event -> {
            playSound(sonidoLa);
            comprobacion.add(sonidoLa);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla7.setOnAction(event -> {
            playSound(sonidoSi);
            comprobacion.add(sonidoSi);
            contador++;
            if (contador % 3 == 0) {
                comprobarCombinacion();
            }
        }
        );
        tecla8.setOnAction(event -> {
            playSound(sonidoDoMayor);
            comprobacion.add(sonidoDoMayor);
            contador++;
            if (contador == 3) {
                comprobarCombinacion();
            }
        }
        );
        button_escuchar.setOnAction(event -> playCombinacion());
        button_escuchar_de_nuevo.setOnAction(event-> {
            for (String sonido : combinacion_correcta) {
                playSound(sonido);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        }
        });
    }

    private void playSound(String filePath) {
        try {
            File file = new File(filePath);
            String url = file.toURI().toURL().toString();
            AudioClip audioClip = Applet.newAudioClip(new java.net.URL(url));
            audioClip.play();
        } catch (MalformedURLException e) {
            System.out.println("Error al cargar el audio" + e.getMessage());
        }
    }

    private void comprobarCombinacion() {

        if (contador % 3 == 0) {
            // Obtener los últimos tres elementos de la lista
            ultimosTres = comprobacion.subList(comprobacion.size() - 3, comprobacion.size());
        }
        // Comparar el contenido del array con los tres últimos elementos de la lista
        if (ultimosTres.equals(combinacion_correcta)) {
            playSound(correcto);
        } else {
            playSound(falso);
        }

    }

    private void playCombinacion() {
        x = random.nextInt(10) + 1;
        switch (x) {
            case 1:
                ArrayList<String> sonidosCaso1 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoSol, sonidoLa));

                combinacion_correcta = sonidosCaso1;

                for (String sonido : sonidosCaso1) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                ArrayList<String> sonidosCaso2 = new ArrayList<>(Arrays.asList(sonidoDoMayor, sonidoDoMenor, sonidoSol));
                combinacion_correcta = sonidosCaso2;
                for (String sonido : sonidosCaso2) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                ArrayList<String> sonidosCaso3 = new ArrayList<>(Arrays.asList(sonidoDoMenor, sonidoMi, sonidoSol));
                combinacion_correcta = sonidosCaso3;
                for (String sonido : sonidosCaso3) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 4:
                ArrayList<String> sonidosCaso4 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoDoMayor, sonidoLa));
                combinacion_correcta = sonidosCaso4;
                for (String sonido : sonidosCaso4) {

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    playSound(sonido);

                }
                break;
            case 5:
                ArrayList<String> sonidosCaso5 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoSol, sonidoLa));
                combinacion_correcta = sonidosCaso5;
                for (String sonido : sonidosCaso5) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 6:
                ArrayList<String> sonidosCaso6 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoSi, sonidoLa));
                combinacion_correcta = sonidosCaso6;
                for (String sonido : sonidosCaso6) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 7:
                ArrayList<String> sonidosCaso7 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoSol, sonidoLa));
                combinacion_correcta = sonidosCaso7;
                for (String sonido : sonidosCaso7) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 8:
                ArrayList<String> sonidosCaso8 = new ArrayList<>(Arrays.asList(sonidoDoMenor, sonidoSol, sonidoSi));
                combinacion_correcta = sonidosCaso8;
                for (String sonido : sonidosCaso8) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 9:
                ArrayList<String> sonidosCaso9 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoSol, sonidoDoMayor));
                combinacion_correcta = sonidosCaso9;
                for (String sonido : sonidosCaso9) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 10:
                ArrayList<String> sonidosCaso10 = new ArrayList<>(Arrays.asList(sonidoFa, sonidoSi, sonidoSol));
                combinacion_correcta = sonidosCaso10;
                for (String sonido : sonidosCaso10) {
                    playSound(sonido);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }
    }

}
