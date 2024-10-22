public class Account {
    private int balance;    

    public Account(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public boolean withdraw(int amount){
        if(balance - amount < 0 || amount < 0){
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

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
