// Name: Bryce Doyle

package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class YoMommaTranslator {

    public static Map<String, String> readFile() throws FileNotFoundException
    {
        // Implementing my file
        File inputFile = new File("acronyms.txt");
        Scanner scan = new Scanner(inputFile);
        String line;
        
        // Making my Map
        Map<String, String> translator = new HashMap<>();
        
        // Reading my file and shoving it into my Map
        while (scan.hasNextLine())
        {
            line = scan.nextLine();
            String[] splitted = line.split("\\t");
            translator.put(splitted[0], splitted[1]);
        }

        scan.close();
        
        // Returns my Map to be used in the acronym maker
        return translator;
    }
    
    public static void userInput(Map<String, String> acronyms)
    {
        // Asks the user for their sentence filled with slang and stores it
        System.out.println("Enter your wacky sentence.");
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        String userInput = scan.next();
        
        // Splits the input into an array of Strings
        String[] split = userInput.split("\\s+");
        
        // The for loop that does the translating and most importantly gets the job done.
        for (int i = 0; i < split.length; i++)
        {
            if (acronyms.containsKey(split[i].toUpperCase()))
            {
                String replaced = acronyms.replace(split[i].toUpperCase(), acronyms.get(split[i]));
                split[i] = replaced.toLowerCase();
            }
            
            System.out.print(split[i] + " ");
            
            if (i == split.length)
                System.out.println(".");
        }

        scan.close();
        
    }    
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        Map<String, String> acronyms = readFile();
        userInput(acronyms);  
    }
    
}
