import java.util.List;
import java.util.Random;

public class CombatEngine {
    GameData data;
    GameView view;
    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
    }

    public void initialize() {
        for (Knight knight: data.getActiveKnights()) {
            knight.setActiveFortune(data.getRandomFortune());
        }
        view.printFortunes(data.getActiveKnights());
    }

    public void battle(List<MOB> activeMonsters) {
        Random rand = new Random();
        while (data.activeKnights.size() > 0 || activeMonsters.size() > 0) {
            for (Knight knight : data.activeKnights) {
                MOB opponent = activeMonsters.get(rand.nextInt(activeMonsters.size() - 1));
                boolean hit = (DiceSet.roll(DiceType.D20) + knight.getHitModifier()) > opponent.armor;
                if (hit) {
                    opponent.addDamage(DiceSet.roll(knight.getDamageDie()));
                    if (opponent.getHP() < 0) {
                        activeMonsters.remove(opponent);
                        view.printBattleText(opponent);
                        for (Knight bruh : data.activeKnights) {
                            bruh.addXP(1);
                        }
                    }
                }
            }
            for (MOB mob : activeMonsters) {
                Knight opponent = data.getActiveKnights().get(rand.nextInt(data.getActiveKnights().size() - 1));
                boolean hit = (DiceSet.roll(DiceType.D20) + mob.getHitModifier()) > opponent.armor;
                if (hit) {
                    opponent.addDamage(DiceSet.roll(mob.getDamageDie()));
                    if (opponent.getHP() < 0) {
                        data.activeKnights.remove(opponent);
                        view.printBattleText(opponent);
                    }
                }
            }
        }
    }

    public void runCombat() {
        List<MOB> activeMonsters = data.getRandomMonsters();
        view.printBattleText(activeMonsters, data.getActiveKnights());
            battle(activeMonsters);
            if (data.getActiveKnights().size() == 0) {
            view.printDefeated();
            } else if (view.checkContinue()) {
                data.getRandomMonsters();
                view.printBattleText(data.monsters, data.getActiveKnights());
                runCombat();
            }
    }

    public void clear() {
        for (Knight knight: data.getActiveKnights()) {
            knight.setActiveFortune(null);
        }
    }

}
