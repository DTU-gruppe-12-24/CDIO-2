package game;

class Program {
    /** 
     * Main function of the program.
     * Creates and starts the game.
     */
    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.play();
    }
}

public class DiceGame {
    private Player[] players;
    private RaffleCup raffleCup;
    private java.util.Scanner scanner;

    public DiceGame() {
        scanner = new java.util.Scanner(System.in);

        players = new Player[2];
        
        raffleCup = new RaffleCup(6);
    }
    
    public void play() {
        
        // Not in constructor in case game would be replayed
        players[0] = new Player(1000, 1);
        players[1] = new Player(1000, 2);

        int currentPlayerIndex = (int) (Math.random() * 2);
        Player currentPlayer = players[currentPlayerIndex];

        boolean playing = true;
        while(playing) {
            
            System.out.println(System.lineSeparator() + "Player " + currentPlayer.getID() + " press enter to roll the dice.");
            scanner.nextLine();
            raffleCup.roll();

            int sum = raffleCup.getSum();
            int value1 = raffleCup.getValue(0);
            int value2 = raffleCup.getValue(1);
            System.out.println("Die 1 value: " + value1);
            System.out.println("Die 2 value: " + value2);
            System.out.println("Total value: " + sum);

            int change = switch (sum) {
                case 2 -> 250; 
                case 3 -> -100;
                case 4 -> 100;
                case 5 -> -20;
                case 6 -> 180;
                case 7 -> 0;
                case 8 -> -70;
                case 9 -> 60;
                case 10 -> -80; //werewall
                case 11 -> -50;
                default -> 650;
            };

            String translateableOutput = switch (sum) {
                case 2 -> "You ascend the ancient tower, discovering hidden treasures worth 250 coins.";
                case 3 -> "Exploring the crater proves disastrous, costing you 100 coins in lost supplies.";
                case 4 -> "You pass through the majestic palace gates, rewarded with 100 coins from the grateful nobles.";
                case 5 -> "The unforgiving cold desert saps your strength, leaving you 20 coins poorer.";
                case 6 -> "Entering the walled city, you uncover lucrative opportunities, gaining 180 coins.";
                case 7 -> "The monastery offers peace and wisdom, but no wealth is found here.";
                case 8 -> "The black cave swallows your resources, costing you 70 coins in the process.";
                case 9 -> "The friendly villagers in the mountain huts reward you with 60 coins for your assistance.";
                case 10 -> "Encountering the Werewall sends you fleeing, costing you 80 coins, but you gain an extra turn!";
                case 11 -> "You stumble into a treacherous pit, losing 50 coins in the fall.";
                case 12 -> "You've uncovered a legendary goldmine, bringing you 650 coins and immense wealth!";
                default -> "Invalid number. Please select a valid option.";
            };

            System.out.println("Player " + currentPlayer.getID() + ", " +  translateableOutput);

            
            if (change > 0) currentPlayer.deposit(change);
            else if (change < 0) {
                if (!currentPlayer.withdraw(-change)) currentPlayer.withdraw(currentPlayer.getBalance());
            }


            if (currentPlayer.getBalance() > 3000) {
                playing = false;
                System.out.println("You won the game, player " + currentPlayer.getID() + ". Congratulations!!!" 
                + System.lineSeparator() + "The final scores are as follows:");
            }

            System.out.println("Player 1 balance: " + players[0].getBalance());
            System.out.println("Player 2 balance: " + players[1].getBalance());

            if (sum == 10) {
                System.out.println("Because you landed on the werewall tile, you get an extra turn.");
            } else {
                // Switch turn to next player
                if(currentPlayerIndex == 0) currentPlayerIndex = 1;
                else currentPlayerIndex = 0;
                currentPlayer = players[currentPlayerIndex];
            }
        }
        
        boolean decided = false;
        while(!decided) {
            System.out.println("Do you want to play again? (yes/no)");
            String answer = scanner.nextLine().toLowerCase();
            //Play game again
            if(answer.equals("yes")) {
                decided = true;
                play();
            }
            //Leave function
            else if(answer.equals("no")) {
                decided = true;
            }
            //Ask again
            else {
                System.out.println("Unrecognized answer");
            }
        }

    }
}
