package model.parts;

public class Monitor extends Parts {

    private int cost;
    private int screenSize;
    private String resolution;
    private int refreshRate;

    //EFFECTS:a model name for a monitor is given
    //creates an a monitor with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public Monitor(String model) {
        super(model);
        cost = 150;
        screenSize = 27;
        resolution = "1920x1080";
        refreshRate = 240;
    }

    //EFFECTS: returns the cost of each Monitor as a int
    //includes a total
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns screen size as a int
    // public int getScreenSize() {
    //     return screenSize;
    // }

    //EFFECTS: returns resolution as a string
    // public String getResolution() {
    //     return resolution;
    // }

    //EFFECTS: returns refresh rate as a int
//     public int getRefreshRate() {
//         return refreshRate;
//     }
}
