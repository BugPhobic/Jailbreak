/**
 * This is the class that is responsible for reading user input and interpreting
 * it. It reads a line from the terminal each time it is called and attempts to
 * interpret it as two word command. It then passes the combined string to check
 * the validity of the inputted command
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-10
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parser {
    //Others

    /**
     * Takes the user input and creates a command out of it by separating the
     * input into a command and an argument word before putting them together
     * as a string and checking the validity of the command.
     * @return Command The Command object
     */
    public static Command generateCommand() {
        String argumentWord;
        String commandWord;
        String inputLine = "";

        //Printing the prompt
        System.out.println();
        System.out.println("*************************************************************************");
        System.out.print("> ");

        //Receiving user input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine().toLowerCase();
        } catch (java.io.IOException exc) {
            System.out.println("There was an error during reading: " + exc.getMessage());
        }

        //Getting the commandWord and argumentWord words. The rest is ignored.
        String[] inputWords = inputLine.split(" ");
        switch (inputWords.length) {
            case 0:
                commandWord = "";
                argumentWord = "";
                break;
            case 1:
                commandWord = inputWords[0];
                argumentWord = "";
                break;
            case 2:
                commandWord = inputWords[0];
                argumentWord = inputWords[1];
                break;
            case 3:
                commandWord = inputWords[0];
                argumentWord = inputWords[1] + " " + inputWords[2];
                break;
            default:
                commandWord = "";
                argumentWord = "";
                break;
        }

        //Checks if the given command word is valid and returns appropriate Command object
        if (CommandWords.isCommand(commandWord))
            return new Command(commandWord, argumentWord);
        else
            return new Command("", argumentWord);
    }
}