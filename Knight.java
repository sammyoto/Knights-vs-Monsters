public class Knight extends MOB {
    protected final int id;
    protected int xp;
    Fortune activeFortune;

    public Knight (int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }

    public int getXP() { return xp; }
    public Integer getId() { return id; }
    public Fortune getActiveFortune () { return activeFortune; }

    public void addXP(int exp) {
        xp += exp;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
        if (activeFortune.type == null) {
            maxHP += activeFortune.hpBonus;
            armor += activeFortune.armor;
            hitModifier += activeFortune.hitModifier;
        } else {
            maxHP += activeFortune.hpBonus;
            armor += activeFortune.armor;
            hitModifier += activeFortune.hitModifier;
            damageDie = activeFortune.type;
        }
    }

    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                String.format("| id: %-23d|%n", getId()) +
                "|                            |\n" +
                String.format("| Health: %-6d  XP: %-7d|%n", getHP(), getXP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie(), getArmor()) +
                "|                            |\n" +
                "+============================+\n";
    }
    public String toCSV() {
        return String.format("%s,%d,%d,%d,%s,%d",getName(), getMaxHP(), getArmor(), getHitModifier(), getDamageDie(), getXP());
    }
}
