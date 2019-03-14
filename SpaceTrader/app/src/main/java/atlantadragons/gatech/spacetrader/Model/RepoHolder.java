package atlantadragons.gatech.spacetrader.Model;

public class RepoHolder {
    private Repository repo;

    private static RepoHolder holder = new RepoHolder();

    private RepoHolder() {
        repo = new Repository();
    }

    public static RepoHolder getHolder() { return holder; }
}
