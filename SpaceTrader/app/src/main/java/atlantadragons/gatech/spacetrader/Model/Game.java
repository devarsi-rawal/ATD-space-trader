package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

import static atlantadragons.gatech.spacetrader.Model.Planet.planetNames;

public class Game {

    private GameMode gameMode;
    private Player player;
    public Universe universe;

    private Planet currentPlanet;

    public Game (GameMode gameMode, Player player) {
        this.gameMode = gameMode;
        this.player = player;
        universe = new Universe();
    }

    public Universe getUniverse() {
        return universe;
    }

    public List<Integer> getStock() {
        return player.
    }

    public String toString() {
        String string = "";
        string = player.toString() + "\n" +
                "Difficulty: " + gameMode.toString() + "\n" +
                universe.toString();
        return string;
    }
}
