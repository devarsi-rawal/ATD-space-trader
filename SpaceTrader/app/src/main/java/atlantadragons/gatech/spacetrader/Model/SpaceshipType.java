package atlantadragons.gatech.spacetrader.Model;

public enum SpaceshipType {
    GNAT("Gnat", 0, 100),
    FLEA("Flea", 1, 100),
    FIREFLY("Firefly", 2, 100),
    MOSQUITO("Mosquito", 3, 100),
    BUMBLEBEE("Bumblebee", 4, 100),
    BEETLE("Beetle", 5, 100),
    HORNET("Hornet", 6, 100),
    GRASSHOPPER("Grasshopper", 7, 100),
    TERMITE("Termite", 8, 100),
    WASP("Wasp", 9, 200);

    private String name;
    private int level;
    private int cargoCapacity;

    SpaceshipType (String name, int level, int cargoCapacity) {
        this.name = name;
        this.level = level;
        this.cargoCapacity = cargoCapacity;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCargoCapacity() { return cargoCapacity; }
}
