package model.parts;

public abstract class Parts {
    private String model;

    public Parts(String model) {
        this.model = model;
    }

    abstract int getCost();

    public String getModel() {
        return model;
    }
}
