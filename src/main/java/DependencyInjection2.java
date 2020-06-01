import java.util.Arrays;
import java.util.List;

public class DependencyInjection2 {
    public static void main(String[] args) {
        FkDataBase2 fkDataBase2 = new FkDataBase2();
        GoodsService2 goodsService2 = new GoodsService2(fkDataBase2);
        UserService2 userService2 = new UserService2(fkDataBase2);
        HomePage2 homePage2 = new HomePage2(userService2,goodsService2);

        WebApplication2 webApplication2 = new WebApplication2(homePage2);
        webApplication2.run();


    }
}


//@Component
class WebApplication2{

    //@Autowire
    private final HomePage2 page;

    WebApplication2(HomePage2 page) {
        this.page = page;
    }
    void run(){
        System.out.println("http://www.google.com");
        page.render2();
    }
}






class HomePage2{

    //@Autowire
    private final UserService2 userService2;
    //@Autowire
    private final GoodsService2 goodsService2;

    public HomePage2(UserService2 userService2, GoodsService2 goodsService2) {
        this.userService2 = userService2;
        this.goodsService2 = goodsService2;
    }

    public UserService2 getUserService2() {
        return userService2;
    }

    public GoodsService2 getGoodsService2() {
        return goodsService2;
    }

    public void render2(){
        System.out.println("All Users");
        for (User2 user : userService2.findAllUsers()) {
            System.out.println(user.getName());
            System.out.println("----");
        }
        for (Order2 order2 : goodsService2.findAllOrders()){
            System.out.println(order2.getWatch() + " " + order2.getIpad());
        }
    }

}

//@Service
class UserService2{
    //@Autowire
    private final FkDataBase2 fkDataBase2;

    UserService2(FkDataBase2 fkDataBase2) {
        this.fkDataBase2 = fkDataBase2;
    }
    List<User2> findAllUsers() {
        return fkDataBase2.findAllUsers();
    }
}
//@Service
class GoodsService2{
    //@Autowire
private final FkDataBase2 fkDataBase2;

    GoodsService2(FkDataBase2 fkDataBase2) {
        this.fkDataBase2 = fkDataBase2;
    }
    List<Order2> findAllOrders(){
        return fkDataBase2.findAllOrders();
    }
}

//@Repository
class FkDataBase2{

     List<User2> findAllUsers(){
       return Arrays.asList(
                 new User2("alex", 33),
                 new User2("Dayan", 22),
                 new User2("Sharon", 21)

         );
     }
     List<Order2> findAllOrders(){
            return Arrays.asList(
              new Order2("ipad2", "rolex"),
              new Order2("ipad2", "Citizen"),
                    new Order2("ipad3", "Swiss")
            );
     }
}


class User2{
    String name;
    int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Order2{
    String ipad;
    String watch;

    public Order2(String ipad, String watch) {
        this.ipad = ipad;
        this.watch = watch;
    }

    public String getIpad() {
        return ipad;
    }

    public void setIpad(String ipad) {
        this.ipad = ipad;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }
}
