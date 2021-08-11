import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameData {
    protected static final Random random = new Random();
    protected final List<Fortune> fortunes = new ArrayList<>();
    protected final List<MOB> monsters = new ArrayList<>();
    protected final List<Knight> knights = new ArrayList<>();
    protected final List<Knight> activeKnights = new ArrayList<>();


    protected Knight findKnight (String nameOrId, List<Knight> list) {
            for (Knight knight: list) {
                    if (knight.getName().toLowerCase().contains(nameOrId) || knight.getId().toString().equals(nameOrId)) {
                        return knight;
                }
            }
            return null;
    }

    public List<Knight> getKnights() { return knights; }
    public List<Knight> getActiveKnights() { return activeKnights; }
    public Knight getActive(String nameOrId) { return findKnight(nameOrId, activeKnights); }
    public Knight getKnight(String nameOrId) { return findKnight(nameOrId, knights); }

    public boolean setActive(Knight kt) {
        if (activeKnights.size() < 4) {
            activeKnights.add(kt);
            return true;
        } else {
            return false;
        }
    }

    public void removeActive(Knight kt) {
        activeKnights.remove(kt);
        kt.resetDamage();
    }

    public Fortune getRandomFortune() {
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    public List<MOB> getRandomMonsters() {
        List<MOB> sam = new ArrayList<>();
        for (int i = 1; i <= random.nextInt(activeKnights.size()); ++i) {
            sam.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return sam;
    }

    public List<MOB> getRandomMonsters(int number) {
        List<MOB> randMob = new ArrayList<>();
        for (int i = 1; i <= number; ++i) {
            randMob.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return randMob;
    }

    public abstract void save(String filename);
}
