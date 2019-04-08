package atlantadragons.gatech.spacetrader.Model;

import java.util.Arrays;
import java.util.List;

public enum PlanetResourceType {
    NOSPECIALRESOURCES("No Special Resources", 0),
    MINERALRICH("Mineral Rich", 1),
    MINERALPOOR("Mineral Poor", 2),
    DESERT("Desert", 3),
    LOTSOFWATER("Lots of Water", 4),
    RICHSOIL("Rich Soil", 5),
    POORSOIL("Poor Soil", 6),
    RICHFAUNA("Rich Fauna", 7),
    LIFELESS("Lifeless", 8),
    WEIRDMUSHROOMS("Weird Mushrooms", 9),
    LOTSOFHERBS("Lots of Herbs", 10),
    ARTISTIC("Artistic", 11),
    WARLIKE("Warlike", 12);

    private String name;
    private int id;
    private static final List<PlanetResourceType> VALUES = Arrays.asList(PlanetResourceType.values());

    PlanetResourceType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static PlanetResourceType randomResourceType() {
        int randInt = (int) (Math.random() * 100);
        if (randInt < 20) { return NOSPECIALRESOURCES; }
        else if (randInt >= 30 && randInt < 40) { return MINERALRICH; }
        else if (randInt >= 40 && randInt < 50) { return MINERALPOOR; }
        else if (randInt >= 50 && randInt < 60) { return DESERT; }
        else if (randInt >= 60 && randInt < 70) { return LOTSOFWATER; }
        else if (randInt >= 70 && randInt < 75) { return RICHFAUNA; }
        else if (randInt >= 75 && randInt < 80) { return LIFELESS; }
        else if (randInt >= 80 && randInt < 85) { return WEIRDMUSHROOMS; }
        else if (randInt >= 85 && randInt < 90) { return LOTSOFHERBS; }
        else if (randInt >= 90 && randInt < 95) { return ARTISTIC; }
        else { return WARLIKE; }
    }

    public String getName() { return name; }
    public int getId() { return id; }
}
