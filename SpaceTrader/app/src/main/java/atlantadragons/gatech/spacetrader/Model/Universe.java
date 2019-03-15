package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

public class Universe {

    private List<SolarSystem> universe = new ArrayList<>();
    private SolarSystem currentSolarSystem;

    public Universe() {
        universe.add(new SolarSystem("Adahn", 1, 10));
        universe.add(new SolarSystem("Brax", 89, 12));
        universe.add(new SolarSystem("Capelle", 140, 80));
        universe.add(new SolarSystem("Draylon", 94, 26));
        universe.add(new SolarSystem("Frolix", 32, 74));
        universe.add(new SolarSystem("Hades", 50, 50));
        universe.add(new SolarSystem("Korma", 22, 40));
        universe.add(new SolarSystem("Omega", 0, 0));
        universe.add(new SolarSystem("Utopia", 132, 62));
        universe.add(new SolarSystem("Zuul", 69, 69));

        currentSolarSystem = universe.get((int) (Math.random() * 9));
    }

    public List<String> getPlanetNames() {
        List<String> names = new ArrayList<>();
        for (SolarSystem s : universe) {
            names.add(s.getName());
        }
        return names;
    }
    public String getCurrentPlanetName() {
        return currentSolarSystem.getName();
    }

    public int getxCoord() {
        return currentSolarSystem.getxCoord();
    }

    public int getyCoord() {
        return currentSolarSystem.getyCoord();
    }

    public TechLevel getTechLevel() {
        return currentSolarSystem.getTechLevel();
    }

    public PlanetResourceType getResourceType() {
        return currentSolarSystem.getResourceType();
    }

    public List<List<Double>> getMarketPrices() {
        return currentSolarSystem.getMarketPrices();
    }

    public List<List<Integer>> getMarketStock() {
        return currentSolarSystem.getMarketStock();
    }

    public void buyGood(Resource resource, int quantity) {
        currentSolarSystem.buyGood(resource, quantity);
    }

    public void sellGood(Resource resource, int quantity) {
        currentSolarSystem.sellGood(resource, quantity);
    }

    public String toString() {
        return universe.toString();
    }
}
