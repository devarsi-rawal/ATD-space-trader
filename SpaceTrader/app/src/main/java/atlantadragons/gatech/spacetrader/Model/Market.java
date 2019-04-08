package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

class Market {


    private List<Integer> stock = new ArrayList<>();
    private List<Double> prices = new ArrayList<>();

    public Market(TechLevel techLevel, PlanetResourceType resourceType) {
        for (Resource r : Resource.values()) {
            stock.add(100);
            prices.add(r.getPrice());
        }
    }

    public List<Integer> getStock() { return stock; }
    public List<Double> getPrices() { return prices; }

    public double getPriceOf(Resource resource) {
        return prices.get(resource.ordinal());
    }

    public int getStockOf(Resource resource) {
        return stock.get(resource.ordinal());
    }

    public void setQuantityOf(Resource resource, int quantity) {
        stock.set(resource.ordinal(), quantity);
    }

}
