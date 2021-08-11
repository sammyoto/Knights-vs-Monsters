public class Fortune implements Attributes{
    String name;
    int hpBonus;
    int armor;
    int hitModifier;
    DiceType type;


    public Fortune (String name, int hpBonus, int armor, int hitModifier) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
    }
    public Fortune (String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.type = type;
    }
    @Override
    public int getArmor() { return armor; }
    @Override
    public int getMaxHP() { return hpBonus; }
    @Override
    public DiceType getDamageDie() { return type; }
    @Override
    public int getHitModifier() { return hitModifier; }
    public String getName() { return name; }


    public String toString() {
        if (getDamageDie() == null) {
            return "+======================+\n" +
                    String.format("|%-22s|%n", getName()) +
                    String.format("|HP Bonus:%13s|%n", ("+" + getMaxHP())) +
                    String.format("|AC Bonus:%13s|%n", ("+" + getArmor())) +
                    String.format("|Hit Bonus:%12s|%n", ("+" + getHitModifier())) +
                    String.format("|Damage Adj:%11s|%n", "-") +
                    "+======================+\n";
        } else {
            return "+======================+\n" +
                    String.format("|%-22s|%n", getName()) +
                    String.format("|HP Bonus:%13s|%n", ("+" + getMaxHP())) +
                    String.format("|AC Bonus:%13s|%n", ("+" + getArmor())) +
                    String.format("|Hit Bonus:%12s|%n", ("+" + getHitModifier())) +
                    String.format("|Damage Adj:%11s|%n", getDamageDie()) +
                    "+======================+\n";
        }


    }
}
