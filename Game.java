/**
 * This class holds the template for the game environment. Upon starting the
 * game, an instance of this class is created, storing the game environment
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-12
 */

import java.util.Scanner;

class Game {
    //The player object is in index 0
    private static final Character[] CHARACTERS = new Character[6];

    //The player lose event is in index 0. The teleporter event is in index 1
    private static final Event[] EVENTS = new Event[10];

    private static final Item[] ITEMS = new Item[6];

    //The the roomNum of an element is always one more than its index
    private static final Room[] ROOMS = new Room[18];

    //Constructors

    /**
     * Creates the game and initializes the map, items, characters and events
     */
    public Game() {
        createRooms();
        createItems();
        createCharacters();
        createEvents();
    }

    //Others

    /**
     * Initializes an array that holds all of the characters in the game
     */
    private static void createCharacters() {
        //Creating the player object and setting its starting location
        CHARACTERS[0] = new Character("Player", "Hero", 100, 25, 15, 5, 1, 25, 15, 1);
        CHARACTERS[1] = new Character("Ward Guard", "Guard", 70, 20, 10, 0, 0, 0, 0, 4);
        CHARACTERS[2] = new Character("East Hallways 1 Guard", "Strong Guard", 100, 30, 10, 0, 0, 0, 0, 5);
        CHARACTERS[3] = new Character("Guard Station Guard", "Guard", 70, 20, 10, 0, 0, 0, 0, 14);
        CHARACTERS[4] = new Character("Changeroom Guard", "Pissed Guard", 45, 35, 25, 0, 0, 0, 0, 16);
        CHARACTERS[5] = new Character("Final Boss", "Armored Guard", 200, 30, 15, 5, 1, 5, 1, 18);
    }

    /**
     * Initializes an array that holds all of the events in the game
     */
    private static void createEvents() {
        String eventContent;

        eventContent = "I curse my bad luck as I am wrestled to the floor.  "
                + "I have a bad feeling about what the interrogators have prepared for me...  "
                + "    MESSAGE FROM CREATOR: You clearly suck at this, don't you?";
        EVENTS[0] = new Event(0, "Player", false, eventContent);
        eventContent = "*Me*: What the heck is a teleporter doing here?!!!  "
                + "Before I have a chance to do anything, the teleporter activates!  "
                + "    *Me*: ...So much for teleporting me out of the prison.";
        EVENTS[1] = new Event(17, "null", false, eventContent);
        eventContent = "As I walk into the room, the guard in the room gets up, surprised.  "
                + "*Guard*: Where do you think you're going, inmate?!  "
                + "*Me*: Where do you think I'm going? Out of this hell hole, of course.  "
                + "If you are foolish enough to try stopping me, I won't hesitate to end  your miserable existence.  "
                + "*Guard*: Getting cocky, huh? Don't think you can beat me just cause you  got your hands on a weapon! I'll show you who ends who!";
        EVENTS[2] = new Event(4, "null", false, eventContent);
        eventContent = "*Me*: I sure do hope that getting whacked didn't lower your IQ too much.  ...Not that there was much for it drop down to, anyways.";
        EVENTS[3] = new Event(0, "Ward Guard", false, eventContent);
        eventContent = "*Guard*: Hey you! Stop!  *Me*: As if!";
        EVENTS[4] = new Event(5, "null", false, eventContent);
        eventContent = "A man bent over cleaning the tables notices my presence. He appears to be  another inmate.  "
                + "*Man*: You over there, what do you think you're doing out of your cell?!  "
                + "*Me*: You're an inmate, aren't you? Please, help me get out of this place!  "
                + "*Man*: So you're the new guy those interrogators were going on about today.  "
                + "You don't belong here, I can tell. As for where you do belong, looking at your  "
                + "attire you either belong at some cosplay convention or at a mental health institution.  "
                + "*Me*: ...  "
                + "*Man*: You will have to get past the North Hallways west of here.  "
                + "The exit is past the *Guard Station* at the end of the hallways, but you will  "
                + "need an *Exit Pass* to get past the station. It should be on one of the guards here...  "
                + "*Me*: ...Thanks for the help.  "
                + "*Man*: One more thing. There is a cell at the end of the East Hallways east of here  "
                + "was used by a high ranking gangster. You might find useful equipment stashed away there.";
        EVENTS[5] = new Event(9, "null", false, eventContent);
        eventContent = "I notice the sound of someone snoring coming from one of the stalls.  "
                + "*Me*: Who on earth would sleep in a washroom?! (Opens stall door)  "
                + "In the stall is a guard who reeks of booze.  "
                + "*Me*: Guess the guy tried to make work a bit more tolerable...  "
                + "*Guard*: Heeey man! S..stop hogging the...weed...  "
                + "*Me*: At least he was pretty 'involved' with the inmates...  "
                + "  I do not fail to notice what looks like a pass on his side.  "
                + "*Me*: Heh. This is almost too easy.";
        EVENTS[6] = new Event(11, "null", false, eventContent);
        eventContent = "Judging from the how the room looks, it appears this is a changeoom...  "
                + "It should be, cause there's a *Guard* undressing in front of me."
                + "*Guard*: AAAH! PERVERT!!  "
                + "*Me*: Hey! It's not like I was trying to peek on you!  "
                + "*Guard*: YOU WERE PLANNING TO DO MORE?!! I'LL KILL YOU!";
        EVENTS[7] = new Event(16, "null", false, eventContent);
        eventContent = "The *Armored Guard* here appears to have been surprised by me paying him a visit.  "
                + "*Armored Guard*: How the hell did you get here?!  "
                + "*Me*: I got my hands on this *Exit Pass*. Now, get out of my way.  "
                + "*Armored Guard*: I never thought that my commanding officer would  "
                + "be defeated by a weakling like you.  "
                + "*Me*: You mean that drunk guy in the stalls was your commanding officer?  "
                + "He should be fired! He's a waste of the taxpayer's money.  "
                + "*Armored Guard*: SHUT YOUR MOUTH! I'LL SHOW YOU YOUR PLACE!  "
                + "*Me*: Looks like I'll have to beat some sense into him before I  can escape.";
        EVENTS[8] = new Event(18, "null", false, eventContent);
        eventContent = "After a long and hard fight, the armoured guard falls down dead.  "
                + "Only a single door stands between me and the outside world.  "
                + "*Me*: I'll show these fools what it means to mess with me...  "
                + "As I walk to wards the exit, I notice something.  "
                + "*Me*: Wait a second...  Was that guy eating Pocky? It's been ages since I had one!  Omnomnomnom"
                + "              (THWACK)!  "
                + "Being the idiot that you are, you were ambushed while busy stuffing your  "
                + "mouth with Pocky sticks. Oh well, there's always next time...  "
                + "    MESSAGE FROM CREATOR: Congratulations on finishing the game!";
        EVENTS[9] = new Event(0, "Final Boss", false, eventContent);
    }

