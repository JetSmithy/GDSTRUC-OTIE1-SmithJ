import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);


        int playerId = 1;
        int gamesMade = 0;


        while (gamesMade < 10) {
            System.out.println("\nMatchmaking");
            System.out.println("Games made " + gamesMade + "/10");
            System.out.println("Players in current queue: " + queue.size());


            // Randomly enqueue 1 to 7 players
            int x = rand.nextInt(7) + 1;


            System.out.println("\n" + x + " players are are attempting to join queue:");


            for (int i = 0; i < x; i++) {
                Player player = new Player(
                        playerId,
                        "Player" + playerId,
                        rand.nextInt(1000) + 1
                );


                queue.enqueue(player);


                System.out.println("Enqueued: " + player);
                playerId++;
            }


            System.out.println("\nCurrent queue:");
            queue.printQueue();


            // Press Enter to end the turn
            System.out.println("\nPress Enter to end this turn...");
            scanner.nextLine();


            // Start games while at least 5 players are available
            while (queue.size() >= 5 && gamesMade < 10) {
                gamesMade++;


                System.out.println("\nGame " + gamesMade);
                System.out.println("Match found! Current players are:");


                for (int i = 0; i < 5; i++) {
                    System.out.println((i + 1) + ". " + queue.dequeue());
                }


                System.out.println("Game " + gamesMade + " successfully created!");
                System.out.println("Players remaining in queue: " + queue.size());
            }
        }


        System.out.println("Matchmaking Completed");
        System.out.println("Successfully created 10 games!");
        System.out.println("Players remaining in current queue: " + queue.size());


        scanner.close();
    }


}


