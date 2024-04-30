package com.example.wordguessergui;

public class OutOfGuessesException extends Exception{

    public String answer;
    public OutOfGuessesException(String answer){
        this.answer = answer;
    }
}
