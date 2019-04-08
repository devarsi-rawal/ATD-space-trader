package atlantadragons.gatech.spacetrader.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import atlantadragons.gatech.spacetrader.Model.Interactor;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.Model.Resource;

public class TradeViewModel extends AndroidViewModel {

    private Interactor interactor;

    public TradeViewModel(@NonNull Application application) {
        super(application);
        interactor = RepoHolder.getHolder().getInteractor();
    }

    public boolean buyGood(int resourceID, int quantity, double cost) {
        double money = interactor.getCredits();
        int capacity = interactor.getShipCapacity();
        int goodsCount = interactor.getShipGoodsCount();
        if (cost * quantity <= money && goodsCount + quantity <= capacity) {
            interactor.buyGood(Resource.values()[resourceID], quantity, cost * quantity);
            return true;
        }
        return false;
    }

    public boolean sellGood(int resourceID, int quantity, double cost) {
        int resourceStock = interactor.getCargoStock().get(resourceID);
        if (resourceStock - quantity >= 0) {
            interactor.sellGood(Resource.values()[resourceID], quantity, cost/2 * quantity);
            return true;
        }
        return false;
    }

    public Double getCredits() {
        return interactor.getCredits();
    }

    public int getGoodsCount() {
        return interactor.getShipGoodsCount();
    }

    public List<Double> getMarketPrices() {
        return interactor.getMarketPrices().get(0);
    }

    public List<Integer> getCargoStock() {
        return interactor.getCargoStock();
    }

    public List<Integer> getMarketStock() {
        return interactor.getMarketStock().get(0);
    }
}
