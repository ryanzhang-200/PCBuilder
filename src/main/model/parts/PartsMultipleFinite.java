package model.parts;

public abstract class PartsMultipleFinite extends Parts {

    public PartsMultipleFinite(String model) {
        super(model);
    }

    abstract int getCost();
}
