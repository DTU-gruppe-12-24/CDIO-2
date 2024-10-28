package game;

// Account class, each account only has a balance
public class Account {
    private int balance;    

    /**
     * Player's constructor.
     * @param balance The initial balance of the player's account.
     */
    public Account(int balance){
        this.balance = balance;
    }

    /** Accessor for the player's account balance. 
     * @return balance
     */
    public int getBalance(){
        return balance;
    }


    /** Withdraws amount from balance if balance minus the amount is greater then 0 and the amount less then 0
     * 
     * @param amount The amount to withdraw from the player's account.
     * @return Boolean to indicate success.
     */

    public boolean withdraw(int amount){
        if(balance - amount < 0 || amount < 0){
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

     /** Deposit amount to balance if amount is not less then 0 
     *
     * @param amount The amount to deposit.
     * @return Boolean to indicate success.
     */

    public boolean deposit(int amount){
        if(amount < 0){
            return false;
        } else {
            balance += amount;
            return true;
        }
    }
    
    public String toString(){
        return "Balance: " + balance;
    }

}
