import java.util.*;
import java.util.stream.*;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
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
        return "Bogie{" + "type='" + type + '\'' + ", capacity=" + capacity + '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Passenger", 80),
                new Bogie("Passenger", 120),
                new Bogie("Cargo", 200),
                new Bogie("Passenger", 60),
                new Bogie("Cargo", 150)
        );

        // Filter only passenger bogies with capacity > 70
        List<Bogie> passengerBogies = bogies.stream()
                .filter(b -> b.getType().equalsIgnoreCase("Passenger"))
                .filter(b -> b.getCapacity() > 70)
                .collect(Collectors.toList());

        passengerBogies.forEach(System.out::println);
    }
}