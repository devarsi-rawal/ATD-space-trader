package atlantadragons.gatech.spacetrader.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum TechLevel {
    PRE_AGRICULTURAL("Pre-agricultural", 0),
    AGRICULTURAL("Agricultural", 1),
    MEDIEVAL("Medieval", 2),
    RENAISSANCE("Renaissance", 3),
    EARLY_INDUSTRIAL("Early Industrial", 4),
    INDUSTRIAL("Industrial", 5),
    POST_INDUSTRIAL("Post-Industrial", 6),
    HI_TECH("Hi-Tech", 7);

    private String levelName;
    private int level;
    private static final List<TechLevel> VALUES = Arrays.asList(values());

    TechLevel(String levelName, int level) {
        this.levelName = levelName;
        this.level = level;
    }

    public String getLevelName() { return levelName; }
    public int getLevel() { return level; }

    public static TechLevel randomTechLevel() {
        return VALUES.get((new Random()).nextInt(VALUES.size()));
    }
}