    /**
     * Initializes an array that holds all of them items in the game
     */
    private static void createItems() {
        ITEMS[0] = new Item(false, "Med Kit", "A kit containing basic medical supplies.", "Will restore 75 HP.", 3, 0, 0, 75, false);
        ITEMS[1] = new Item(false, "Carbine", "A lightweight automatic weapon that'll probably do more damage \nto the guards than me whacking them over the head.", "Allows me to shoot the guards.", 8, 80, 60, 0, false);
        ITEMS[2] = new Item(false, "Carbine Magazine", "A small magazine for the carbine. Too bad I'll probably \nhave to empty the whole magazine to hit something.", "I can't shoot the guards without ammo, can I?", 8, 0, 0, 0, false);
        ITEMS[3] = new Item(true, "Exit Pass", "A small electronic card. It will probably be needed for me to \nget out of this hellhole.", "Allows me to go past the *Guard Station*", 11, 0, 0, 0, false);
        ITEMS[4] = new Item(false, "Carbine Magazine", "A small magazine for the carbine. Too bad I'll probably \nhave to empty the whole magazine to hit something.", "I can't shoot the guards without ammo, can I?", 12, 0, 0, 0, false);
        ITEMS[5] = new Item(false, "Med Kit", "A kit that contains basic medical supplies.", "Will restore 75 HP.", 17, 0, 0, 75, false);
    }

