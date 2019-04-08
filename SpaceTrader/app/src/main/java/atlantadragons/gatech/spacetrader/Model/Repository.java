package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

class Repository {

    private Game currentGame;

    private List<Game> games;

    public Repository() {
        games = new ArrayList<>();
    }

    public Game getCurrentGame() { return currentGame; }

    public void addGame(Game game) {
        currentGame = game;
        games.add(game);
    }
}
