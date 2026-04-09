import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================
 * DOMAIN MODEL - Bogie
 * ============================================================================
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("[%s: %d Seats]", name, capacity);
    }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 10: Count Total Seats in Train (reduce)
 * * Description:
 * This use case demonstrates functional aggregation. We use the Stream API
 * to transform Bogie objects into their numeric capacities and then
 * 'reduce' them into a single sum.
 * * @version 10.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Initialize the Train Consist
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("AC Chair Car", 56));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("General Coach", 90));

        System.out.println("Calculating total capacity for the following consist:");
        trainConsist.forEach(b -> System.out.println(" + " + b));

        // 2. Key Concept: Map and Reduce
        // map: Extracts the capacity (Integer) from each Bogie object
        // reduce: Sums all extracted capacities starting from 0 (identity)
        int totalSeatingCapacity = trainConsist.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        // 3. Display the numeric analytics
        System.out.println("\n--- Operational Analytics ---");
        System.out.println("Total Passenger Bogies: " + trainConsist.size());
        System.out.println("Total Seating Capacity : " + totalSeatingCapacity + " Seats");

        // 4. Verify Integrity
        System.out.println("\nStatus: Aggregation successful. Total capacity is finalized for dispatch.");
    }
}