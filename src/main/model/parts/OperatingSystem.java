package model.parts;

public class OperatingSystem implements Parts {

    private String systemName;
    private int cost;

    //EFFECTS:a model name for a operating system is given
    //creates an a operating system with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public OperatingSystem(String system) {
        systemName = system;
        cost = 50;
    }
    
    //EFFECTS: returns the System name as a string
    public String getSystemName() {
        return systemName;
    }

    //EFFECTS: returns the cost of the operating system as a int
    public int getCost() {
        return cost;
    }
}
