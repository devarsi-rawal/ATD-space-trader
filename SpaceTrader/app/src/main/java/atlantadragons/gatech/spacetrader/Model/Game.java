package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

import static atlantadragons.gatech.spacetrader.Model.Planet.planetNames;
import static atlantadragons.gatech.spacetrader.Model.SolarSystem.solarSystemNames;

public class Game {

    private GameMode gameMode;
    private Player player;
    public static List<SolarSystem> universe = new ArrayList<>();
    private static Planet currentPlanet;

    private static final int X_MAX = 150;
    private static final int Y_MAX = 100;

    private static int[][] gameBoard = new int[X_MAX][Y_MAX];

    public static void createUniverse() {
        for (int i = 0; i <= 10; i++) {
            int xCoord = -1;
            int yCoord = -1;
            while (gameBoard[xCoord][yCoord] == 0) {
                xCoord = (int) (Math.random() * X_MAX);
                yCoord = (int) (Math.random() * Y_MAX);
            }
            gameBoard[xCoord][yCoord] = -1;
            new SolarSystem("Name", xCoord, yCoord);
            universe.add(new SolarSystem(solarSystemNames[i], xCoord, yCoord));
            for (int j = 0; j < (int) (Math.random() * 5); i++) {
                String name = planetNames[(int) (Math.random() * planetNames.length)];
                TechLevel techLevel = TechLevel.randomTechLevel();
                PlanetResourceType resourceType = PlanetResourceType.randomResourceType();
                Planet planet = new Planet(name, techLevel, resourceType, universe.get(i));
                universe.get(i).addPlanet(planet);
            }

        }
        currentPlanet = universe.get(0).getPlanetList().get(0);
    }

    public void setCurrentPlanet(Planet planet) { currentPlanet = planet; }

}
