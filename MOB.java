public class MOB implements Attributes{
    int hitModifier;
    int armor;
    int maxHP;
    int damage;
    String name;
    DiceType damageDie;

    @Override
    public int getArmor() { return armor; }
    @Override
    public int getMaxHP() { return maxHP; }
    @Override
    public DiceType getDamageDie() { return damageDie; }
    @Override
    public int getHitModifier() { return hitModifier; }
    public String getName() { return name; }
    public int getHP () { return maxHP - damage; }
    public int getDamage () { return damage; }

    public MOB (String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    }

    public void addDamage (int damages) {
        damage += damages;
    }

    public void resetDamage() {
        damage = 0;
    }

    public String toString() {
        return String.format("Health:%d\nDamage:%d\nArmor:%d\n", getHP(), getHitModifier(), getArmor());
    }

    public MOB copy() {
        return new MOB(getName(), getMaxHP(), getArmor(), getHitModifier(), getDamageDie());
    }
}
