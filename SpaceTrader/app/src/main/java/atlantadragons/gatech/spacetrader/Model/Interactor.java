package atlantadragons.gatech.spacetrader.Model;

import java.util.List;

public class Interactor {

    private Repository repo;

    public Interactor(Repository repo) {
        this.repo = repo;
    }

    public void addGame(Game game) {
        repo.addGame(game);
    }

    private Game getCurrentGame() {
        return repo.getCurrentGame();
    }

    public List<List<Double>> getMarketPrices() {
        return getCurrentGame().getMarketPrices();
    }

    public List<List<Integer>> getMarketStock() {
        return getCurrentGame().getMarketStock();
    }

    public void buyGood(Resource resource, int quantity, double cost) {
        getCurrentGame().buyGood(resource, quantity, cost);
    }

    public void sellGood(Resource resource, int quantity, double cost) {
        getCurrentGame().sellGood(resource, quantity, cost);
    }

    public double getCredits() {
        return getCurrentGame().getCredits();
    }

    public void loseCredits(double d) {
        getCurrentGame().loseCredits(d);
    }

    public void earnCredits(double d) {
        getCurrentGame().earnCredits(d);
    }

    public List<Integer> getCargoStock() { return getCurrentGame().getCargoStock(); }

    public int getShipGoodsCount() {
        return getCurrentGame().getShipGoodsCount();
    }

    public int getShipCapacity() {
        return getCurrentGame().getShipCapacity();
    }

    public double getShipFuelRemaining() {return getCurrentGame().getShipFuelRemaining();}

    public void setShipFuelRemaining(double d) {getCurrentGame().setShipFuelRemaining(d);}

    public Universe getUniverse() { return getCurrentGame().getUniverse(); }

    public List<String> getPlanetNames() {
        return getCurrentGame().getPlanetNames();
    }

}
