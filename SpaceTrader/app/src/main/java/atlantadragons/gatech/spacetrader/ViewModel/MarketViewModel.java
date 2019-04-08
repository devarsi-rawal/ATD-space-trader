package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;

public class MarketViewModel extends AndroidViewModel {

    public MarketViewModel(@NonNull Application application) {
        super(application);
        Interactor interactor = RepoHolder.getHolder().getInteractor();
    }


}
