package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    private String name;

    private int xCoord;
    private int yCoord;

    private List<Planet> planetList = new ArrayList<>();

    public SolarSystem(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        planetList.add(new Planet(name, TechLevel.randomTechLevel(), PlanetResourceType.randomResourceType()));
    }

    public void addPlanet(Planet planet) {
        planetList.add(planet);
    }

    public String getName() { return name; }

    public List<String> getPlanetNames() {
        List<String> names = new ArrayList<>();
        for (Planet p : planetList) {
            names.add(p.getName());
        }
        return names;
    }

    public void buyGood(Resource resource, int quantity) {
        planetList.get(0).buyGood(resource, quantity);
    }

    public void sellGood(Resource resource, int quantity) {
        planetList.get(0).sellGood(resource, quantity);
    }

    public String toString() {
        return String.format("Solar System: %s @ coordinates: (%d, %d) with planets: %s", name, xCoord, yCoord, planetList.toString());
    }
}
