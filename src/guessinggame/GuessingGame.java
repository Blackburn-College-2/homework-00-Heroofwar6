/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;

import java.util.Scanner;

/**
 *
 * @author krigsdator
 */
public class GuessingGame {

    /**
     *
     * @param guess the player guess
     * @param options the strings in the array at the start
     * @return whether the guess was even equal to any options
     */
    public boolean checkArray(String guess, String[] options) {
        int equal = 0;
        for (int i = 0; i < options.length; i++) {
            if (guess.equals(options[i])) {
                equal++;
            }
        }
        boolean goodGuess = false;
        if (equal > 0) {
            goodGuess = true;
        }
        return goodGuess;
    }

    /**
     *
     * @param guess The players guess
     * @param answer The secret meal
     * @return check to see if the player actually guessed right
     */
    public boolean checkOption(String guess, String answer) {
        boolean correct = false;
        if(guess.equals(answer)){
            System.out.println("Correct! You win!");
            correct = true;
        }else if(!(guess.equals(answer))){
            System.out.println("Wrong!");
        }
        return correct;
    }
    public void twiceGuessed(String guess, String firstGuess){
        if(guess.equals(firstGuess)){
            System.out.print("You already guessed that! ");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GuessingGame checkGuess = new GuessingGame();
        Scanner input = new Scanner(System.in);
        String[] food = new String[3];
        food[0] = "shrimp";
        food[1] = "tacos";
        food[2] = "sushi";

        int index = (int) (2.0 * Math.random());
        String secret = food[index];

        System.out.println("The secret meal must be one of the following");
        for (int i = 0; i < food.length; i++) {
            System.out.println(food[i]);
        }
        System.out.print("Guess the meal: ");
        String guess = input.nextLine();
        String firstGuess = guess;
        boolean goodGuess = checkGuess.checkArray(guess, food);
        if (goodGuess) {
           boolean correctGuess = checkGuess.checkOption(guess, secret);
           if(!correctGuess){
               System.out.print("Guess the meal: ");
               guess = input.nextLine();
               checkGuess.twiceGuessed(guess, firstGuess);
               boolean lastGuess = checkGuess.checkOption(guess, secret);
               if(!lastGuess){
                   System.out.println("You lose.");
               }
           }
        } else {
            System.out.println("That wasn't even an option. You lose.");
        }
    }
}
