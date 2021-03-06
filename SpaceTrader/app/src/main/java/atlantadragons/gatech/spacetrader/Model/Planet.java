package atlantadragons.gatech.spacetrader.Model;

import java.util.List;

class Planet {

    private String name;
    private TechLevel techLevel;
    private PlanetResourceType resourceType;
    private Market market;

    public static final String[] planetNames =
            {
                    "Acamar",
                    "Adahn",
                    "Aldea",
                    "Andevian",
                    "Antedi",
                    "Araragi",
                    "Balosnee",
                    "Baratas",
                    "Brax",			// One of the heroes in Master of Magic
                    "Bretel",		// This is a Dutch device for keeping your pants up.
                    "Calondia",
                    "Campor",
                    "Capelle",		// The city I lived in while programming this game
                    "Carzon",
                    "Castor",		// A Greek demi-god
                    "Cestus",
                    "Cheron",
                    "Concordia",
                    "Courteney",	// After Courteney Cox…
                    "Daled",
                    "Damast",
                    "Davlos",
                    "Deneb",
                    "Deneva",
                    "Devidia",
                    "Draylon",
                    "Drema",
                    "Endor",
                    "Esmee",		// One of the witches in Pratchett's Discworld
                    "Exo",
                    "Felix",
                    "Ferris",		// Iron
                    "Festen",		// A great Scandinavian movie
                    "Fourmi",		// An ant, in French
                    "Frolix",		// A solar system in one of Philip K. Dick's novels
                    "Gemulon",
                    "Guinifer",		// One way of writing the name of king Arthur's wife
                    "Hades",		// The underworld
                    "Hamlet",		// From Shakespeare
                    "Helena",		// Of Troy
                    "Hulst",		// A Dutch plant
                    "Iodine",		// An element
                    "Iralius",
                    "Janus",		// A seldom encountered Dutch boy's name
                    "Japori",
                    "Jarada",
                    "Jason",		// A Greek hero
                    "Kaylon",
                    "Khefka",
                    "Kira",			// My dog's name
                    "Klaatu",		// From a classic SF movie
                    "Klaestron",
                    "Kobayashi",
                    "Korma",		// An Indian sauce
                    "Kravat",		// Interesting spelling of the French word for "tie"
                    "Krios",
                    "Laertes",		// A king in a Greek tragedy
                    "Largo",
                    "Lave",			// The starting system in Elite
                    "Ligon",
                    "Lily",
                    "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
                    "Magrat",		// The second of the witches in Pratchett's Discworld
                    "Malcoria",
                    "Melina",
                    "Mentar",		// The Psilon home system in Master of Orion
                    "Merik",
                    "Mintaka",
                    "Montor",		// A city in Ultima III and Ultima VII part 2
                    "Mordan",
                    "Myrthe",		// The name of my daughter
                    "Nelvana",
                    "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
                    "Nyle",			// An interesting spelling of the great river
                    "Odet",
                    "Og",			// The last of the witches in Pratchett's Discworld
                    "Omega",		// The end of it all
                    "Omphalos",		// Greek for navel
                    "Orias",
                    "Othello",		// From Shakespeare
                    "Parade",		// This word means the same in Dutch and in English
                    "Penthara",
                    "Picard",		// The enigmatic captain from ST:TNG
                    "Pollux",		// Brother of Castor
                    "Quator",
                    "Rakhar",
                    "Ran",			// A film by Akira Kurosawa
                    "Regulas",
                    "Relva",
                    "Rhymus",
                    "Rochani",
                    "Rubicum",		// The river Ceasar crossed to get into Rome
                    "Rutia",
                    "Sarpeidon",
                    "Sefalla",
                    "Seltrice",
                    "Sigma",
                    "Sol",			// That's our own solar system
                    "Somari",
                    "Stakoron",
                    "Styris",
                    "Talani",
                    "Tamus",
                    "Tantalos",		// A king from a Greek tragedy
                    "Tanuga",
                    "Tarchannen",
                    "Terosa",
                    "Thera",		// A seldom encountered Dutch girl's name
                    "Titan",		// The largest moon of Jupiter
                    "Tohru",
                    "Torin",		// A hero from Master of Magic
                    "Triacus",
                    "Turkana",
                    "Tyrus",
                    "Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
                    "Utopia",		// The ultimate goal
                    "Vadera",
                    "Vagra",
                    "Vandor",
                    "Ventax",
                    "Xenon",
                    "Xerxes",		// A Greek hero
                    "Yew",			// A city which is in almost all of the Ultima games
                    "Yojimbo",		// A film by Akira Kurosawa
                    "Zalkon",
                    "Zuul"			// From the first Ghostbusters movie
            };

    public Planet(String name, TechLevel techLevel, PlanetResourceType resourceType) {
        this.name = name;
        this.techLevel = techLevel;
        this.resourceType = resourceType;
        this.market = new Market(techLevel, resourceType);
        calculateMarketPrices();
    }

    public String getName() { return name; }
    public TechLevel getTechLevel() { return techLevel; }
    public PlanetResourceType getResourceType() { return resourceType; }

    public List<Double> getMarketPrices() {
        return market.getPrices();
    }

    public List<Integer> getMarketStock() {
        return market.getStock();
    }

    public void buyGood(Resource resource, int quantity) {
        market.setQuantityOf(resource, market.getStockOf(resource) - quantity);
    }

    public void sellGood(Resource resource, int quantity) {
        market.setQuantityOf(resource, market.getStockOf(resource) + quantity);
    }

    public String toString() {
        return String.format("Planet name: %s, Tech Level: %s, Resource Type: %s",
                name, techLevel.getLevelName(), resourceType.getName());
    }

    private void calculateMarketPrices() {
        for (int i = 0; i < market.getPrices().size(); i++) {
            Resource resource = Resource.values()[i];
            double price = market.getPriceOf(resource);
            if (resourceType.getId() == resource.getDecreaseType()) {
                market.getPrices().set(i, (price * 3) / 4);
            } else if (resourceType.getId() == resource.getIncreaseType()) {
                market.getPrices().set(i, (price * 5) / 4);
            }
        }
    }



}
