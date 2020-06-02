import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public class InjectionTest {

    public static void main(String[] args) {
      /*  FkDataBase_ fkDataBase_ = new FkDataBase_();
        UserService_ userService3 = new UserService_(fkDataBase_);
        ComponentsService componentsService = new ComponentsService(fkDataBase_);
        HomePage_ homePage_ = new HomePage_(userService3, componentsService);
        WebbApplication4 webbApplication4 = new WebbApplication4(homePage_);
        webbApplication4.run();*/


        // loading configuration class containing all beans from config class.
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config_.class);
        WebbApplication4 webApp = ctx.getBean(WebbApplication4.class);
        webApp.run();

        //if you have not config class and want to load all beans by annnotating abobe.
     /*   ApplicationContext ctx3 = new AnnotationConfigApplicationContext("com.mycompany.com");
        WebbApplication4 webApp3 = ctx3.getBean(WebbApplication4.class);
        webApp.run();*/
    }
}

@Configuration
//@ComponentScan(basePackages = {"com.mycom.package"})
class Config_ {
    @Bean
    public WebbApplication4 webbApplication4(HomePage_ homePage_) {
        return new WebbApplication4(homePage_);
    }

    @Bean
    public FkDataBase_ fkDataBase_() {
        return new FkDataBase_();
    }

    @Bean
    public HomePage_ homePage_(UserService_ userService_, ComponentsService componentsService) {
        return new HomePage_(userService_, componentsService);
    }

    @Bean
    public UserService_ userService_(FkDataBase_ fkDataBase_){
        return new UserService_(fkDataBase_);
    }

    @Bean
    public ComponentsService componentsService(FkDataBase_ fkDataBase_) {
        return new ComponentsService(fkDataBase_);
    }
}


@Component
class WebbApplication4 {
    private final HomePage_ homePage_;

    WebbApplication4(HomePage_ homePage_) {
        this.homePage_ = homePage_;
    }

    void run() {
        System.out.println("Loading page -> http://www.google.com");
        homePage_.render_();
    }
}

@Repository
class FkDataBase_ {
    List<User_> findUsers_() {
        return Arrays.asList(
                new User_("Alex", 33),
                new User_("Araz", 33),
                new User_("Elnaz", 30)
        );
    }

    List<ComputerComponent> findAllComponents() {
        return Arrays.asList(
                new ComputerComponent("motherboard", 40),
                new ComputerComponent("cpui7", 90),
                new ComputerComponent("ssdDisc", 70)
        );
    }
}

@Component
class HomePage_ {
    private final UserService_ userService_;
    private final ComponentsService componentsService;

    @Autowired
    public HomePage_(UserService_ userService_, ComponentsService componentsService) {
        this.userService_ = userService_;
        this.componentsService = componentsService;
    }

    void render_() {
        System.out.println(userService_.findAllUserNames_());
        System.out.println(componentsService.findAllComputerComp());
    }

}

@Service
class UserService_ {
    private final FkDataBase_ fkDataBase_;

    @Autowired
    public UserService_(FkDataBase_ fkDataBase_) {
        this.fkDataBase_ = fkDataBase_;
    }

    public List<String> findAllUserNames_() {
        List<String> stringList = new ArrayList<>();
        for (User_ user_ : fkDataBase_.findUsers_()) {
            stringList.add(user_.getName());
        }
        return stringList;
    }
}

@Service
class ComponentsService {
    private final FkDataBase_ fkDataBase_;

    @Autowired
    public ComponentsService(FkDataBase_ fkDataBase_) {
        this.fkDataBase_ = fkDataBase_;
    }

    public List<String> findAllComputerComp() {
        List<String> components = new ArrayList<>();
        for (ComputerComponent component : fkDataBase_.findAllComponents()) {
            components.add(component.getName());
        }
        return components;
    }
}


class User_ {
    String name;
    int age;

    public User_(String name, int age) {
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

class ComputerComponent {
    String name;
    int price;

    public ComputerComponent(String name, int price) {
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