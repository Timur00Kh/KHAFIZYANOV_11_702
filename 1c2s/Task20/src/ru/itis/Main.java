package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Player player = new Player();
	    player.setWeapon(new ArtifactWeaponAdapter(new Artifact()));
	    player.action1();
	    player.action2();
    }
}
