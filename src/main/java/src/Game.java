package src;

public class Game {
    private static Game game = new Game();

    private Game() {
    }

    public static Game getGame() {
        return game;
    }
}
