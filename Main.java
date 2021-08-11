public class Main {
    public static void test() {
        System.out.println("Beginning Tests");
        System.out.println();
        System.out.println("Testing DiceSet:");
        System.out.println();
        DiceType four = DiceType.D4;
        DiceType six = DiceType.D6;
        DiceType eight = DiceType.D8;
        DiceType ten = DiceType.D10;
        DiceType twelve = DiceType.D12;
        DiceType twenty = DiceType.D20;

        System.out.printf("Expecting: 4 Actual: %d\n", DiceSet.roll(four));
        System.out.printf("Expecting: 6 Actual: %d\n", DiceSet.roll(six));
        System.out.printf("Expecting: 8 Actual: %d\n", DiceSet.roll(eight));
        System.out.printf("Expecting: 10 Actual: %d\n", DiceSet.roll(ten));
        System.out.printf("Expecting: 12 Actual: %d\n", DiceSet.roll(twelve));
        System.out.printf("Expecting: 20 Actual: %d\n", DiceSet.roll(twenty));
        System.out.println();

        System.out.println("Testing Fortune:");
        Fortune sam = new Fortune("sam", 20, 12, 5, four);
        System.out.printf("%s", sam.toString());
        System.out.println();

        System.out.println("Testing MOB:");
        MOB poop = new MOB("poop", 21, 12, 18, eight);
        System.out.print(poop.toString());
        System.out.println();

        System.out.println("Testing Knight:");
        Knight Sammyoto = new Knight(123, "Sammyoto", 1, 2, 3, twelve, 24);
        System.out.print(Sammyoto.toString());
        System.out.println();

        System.out.println("Testing GameData:");


    }



    public static void main(String[] args) {
        test();
    }
}
