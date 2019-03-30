package atlantadragons.gatech.spacetrader.Model;

import android.widget.Space;

public enum SpaceshipType {
    GNAT("Gnat", 0, 100, 100),
    FLEA("Flea", 1, 100, 100),
    FIREFLY("Firefly", 2, 100, 100),
    MOSQUITO("Mosquito", 3, 100, 100),
    BUMBLEBEE("Bumblebee", 4, 100, 100),
    BEETLE("Beetle", 5, 100, 100),
    HORNET("Hornet", 6, 100, 100),
    GRASSHOPPER("Grasshopper", 7, 100, 100),
    TERMITE("Termite", 8, 100, 100),
    WASP("Wasp", 9, 100, 100);

    private String name;
    private int level;
    private int cargoCapacity;
    private double fuel;

    SpaceshipType (String name, int level, int cargoCapacity, double fuel) {
        this.name = name;
        this.level = level;
        this.cargoCapacity = cargoCapacity;
        this.fuel = fuel;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCargoCapacity() { return cargoCapacity; }
    public double getFuel() { return fuel; }
}
