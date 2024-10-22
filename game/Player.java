package game;

public class Player {
    private final int ID;
    private final Account ACCOUNT;

    public Player(int initialBalance, int ID) {
        this.ACCOUNT = new Account(initialBalance);
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public int getBalance(){
        return ACCOUNT.getBalance();
    }

    public boolean withdraw(int amount) {
        return ACCOUNT.withdraw(amount);
    }

    public boolean deposit(int amount) {
        return ACCOUNT.deposit(amount);
    }

    public String toString() {
        return "Player-ID: " + ID + System.lineSeparator() +
                "Player account information: " + ACCOUNT;
    }
}