import java.util.*;

public class Injection3 {
    public static void main(String[] args) {

       /* FkDataBase3 fkDataBase3 = new FkDataBase3();
        ItemsService itemsService = new ItemsService(fkDataBase3);
        UserService3 userService3 = new UserService3(fkDataBase3);
        HomePage3 homePage3 = new HomePage3(itemsService, userService3);
        WebbApplication3 webbApplication3 = new WebbApplication3(homePage3);
        webbApplication3.run();*/

        // WebbApplication3 app = ctx.getBean(WebbApplication3.class);
        // WebbApplication3 app2 =  Helpers.configDataHelper().getConfigurationData(WebbApplication3.class, "some_bean_id");
        // app.run();
        //app2.run();
    }
}

//@Configuration
class Config {

    //@Bean
    public WebbApplication3 webbApplication3(HomePage3 homePage3) {
        return new WebbApplication3(homePage3);
    }

    //@Bean
    public HomePage3 homePage3(ItemsService itemsService, UserService3 userService) {
        return new HomePage3(itemsService, userService);
    }


    //@Bean
    public FkDataBase3 fkDataBase3() {
        return new FkDataBase3();
    }

    //@Bean
    public ItemsService itemsService(FkDataBase3 fkDataBase3) {
        return new ItemsService(fkDataBase3);
    }

    //@Bean
    public UserService3 userService(FkDataBase3 fkDataBase3) {
        return new UserService3(fkDataBase3);
    }
}

//@Component
class WebbApplication3 {

    private final HomePage3 homePage3;

    //@Autowire
    public WebbApplication3(HomePage3 homePage3) {
        this.homePage3 = homePage3;
    }

    void run() {
        System.out.println("Loading page www.google.com");
        homePage3.show();
    }
}

//@Component
class HomePage3 {
    private final ItemsService itemsService;
    private final UserService3 userService3;

    //@Autowired
    public HomePage3(ItemsService itemsService, UserService3 userService3) {
        this.itemsService = itemsService;
        this.userService3 = userService3;
    }

    void show() {
        itemsService.findAllNames();
        userService3.findAllUser3();
    }

}

//@Repository
class FkDataBase3 {
    List<Item> findAllItems() {
        return Arrays.asList(
                new Item("Ipad2", 30),
                new Item("Ipad3", 50),
                new Item("Ipad4", 60)
        );
    }

    List<User3> findAllUser3() {
        return Arrays.asList(
                new User3("Alex", 23),
                new User3("Maria", 28),
                new User3("James", 36)
        );
    }
}

//@Service
class UserService3 {

    private final FkDataBase3 fkDataBase3;

    //@Autowired
    public UserService3(FkDataBase3 fkDataBase3) {
        this.fkDataBase3 = fkDataBase3;
    }

    Map<String, Integer> findAllUser3() {
        Map<String, Integer> userMap = new HashMap<>();
        for (User3 user3 : fkDataBase3.findAllUser3()) {
            userMap.put(user3.getName(), user3.getAge());
        }
        return userMap;
    }
}

//@Service
class ItemsService {
    private final FkDataBase3 fkDataBase3;

    //Autowired
    ItemsService(FkDataBase3 fkDataBase3) {
        this.fkDataBase3 = fkDataBase3;
    }

    public List<String> findAllNames() {
        List<String> itemNames = new ArrayList<>();
        for (Item item : fkDataBase3.findAllItems()) {
            itemNames.add(item.getName());
        }
        return itemNames;
    }
}

class User3 {
    String name;
    int age;

    public User3(String name, int age) {
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

class Item {
    String name;
    int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}




