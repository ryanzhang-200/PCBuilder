package model.parts;

public abstract class PartsMultipleInfinite extends Parts {
    
    public PartsMultipleInfinite(String model) {
        super(model);
    }

    abstract int getCost();
}
