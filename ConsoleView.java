import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView{
    @Override
    public void splashScreen() {
        System.out.print("Splashscreen!");
    }

    @Override
    public void endGame() {
        System.out.print("Thanks for playing!");
    }

    @Override
    public String displayMainMenu() {
        System.out.print("What would you like to do?");
        Scanner scnr = new Scanner(System.in);
        String response = scnr.nextLine();
        return response;
    }

    @Override
    public void printHelp() {
        System.out.println("Unsure what to do, here are some options:");
        System.out.println("\tls or list all  - listing the knights");
        System.out.println("\tlist active  - list the active knights knights only");
        System.out.println("\tshow name or id - show the knight details card");
        System.out.println("\tset active name or id - set knight as active (note: only 4 knights can be active)");
        System.out.println("\tremove active name or id - remove a knight from active status (heals knight)");
        System.out.println("\texplore or adventure or quest - find random monsters to fight");
        System.out.println("\tsave filename - save the game to the file name (default: saveData.csv)");
        System.out.println("\texit or goodbye - to leave the game");
        System.out.println("");
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal,");
        System.out.println("but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat");
        System.out.println("before, you have to heal?");


    }

    @Override
    public void listKnights(List<Knight> knights) {
        if (knights.isEmpty()) {
            System.out.print("No knights to list");
        } else {
            for (int i = 0; i < knights.size(); ++i) {
                System.out.printf("%d: %s\n", knights.get(i).getId(), knights.get(i).getName());
            }
        }
    }

    @Override
    public void knightNotFound() {
        System.out.print("Knight not found!");
    }

    @Override
    public void showKnight(Knight knight) {
        System.out.println(knight.toString());
    }

    @Override
    public void setActiveFailed() {
        System.out.print("Unable to set active knight. Only four can be active at a time.");
    }

    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        System.out.println("Our heroes come across the following monsters. Prepare for battle!\n");
        if (activeKnights.size() > monsters.size()) {
            for (int i = 0; i < activeKnights.size(); ++i) {
                if (monsters.get(i) == null) {
                    System.out.printf("%s\n", activeKnights.get(i).getName());
                } else {
                    System.out.printf("%s%27s\n", activeKnights.get(i).getName(), monsters.get(i).getName());
                }
            }
        } else if (monsters.size() > activeKnights.size()) {
            for (int i = 0; i < monsters.size(); ++i) {
                if (monsters.get(i) == null) {
                    System.out.printf("%27s\n", monsters.get(i).getName());
                } else {
                    System.out.printf("%s%27s\n", activeKnights.get(i).getName(), monsters.get(i).getName());
                }
            }
        } else {
            for (int i = 0; i < activeKnights.size(); ++i) {
                System.out.printf("%s%27s\n", activeKnights.get(i).getName(), monsters.get(i).getName());
            }
        }
    }

    @Override
    public void printBattleText(MOB dead) {
        System.out.printf("%s was defeated!", dead.getName());
    }

    @Override
    public void printFortunes(List<Knight> activeKnights) {
        for (Knight knight: activeKnights) {
            System.out.printf("%s drew\n", knight.getName());
            System.out.printf("%s", knight.getActiveFortune().toString());
        }
    }

    @Override
    public boolean checkContinue() {
        System.out.print("Would you like to continue on your quest (y/n)?");
        Scanner scnr = new Scanner(System.in);
        String answer = scnr.nextLine();
        if (answer.equals("y") || answer.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printDefeated() {
        System.out.print("All active knights have been defeated!");
    }

}
