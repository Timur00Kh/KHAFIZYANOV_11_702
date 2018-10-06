package ru.itis;

public class ArtifactWeaponAdapter implements Weapon {
    Artifact artifact;

    ArtifactWeaponAdapter(Artifact w){
        this.artifact = w;
    }

    public void action1() {
        artifact.attack();
    }

    public void action2() {
        artifact.heal();
    }
}
