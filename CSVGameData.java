import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class CSVGameData extends GameData{
    int IDCounter = 0;
    public CSVGameData(String gameData, String saveData) {
        loadSaveData(saveData);
        loadGameData(gameData);
    }

    void loadSaveData(String saveData) {
        CSVReader saveDatas = new CSVReader(saveData, false);
        while (saveDatas.hasNext()) {
            IDCounter += 1;
            List<String> sam = saveDatas.getNext();
            String name = sam.get(0);
            int hp = Integer.parseInt(sam.get(1));
            int armor = Integer.parseInt(sam.get(2));
            int hitmodifier = Integer.parseInt(sam.get(3));
            DiceType damagedie = DiceType.valueOf(sam.get(4));
            int xp = Integer.parseInt(sam.get(5));

            knights.add(new Knight(IDCounter, name, hp, armor, hitmodifier, damagedie, xp));
        }
        IDCounter = 0;
    }

    void loadGameData(String gameData) {
        CSVReader gameDatas = new CSVReader(gameData, false);
        while (gameDatas.hasNext()) {
            List<String> sam = gameDatas.getNext();
            String name = sam.get(1);
            int hp = Integer.parseInt(sam.get(2));
            int armor = Integer.parseInt(sam.get(3));
            int hitmodifier = Integer.parseInt(sam.get(4));

            if (sam.get(0).equals("MOB")) {
                DiceType damagedie = DiceType.valueOf(sam.get(5));
                monsters.add(new MOB(name, hp, armor, hitmodifier, damagedie));
            } if (sam.get(0).equals("FORTUNE")) {
                if (sam.get(5).equals("-")) {
                    fortunes.add(new Fortune(name, hp, armor, hitmodifier));
                } else {
                    DiceType damagedie = DiceType.valueOf(sam.get(5));
                    fortunes.add(new Fortune(name, hp, armor, hitmodifier, damagedie));
                }
            }
        }
    }

    public void save (String filename) {
        try {
            FileWriter sam = new FileWriter(filename);
            for (int i = 0; i < knights.size(); ++i) {
                sam.write(knights.get(i).toCSV() + "\n");
            }
            sam.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String [] args) {
        CSVReader sam = new CSVReader("knights.csv", false);
        System.out.print(sam.getNext());
        System.out.print(sam.getNext());
        System.out.print(sam.getNext());
        System.out.print(sam.getNext());
        System.out.println(sam.getNext());







    }
}
