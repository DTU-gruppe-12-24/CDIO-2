package test;

import game.Account;
import game.RaffleCup;

/**
 * Class for testing according to the specifications:
 * <br>
 * - The distribution of the 6-sided die: simple counting of the observed face values.
 * <br>
 * - The max time of rolling the dice with the raffle cup.
 * <br>
 * - Making sure the account balance cannot become negative.
 * <br>
 * The results are printed to the terminal.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("RaffleCup tests:");
        raffleCupTests();
        System.out.println(System.lineSeparator() + "Account tests:");
        accountTests();
    }

    public static void accountTests() {
        boolean success = true;
        Account account = new Account(1000);
        System.out.println("Initial account: " + account);
        account.withdraw(2000);
        System.out.println("Account after withdrawing 2000: " + account);
        if(account.getBalance() < 0) success = false;
        account.deposit(-2000);
        System.out.println("Account after depositing -2000: " + account);
        if(account.getBalance() < 0) success = false;

        // Output of test
        if(success) {
            System.out.println("Account test: SUCCESS!" + System.lineSeparator() + "The account balance can never become negative.");
        } else {
            System.out.println("Account test: FAIL!" + System.lineSeparator() + "The account balance ended up being negative.");
        }
    }

    public static void raffleCupTests() {
        int[] countArrFaceValue = new int[6]; // Array to keep track of the face value count.
        long maxTime = Long.MIN_VALUE; // To keep track of the max time experienced for each roll.

        RaffleCup cup = new RaffleCup(6);

        for (int i = 0; i < 1000; i++) {
            /*
              Start measuring execution time as we want to see how long it takes from rolling to
              seeing/looking up the face value of the dice.
              Source: https://www.geeksforgeeks.org/measure-time-taken-function-java/; accessed: 2024/10/22.
             */
            long startTime = System.nanoTime();

            cup.roll();
            cup.getValue(0);
            cup.getValue(1);

            // Stop measuring execution time.
            long endTime = System.nanoTime();

            // Calculate the execution time in nanoseconds.
            long executionTime
                    = (endTime - startTime);

            // Update max if higher time observed.
            if (executionTime > maxTime) {
                maxTime = executionTime;
            }

            // Increment face value counter in our counter-array.
            countArrFaceValue[cup.getValue(0) - 1]++;
        }

        // Output of our tests:
        // Count of the different face values.
        System.out.println("The count of the different face values of die 1 of the raffle cup:");
        for (int i = 0; i < countArrFaceValue.length; i++) {
            System.out.println("Face value: " + (i + 1) + ", count: " + countArrFaceValue[i]);
        }
        System.out.println();

        // The max time we've measured from rolling the dice to having read the face value of all dice.
        System.out.println("The max time we've measured: " + maxTime + " nanoseconds.");
    }
}