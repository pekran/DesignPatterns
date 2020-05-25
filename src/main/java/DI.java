import java.util.Arrays;
import java.util.List;

public class DI {
    public static void main(String[] args) {
        // Road road = ctx.getBean(Road.class)
        // road.cars = 2 Cars
        
        // Road road = new Road()
        // road.cars = null
    }

    //
    public static Road createRoad() {
        Road road = new Road();
        road.cars = Arrays.asList(
                new Car(),
                new Car()
        );
        return road;
    }
}


// depends on Driver and Passengers
class Car {
    Driver driver;
    List<Passenger> passengers;
}

class Driver {
}

class Passenger {
}

// depends on objects like Cars
class Road {
    // Dependency
    List<Car> cars;
} 