package atlantadragons.gatech.spacetrader;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

public class ConfigurationViewModel extends AndroidViewModel {
    Player player;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean setPlayer(Player p) {
        //check if input is good
        int total = p.getEngineer() + p.getFighter() + p.getPilot() + p.getTrader();

        //if good, update player and move to next screen and return true
        //else return false
        if (total == 16) {
            this.player = p;
            Log.d("APP", "New Player created: " + p.toString());
            return true;
        }

        return false;
    }

    public Player getPlayer() {
        return player;
    }
}
