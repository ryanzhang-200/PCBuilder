package model.parts;

public class CPU implements Parts {

    private double processingPower;
    private double processingPowerBoost;
    private int numCore;
    private String model;
    private int cost;

    //EFFECTS:a model name for a CPU is given
    //creates an a CPU with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public CPU(String model) {
        this.model = model;
        processingPower = 3.5;
        processingPowerBoost = 4;
        numCore = 4;
        cost = 200;
    }

    // //EFFECTS: returns the model as a string
    // public String getModel() {
    //     return model;
    // }

    //EFFECTS: returns the cost of the CPU as a int
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns processingPower of the case as a double
    // public double getProcessingPower() {
    //     return processingPower;
    // }

    //EFFECTS: returns processingPower of the case as a double
    // public double getProcessingPowerBoost() {
    //     return processingPowerBoost;
    // }

    //EFFECTS returns number of cores in the CPU
    // public int getNumCore() {
    //     return numCore;
    // }
}
