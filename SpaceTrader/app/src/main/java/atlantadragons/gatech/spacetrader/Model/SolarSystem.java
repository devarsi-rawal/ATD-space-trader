package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    private String name;

    private int xCoord;
    private int yCoord;

    private ArrayList<Planet> planetList = new ArrayList<>();

    public SolarSystem(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        planetList.add(new Planet(name, TechLevel.randomTechLevel(),
                PlanetResourceType.randomResourceType()));
    }

    public void addPlanet(Planet planet) {
        planetList.add(planet);
    }

    public String getName() {
        return name;
    }
    public int getxCoord() {
        return xCoord;
    }
    public int getyCoord() {
        return yCoord;
    }
    public TechLevel getTechLevel() {
        return planetList.get(0).getTechLevel();
    }
    public PlanetResourceType getResourceType() {
        return planetList.get(0).getResourceType();
    }
    public ArrayList<Planet> getPlanetList() {return planetList;}
    public List<String> getPlanetNames() {
        List<String> names = new ArrayList<>();
        for (Planet p : planetList) {
            names.add(p.getName());
        }
        return names;
    }

    public List<List<Double>> getMarketPrices() {
        List<List<Double>> list = new ArrayList<>();
        for (Planet p : planetList) {
            list.add(p.getMarketPrices());
        }
        return list;
    }

    public List<List<Integer>> getMarketStock() {
        List<List<Integer>> list = new ArrayList<>();
        for (Planet p : planetList) {
            list.add(p.getMarketStock());
        }
        return list;
    }

    public void buyGood(Resource resource, int quantity) {
        planetList.get(0).buyGood(resource, quantity);
    }

    public void sellGood(Resource resource, int quantity) {
        planetList.get(0).sellGood(resource, quantity);
    }

    public String toString() {
        return String.format("Solar System: %s @ coordinates: (%d, %d) with planets: %s",
                name, xCoord, yCoord, planetList.toString());
    }
}
