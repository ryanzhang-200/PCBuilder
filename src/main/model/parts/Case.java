package model.parts;

public class Case extends Parts {
    private int cost;
    private int height;
    private int width;
    private int length;

    //EFFECTS:a model name for a case is given
    //creates an a case with a certain characteristics
    //(To be added: a database with all different models having different specs)
    public Case(String model) {
        super(model);
        cost = 100;
        height = 50;
        width = 15;
        length = 40;
    }

    //EFFECTS: returns the cost of the case as a int
    public int getCost() {
        return cost;
    }

    //EFFECTS: returns height of the case as a int
    // public int getHeight() {
    //     return height;
    // }

    //EFFECTS: returns width of the case as a int
    // public int getWidth() {
    //     return width;
    // }

    //EFFECTS: returns length of the case as a int
    // public int getLength() {
    //     return length;
    // }
    // public void setModel(String model) {
    //     this.model = model;
    // }
    // public void setCost(int cost) {
    //     this.cost = cost;
    // }
    // public void setHeight(int height) {
    //     this.height = height;
    // }
    // public void setWidth(int width) {
    //     this.width = width;
    // }
    // public void setLength(int length) {
    //     this.length = length;
    // }
}
