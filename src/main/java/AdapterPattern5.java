import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdapterPattern5 {
    public static void main(String[] args) {

        List<BMW> bmws = Arrays.asList(
                new BMW("X1", 123456, "alex", 2),
                new BMW("X2", 222333, "John", 1),
                new BMW("X3", 333444, "Arthur", 3));
                new BMW("X6", 887656, "MAX", 6);

        //CarCompanyBuyer carCompanyBuyer = new CarCompanyBuyer();
        System.out.println(CarCompanyBuyer.totalPriceOfMultipleCars(bmws));
        System.out.println(CarCompanyBuyer.changeAllRegNumberToSame(bmws));
        System.out.println(CarCompanyBuyer.changeAllOwnerToSame(bmws));
        System.out.println(CarCompanyBuyer.carType(bmws));

        System.out.println("---------------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------------------------------------------");

        List<Toyota> toyotaList = Arrays.asList(
                new Toyota("Aygo", 123456, "Sara", 2),
                new Toyota("Carmen", 222333, "Peter", 1),
                new Toyota("Rav4", 333444, "Pontus", 3));
        new Toyota("Highlander", 887656, "Boss", 8);

        //CarCompanyBayerAdapter carCompanyBayerAdapter = new CarCompanyBayerAdapter();
        System.out.println(CarCompanyBayerAdapter.totalPriceOfMultipleCars(toyotaList));
        System.out.println(CarCompanyBayerAdapter.changeAllRegNumberToSame(toyotaList));
        System.out.println(CarCompanyBayerAdapter.changeAllOwnerToSame(toyotaList));
        System.out.println(CarCompanyBayerAdapter.carType(toyotaList));
    }
}

class BMW {

    String name;
    int regNumber;
    String Owner;
    int price;

    public BMW(String name, int regNumber, String owner, int price) {
        this.name = name;
        this.regNumber = regNumber;
        this.Owner = owner;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getOwner() {
        return Owner;
    }

    public int price() {
        return price;
    }

    public static String forestDriving() {
        return " Im really fast in forest!";
    }

    public static String AsfaltRoad() {
        return  " Im really fast in asfalt roads!";
    }
}

class Toyota {

    String name;
    int regNumber;
    String Owner;
    int price;

    public Toyota(String name, int regNumber, String owner, int price) {
        this.name = name;
        this.regNumber = regNumber;
        this.Owner = owner;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getOwner() {
        return Owner;
    }

    public int getPrice() {
        return price;
    }

    public static String forestDriving(String name) {
        return name + " Im really designed to drive in forest!";
    }

    public static String AsfaltRoad(String name) {
        return name + " Im not so good to drive fast on asfalt!";
    }


}

class CarCompanyBuyer {

    public static String totalPriceOfMultipleCars(List<BMW> bmwList) {
        return bmwList.stream().mapToDouble(BMW::price).sum() + " Dollar sum price of all cars!";
    }

    public static String changeAllRegNumberToSame(List<BMW> bmwList) {
        List<Integer> regNumbers = bmwList.stream().map(BMW::getRegNumber).collect(Collectors.toList());
        ListIterator<Integer> iterator = regNumbers.listIterator();

        while (iterator.hasNext()) {
            Integer reg = iterator.next();
            iterator.set(Integer.parseInt(reg.toString().replace(reg.toString(),"9893432")));
        }

        // StringJoin
        // ["a", "b", "c"] -> "abc"

        return regNumbers.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static String changeAllOwnerToSame(List<BMW> bmwList) {
        List<String> owners = bmwList.stream().map(BMW::getOwner).collect(Collectors.toList());
        ListIterator<String> iterator = owners.listIterator();

        while (iterator.hasNext()) {
            String owner = iterator.next();
            iterator.set(owner.replace(owner, "Company"));
        }

        return owners.toString().replace("[", "").replace("]","");
    }

    public static Map<String, String> carType(List<BMW> bmwList) {
        Map<String, String> map = new HashMap<>();

        for (BMW carType : bmwList ){
          switch (carType.getName()) {
              case "X1":
                  map.put("X1", BMW.AsfaltRoad());

              case "X2":
                  map.put("X2", BMW.forestDriving());
              case "X3":
                  map.put("X3", BMW.forestDriving());
              default:
                  map.put("Montercar", " This car is good both in asfalt and forest! ");
          }
        }
        return map;
    }
}

class CarCompanyBayerAdapter {

    public static String totalPriceOfMultipleCars(List<Toyota> toyotaList) {
      return CarCompanyBuyer.totalPriceOfMultipleCars(adaptionToToyota(toyotaList));
    }


    public static String changeAllRegNumberToSame(List<Toyota> Toyotalist) {
        return CarCompanyBuyer.changeAllRegNumberToSame(adaptionToToyota(Toyotalist));

    }

    public static String changeAllOwnerToSame(List<Toyota> Toyotalist) {
        return CarCompanyBuyer.changeAllOwnerToSame(adaptionToToyota(Toyotalist));
    }

    public static Map<String, String> carType(List<Toyota> Toyotalist) {
        Map<String, String> map = new HashMap<>();
        for (Toyota carType : Toyotalist){
            switch (carType.getName()){
                case("Aygo"):
                  map.put("Aygo", Toyota.AsfaltRoad(carType.getName()));
                case("Carmen"):
                    map.put("Carmen", Toyota.AsfaltRoad(carType.getName()));
                case ("Rav4"):
                    map.put("Rav4",  Toyota.forestDriving(carType.getName()));
                default:
                    map.put("Montercar", "This is both good for asfalt and forest!");
            }
        }
        return map;
    }

    public static List<BMW> adaptionToToyota(List<Toyota> toyotaList){

     return toyotaList.stream().map(toyota -> new BMW(toyota.getName(), toyota.getRegNumber(), toyota.getOwner(), toyota.getPrice())).collect(Collectors.toList());


    }

}



