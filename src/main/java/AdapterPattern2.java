import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterPattern2 {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
                new Customer("1", "alex", true),
                new Customer("2", "john", true),
                new Customer("#", "undef", false),
                new Customer("4", "undef", false)
        );
        List<Client> clients = Arrays.asList(
                new Client("1" , true),
                new Client("2",  true),
                new Client("#", false),
                new Client("4", false)
        );
        CustomerStats customerStats = new CustomerStats();
        CustomerStatsToClientAdapter adapter = new CustomerStatsToClientAdapter();
        System.out.println(customerStats.countAll(customers));
        System.out.println(customerStats.countActive(customers));

        System.out.println(adapter.countAll(clients));
        System.out.println(adapter.countActive(clients));
    }
}

// 1 class
class Customer {
    private final String id;
    private final String name;
    // means our customer is active.
    private final boolean active;

    Customer(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }
}

// 2 class
class Client {
    private final String id;
    // means our customer is active.
    private final boolean active;

    Client(String id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }
}

class CustomerStats {
    public int countAll(List<Customer> items) {
        return items.size();
    }

    public int countActive(List<Customer> items) {
        return (int) items.stream()
                .filter(Customer::isActive)
                .count();
    }
}

class CustomerStatsToClientAdapter {

    public int countAll(List<Client> items){
        return new CustomerStats().countAll(adaptationOf(items));
    }

    public int countActive(List<Client> items){
        return new CustomerStats().countActive(adaptationOf(items));
    }

    private List<Customer> adaptationOf(List<Client> items) {
        // for loop each item and map it
        List<Customer> customers = new ArrayList<>();
        for (Client client : items) {
            customers.add(toCustomer(client));
        }
        return customers;
    }

    // mapping = convert 1 obj type to another
    // here means Client to Customer
    private Customer toCustomer(Client client) {
        return new Customer(client.getId(), null, client.isActive());
    }
}

