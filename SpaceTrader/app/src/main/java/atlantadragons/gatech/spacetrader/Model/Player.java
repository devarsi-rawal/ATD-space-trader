package atlantadragons.gatech.spacetrader.Model;

import android.widget.Space;

import java.util.Arrays;
import java.util.List;

public class Player {

    private String name;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private Spaceship spaceship;

    private int credits;

    public Player(String name, int pilot, int fighter, int trader, int engineer) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        credits = 1000;
        spaceship = new Spaceship();
    }

    public String getName() { return name;}
    public int getPilot() {return pilot;}
    public int getFighter(){return fighter;}
    public int getTrader(){return trader;}
    public int getEngineer(){return engineer;}

    public void setName(String str) {this.name = str;}
    public void setPilot(int n) {this.pilot = n;}
    public void setFighter(int n) {this.fighter = n;}
    public void setTrader(int n) {this.trader = n;}
    public void setEngineer(int n) {this.engineer = n;}

    public String toString() {
        return String.format("Player name: %s, " +
                "pilotPoints: %d, " +
                "fighterPoints: %d, " +
                "traderPoints: %d, " +
                "engineerPoints: %d, " +
                "credits: %d, " +
                "spaceship: %s",
                name, pilot, fighter, trader, engineer, credits, spaceship.getSpaceshipType().getName());
    }


}
