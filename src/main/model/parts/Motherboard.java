package model.parts;

import java.util.List;
import java.util.ArrayList;

public class Motherboard implements Parts {

    private String model;
    private int cost;
    private int ramSlots;
    private int gpuSlots;
    private int maxMemory;
    private List<String> compatibility = new ArrayList<>();

    //EFFECTS:a model name for a motherboard is given
    //creates an a motherboard with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public Motherboard(String model) {
        this.model = model;
        cost = 100;
        ramSlots = 2;
        gpuSlots = 2;
        maxMemory = 196;
        String[] compatibility = {"DDRX4", "DDRX5"};
    }

    //EFFECTS: returns the model as a string
    public String getModel() {
        return model;
    }

    //EFFECTS: returns the cost of the motherboard as a int
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns num of RAM slots as a int
    public int getRamSlots() {
        return ramSlots;
    }

    //EFFECTS: returns num of GPU slots as a int
    public int getGpuSlots() {
        return gpuSlots;
    }

    //EFFECTS: returns max memory as a int
    // public int getMaxMemory() {
    //     return maxMemory;
    // }

    //EFFECTS: returns a list of strings representing the type of RAM
    //the motherboard is compatibile with
    // public List<String> getCompatibility() {
    //     return compatibility;
    // }
}
