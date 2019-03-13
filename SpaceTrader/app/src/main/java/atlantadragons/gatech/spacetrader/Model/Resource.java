package atlantadragons.gatech.spacetrader.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Resource {
    WATER("Water", 0, 0, 0, 2, 30, 3, 4, PlanetResourceType.LOTSOFWATER, PlanetResourceType.DESERT, 30, 35),
    FUR("Fur", 1, 0, 0, 0, 250, 10, 10, PlanetResourceType.RICHFAUNA, PlanetResourceType.LIFELESS, 230, 250),
    FOOD("Food", 2, 1, 0, 1, 100, 5, 5, PlanetResourceType.RICHSOIL, PlanetResourceType.POORSOIL, 90, 120),
    ORE("Ore", 3, 2, 2, 3, 350, 20, 10, PlanetResourceType.MINERALRICH, PlanetResourceType.MINERALPOOR, 350, 400),
    GAMES("Games", 4, 3, 1, 6, 250, -10, 5, PlanetResourceType.ARTISTIC, null, 160, 170),
    FIREARMS("Firearms", 5, 3, 1, 5, 1250, -75, 100, PlanetResourceType.WARLIKE, null, 600, 800),
    MEDICINE("Medicine", 6, 4, 1, 6, 650, -20, 10, PlanetResourceType.LOTSOFHERBS, null, 400, 600),
    MACHINES("Machines", 7, 4, 3, 5, 900, -30, 5, null, null, 600, 650),
    NARCOTICS("Narcotics", 8, 5, 0, 5, 3500, -125, 150, PlanetResourceType.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS("Robots", 9, 6, 4, 7, 5000, -150, 100, null, null, 3500, 4000);

    private String name;
    private int id;
    private int minBuyLevel, minSellLevel, freqTechLevel, basePrice, priceIncrease, variance;
    private PlanetResourceType cheapEvent, expensiveEvent;
    private int minSpaceOffer, maxSpaceOffer;
    private final List<Resource> VALUES = Arrays.asList(Resource.values());

    Resource(String name, int id, int minBuyLevel, int minSellLevel, int freqTechLevel, int basePrice, int priceIncrease, int variance, 
             PlanetResourceType cheapEvent, PlanetResourceType expensiveEvent, int minSpaceOffer, int maxSpaceOffer) {
        this.name = name;
        this.id = id;
        this.minBuyLevel = minBuyLevel;
        this.minSellLevel = minSellLevel;
        this.freqTechLevel = freqTechLevel;
        this.basePrice = basePrice;
        this.priceIncrease = priceIncrease;
        this.variance = variance;
        this.cheapEvent = cheapEvent;
        this.expensiveEvent = expensiveEvent;
        this.minSpaceOffer = minSpaceOffer;
        this.maxSpaceOffer = maxSpaceOffer;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getMinBuyLevel() { return minBuyLevel; }
    public int getMinSellLevel() { return minSellLevel; }
    public int getFreqTechLevel() { return freqTechLevel; }
    public int getBasePrice() { return basePrice; }
    public int getPriceIncrease() { return priceIncrease; }
    public int getVariance() { return variance; }
    public PlanetResourceType getCheapEvent() { return cheapEvent; }
    public PlanetResourceType getExpensiveEvent() { return expensiveEvent; }
    public int getMinSpaceOffer() { return minSpaceOffer; }
    public int getMaxSpaceOffer() { return maxSpaceOffer; }

    public Resource randomResource() {
        return VALUES.get((new Random()).nextInt(VALUES.size()));
    }
}
