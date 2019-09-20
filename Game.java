import java.util.Arrays;

public class Game {
    private static int distance = 1000;
    private static int cars = 10;

    public static void main(String[] args) throws InterruptedException {
        Watcher watcher = new Watcher();
        int[] carsPositions = new int[cars];

        for (int i = 0; i < cars; i++) {
            carsPositions[i] = 0;
            new Thread(new Car(i, carsPositions, distance, watcher)).start();
        }

        do {
//            System.out.println(Arrays.toString(carsPositions));
        } while (Arrays.stream(carsPositions)
                .min().getAsInt() < distance);

        System.out.println("All cars finished");
    }
}
