package atlantadragons.gatech.spacetrader.Model;

import java.util.ArrayList;
import java.util.List;

public class Spaceship {
    private SpaceshipType spaceshipType;
    private int capacity;
    private List<Integer> cargoStock = new ArrayList<>();

    public Spaceship(SpaceshipType spaceshipType) {
        this.spaceshipType = spaceshipType;
        capacity = spaceshipType.getCargoCapacity();
        for (Resource r : Resource.values()) {
            cargoStock.add(0);
        }
    }

    public Spaceship() {
        this(SpaceshipType.GNAT);
    }


    public SpaceshipType getSpaceshipType() { return spaceshipType; }

    public int getCapacity() { return capacity; }

    public int getStock (Resource resource) {
        return cargoStock.get(resource.ordinal());
    }

    public void setCapacity(Resource resource, int quantity) {
        cargoStock.set(resource.ordinal(), quantity);
    }

}
