
package Guess;
import java.util.Scanner;

public class GuessTheword 
{
    private boolean play=true;
    private Words randomWords=new Words();
    private Scanner ob = new Scanner(System.in);//also prevents the loop from running infinitely
    private int rounds=10;
    private char lastRound;
    public void start()
    {
        do{
            showWord();
            getInput();
            checkInput();
        }while(play);
    }
    void showWord()
    {
        System.out.println("You have "+rounds+" tries left.");
        System.out.println(randomWords);
    }
    void getInput()
    {
        System.out.println("Enter a letter to guess the word :");
        String userGuess=ob.nextLine();
        
        lastRound=userGuess.charAt(0);
    }
    void checkInput()
    {
        //Words ob= new Words();
        //final String show=ob.showSelected;
        //System.out.println(show);
        boolean isGuessedRight= randomWords.guess(lastRound);
        if(isGuessedRight)
        {
            if(randomWords.isGuessedRight())
            {
                System.out.println("Congrats, you won!!");
                System.out.println("The word is : "+randomWords);
                play=false; //no longer needs to run
            }
        }
        else{
            rounds--;

            if(rounds == 0)
            {
                System.out.println("Game Over!!");
                //System.out.println("The word was : "+show);
                play=false;
            }
        }
    }
    public void end() 
    {
        ob.close();
    }
}
