package com.example.wordguessergui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordGuesser {

    private List<String> words;
    private char[] currentWord;

    private char[] currentGuess;

    private Set<Character> guessedLetters;

    private int maxGuesses;

    private int guessesUsed;
    public WordGuesser(List<String> words, int initial, int maxGuesses){
        this.words = words;
        this.maxGuesses = maxGuesses;
        start(initial);
    }

    public void start(int wordToGuess){
        this.currentWord = this.words.get(wordToGuess).toLowerCase().toCharArray();
        this.currentGuess = new char[this.currentWord.length];
        for(int i = 0; i < this.currentGuess.length; i++){
            this.currentGuess[i] = '_';
        }
        this.guessedLetters = new HashSet<Character>();
        this.guessesUsed = 0;
    }

    public String toString(){
        return String.format("Current Game: %s\nGuessed Letters: %s\nGuesses Left: %d",
                             String.copyValueOf(this.currentGuess), this.guessedLetters,
                             this.maxGuesses - this.guessesUsed);

    }

    public void guessLetter(String letter) throws NotALetterException, OutOfGuessesException {
        if(letter.length() != 1){
            NotALetterException e = new NotALetterException();
           throw e;
        }
        if(this.guessesUsed >= this.maxGuesses){
            throw new OutOfGuessesException(this.currentWord.toString());
        }

        this.guessedLetters.add(letter.toCharArray()[0]);
        boolean foundLetter = false;
        for(int i = 0; i < currentWord.length; i++){
            if(String.valueOf(currentWord[i]).equals(letter)){
                foundLetter = true;
                currentGuess[i] = currentWord[i];
            }
        }
        if(! foundLetter) { guessesUsed++; }

    }

    public void validateWord(String word) throws OutOfGuessesException, AccidentallyGuessedALetterException, EmptyGuessException {
        if(this.guessesUsed >= this.maxGuesses) {
            throw new OutOfGuessesException(this.currentWord.toString());
        }
        if(word.isEmpty() || word.isBlank()){
            throw new EmptyGuessException();
        }
        if(word.length() == 1) {
            throw new AccidentallyGuessedALetterException(word);
        }
    }
    public boolean guessWord(String word) throws OutOfGuessesException, AccidentallyGuessedALetterException, EmptyGuessException{
        this.validateWord(word);

        if(Arrays.equals(currentWord, word.toCharArray()))
        {
            return true;
        }
        else {
            guessesUsed++;
            return false;
        }
    }

    public boolean hasGuessesLeft(){
        return this.guessesUsed < this.maxGuesses;
    }


}
