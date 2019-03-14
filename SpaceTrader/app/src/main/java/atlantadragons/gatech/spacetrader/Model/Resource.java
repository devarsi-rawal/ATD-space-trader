package atlantadragons.gatech.spacetrader.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Resource {
    WATER("Water", 80),
    FUR("Fur", 250),
    FOOD("Food", 100),
    ORE("Ore", 350),
    GAMES("Games", 250),
    FIREARMS("Firearms", 1250),
    MEDICINE("Medicine", 650),
    MACHINES("Machines", 900),
    NARCOTICS("Narcotics", 3500),
    ROBOTS("Robots", 5000);

    private String name;
    private double price;

    Resource(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

}

