package ru.itis;

public class Player {
    private ArtifactWeaponAdapter a;

    public void setWeapon(ArtifactWeaponAdapter a) {
        this.a = a;
    }

    public void action1() {
        a.action1();
    }

    public void action2() {
        a.action2();
    }
}
