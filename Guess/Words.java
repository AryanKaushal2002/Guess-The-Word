package Guess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words
{    
    //private String[] randomWords={"animals","happiness","indefinite","steady","birthday","extreme","rights","properties","ceremony","independence","beneath","information","students","employee"};
    private String[] randomWords;
    private String selectedWord;
    private char[] letters;
    //public  final String showSelected=selectedWord;
    private Random random=new Random();
    public Words()
    {
        List<String> listOfStrings=new ArrayList<String>();
       
        // load the data from file
        try {
            listOfStrings= Files.readAllLines(Paths.get("C:\\Users\\KIIT\\OneDrive\\Documents\\JavaMiniProj\\wordlist.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        // convert arraylist to array
        randomWords= listOfStrings.toArray(new String[0]);

        selectedWord=randomWords[random.nextInt(randomWords.length)];
        letters=new char[selectedWord.length()];
        //showSelected=selectedWord;        
    }
    
    public String toString()
    {
        StringBuilder text= new StringBuilder();
        
        for(char letter : letters)
        {
            text.append(letter =='\u0000' ? "-" : letter);            
            text.append(' ');
        }

        return text.toString();
    }    
    public boolean isGuessedRight()
    {
        for(char letter : letters)
        {
            if(letter == '\u0000')
            {
                return false;
            }
        }
        return true;
    }
    public boolean guess(char letter) 
    {
        boolean guessedRight=false;
        for(int i=0;i<selectedWord.length();i++)
        {
            if(letter==selectedWord.charAt(i))
            {
                letters[i]=letter;
                guessedRight=true;
            }
        }
        return guessedRight;
    }
}
