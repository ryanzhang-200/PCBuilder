package model.parts;

public class Storage {
    private int capacity;
    private int speed;
    private Boolean ssd;
    private String type;
    private String model;
    private int cost;

    //EFFECTS:a model name for a hard drive/ssd is given
    //creates an a hard drive/ssd with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public Storage(String model) {
        this.model = model;
        cost = 100;
        capacity = 512;
        speed = 2160;
        ssd = false;
        type = "15000";
    }

    //EFFECTS: returns the model as a string
    public String getModel() {
        return model;
    }

    //EFFECTS: returns the cost of each hard drive/ssd as a String
    //includes a total cost of every hard drive and ssd combined 
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns storage capacity as a int
    // public int getCapacity() {
    //     return capacity;
    // }

    //EFFECTS: returns hard drive speed as a int
    // public int getSpeed() {
    //     return speed;
    // }

    //EFFECTS: returns boolean representing whether hard drive is an ssd or not
    // public boolean getSSD() {
    //     return ssd;
    // }

    //REQUIRES: ssd = false
    //EFFECTS: returns the type of hard drive 
    // public String getType() {
    //     if (ssd == false) {
    //     return type;
    //     } else {
    //         return null;
    //     }
    // }
}
