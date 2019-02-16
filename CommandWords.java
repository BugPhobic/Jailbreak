/**
 * This is the class that holds all of the command words that are recognized
 * by the game. It is used to recognize the commands that the player types in
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-10
 */
class CommandWords {
    //Constant array that holds all the valid command words
    private static final String[] VALID_COMMANDS = {
            "attack", "diagnose", "drop", "examine", "go", "help", "inventory", "look", "quit", "rest", "take", "use"
    };

    //Others
    /**
     * Checks the validity of the inputted command word. Returns false if
     * invalid.
     *
     * @param aString The inputted command word
     * @return boolean The validity of the inputted command word
     */
    public static boolean isCommand(String aString) {
        for (int i = 0; i < VALID_COMMANDS.length; i++) {
            if (VALID_COMMANDS[i].equals(aString))
                return true;
        }
        return false;
    }

    /**
     * Prints the list of valid command words.
     */
    public static void printValidCommands() {
        for (int i = 0; i < VALID_COMMANDS.length; i++) {
            System.out.print(VALID_COMMANDS[i] + "  ");
        }
    }
}