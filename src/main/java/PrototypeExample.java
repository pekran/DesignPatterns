import java.util.ArrayList;
import java.util.List;

// This is a prototype(creational design pattern). Can produce on thing by using clone method several time!
public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        flood("192.10.111.23");
    }

    private static void flood(String ip) throws CloneNotSupportedException {
        final List<Bot> bots = new ArrayList<>();
        final Bot prototype = new Bot(ip);
        for (int i = 0; i < 10; i++) {
            bots.add(prototype.clone());
        }
        for (Bot bot : bots) {
            bot.ping();
        }
    }
}

// Prototype
class Bot implements Cloneable {
    private final String ip;

    Bot(String ip) {
        this.ip = ip;
    }

    void ping() {
        System.out.printf("ping to %s%n", ip);
    }

    @Override
    protected Bot clone() throws CloneNotSupportedException {
        return new Bot(this.ip);
    }
}
