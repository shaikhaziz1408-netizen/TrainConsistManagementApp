import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public int getCapacity() { return capacity; }
}

/**
 * ============================================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ============================================================================
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * * Description:
 * This use case compares the execution speed of traditional 'for' loops
 * against modern 'Streams'. We use System.nanoTime() for precise
 * benchmarking on a simulated large dataset.
 * * @version 13.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("   === Train Consist Management App ===");
        System.out.println("=======================================\n");

        // 1. Setup a large dataset for realistic benchmarking
        List<Bogie> largeConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeConsist.add(new Bogie("Bogie-" + i, (int) (Math.random() * 100)));
        }

        System.out.println("Dataset Ready: 10,000 bogies generated.");
        int threshold = 60;

        // --- BENCHMARK 1: TRADITIONAL LOOP ---
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : largeConsist) {
            if (b.getCapacity() > threshold) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // --- BENCHMARK 2: JAVA STREAMS ---
        long startStream = System.nanoTime();

        List<Bogie> streamResult = largeConsist.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 2. Display Results
        System.out.println("\n--- Performance Benchmarking Results ---");
        System.out.println("Loop Execution Time   : " + loopDuration + " ns");
        System.out.println("Stream Execution Time : " + streamDuration + " ns");

        // 3. Result Verification
        System.out.println("\nConsistency Check:");
        System.out.println("Loop Result Count: " + loopResult.size());
        System.out.println("Stream Result Count: " + streamResult.size());

        if (loopResult.size() == streamResult.size()) {
            System.out.println("✔ RESULTS MATCH: Both methods returned identical data.");
        }

        // 4. Insight
        String faster = (loopDuration < streamDuration) ? "Traditional Loop" : "Java Stream";
        System.out.println("\nCONCLUSION: The " + faster + " was faster in this run.");
        System.out.println("Note: Streams often have a 'startup overhead' for smaller datasets.");
    }
}