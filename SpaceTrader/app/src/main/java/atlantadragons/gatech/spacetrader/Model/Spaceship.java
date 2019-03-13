package atlantadragons.gatech.spacetrader.Model;

public class Spaceship {
    private SpaceshipType spaceshipType;
    private Cargo[] cargoBay = {
            new Cargo(Resource.WATER, 0),
            new Cargo(Resource.FUR, 0),
            new Cargo(Resource.FOOD, 0),
            new Cargo(Resource.ORE, 0),
            new Cargo(Resource.GAMES, 0),
            new Cargo(Resource.FIREARMS, 0),
            new Cargo(Resource.MEDICINE, 0),
            new Cargo(Resource.MACHINES, 0),
            new Cargo(Resource.NARCOTICS, 0),
            new Cargo(Resource.ROBOTS, 0),
    };

    public Spaceship(SpaceshipType spaceshipType) {
        this.spaceshipType = spaceshipType;
    }

    public Spaceship() {
        this(SpaceshipType.GNAT);
    }

    public void addCargo(Resource resource, int amount) {
        int original = cargoBay[resource.ordinal()].getQuantity();
        cargoBay[resource.ordinal()].setQuantity(original + amount);
    }


    public void subtractCargo(Resource resource, int amount) {
        int original = cargoBay[resource.ordinal()].getQuantity();
        cargoBay[resource.ordinal()].setQuantity(original - amount);
    }

    public SpaceshipType getSpaceshipType() { return spaceshipType; }

}
