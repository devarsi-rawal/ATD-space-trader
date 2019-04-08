package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import atlantadragons.gatech.spacetrader.Model.Game;
import atlantadragons.gatech.spacetrader.Model.GameMode;
import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.Player;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;

public class ConfigurationViewModel extends AndroidViewModel {
    Player player;
    Game game;
    private Interactor interactor;
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        interactor = RepoHolder.getHolder().getInteractor();
    }

    public boolean setGame(String name, int engineer, int fighter, int pilot, int trader, GameMode mode) {
        //check if input is good
        int total = engineer + fighter + pilot + trader;

        //if good, update player and move to next screen and return true
        //else return false
        if (total == 16) {
            this.player = new Player(name, engineer, fighter, pilot, trader);
            game = new Game (mode, player);
            Log.d("APP", "New Player created: " + player.toString());
            largeLog("APP", game.toString());
            interactor.addGame(game);
            return true;
        }

        return false;
    }


    private static void largeLog(String tag, String content) {
        if (content.length() > 4000) {
            Log.d(tag, content.substring(0, 4000));
            largeLog(tag, content.substring(4000));
        } else {
            Log.d(tag, content);
        }
    }

    public Player getPlayer() {
        return player;
    }
    public Game getGame() { return game; }
}
