package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;

public class TravelViewModel extends AndroidViewModel {

    private Interactor interactor;

    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = RepoHolder.getHolder().getInteractor();
    }

    public void loseCredits(double d) {
        interactor.loseCredits(d);
    }

    public void earnCredits(double d) {
        interactor.earnCredits(d);
    }
}
