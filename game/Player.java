package game;

public class Player {
    private int id;
    private Account account;

    public Player(int initialBalance, int ID) {
        this.account = new Account(initialBalance);
        this.id = ID;
    }

    public int getID(){
        return id;
    }

    public int getBalance(){
        return account.getBalance();
    }

    public boolean withdraw(int amount) {
        return account.withdraw(amount);
    }

    public boolean deposit(int amount) {
        return account.deposit(amount);
    }

    public String toString() {
        return "Player-ID: " + id + System.lineSeparator() +
                "Player account information: " + account;
    }
}