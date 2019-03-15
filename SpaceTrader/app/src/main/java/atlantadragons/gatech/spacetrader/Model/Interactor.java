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

    public Game getCurrentGame() {
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

    public void getCredits() {
        getCurrentGame().getCredits();
    }

    public int getShipGoodsCount() {
        return getCurrentGame().getShipGoodsCount();
    }

    public int getShipCapacity() {
        return getCurrentGame().getShipCapacity();
    }

    public Universe getUniverse() {
        return getCurrentGame().getUniverse();
    }

    public List<String> getPlanetNames() {
        return getCurrentGame().getPlanetNames();
    }
}
