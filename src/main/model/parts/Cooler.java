package model.parts;

public class Cooler extends Parts {

    private int cost;

    //EFFECTS:a model name for a cooler is given
    //creates an a cooler with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public Cooler(String model) {
        super(model);
        cost = 50;
    }

    //EFFECTS: returns the cost of the cooler as a int
    public int getCost() {
        return cost;
    }


}
