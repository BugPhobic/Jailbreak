/**
 * This is the class that is responsible for holding the information of the
 * commands given by the user. It currently works with a two word system.
 * The first word is the command,  while the second word is the argument. An empty
 * COMMAND_WORD would mean that the command is not recognized by the game
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-10
 */
class Command {
    private final String ARGUMENT_WORD;
    private final String COMMAND_WORD;

    //Constructors

    /**
     * Constructor (Given all arguments)
     * Create the Command object, consisting of the command and the
     * argument.
     *
     * @param firstWord  The command
     * @param secondWord The argument
     */
    public Command(String firstWord, String secondWord) {
        COMMAND_WORD = firstWord;
        ARGUMENT_WORD = secondWord;
    }

    //Accessors    

    /**
     * Returns the argument.
     *
     * @return String The argument
     */
    public String getArgumentWord() {
        return ARGUMENT_WORD;
    }

    /**
     * Returns the command. Empty if command is not recognized.
     *
     * @return String The command word
     */
    public String getCommandWord() {
        return COMMAND_WORD;
    }

    //Others

    /**
     * Checks if there is an argument provided. Returns false if there is none
     *
     * @return boolean The presence of an argument word
     */
    public boolean hasArgumentWord() {
        return (!ARGUMENT_WORD.equals(""));
    }

    /**
     * Returns the validity of the command. Returns false if not recognized.
     *
     * @return boolean The validity of the command
     */
    public boolean isUnknown() {
        return (COMMAND_WORD.equals(""));
    }
}