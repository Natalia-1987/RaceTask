class Car implements Runnable {
    private int carNumber;
    private int[] positions;
    private Integer distance;
    private Watcher watcher;

    public Car(int carNumber, int[] positions, Integer distance, Watcher watcher) {
        this.carNumber = carNumber;
        this.positions = positions;
        this.distance = distance;
        this.watcher = watcher;
    }

    @Override
    public void run() {
//        System.out.println("Car " + carNumber + " started");
        while (positions[carNumber] < distance) {
//            System.out.println("Car " + carNumber + " have position " + positions[carNumber]);
            positions[carNumber]++;
            watcher.checkLeader(positions);
        }
    }
}

