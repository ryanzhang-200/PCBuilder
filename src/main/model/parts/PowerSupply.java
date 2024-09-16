package model.parts;

public class PowerSupply extends Parts {

    private int cost;
    private int power;

    //EFFECTS:a model name for a power supply is given
    //creates an a power supply with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public PowerSupply(String model) {
        super(model);
        cost = 100;
        power = 50;
    }

    //EFFECTS: returns the cost of the power supply as a int
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns the power of the power supply as a int
    // public int getPower() {
    //     return power;
    // }
}
