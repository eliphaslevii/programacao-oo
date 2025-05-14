import java.util.Random;

public class Archer extends Character {
    private Random rng = new Random();

    public Archer(String name) {
        super(name, 100, 18); // ataque médio
    }

    @Override
    public void defend(int damage) {
        hp -= damage;
        System.out.println(name + " tries to dodge but receives " + damage + " damage.");
    }

    @Override
    public void attack(Character enemy) {
        boolean critical = rng.nextDouble() < 0.3; // 30% de chance
        int finalDamage = critical ? baseAttack * 2 : baseAttack;
        System.out.println(name + (critical ? " lands a CRITICAL shot! " : " attacks normally: ") + finalDamage + " damage.");
        enemy.defend(finalDamage);
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " unleashes Arrow Rain! Attacks 3 times!");
        for (int i = 0; i < 3; i++) {
            System.out.println("-> Arrow " + (i + 1));
        }
    }
}
