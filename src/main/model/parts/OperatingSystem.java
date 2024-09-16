package model.parts;

public class OperatingSystem extends Parts {

    private int cost;

    //EFFECTS:a model name for a operating system is given
    //creates an a operating system with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public OperatingSystem(String system) {
        super(system);
        cost = 50;
    }

    //EFFECTS: returns the cost of the operating system as a int
    public int getCost() {
        return cost;
    }
}
