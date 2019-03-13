package atlantadragons.gatech.spacetrader.Model;

public class Cargo {
    private Resource resource;
    private int quantity;

    public Cargo(Resource resource, int quantity) {
        this.resource = resource;
        this.quantity = quantity;
    }
    public Cargo(Resource resource) {
        this(resource, 0);
    }

    public Resource getResource() { return resource; }
    public int getQuantity() { return quantity; }

    public void setResource (Resource resource) { this.resource = resource; }
    public void setQuantity (int quantity) { this.quantity = quantity; }
}
