package atlantadragons.gatech.spacetrader.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Resource {
    WATER("Water", 80, 4, 3),
    FUR("Fur", 250, 7, 8),
    FOOD("Food", 100, 5, 6),
    ORE("Ore", 350, 1, 2),
    GAMES("Games", 250, 11, -1),
    FIREARMS("Firearms", 1250, 12, -1),
    MEDICINE("Medicine", 650, 10, 1),
    MACHINES("Machines", 900, -1, -1),
    NARCOTICS("Narcotics", 3500, 9, -1),
    ROBOTS("Robots", 5000, -1, -1);

    private String name;
    private double price;
    private int increaseType;
    private int decreaseType;

    Resource(String name, int price, int decreaseType, int increaseType) {
        this.name = name;
        this.price = price;
        this.decreaseType = decreaseType;
        this.increaseType = increaseType;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getIncreaseType() { return increaseType; }

    public int getDecreaseType() {
        return decreaseType;
    }
}

