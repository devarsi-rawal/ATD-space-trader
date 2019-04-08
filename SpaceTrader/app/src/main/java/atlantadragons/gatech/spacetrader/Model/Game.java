package atlantadragons.gatech.spacetrader.Model;

import java.util.List;



public class Game {

    private final GameMode gameMode;
    private final Player player;
    private final Universe universe;

    private Planet currentPlanet;

    public Game (GameMode gameMode, Player player) {
        this.gameMode = gameMode;
        this.player = player;
        universe = new Universe();
    }

    public Universe getUniverse() {
        return universe;
    }

    public List<String> getPlanetNames() {
        return universe.getPlanetNames();
    }

    public List<List<Double>> getMarketPrices() {
        return universe.getMarketPrices();
    }

    public List<List<Integer>> getMarketStock() {
        return universe.getMarketStock();
    }

    public void buyGood (Resource resource, int quantity, double cost) {
        universe.buyGood(resource, quantity);
        player.buyGood(resource, quantity, cost);
    }

    public void sellGood (Resource resource, int quantity, double cost) {
        universe.sellGood(resource, quantity);
        player.sellGood(resource, quantity, cost);
    }

    public double getCredits() {
        return player.getCredits();
    }

    public List<Integer> getCargoStock() {return player.getCargoStock(); }

    public int getShipGoodsCount() {
        return player.getShipGoodsCount();
    }

    public int getShipCapacity() { return player.getShipCapacity(); }

    public double getShipFuelRemaining() { return player.getShipFuelRemaining(); }

    public void setShipFuelRemaining(double d) {
        player.setShipFuelRemaining(d);
    }

    public void loseCredits(double d) {
        player.setCredits(player.getCredits() - d);
    }

    public void earnCredits(double d) {
        player.setCredits(player.getCredits() + d);
    }

    public String toString() {
        String string = "";
        string = player.toString() + "\n" +
                "Difficulty: " + gameMode.toString() + "\n" +
                universe.toString();
        return string;
    }
}
