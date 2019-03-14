package atlantadragons.gatech.spacetrader.Model;

import java.util.List;

public class Interactor {

    private Repository repo;

    public Interactor(Repository repo) {
        this.repo = repo;
    }

    public void addGame(Game game) {
        repo.addGame(game);
    }

    public Game getCurrentGame() {
        return repo.getCurrentGame();
    }

    public List<Integer> getStock() {
        return getCurrentGame()
    }
}
