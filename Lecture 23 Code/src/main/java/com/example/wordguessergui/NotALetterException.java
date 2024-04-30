package com.example.wordguessergui;

public class NotALetterException extends Exception{

    public NotALetterException(){
        super("Client guessed something other than a letter");
    }

}