    /**
     * Initializes an array that creates the map of the game
     */
    private static void createRooms() {
        //Initialize the Rooms in the game
        ROOMS[0] = new Room("My Cell", 1, "A dark and dingy cell. Just looking at it depresses me.", false, true, true);
        ROOMS[1] = new Room("South Hallways 1", 2, "A poorly maintained hallway with a dirty floor and dusty walls. \nThe lighting here is very weak.", false, true, false);
        ROOMS[2] = new Room("South Hallways 2", 3, "A poorly maintained hallway with a dirty floor and dusty walls. \nThe lighting here is very weak.", false, true, false);
        ROOMS[3] = new Room("Ward", 4, "Unlike the hallways, this room has heavy doors that separate it from the \nother hallways.", false, false, false);
        ROOMS[4] = new Room("East Hallways 1", 5, "The harsh ceiling lights cast a white glow over the hallways, \nmaking my shadow stand out. Cracked walls on either side of the room \ninform me that this appears to be an older part of the prison.", false, true, false);
        ROOMS[5] = new Room("East Hallways 2", 6, "Cracked walls on either side of the room inform me that this \nappears to be an older part of the prison.", false, true, false);
        ROOMS[6] = new Room("East Hallways 3", 7, "Cracked walls on either side of the room inform me that this \nappears to be an older part of the prison. There appears to be a \njail cell to the north.", false, true, false);
        ROOMS[7] = new Room("Old Cell", 8, "A dingy personal cell. It appears to have been unused for quite a while.", false, true, false);
        ROOMS[8] = new Room("Mess", 9, "The room is lined with tables and chairs.", false, true, false);
        ROOMS[9] = new Room("North Hallways 1", 10, "Unlike the other hallways, this one seems to have been \nmaintained very well.", false, true, false);
        ROOMS[10] = new Room("Washrooms 1", 11, "There is a washing basin on one wall with a few stalls.", false, true, false);
        ROOMS[11] = new Room("Washrooms 2", 12, "There is a washing basin on one wall with a few stalls.", false, true, false);
        ROOMS[12] = new Room("North Hallways 2", 13, "Unlike the other hallways, this one seems to have \nbeen maintained very well.", false, true, false);
        ROOMS[13] = new Room("Guard Station", 14, "This appears the be the main station for the prison \nguards.", true, true, false);
        ROOMS[14] = new Room("North Hallways 3", 15, "This hallway has a few pictures hanging off its \nwalls. It appears that the exit is near…", false, true, false);
        ROOMS[15] = new Room("Changeroom", 16, "The room is lined with lockers and benches. It appears \nthat this is the guards’ changeroom.", false, false, false);
        ROOMS[16] = new Room("Storage Room", 17, "Full of cartons of different sizes, this appears to \nbe a storage room.", false, true, false);
        ROOMS[17] = new Room("Prison Exit", 18, "A large room with one heavy door blocks me from \nthe outside world.", false, true, false);

        //Initialise the exits of each Room
        ROOMS[0].setExits(0, 0, 0, 2);
        ROOMS[1].setExits(3, 1, 0, 0);
        ROOMS[2].setExits(4, 0, 2, 0);
        ROOMS[3].setExits(5, 0, 3, 9);
        ROOMS[4].setExits(0, 6, 4, 0);
        ROOMS[5].setExits(0, 7, 0, 5);
        ROOMS[6].setExits(8, 0, 0, 6);
        ROOMS[7].setExits(0, 0, 7, 0);
        ROOMS[8].setExits(0, 4, 0, 10);
        ROOMS[9].setExits(13, 9, 0, 11);
        ROOMS[10].setExits(12, 10, 0, 0);
        ROOMS[11].setExits(0, 0, 11, 0);
        ROOMS[12].setExits(14, 0, 10, 0);
        ROOMS[13].setExits(15, 0, 13, 0);
        ROOMS[14].setExits(18, 16, 14, 17);
        ROOMS[15].setExits(0, 0, 0, 15);
        ROOMS[16].setExits(0, 15, 0, 0);
        ROOMS[17].setExits(0, 0, 15, 0);
    }

    /**
     * Drops an item from the player's inventory
     *
     * @param command The command entered by the user
     */
    private static void drop(Command command) {
        int itemIndex;

        //Need an item name to drop something
        if (!command.hasArgumentWord()) {
            System.out.println("*Me*: Drop what?");
        } else {
            //Checking if the item exists in-game and is in the player's inventory
            boolean itemExists = false;

            for (itemIndex = 0; itemIndex < ITEMS.length; itemIndex++) {
                if (validItem(itemIndex, command) && ITEMS[itemIndex].getItemOwnership() && !ITEMS[itemIndex].getItemUsed()) {
                    itemExists = true;
                    break;
                }
            }

            //The item doesn't exist or the it's not the player's inventory
            if (!itemExists)
                System.out.println("*Me*: I can't drop what I don't have! I'm not God!");

                //Drops the item if it's not a key item and is in the player's inventory
            else if (!ITEMS[itemIndex].getKeyItem()) {
                ITEMS[itemIndex].setItemOwnership(false);
                ITEMS[itemIndex].setItemLocation(ROOMS[getCurrentRoomIndex()].getRoomNum());
                System.out.println("Dropped *" + ITEMS[itemIndex].getItemName() + "*.");
            } else
                System.out.println("*Me*: Why would I ever even THINK about dropping this?!");
        }
    }

    /**
     * Enemy deals damage to the player
     *
     * @param enemyIndex The index of the enemy object in the CHARACTERS array
     */
    private static void enemyAttack(int enemyIndex) {
        //Use RNG to calculate damage dealt based on the enemy's attributes
        int damageDealt = randInt(CHARACTERS[enemyIndex].getCharacterMinDmg(), CHARACTERS[enemyIndex].getCharacterMaxDmg());

        //Update the player's HP
        CHARACTERS[0].setHp(CHARACTERS[0].getHp() - damageDealt);

        System.out.println();
        System.out.println("*" + CHARACTERS[enemyIndex].getCharacterType() + "* attacks me for " + damageDealt + " damage.");
    }

    /**
     * Returns whether or not an enemy is detected in the current location of the player
     *
     * @param enemyIndex The index of the Character object being checked in the CHARACTERS array
     * @return Returns whether or not a Character of the passed index is active in the current location of the player
     */
    private static boolean enemyDetected(int enemyIndex) {
        return (CHARACTERS[enemyIndex].getCharacterLocation() == CHARACTERS[0].getCharacterLocation() && CHARACTERS[enemyIndex].getHp() > 0);
    }

