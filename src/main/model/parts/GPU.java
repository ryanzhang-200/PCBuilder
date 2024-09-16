package model.parts;

public class GPU extends Parts {
    private int gpuPower;
    private int cost;

    //EFFECTS:a model name for a GPU is given
    //creates an a GPU with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public GPU(String model) {
        super(model);
        cost = 200;
        gpuPower = 2160;
    }

    //EFFECTS: returns the cost of the GPU as a int
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns of the power of the GPU as an int
    // public int getGPUPower() {
    //     return gpuPower;
    // }
}
