package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.Model.Resource;

public class MarketViewModel extends AndroidViewModel {

    private Interactor interactor;

    public MarketViewModel(@NonNull Application application) {
        super(application);
        interactor = RepoHolder.getHolder().getInteractor();
    }

    public List<String> getResources() {
        List<String> list = new ArrayList<>();
        for (Resource r : Resource.values()) {
        }
    }
}