    /**
     * Prints out a physical description and a description of the effects of an item
     *
     * @param command The command inputted by the user
     */
    private static void examineItem(Command command) {
        //Which item should be described?
        if (!command.hasArgumentWord()) {
            System.out.println("*Me*: What on earth am I even trying to describe?");
            return;
        }

        //Checking if the item exists in-game and is in the player's inventory
        for (int i = 0; i < ITEMS.length; i++) {
            if (itemDetected(i) || ITEMS[i].getItemOwnership() && validItem(i, command) && !ITEMS[i].getItemUsed()) {
                System.out.println(ITEMS[i].getItemDescription());
                System.out.println(ITEMS[i].getItemEffect());
                return;
            }
        }

        System.out.println("*Me*: I would like to say that I don't do drugs.  SO WHY AM I TRYING TO DESCRIBE WHAT DOESN'T EXIST?!!");
    }

    /**
     * Terminates the thread the game is running in to stop execution, quitting the game
     */
    private static void gameExit() {
        //I would have reworked the quit method if I had more time
        System.exit(0);
    }

    /**
     * Returns the index of the current Room object the player is in
     *
     * @return Returns the index of the current Room object that the player is in from the ROOMS array
     */
    private static int getCurrentRoomIndex() {
        //The room index of a Room is one less than its roomNum
        return CHARACTERS[0].getCharacterLocation() - 1;
    }

    /**
     * Changes the room the player is in
     *
     * @param command The command inputted by the user
     */
    private static void goRoom(Command command) {
        boolean noEnemy = true;
        boolean noExitPass = true;
        int enemyIndex;
        int previousLocation = CHARACTERS[0].getCharacterLocation();
        String direction = command.getArgumentWord();

        //Checks if there is an enemy in the room
        for (enemyIndex = 1; enemyIndex < CHARACTERS.length; enemyIndex++) {
            if (enemyDetected(enemyIndex)) {
                noEnemy = false;
                break;
            }
        }

        //Checks if the player has the *Exit Pass* in the inventory
        for (Item currentItem : ITEMS) {
            if (currentItem.getItemName().equals("Exit Pass") && currentItem.getItemOwnership() && !currentItem.getItemUsed()) {
                noExitPass = false;
                break;
            }
        }

        //Where to?
        if (!command.hasArgumentWord()) {
            System.out.println("*Me*: I would rather not wander around aimlessly.");
            return;
        }

        //Enemy stops player exiting current room
        if (!ROOMS[getCurrentRoomIndex()].getFreeMovement() && !noEnemy) {
            System.out.println("*" + CHARACTERS[enemyIndex].getCharacterType() + "* stops me from exiting!");
            return;
        }

	/*Attempting to leave the current room and updating player location if successful        
	Checking if the direction the players wants to move to has a room*/
        if (direction.equals("north") && ROOMS[getCurrentRoomIndex()].getNorthExit() != 0) {
            if (ROOMS[getCurrentRoomIndex()].getExitPassRequired() && noExitPass) {
                System.out.println("*Me*: I'll need the *Exit Pass* to proceed!");
                return;
            }
            CHARACTERS[0].setCharacterLocation((ROOMS[getCurrentRoomIndex()].getNorthExit()));
        }
        if (direction.equals("east") && ROOMS[getCurrentRoomIndex()].getEastExit() != 0)
            CHARACTERS[0].setCharacterLocation((ROOMS[getCurrentRoomIndex()].getEastExit()));
        if (direction.equals("south") && ROOMS[getCurrentRoomIndex()].getSouthExit() != 0)
            CHARACTERS[0].setCharacterLocation((ROOMS[getCurrentRoomIndex()].getSouthExit()));
        if (direction.equals("west") && ROOMS[getCurrentRoomIndex()].getWestExit() != 0)
            CHARACTERS[0].setCharacterLocation((ROOMS[getCurrentRoomIndex()].getWestExit()));

        //There is no room in the direction the player is trying to move to
        if (CHARACTERS[0].getCharacterLocation() == previousLocation)
            System.out.println("*Me*: Am I high or what?! I can't go there!");

            //Successfully moved to new room
        else {
            //Checking new room for room events
            for (int eventIndex = 0; eventIndex < EVENTS.length; eventIndex++) {
                if (!EVENTS[eventIndex].getEventExecuted() && CHARACTERS[0].getCharacterLocation() == EVENTS[eventIndex].getRoomActive() && !ROOMS[getCurrentRoomIndex()].getVisitStatus()) {
                    EVENTS[eventIndex].printEventContent();
                    EVENTS[eventIndex].setEventExecuted(true);

                    //Teleport the player if it is the teleporter event that is being executed
                    if (eventIndex == 1)
                        CHARACTERS[0].setCharacterLocation(randInt(1, ROOMS.length));
                    else
                        break;
                }
            }
            printLocationInfo(false);
        }
    }

