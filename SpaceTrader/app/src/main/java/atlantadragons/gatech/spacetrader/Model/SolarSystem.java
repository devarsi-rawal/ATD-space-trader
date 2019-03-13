package atlantadragons.gatech.spacetrader.Model;

import java.util.List;

public class SolarSystem {

    private String name;

    private int xCoord;
    private int yCoord;

    private List<Planet> planetList;

    public static final String[] solarSystemNames =
            {
                    "Adahn",
                    "Brax",
                    "Capelle",
                    "Draylon",
                    "Frolix",
                    "Hades",
                    "Korma",
                    "Omega",
                    "Utopia",
                    "Zuul"

            };

    public SolarSystem(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void addPlanet(Planet planet) {
        planetList.add(planet);
    }

    public String getName() { return name; }

    public List<Planet> getPlanetList() { return planetList; }

    public String toString() {
        return String.format("Solar System: %s @ coordinates: (%d, %d) with planets: %s", name, xCoord, yCoord, planetList.toString());
    }
}
