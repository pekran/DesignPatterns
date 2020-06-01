import java.util.Arrays;
import java.util.List;

public class DepsInjection {
    public static void main(String[] args) {
        FkDatabase fkDatabase = new FkDatabase();

        UserService userService = new UserService(fkDatabase);
        OrderService orderService = new OrderService(fkDatabase);
        HomePage page = new HomePage(userService, orderService);

        WebApplication webApplication = new WebApplication(page);

//                 ------------------------------------------
//
//        WebApplication webApplication = ctx.getBean(WebApplication.class);
          webApplication.run();
    }
}

// 1. Dependency
// only 1 page:

// @Component
class WebApplication {
    // dependency for WebApplication

    // @Autowired
    private final HomePage page;

    WebApplication(HomePage page) {
        this.page = page;
    }

    void run() {
        System.out.println("App started at http://localhost:8080");
        page.render();
    }
}


// 2. Other Dependencies

// 1. List of users
// 2. list of their orders


// @Configuration
// class Config {
//
//    @Bean
//    public HomePage homePage() {
//        return new HomePage(...);
//    }
//

//  @Component
class HomePage {
    // @Autowired
    private final UserService userService;
    // @Autowired
    private final OrderService orderService;

    HomePage(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    public void render() {
        System.out.println("ALL users:");
        for (_User user : userService.findAll()) {
            System.out.println(user.getName());
        }
        System.out.println("---------------------------------");
        System.out.println("All orders: ");
        for (_Order order : orderService.findAll()) {
            System.out.println(order.getGood());
        }
        System.out.println("---------------------------------");
        System.out.println("Page loaded...");
    }
}

// @Service
class UserService {
    // @Autowired
    private final FkDatabase fkDatabase;

    UserService(FkDatabase fkDatabase) {
        this.fkDatabase = fkDatabase;
    }

    List<_User> findAll() {
        return fkDatabase.findAllUsers();
    }
}

// @Service
class OrderService {
    // @Autowired = @Inject
    private final FkDatabase fkDatabase;

    OrderService(FkDatabase fkDatabase) {
        this.fkDatabase = fkDatabase;
    }

    List<_Order> findAll() {
        return fkDatabase.findAllOrders();
    }
}

// @Repository = @Component
class FkDatabase {
    List<_User> findAllUsers() {
        return Arrays.asList(
                new _User("alex", 27),
                new _User("john", 22),
                new _User("jack", 30)
        );
    }

    List<_Order> findAllOrders() {
        return Arrays.asList(
                new _Order(new _User("alex", 27), "iphone", 1_000),
                new _Order(new _User("alex", 27), "macbook", 1_000),
                new _Order(new _User("alex", 27), "apple watch", 2_000)
        );
    }
}

class _User {
    private final String name;
    private final int age;

    _User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class _Order {
    private final _User user;
    private final String good;
    private final double price;

    _Order(_User user, String good, double price) {
        this.user = user;
        this.good = good;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getGood() {
        return good;
    }

    public _User getUser() {
        return user;
    }
}