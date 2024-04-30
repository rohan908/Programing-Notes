package com.example.wordguessergui;

public class AccidentallyGuessedALetterException extends Exception{

    private String theLetter;
    public AccidentallyGuessedALetterException(String theLetter){
        super(String.format("You guessed the letter %s, not a word >:(", theLetter));
        this.theLetter = theLetter;
    }

    public String getTheLetter() { return theLetter;}
}
