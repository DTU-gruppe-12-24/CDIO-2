package game;

public class RaffleCup {
    private final Die[] DICE;

    public RaffleCup(int sidesOfDie) {
        DICE = new Die[]{new Die(sidesOfDie), new Die(sidesOfDie)};
    }

    public void roll(){
        for (Die die : DICE) {
            die.roll();
        }
    }

    public int getValue(int index) {
        return DICE[index].getFaceValue();
    }

    public int getSum() {
        int sum = 0;
        for (Die die : DICE) {
            sum += die.getFaceValue();
        }
        return sum;
    }

    public String toString() {
        String output = "The dice of the raffle-cup:" + System.lineSeparator();
        for (Die die : DICE) {
            output += die + System.lineSeparator();
        }
        return output;
    }
}
