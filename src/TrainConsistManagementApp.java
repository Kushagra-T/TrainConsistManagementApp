import java.util.*;
import java.util.stream.Collectors;

// Define PassengerBogie class
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Step 1: Create a list of passenger bogies (reuse from UC7)
        List<PassengerBogie> bogieList = Arrays.asList(
                new PassengerBogie("Sleeper", 55),
                new PassengerBogie("AC Chair", 80),
                new PassengerBogie("First Class", 100),
                new PassengerBogie("Sleeper", 60),
                new PassengerBogie("AC Chair", 70)
        );

        // Step 2: Convert list to stream and apply filter
        List<PassengerBogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60) // condition
                .collect(Collectors.toList());

        // Step 3: Display filtered bogies
        System.out.println("Filtered Passenger Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // Step 4: Verify original list remains unchanged
        System.out.println("\nOriginal Bogie List (Unchanged):");
        bogieList.forEach(System.out::println);
    }
}
