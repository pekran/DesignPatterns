import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class AdapterPattern {
    public static void main(String[] args) {
        PersonGreetingAdapter adapter = new PersonGreetingAdapter();
        OnlineGreetingService service = new OnlineGreetingService();
        service.greet(new OnlineUser("John")); // Hello, John
        service.goodbye(new OnlineUser("John")); // Bye, John
        adapter.greet(new Person("Alex")); // Hello, Alex
        adapter.goodbye(new Person("Alex")); // Bye, Alex
    }
}

// 1 class
class OnlineUser {
    private final String username;

    OnlineUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// 2 class
class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Can greeting only User
class OnlineGreetingService {
    void greet(OnlineUser onlineUser) {
        System.out.println("Hello, " + onlineUser.getUsername());
        // ....
        // ....
        // ...
        // ...
//        System.out.println("Greeting ends...");
    }

    void goodbye(OnlineUser onlineUser) {
        System.out.println("Goodbye, " + onlineUser.getUsername() + "...");
        // ....
        // ....
        // ...
        // ...
    }
}

// Adapter should work with Person by using OnlineGreetingService
class PersonGreetingAdapter {
    public void greet(Person person) {
        OnlineGreetingService greetingService = new OnlineGreetingService();
        greetingService.greet(adaptationOfInstance(person));
    }

    private OnlineUser adaptationOfInstance(Person person) {
        return new OnlineUser(person.getName());
    }

    public void goodbye(Person person) {
        OnlineGreetingService greetingService = new OnlineGreetingService();
        greetingService.goodbye(new OnlineUser(person.getName()));
    }

    private OnlineUser adaptationOfInstance2(Person person) {
        return new OnlineUser(person.getName());
    }
}