    /**
     * Returns whether or not an item is detected in the current location of the player
     *
     * @param itemIndex The index of the Item object being checked in the ITEMS array
     * @return Returns whether or not an Item of the passed index exists in the current location of the player
     */
    private static boolean itemDetected(int itemIndex) {
        return (ITEMS[itemIndex].getItemLocation() == CHARACTERS[0].getCharacterLocation() && !ITEMS[itemIndex].getItemOwnership());
    }

    /**
     * Prints out the Room's information along with any items or enemies present
     */
    private static void look() {
        printLocationInfo(true);
        printObjectsList();
    }

    /**
     * Main method that runs while the game is being executed. Loops until exit
     */
    public static void play() {
        boolean gameOver = false;
        boolean isResting = false;
        int enemyIndex = 1;

        printWelcome();
        
        /*Enter the main command loop. Repeatedly read commands and
	execute them until the game is over.*/
        while (!gameOver) {
            //Receive a command from the player and run it
            Command command = Parser.generateCommand();
            isResting = command.getCommandWord().toLowerCase().equals("rest");
            gameOver = processCommand(command);

            //Enemy attacks player if present in the same room
            for (enemyIndex = 1; enemyIndex < CHARACTERS.length; enemyIndex++) {
                if (enemyDetected(enemyIndex)) {
                    enemyAttack(enemyIndex);
                    break;
                } else if (enemyIndex == CHARACTERS.length - 1)
                    break;
            }

            //Checking if the player is dead
            if (CHARACTERS[0].getHp() > 0) {
                //Applying regeneration heal
                for (int characterIndex = 0; characterIndex < CHARACTERS.length; characterIndex++) {
                    if (CHARACTERS[characterIndex].getHp() < CHARACTERS[characterIndex].getMaxHp())
                        regenerate(characterIndex, isResting);
                }

                //The enemy is still present
                if (enemyDetected(enemyIndex))
                    printBattleInterface(enemyIndex);
            }

            //Player is dead, execute the game lose event and exit the game
            else {
                EVENTS[0].printEventContent();
                gameExit();
            }
        }
        System.out.println();
        System.out.println("MESSAGE FROM THE CREATOR: Thanks for playing. Good bye.");
    }

    /**
     * The player deals damage to the enemy by attacking or using an item
     *
     * @param enemyIndex The index of the Character object being checked in the CHARACTERS array
     * @param itemIndex  The index of the Item object being checked in the ITEMS array. Less than 0 if not using item to attack
     */
    private static void playerAttack(int enemyIndex, int itemIndex) {
        int damageDealt = 0;

        //Player is not using item to attack
        if (!(itemIndex >= 0)) {
            damageDealt = randInt(CHARACTERS[0].getCharacterMinDmg(), CHARACTERS[0].getCharacterMaxDmg());
            CHARACTERS[enemyIndex].setHp(CHARACTERS[enemyIndex].getHp() - damageDealt);
            System.out.println();
            System.out.println("I attack the *" + CHARACTERS[enemyIndex].getCharacterType() + "* for " + damageDealt + " damage.");
        }

        //Player is using item to attack
        else {
            damageDealt = randInt(ITEMS[itemIndex].getItemMinDmg(), ITEMS[itemIndex].getItemMaxDmg());
            CHARACTERS[enemyIndex].setHp(CHARACTERS[enemyIndex].getHp() - damageDealt);
            System.out.println();
            System.out.println("I empty the magazine into *" + CHARACTERS[enemyIndex].getCharacterType() + "* for " + damageDealt + " damage.");
        }

        //Checking if the enemy is dead to run event checker for Character related events
        if (!enemyDetected(enemyIndex)) {
            //Checking for events related to characters
            for (int eventIndex = 0; eventIndex < EVENTS.length; eventIndex++) {
                if (!EVENTS[eventIndex].getEventExecuted() && CHARACTERS[enemyIndex].getCharacterId().equals(EVENTS[eventIndex].getCharacterIdActive())) {
                    EVENTS[eventIndex].printEventContent();
                    EVENTS[eventIndex].setEventExecuted(true);

                    //Player killed the boss. Quit the game
                    if (EVENTS[eventIndex].getCharacterIdActive().equals("Final Boss"))
                        gameExit();
                    break;
                }
            }

            //Print out the dialog for killing an enemy
            System.out.println("I killed the *" + CHARACTERS[enemyIndex].getCharacterType() + "*.");
        }
    }

    /**
     * Prints the player's and the enemy's HP during combat
     *
     * @param enemyIndex The index of the Character object being checked in the CHARACTERS array
     */
    private static void printBattleInterface(int enemyIndex) {
        System.out.println();
        System.out.print("Me");
        System.out.println();
        printCharacterStatus(0);
        System.out.println();

        System.out.print(CHARACTERS[enemyIndex].getCharacterType());
        System.out.println();
        printCharacterStatus(enemyIndex);
    }

