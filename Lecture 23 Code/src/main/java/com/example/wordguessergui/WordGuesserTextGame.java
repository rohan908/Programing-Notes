package com.example.wordguessergui;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuesserTextGame {

    public static List<String> animalWords(){
        try {
            List<String> animalWords = new AnimalWords().getWords();
            return animalWords;
        } catch (IOException e) {
            System.err.println("Couldn't open Animals.txt");
            return List.of("zebra");
        }

    }

    public static void main(String[] args){

        char action = 'p';
        Scanner keyboard = new Scanner(System.in);
        //List<String> words = List.of("pineapple", "pear", "grapefruit");
        List<String> words = animalWords();
        Random r = new Random();
        WordGuesser wg = new WordGuesser(words,r.nextInt(words.size()),5);



        while(action != 'q'){
            System.out.println(wg.toString());
            System.out.println("What would you like to do?");
            System.out.println("[l]etter, [w]ord, [s]tart over, [q]uit");
            String input = keyboard.nextLine();
            if(input.isEmpty() || input.isBlank()){
                System.err.println("Bad prompt input");
            }
            else{
                action = input.charAt(0);
                if(action == 'l'){
                    System.out.println("Enter a letter:");
                    String letter = keyboard.nextLine();
                    try {
                        wg.guessLetter(letter);
                    } catch (NotALetterException e) {
                        System.out.println(e.getMessage());
                    } catch (OutOfGuessesException e) {
                        System.out.println("You are out of guesses" + e.answer);
                    }
                }
                else if(action == 'w'){
                    System.out.println("Enter a word:");
                    String word = keyboard.nextLine();
                    try {
                        boolean win = wg.guessWord(word);
                        if(win){
                            System.out.println("you win!");
                        }
                    } catch (OutOfGuessesException e) {
                        System.out.println("You are out of guesses:" + e.answer);
                    } catch (AccidentallyGuessedALetterException e) {
                        System.out.printf("Did you mean to guess the letter %s? [y]es/[n]o\n", e.getTheLetter());
                        String yn = keyboard.nextLine();
                        if(yn.startsWith("y")){
                            try {
                                wg.guessLetter(e.getTheLetter());
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } catch (EmptyGuessException e) {
                        System.out.println("You hit enter too soon");
                    }

                }
                else if(action == 's'){
                    wg.start(r.nextInt(words.size()));
                }
                else if(action == 'q'){

                }
            }

        }
    }
}
