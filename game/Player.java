package game;

/**
 * Responsible for keeping track of his/her ID and his/her account.
 */
public class Player {
    private final int ID;
    private final Account ACCOUNT;

    /**
     * Player's constructor.
     *
     * @param initialBalance The initial balance of the player's account.
     * @param ID             The ID for identifying the player.
     */
    public Player(int initialBalance, int ID) {
        this.ACCOUNT = new Account(initialBalance);
        this.ID = ID;
    }

    /**
     * Accessor for the player's ID.
     *
     * @return The player's ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Accessor for the player's account balance.
     *
     * @return The balance of the player's account.
     */
    public int getBalance() {
        return ACCOUNT.getBalance();
    }

    /**
     * Conveys the amount to withdraw from the player's account.
     *
     * @param amount The amount to withdraw from the player's account.
     * @return Boolean to indicate success.
     */
    public boolean withdraw(int amount) {
        return ACCOUNT.withdraw(amount);
    }

    /**
     * Conveys the amount to deposit on the player's account.
     *
     * @param amount The amount to deposit.
     * @return Boolean to indicate success.
     */
    public boolean deposit(int amount) {
        return ACCOUNT.deposit(amount);
    }

    public String toString() {
        return "Player-ID: " + ID + System.lineSeparator() +
                "Player account information: " + ACCOUNT;
    }
}