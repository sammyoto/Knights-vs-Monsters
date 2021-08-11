import java.util.Random;
public class DiceSet {
    public static int roll(DiceType die) {
        Random rand = new Random();
        switch (die) {
            case D4:
               return rand.nextInt(4) + 1;
            case D6:
                return rand.nextInt(6) + 1;
            case D8:
                return rand.nextInt(8) + 1;
            case D10:
                return rand.nextInt(10) + 1;
            case D12:
                return rand.nextInt(12) + 1;
            case D20:
                return rand.nextInt(20) + 1;
            default:
                return 0;
        }
    }
}

