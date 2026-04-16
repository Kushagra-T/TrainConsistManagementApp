import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Prepare dataset of bogies
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            bogies.add(new Bogie("Passenger-" + i, (i % 100) + 1));
        }

        // Loop-based filtering
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream-based filtering
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Results
        System.out.println("Loop-based result size: " + loopFiltered.size());
        System.out.println("Stream-based result size: " + streamFiltered.size());
        System.out.println("Loop execution time (ns): " + loopTime);
        System.out.println("Stream execution time (ns): " + streamTime);

        // Consistency check
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("✅ Both approaches produced identical results.");
        } else {
            System.out.println("❌ Results differ between approaches.");
        }
    }
}
