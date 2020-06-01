
public class SingeltonePattern {
    public static void main(String[] args) {
        EagerCarSingleton instance = EagerCarSingleton.getInstance();
        System.out.println(instance);
        System.out.println(EagerCarSingleton.getInstance());

        LazyComputerSingleTon lazyInstance = LazyComputerSingleTon.getLazyInstance();
        System.out.println(lazyInstance);
        lazyInstance.setCpu("core i-7");
        System.out.println(lazyInstance);
        System.out.println(LazyComputerSingleTon.getLazyInstance().getCpu());
    }
}


class EagerCarSingleton {
    private int age;
    private String color;
    private String carType;

    private static final EagerCarSingleton instance  = new EagerCarSingleton(10, "red", "BMW");

    public static EagerCarSingleton getInstance(){
        return instance;
    }

     private EagerCarSingleton(int age, String color, String carType) {
        this.age = age;
        this.color = color;
        this.carType = carType;
    }

    public void movement(){
        System.out.println("I can move fast!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "CarsSingleton{" +
                "age=" + age +
                ", color='" + color + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}


class LazyComputerSingleTon{
    private int ram;
    private String cpu;
    private String graphicCard;

    private LazyComputerSingleTon(int ram, String cpu, String graphicCard) {
        this.ram = ram;
        this.cpu = cpu;
        this.graphicCard = graphicCard;
    }

    private static LazyComputerSingleTon lazyInstance;

    public static LazyComputerSingleTon getLazyInstance(){
        if(lazyInstance == null){
            lazyInstance = new LazyComputerSingleTon(16, "corei9", "NvidiaGforeX");
        }
        return lazyInstance;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    @Override
    public String toString() {
        return "LazyComputerSingleTon{" +
                "ram=" + ram +
                ", cpu='" + cpu + '\'' +
                ", graphicCard='" + graphicCard + '\'' +
                '}';
    }
}