    /**
     * Prints out a Character's health
     *
     * @param index The index of the Character object being checked in gthe CHARACTERS array
     */
    private static void printCharacterStatus(int index) {
        System.out.println("HP: " + CHARACTERS[index].getHp() + "/" + CHARACTERS[index].getMaxHp());
    }

    /**
     * Prints out the printHelp information
     */
    private static void printHelp() {
        System.out.println("*Me*: I'm trying to avoid an S&M session with the interrogators in this");
        System.out.println("corrections facility. To do that, I need to get the hell out here, fast.");
        System.out.println("I must fight past the guards and make it to the prison exit.");
        System.out.println();
        System.out.println();
        System.out.println("*Me*: Why am I reminding myself what I need to do? It's not like I have dementia.");
        System.out.println();
        System.out.print("Commands: ");
        CommandWords.printValidCommands();
        System.out.println();
        System.out.println();

        System.out.println("Description:");
        System.out.println("Attack — Attacks the enemy");
        System.out.println("Diagnose — View health");
        System.out.println("Drop (Item) — Drops an item from the inventory");
        System.out.println("Examine (Item) — Prints the description and effects of an item");
        System.out.println("Go (north/south/east/west) — Move to the room in the direction specified");
        System.out.println("Help — Prints this info for all you noobs out there");
        System.out.println("Inventory — Lists the items in the inventory");
        System.out.println("Look — Prints a description of the room, along with the exits, items, and enemies in the room");
        System.out.println("Quit — Quits the game (Confirmation is required)");
        System.out.println("Rest — Increases regeneration for one turn");
        System.out.println("Take (Item) — Takes an item from the current room and places it in the inventory");
        System.out.println("Use (Item) — Uses an item");
        System.out.println();
        System.out.println("Please Note: This game is not case-sensitive");
    }

    /**
     * Prints the items in the player's inventory
     */
    private static void printInventory() {
        //Printing only items that are owned by the player and are unused
        System.out.print("Inventory: ");
        for (Item currentItem : ITEMS) {
            if (currentItem.getItemOwnership() && !currentItem.getItemUsed())
                System.out.print(currentItem.getItemName() + "  ");
        }
        System.out.println();
    }

    /**
     * Prints out the description of the Room the player is in along with its exits
     *
     * @param isLooking Whether or not the user entered the look command this turn
     */
    private static void printLocationInfo(boolean isLooking) {
        System.out.println("I am in *" + ROOMS[getCurrentRoomIndex()].getRoomName() + "*");

        //Print description of room if unvisited or using the look command and flag the room as visited
        if (!ROOMS[getCurrentRoomIndex()].getVisitStatus()) {
            System.out.println(ROOMS[getCurrentRoomIndex()].getRoomDescription());
            ROOMS[getCurrentRoomIndex()].setVisitStatus(true);
        } else if (isLooking) {
            System.out.println(ROOMS[getCurrentRoomIndex()].getRoomDescription());
        }
        System.out.println();

        //Print the exits if there is a Room in that direction
        System.out.print("Exits: ");
        if (ROOMS[getCurrentRoomIndex()].getNorthExit() != 0)
            System.out.print("north ");
        if (ROOMS[getCurrentRoomIndex()].getEastExit() != 0)
            System.out.print("east ");
        if (ROOMS[getCurrentRoomIndex()].getSouthExit() != 0)
            System.out.print("south ");
        if (ROOMS[getCurrentRoomIndex()].getWestExit() != 0)
            System.out.print("west");
        System.out.println();
    }

    /**
     * Prints the items and enemies in the Room the player is in
     */
    private static void printObjectsList() {
        //Checking room for items
        System.out.println();
        System.out.println("Items:");
        for (int i = 0; i < ITEMS.length; i++) {
            if (itemDetected(i))
                System.out.println("There is *" + ITEMS[i].getItemName() + "* here.");
        }

        //Checking room for active enemies
        System.out.println();
        System.out.println("Enemies:");
        for (int i = 1; i < CHARACTERS.length; i++) {
            if (enemyDetected(i))
                System.out.println("There is *" + CHARACTERS[i].getCharacterType() + "* here.");
        }
    }

    /**
     * Prints the welcome message for the game
     */
    private static void printWelcome() {
        System.out.println("Welcome to Jailbreak!");
        System.out.println("You are an inmate in a prison, captured after the fact that you're");
        System.out.println("not exactly human was exposed.");
        System.out.println("Type help if you're a noob.");
        ROOMS[getCurrentRoomIndex()].setVisitStatus(true);
        System.out.println();
        System.out.println();
        printLocationInfo(false);
    }

