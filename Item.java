/**
 * This class is a template for all the items that are created in the game
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-10
 */
public class Item {
    private final boolean KEY_ITEM;
    private final int HP_RECOVERED;
    private final int MAX_DMG;
    private final int MIN_DMG;
    private final String ITEM_DESCRIPTION;
    private final String ITEM_EFFECT;
    private final String ITEM_NAME;
    private boolean itemOwnership;
    private boolean itemUsed;
    private int itemLocation;

    //Constructors

    /**
     * Constructor (Given no parameters)
     */
    public Item() {
        KEY_ITEM = false;
        ITEM_NAME = "null";
        ITEM_DESCRIPTION = "null";
        ITEM_EFFECT = "null";
        itemLocation = 0;
        MAX_DMG = -1;
        MIN_DMG = -1;
        HP_RECOVERED = -1;
        itemOwnership = false;
        itemUsed = false;
    }

    /**
     * Constructor (Given all parameters)
     * Creates an item and places it in a room in the game.
     *
     * @param keyItem         Whether or not the item is a key item
     * @param name            The name of the item
     * @param description     A description of the physical appearance of the item
     * @param usedDescription A description of the effects of the item
     * @param location        The roomNum of the room in which the item exists
     * @param maximumDamage   The maximum damage that can be dealt if item is used
     * @param minimumDamage   The minimum damage that can be dealt if item is used
     * @param hpRecovered     The HP recovered when if item is used
     * @param status          Whether or not the player has picked up the item
     */
    public Item(boolean keyItem, String name, String description, String usedDescription, int location, int maximumDamage, int minimumDamage, int hpRecovered, boolean status) {
        KEY_ITEM = keyItem;
        ITEM_NAME = name;
        ITEM_DESCRIPTION = description;
        ITEM_EFFECT = usedDescription;
        MAX_DMG = maximumDamage;
        MIN_DMG = minimumDamage;
        HP_RECOVERED = hpRecovered;
        itemLocation = location;
        itemOwnership = status;
        itemUsed = false;
    }

    /**
     * Constructor (Given object)
     * Creates a duplicate item and places it in the same room
     *
     * @param object An instance of the Item class
     */
    public Item(Item object) {
        this.KEY_ITEM = object.KEY_ITEM;
        this.ITEM_NAME = object.ITEM_NAME;
        this.ITEM_DESCRIPTION = object.ITEM_DESCRIPTION;
        this.ITEM_EFFECT = object.ITEM_EFFECT;
        this.MAX_DMG = object.MAX_DMG;
        this.MIN_DMG = object.MIN_DMG;
        this.HP_RECOVERED = object.HP_RECOVERED;
        this.itemLocation = object.itemLocation;
        this.itemOwnership = object.itemOwnership;
        this.itemUsed = object.itemUsed;
    }

    //Mutators

    /**
     * Define the roomNum of the room in which the item exists
     *
     * @param location The roomNum of the room in which the item exists
     */
    public void setItemLocation(int location) {
        itemLocation = location;
    }

    /**
     * Define whether or not the item has been picked up
     *
     * @param status Whether or not the item has been picked up
     */
    public void setItemOwnership(boolean status) {
        itemOwnership = status;
    }

    /**
     * Define whether or not the item has been used
     *
     * @param status Whether or not the item has been used
     */
    public void setItemUsed(boolean status) {
        itemUsed = status;
    }

    //Accessors

    /**
     * Returns whether or not the item is a key item
     *
     * @return Whether or not the item is a key item
     */
    public boolean getKeyItem() {
        return KEY_ITEM;
    }

    /**
     * Returns a description of the physical appearance of the item
     *
     * @return Description of the physical appearance of the item
     */
    public String getItemDescription() {
        return ITEM_DESCRIPTION;
    }

    /**
     * Returns a description of the effects of using this item
     *
     * @return Effects of using this item
     */
    public String getItemEffect() {
        return ITEM_EFFECT;
    }

    /**
     * Returns the HP that can be recovered using the item
     *
     * @return HP that can be recovered using the item
     */
    public int getItemHpRecovered() {
        return HP_RECOVERED;
    }

    /**
     * Returns the roomNum of the room in which the item is located
     *
     * @return The roomNum of the room in which the item exists
     */
    public int getItemLocation() {
        return itemLocation;
    }

    /**
     * Returns the maximum damage that can be dealt using the item
     *
     * @return Maximum damage that can be dealt using the item
     */
    public int getItemMaxDmg() {
        return MAX_DMG;
    }

    /**
     * Returns the minimum damage that can be dealt using the item
     *
     * @return Minimum damage that can be dealt using the item
     */
    public int getItemMinDmg() {
        return MIN_DMG;
    }

    /**
     * Returns the name of the item
     *
     * @return Name of the item
     */
    public String getItemName() {
        return ITEM_NAME;
    }

    /**
     * Returns whether or not the item has been picked up
     *
     * @return Whether or not the item has been picked up
     */
    public boolean getItemOwnership() {
        return itemOwnership;
    }

    /**
     * Returns whether or not the item has been used
     *
     * @return Whether or not the item has been used
     */
    public boolean getItemUsed() {
        return itemUsed;
    }
}