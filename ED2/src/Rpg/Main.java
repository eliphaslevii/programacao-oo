package Rpg;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thorgal");
        Mage mage = new Mage("Merlino");
        Archer archer = new Archer("Legolis");

        System.out.println("\n--- Initial Status ---");
        warrior.showStatus();
        mage.showStatus();
        archer.showStatus();

        System.out.println("\n--- Battle Begins ---");
        warrior.attack(mage);
        mage.useSpecialAbility();
        archer.useSpecialAbility();

        System.out.println("\n--- Final Status ---");
        warrior.showStatus();
        mage.showStatus();
        archer.showStatus();
    }
}
