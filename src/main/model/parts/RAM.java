package model.parts;

public class RAM {

    private int memory;
    private int speed;
    private String type;
    private String model;
    private int cost;

    //EFFECTS:a model name for a RAM stick is given
    //creates an a RAM stick with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public RAM(String model) {
        this.model = model;
        cost = 100;
        speed = 2160;
        memory = 8;
        type = "DDRX5";
    }

    //EFFECTS: returns the model as a string
    public String getModel() {
        return model;
    }

    //EFFECTS: returns the cost of each memory stick as a String
    //includes a total cost of the memory sticks
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns memory as a int
    // public int getMemory() {
    //     return memory;
    // }

    //EFFECTS: returns memory speed as a int
    // public int getSpeed() {
    //     return speed;
    // }

    //EFFECTS: returns type of RAM stick as a string
    // public String getType() {
    //     return type;
    // }
}
