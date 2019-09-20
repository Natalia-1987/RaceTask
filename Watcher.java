import java.util.Arrays;

public class Watcher {
    private int leader = -1;

    synchronized public void checkLeader(int[] positions) {
        int maxPosition = Arrays.stream(positions).max().getAsInt();
        long carsOnMaxPosition = Arrays.stream(positions).filter(value -> value == maxPosition).count();
        if (carsOnMaxPosition == 1) {
            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == maxPosition) {
                    if (leader != i) {
                        leader = i;
                        System.out.println("Leader changed. Now Car" + leader + " is leader");
                    }
                    break;
                }
            }
        }
    }
}
