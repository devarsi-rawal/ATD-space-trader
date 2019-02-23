package atlantadragons.gatech.spacetrader;

import java.util.Arrays;
import java.util.List;

public class Player {

    public static List<String> legalGameModes = Arrays.asList("Beginner", "Easy", "Medium", "Hard", "Impossible");

    private String name;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;

    private String mode;

    public Player(String name, int pilot, int fighter, int trader, int engineer, String mode) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        this.mode = mode;
    }

    public String getName() { return name;}
    public int getPilot() {return pilot;}
    public int getFighter(){return fighter;}
    public int getTrader(){return trader;}
    public int getEngineer(){return engineer;}
    public String getMode(){return mode;}

    public void setName(String str) {this.name = str;}
    public void setPilot(int n) {this.pilot = n;}
    public void setFighter(int n) {this.fighter = n;}
    public void setTrader(int n) {this.trader = n;}
    public void setEngineer(int n) {this.engineer = n;}
    public void setMode(String m) {this.mode = m;}

    public String toString() {
        return String.format("Player name: %s, pilot: %d, fighter: %d, trader: %d, engineer: %d, game mode: %s", name, pilot, fighter, trader, engineer, mode);
    }


}
