package atlantadragons.gatech.spacetrader.Model;

public class RepoHolder {

    private Repository repo;
    private Interactor interactor;

    private static RepoHolder holder = new RepoHolder();

    private RepoHolder() {
        repo = new Repository();
        createInteractor();
    }

    public void createInteractor() {
        interactor = new Interactor(repo);
    }

    public static RepoHolder getHolder() { return holder; }

    public Interactor getInteractor() { return interactor; }
}
