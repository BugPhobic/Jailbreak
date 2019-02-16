/**
 * This class is a template for all the rooms that are created in the game
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-10
 */
class Room {
    private final String ROOM_DESCRIPTION;
    private final String ROOM_NAME;
    private final int ROOM_NUM;
    private boolean exitPassRequired;
    private boolean freeMovement;
    private boolean visitStatus;
    private int eastExit;
    private int northExit;
    private int southExit;
    private int westExit;


    //Constructors

    /**
     * Constructor (Given no parameters)
     */
    public Room() {
        ROOM_DESCRIPTION = "null";
        ROOM_NAME = "null";
        ROOM_NUM = -1;
        northExit = 0;
        southExit = 0;
        eastExit = 0;
        westExit = 0;
        exitPassRequired = false;
        freeMovement = false;
        visitStatus = false;
    }

    /**
     * Constructor (Given all parameters)
     * Creates a room in the game.
     *
     * @param name           The name of the room
     * @param num            The room's number
     * @param description    The description of the room
     * @param exitPassNeeded Whether or not the *Exit Pass* is need for further movement from this room
     * @param movementStatus Whether or not a character can freely get into and out of the room
     * @param status         Whether or not the room has been visited
     */
    public Room(String name, int num, String description, boolean exitPassNeeded, boolean movementStatus, boolean status) {
        ROOM_DESCRIPTION = description;
        ROOM_NUM = num;
        ROOM_NAME = name;
        exitPassRequired = exitPassNeeded;
        freeMovement = movementStatus;
        visitStatus = false;
    }

    /**
     * Constructor (Given object)
     * Creates a duplicate room.
     *
     * @param object An instance of the Room class
     */
    public Room(Room object) {
        this.ROOM_DESCRIPTION = object.ROOM_DESCRIPTION;
        this.ROOM_NAME = object.ROOM_NAME;
        this.ROOM_NUM = object.ROOM_NUM;
        this.northExit = object.northExit;
        this.eastExit = object.eastExit;
        this.southExit = object.southExit;
        this.westExit = object.westExit;
        this.exitPassRequired = object.exitPassRequired;
        this.freeMovement = object.freeMovement;
        this.visitStatus = object.visitStatus;
    }

    //Mutators

    /**
     * Defines whether or not the *Exit Pass* is needed for further movement in this room
     *
     * @param exitPassNeeded Whether or not the *Exit Pass* is needed for further movement in this room
     */
    public void setExitPassRequired(boolean exitPassNeeded) {
        exitPassRequired = exitPassNeeded;
    }

    /**
     * Defines the exit rooms of the room
     *
     * @param north The room number of the room to the north
     * @param east  The room number of the room to the east
     * @param south The room number of the room to south
     * @param west  The room number of the room to west
     */
    public void setExits(int north, int east, int south, int west) {
        if (north != 0)
            northExit = north;
        if (east != 0)
            eastExit = east;
        if (south != 0)
            southExit = south;
        if (west != 0)
            westExit = west;
    }

    /**
     * Defines whether or not a character can freely get into and out of the room
     *
     * @param movementStatus Whether or not a character can freely get into and out of the room
     */
    public void setFreeMovement(boolean movementStatus) {
        freeMovement = movementStatus;
    }

    /**
     * Defines whether or not the player has visited the room
     *
     * @param status The visit status
     */
    public void setVisitStatus(boolean status) {
        visitStatus = status;
    }

    //Accessors

    /**
     * Returns the room number of the east exit
     *
     * @return The room number of the room to the east
     */
    public int getEastExit() {
        return eastExit;
    }

    /**
     * Defines whether or not the *Exit Pass* is needed for further movement in this room
     *
     * @return Whether or not the *Exit Pass* is needed for further movement in this room
     */
    public boolean getExitPassRequired() {
        return exitPassRequired;
    }

    /**
     * Returns whether or not a character can freely get into and out the room
     *
     * @return Whether or not a character can freely get into and out the room
     */
    public boolean getFreeMovement() {
        return freeMovement;
    }

    /**
     * Returns the room number of the north exit
     *
     * @return The room number of the room to the north
     */
    public int getNorthExit() {
        return northExit;
    }

    /**
     * Returns the description of the room
     *
     * @return The description of the room
     */
    public String getRoomDescription() {
        return ROOM_DESCRIPTION;
    }

    /**
     * Returns the name of the room
     *
     * @return The name of the room
     */
    public String getRoomName() {
        return ROOM_NAME;
    }

    /**
     * Returns the room's number
     *
     * @return The room's number
     */
    public int getRoomNum() {
        return ROOM_NUM;
    }

    /**
     * Returns the room number of the south exit
     *
     * @return The room number of the room to the south
     */
    public int getSouthExit() {
        return southExit;
    }

    /**
     * Returns whether or not the player has visited the room
     *
     * @return The visit status of the room
     */
    public boolean getVisitStatus() {
        return visitStatus;
    }

    /**
     * Returns the room number of the west exit
     *
     * @return The room number of the room to the west
     */
    public int getWestExit() {
        return westExit;
    }
}