package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.Model.Resource;
import atlantadragons.gatech.spacetrader.View.TravelActivity;

public class TravelViewModel extends AndroidViewModel {

    private Interactor interactor;

    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = RepoHolder.getHolder().getInteractor();
    }
}
