package com.example.wordguessergui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class HelloController {

    private WordGuesser wg;
    List<String> words;

    public HelloController(){
        try {
            words = new AnimalWords().getWords();
        } catch (IOException e) {
            System.err.println("Couldn't open Animals.txt");
            words = List.of("zebra");
        }
        Random r = new Random();
        wg = new WordGuesser(words,r.nextInt(words.size()),5);

    }

    @FXML
    private Label welcomeText;

    @FXML
    private Label error;

    @FXML
    private TextField input;



    @FXML
    protected void onStartButtonClick() {
        welcomeText.setFont(new Font(24));
        wg.start(new Random().nextInt(words.size()));
        welcomeText.setText(wg.toString());
    }

    @FXML
    protected void onGuessLetterClick() {
        try {
            wg.guessLetter(input.getText());
            error.setText("");
            welcomeText.setText(wg.toString());
            input.setText("");
        } catch (Exception e) {
            error.setText(e.getMessage());
        }
    }

    @FXML
    protected void onGuessWordClick() {
        try {
            boolean won = wg.guessWord(input.getText());
            error.setText("");
            welcomeText.setText(wg.toString());
            input.setText("");
            if(won){
                error.setText("You won!");
            }
        } catch (Exception e){
            error.setText(e.getMessage());
        }

    }
}