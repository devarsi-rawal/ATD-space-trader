package atlantadragons.gatech.spacetrader.Model;

public enum GameMode {
    BEGINNER("Beginner"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    private String mode;

    GameMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