    /**
     * Executes commands inputted by the player. If this command ends the game,
     * true is returned, otherwise false is returned.
     *
     * @param command The Command inputted by the user
     * @return Whether or not the command ends the game
     */
    private static boolean processCommand(Command command) {
        boolean wantToQuit = false;
        String commandWord = command.getCommandWord();


        //Command is not recognized
        if (command.isUnknown()) {
            System.out.println("*Me*: Today's a really terrible day... I DON'T EVEN KNOW WHAT I'M TRYING TO DO!!!");
            return false;
        }

        //Interpreting command and executing it
        switch (commandWord) {
            case "help":
                printHelp();
                return false;
            case "go":
                goRoom(command);
                return false;
            case "quit":
                wantToQuit = quit();
                return wantToQuit;
            case "take":
                take(command);
                return false;
            case "drop":
                drop(command);
                return false;
            case "look":
                look();
                return false;
            case "inventory":
                printInventory();
                return false;
            case "diagnose":
                printCharacterStatus(0);
                System.out.println("*Me*: I never thought I would be grateful for my regenerative capabilities.");
                System.out.println("I would NOT enjoy a hospital stay right now.");
                return false;
            case "rest":
                rest();
                return false;
            case "examine":
                examineItem(command);
                return false;
            case "use":
                useItem(command);
                return false;
            case "attack": //Checking if there is an enemy to attack
                for (int i = 1; i < CHARACTERS.length; i++) {
                    if (enemyDetected(i)) {
                        playerAttack(i, -1);
                        return false;
                    }
                }

                //No enemy detected
                System.out.println("*Me*: Fight nothing but the air in front of me? Maybe I should see a shrink after I get out of here.");
                return false;
            default:
                return true;
        }
    }

    /**
     * Asks the user to confirm their quit action. Returns true if quitting the game
     *
     * @return Whether or not the command ends the game
     */
    private static boolean quit() {
        boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
        String choice;

        //Confirming quit action
        do {
            System.out.println("Do I really want to throw the towel in?(y/n)");
            System.out.print("> ");
            choice = userInput.nextLine().toLowerCase();

            if (choice.equals("y")) {
                validInput = true;
                System.out.println("Resigned to my fate, I walk back to my cell. It's not all bad...");
                System.out.println("I do have sometime to prepare for the upcoming 'session' with the");
                System.out.println("interrogators, afterall.");
                return true;
            } else if (choice.equals("n")) {
                validInput = true;
                System.out.println("*Me*: Nope. I ain't going down without a fight.");
                System.out.println("...Besides, I'm not some sort of masochist.");
                return false;
            }
        } while (!validInput);

        //Default
        return false;
    }

    /**
     * Returns a randomly generated number between the given minimum and maximum
     * values (inclusive)
     *
     * @param min The minimum acceptable value
     * @param max The maximum acceptable value
     * @return A randomly generated value
     */
    private static int randInt(int min, int max) {
        int range = max - min + 1;
        int num = (int) (Math.random() * range) + min;
        return num;
    }

    /**
     * Applies the regeneration heal to characters
     *
     * @param characterIndex The index of the Character object in the CHARACTERS array
     * @param isResting      Whether or not the user entered the rest command
     */
    private static void regenerate(int characterIndex, boolean isResting) {
        //Apply regeneration heal if the Character is not dead
        if (CHARACTERS[characterIndex].getHp() > 0) {
            int damageHealed = 0;

            //If resting, apply the resting regeneration heal, otherwise, apply the regular heal
            if (isResting) {
                damageHealed = randInt(CHARACTERS[characterIndex].getMinRestingRegen(), CHARACTERS[characterIndex].getMaxRestingRegen());
                CHARACTERS[characterIndex].setHp(CHARACTERS[characterIndex].getHp() + damageHealed);
            } else {
                damageHealed = randInt(CHARACTERS[characterIndex].getMinRegen(), CHARACTERS[characterIndex].getMaxRegen());
                CHARACTERS[characterIndex].setHp(CHARACTERS[characterIndex].getHp() + damageHealed);
            }

            //Set Character HP to its maximum if HP after regen exceeds maximum hitpoints
            if (CHARACTERS[characterIndex].getHp() > CHARACTERS[characterIndex].getMaxHp())
                CHARACTERS[characterIndex].setHp(CHARACTERS[characterIndex].getMaxHp());

            //Prints out regeneration dialogue
            System.out.println();
            if (damageHealed > 0) {
                if (CHARACTERS[characterIndex].getCharacterId().equals("Player"))
                    System.out.println("I regenerated " + damageHealed + " HP.");
                else if (CHARACTERS[0].getCharacterLocation() == CHARACTERS[characterIndex].getCharacterLocation())
                    System.out.println("*" + CHARACTERS[characterIndex].getCharacterType() + "* regenerated " + damageHealed + " HP.");
            }
        }
    }

