public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 120, 25); // mais vida, mais ataque
    }

    @Override
    public void defend(int damage) {
        int reduced = damage / 2;
        hp -= reduced;
        System.out.println(name + " blocks! Receives only " + reduced + " damage.");
    }

    @Override
    public void useSpecialAbility() {
        int damage = baseAttack * 2;
        System.out.println(name + " uses Double Strike! Next attack will deal " + damage + " damage.");
        // Aplicação direta no próximo inimigo, se desejar implementar sequência, adicione flag.
    }
}
