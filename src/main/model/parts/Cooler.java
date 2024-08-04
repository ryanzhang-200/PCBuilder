package model.parts;

public class Cooler implements Parts {

    private int cost;
    private String model;

    //EFFECTS:a model name for a cooler is given
    //creates an a cooler with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public Cooler(String model) {
        this.model = model;
        cost = 50;
    }

    // //EFFECTS: returns the model as a string
    public String getModel() {
        return model;
    }

    //EFFECTS: returns the cost of the cooler as a int
    public int getCost() {
        return cost;
    }


}
