/**
 * Used to Illustrate Abstract Methods.
 */
public class Game {

    public static void main(String[] args) {
        Potion potion = new Potion();
        Scroll scroll = new Scroll();
        //MagicGameElement element = new MagicGameElement();

        potion.use();
        scroll.use();
    }
}
