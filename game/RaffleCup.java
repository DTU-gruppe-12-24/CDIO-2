package game;

/**
 * Responsible for interacting with the dice.
 */
public class RaffleCup {
    private final Die[] DICE;

    /**
     *
     * @param sidesOfDie The number of sides of the die.
     */
    public RaffleCup(int sidesOfDie) {
        DICE = new Die[]{new Die(sidesOfDie), new Die(sidesOfDie)};
    }

    /**
     * Roll the dice, updating their face value.
     */
    public void roll(){
        for (Die die : DICE) {
            die.roll();
        }
    }

    /**
     *
     * @param index The index of the die to get the face value of.
     * @return The face value of the specified die.
     */
    public int getValue(int index) {
        return DICE[index].getFaceValue();
    }

    /**
     *
     * @return Get the sum total of the dice face values.
     */
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
