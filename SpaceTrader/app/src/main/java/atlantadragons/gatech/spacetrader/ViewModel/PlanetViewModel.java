package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;

public class PlanetViewModel extends AndroidViewModel {

    private Interactor interactor;

    public PlanetViewModel(@NonNull Application application) {
        super(application);
        interactor = RepoHolder.getHolder().getInteractor();
    }

    public String getPlanetName() {
        return interactor.getUniverse().getCurrentPlanetName();
    }

    public String getPlanetTechLevel() {
        return interactor.getUniverse().getTechLevel().getLevelName();
    }

    public String getPlanetResourceType() {
        return interactor.getUniverse().getResourceType().getName();
    }

    public String getCoordinates() {
        return String.format("(%d, %d)",
                interactor.getUniverse().getxCoord(),
                interactor.getUniverse().getyCoord());
    }
}
