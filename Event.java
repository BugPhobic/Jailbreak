/**
 * This class holds the template for the events that happen in the game
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-10
 */
public class Event {
    private final int ROOM_ACTIVE;
    private final String CHARACTER_ID_ACTIVE;
    private final String EVENT_CONTENT;
    private boolean executed;

    //Constructors

    /**
     * Constructor (Given no parameters)
     */
    Event() {
        ROOM_ACTIVE = 0;
        CHARACTER_ID_ACTIVE = "null";
        executed = false;
        EVENT_CONTENT = null;
    }

    /**
     * Constructor (Given all parameters)
     * Creates an event that can be executed in the game
     *
     * @param roomNum     The roomNum of the Room in which the event should be executed
     * @param characterId The CHARACTER_ID of the Character instance relevant to the event
     * @param status      Whether or not the event has been executed
     * @param content     The dialogue and other content in the event
     */
    Event(int roomNum, String characterId, boolean status, String content) {
        ROOM_ACTIVE = roomNum;
        CHARACTER_ID_ACTIVE = characterId;
        executed = status;
        EVENT_CONTENT = content;
    }

    /**
     * Constructor (Given object)
     * Creates a duplicate event
     *
     * @param object An instance of the Event class
     */
    Event(Event object) {
        this.ROOM_ACTIVE = object.ROOM_ACTIVE;
        this.CHARACTER_ID_ACTIVE = object.CHARACTER_ID_ACTIVE;
        this.executed = object.executed;
        this.EVENT_CONTENT = object.EVENT_CONTENT;
    }

    //Mutators

    /**
     * Defines whether or not the event has been executed
     *
     * @param status Whether or not the event has been executed
     */
    public void setEventExecuted(boolean status) {
        executed = status;
    }

    //Accessors

    /**
     * Returns the Room in which the event should be executed
     *
     * @return The roomNum of the Room in which the event should be executed
     */
    public int getRoomActive() {
        return ROOM_ACTIVE;
    }

    /**
     * Returns the ID of the Character for which the event should be executed
     *
     * @return The CHARACTER_ID of the Character instance for which the event should be executed
     */
    public String getCharacterIdActive() {
        return CHARACTER_ID_ACTIVE;
    }

    /**
     * Returns whether or not the event has been executed
     *
     * @return Whether or not the event has been executed
     */
    public boolean getEventExecuted() {
        return executed;
    }

    //Others

    /**
     * Prints the content of the event
     */
    public void printEventContent() {
        //Creates an array that holds all the content of the event
        String[] eventDialogue = EVENT_CONTENT.split("  ");

        System.out.println();
        //Prints the event content
        for (int i = 0; i < eventDialogue.length; i++) {
            System.out.println(eventDialogue[i]);
        }
        System.out.println();
    }
}