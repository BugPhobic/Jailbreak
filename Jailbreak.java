/**
 * This is the main class of the "Jailbreak" game. It creates an instance of
 * the game environment and starts the game
 *
 * @author Sam Grace Saji
 * @version 3.0
 * @since 2018-06-04
 */
public class Jailbreak {
    public static void main
            (String[] args) {
        //Create an instance of the game environment
        Game game = new Game();

        //Start playing the game
        game.play();
    }
}