    /**
     * Player rests to regenerate more HP than usual
     */
    private static void rest() {
        //Why would you rest if at maximum HP?
        if (CHARACTERS[0].getHp() == CHARACTERS[0].getMaxHp())
            System.out.println("*Me*: WHY ON EARTH AM I WASTING MORE TIME IN THIS HELL HOLE?!!!");

        else
            System.out.println("*Me*: Phew. I was wondering when I could catch a breath.");
    }

    /**
     * Takes an item and puts it in the player's inventory
     *
     * @param command The Command that the user entered
     */
    private static void take(Command command) {
        boolean itemExists;
        int i;

        //What item should be taken?
        if (!command.hasArgumentWord()) {
            System.out.println("*Me*: And what exactly do I even want to take?");
        } else {
            itemExists = false;

            //Checking if the item is a valid in-game item and is in the room the player is in
            for (i = 0; i < ITEMS.length; i++) {
                if (validItem(i, command) && itemDetected(i)) {
                    itemExists = true;
                    break;
                }
            }

            if (itemExists) {
                ITEMS[i].setItemOwnership(true);
                System.out.println("Picked up *" + ITEMS[i].getItemName() + "*.");
            } else
                System.out.println("*Me*: What on earth am I trying to pick up?!!");
        }
    }

    /**
     * Player uses the Med Kit to heal HP
     *
     * @param itemIndex The index of the Med Kit being used in the ITEMS array
     */
    private static void useMedKit(int itemIndex) {
        //Med Kit is useless when at full HP
        if (CHARACTERS[0].getHp() == CHARACTERS[0].getMaxHp()) {
            System.out.println("*Me*: Why am I bothering to fix what's not broken?");
        } else {
            //Flag item as used and update player HP
            ITEMS[itemIndex].setItemUsed(true);
            CHARACTERS[0].setHp(CHARACTERS[0].getHp() + ITEMS[itemIndex].getItemHpRecovered());

            //Set player's HP at maximum HP if HP exceeds the maximum value after heal
            if (CHARACTERS[0].getHp() > CHARACTERS[0].getMaxHp())
                CHARACTERS[0].setHp(CHARACTERS[0].getMaxHp());

            System.out.println("Used *" + ITEMS[itemIndex].getItemName() + "*");
            System.out.println("Regenerated " + ITEMS[itemIndex].getItemHpRecovered() + " HP");
        }
    }

    /**
     * Interprets the use command entered by the user and executes the appropriate methods
     *
     * @param command The Command inputted by the user
     */
    private static void useItem(Command command) {
        boolean ammoExists;
        int magazineIndex;

        //What item should be used?
        if (!command.hasArgumentWord()) {
            System.out.println("*Me*: I don't even know what I want to use.");
            return;
        }

        //Checking the validity of the item being used and executing appropriate methods if valid
        for (int i = 0; i < ITEMS.length; i++) {
            if (validItem(i, command) && ITEMS[i].getItemOwnership() && !ITEMS[i].getItemUsed()) {
                switch (ITEMS[i].getItemName()) {
                    case "Med Kit":
                        useMedKit(i);
                        return;
                    case "Carbine":
                        ammoExists = false;

                        //Checking if the player has ammo in his inventory
                        for (magazineIndex = 0; magazineIndex < ITEMS.length; magazineIndex++) {
                            if (ITEMS[magazineIndex].getItemName().equals("Carbine Magazine") && ITEMS[magazineIndex].getItemOwnership() && !ITEMS[magazineIndex].getItemUsed()) {
                                ammoExists = true;
                                break;
                            }
                        }

                        if (ammoExists) {
                            //Checking if the player is in combat with an enemy
                            for (int j = 1; j < CHARACTERS.length; j++) {
                                if (enemyDetected(j)) {
                                    playerAttack(j, i);
                                    ITEMS[magazineIndex].setItemUsed(true);
                                    return;
                                }
                            }

                            System.out.println("*Me*: Why would I waste the little ammunition I have?");
                            System.out.println("I'm not some sort of masochist, am I?");
                            return;
                        } else {
                            System.out.println("*Me*: I don't think air counts as ammo.");
                            return;
                        }
                    case "Carbine Magazine":
                        System.out.println("*Me*: Well, I don't think throwing the magazines will do much...");
                        System.out.println("Except maybe make my life harder than it already is.");
                        return;
                    case "Exit Pass":
                        System.out.println("*Me*: I just need to keep this on me.");
                        return;
                    default:
                        return;
                }
            }
        }

        //The item being used is not valid
        System.out.println("*Me*: I can't use something that doesn't even exist!!!");
    }

    /**
     * Checks if the item argument entered by the player is valid
     *
     * @param itemIndex The index of the Item being checked in the ITEMS array
     * @param command   The Command inputted by the player
     * @return boolean Whether or not the Item is a valid in-game item
     */
    private static boolean validItem(int itemIndex, Command command) {
        return (ITEMS[itemIndex].getItemName().toLowerCase().equals(command.getArgumentWord()));
    }
}