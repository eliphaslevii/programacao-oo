public class Mage extends Character {
    public Mage(String name) {
        super(name, 80, 20); // vida mais baixa
    }

    @Override
    public void defend(int damage) {
        hp -= damage;
        System.out.println(name + " fails to block and receives " + damage + " damage.");
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " casts Fireball! Deals area damage (fictional for now).");
        // Poderia causar dano a vários inimigos, ou fixo a todos em lista.
    }
}
