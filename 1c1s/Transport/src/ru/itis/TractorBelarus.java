package ru.itis;

public class TractorBelarus extends Transport {
    private int potato;
    public TractorBelarus(String name, int fuelFlow, int potato){
        super(name, fuelFlow);
        this.potato = potato;
    }

    public int getPotato() {
        return potato;
    }

    //public void setPotato(int potato) {

    //}
}
