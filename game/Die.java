package game;

/**
 * A Die.
 */
public class Die {
    private int faceValue; // Initial face value of the die.
    private final int SIDES; //  The sides of the die.

    /**
     * Constructor of the Die class.
     * <br>
     * We use the roll() method to get a random face value to reflect the
     * real-world randomization of first starting using a die in a
     * game.
     */
    public Die(int sides) {
        this.SIDES = sides;
        roll();
    }

    /**
     * Rolls the die, updating its face value based on a uniform
     * distribution.
     */
    public void roll() {
        faceValue = (int) (Math.random() * SIDES) + 1;
    }

    /**
     * @return the face value of the die
     */
    public int getFaceValue() {
        return faceValue;
    }

    public String toString(){
        return "facevalue: " + faceValue + ", sides: " + SIDES;
    }
}
