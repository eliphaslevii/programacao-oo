public abstract class Character {
    protected String name;
    protected int hp;
    protected int baseAttack;

    public Character(String name, int hp, int baseAttack) {
        this.name = name;
        this.hp = hp;
        this.baseAttack = baseAttack;
    }

    public void attack(Character enemy) {
        System.out.println(name + " attacks " + enemy.name + " for " + baseAttack + " damage.");
        enemy.defend(baseAttack);
    }

    public abstract void defend(int damage);

    public abstract void useSpecialAbility();

    public void showStatus() {
        System.out.printf("%s | HP: %d | ATK: %d\n", name, hp, baseAttack);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
