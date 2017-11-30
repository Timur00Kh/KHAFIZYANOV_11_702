package ru.itis;

public class TraktorBelarus extends Transport{
    static int potato;

    public TraktorBelarus(String name, String number, int potato) {
        super(name, number);
        this.potato = potato;
    }

    public static int getPotato() {
        return potato;
    }

    public static void showPotato(){
        System.out.println("Количество картошки:" + potato);
    }

}