import java.util.*;
import java.util.stream.Collectors;

public class AdapterPattern6 {

    public static void main(String[] args) {
        List<Volvo> volvoList1 = Arrays.asList(
                new Volvo(31, "erik", "red"),
                new Volvo(22, "anders", "yellow"));


        System.out.println(CarCompanyBuyerSW.CalculateTotPrice(volvoList1));
        CarCompanyBuyerSW.changeOwner(volvoList1);
        System.out.println(volvoList1);


        List<Saab> saabsList = Arrays.asList(
                new Saab(44, "gustav", "Blue"),
                new Saab(48, "patrik", "Brown"));

        System.out.println(CarCompanyBuyerSW.CalculateTotPrice(CarCompanyAdapter.adapt(saabsList)));
        List<Volvo> adapt = CarCompanyAdapter.adapt(saabsList);
        CarCompanyBuyerSW.changeOwner(adapt);
        System.out.println(adapt);
    }
}

class CarCompanyBuyerSW {
    //static int totPrice;
    public static int CalculateTotPrice(List<Volvo> volvos) {
        int totPrice = 0;
        for (Volvo volvo : volvos) {
            totPrice += volvo.getPrice();
        }
        return totPrice;
    }

    public static void changeOwner(List<Volvo> volvos) {
        for (Volvo volvo : volvos) {
            volvo.setOwner("CompanyOwned");
        }
    }
}


class CarCompanyAdapter {
    public static List<Volvo> adapt(List<Saab> saabs) {
        List<Volvo> saablist = new ArrayList<>();
        for (Saab sab : saabs) {
            saablist.add(new Volvo(sab.getPrice(), sab.getOwner(), sab.getColor()));
        }
        return saablist;
    }
}

class Volvo {
    int price;
    String owner;
    String color;


    public Volvo(int price, String owner, String color) {
        this.price = price;
        this.owner = owner;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Volvo{" +
                "price=" + price +
                ", owner='" + owner + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class Saab {
    int price;
    String owner;
    String color;

    public Saab(int price, String owner, String color) {
        this.price = price;
        this.owner = owner;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Saab{" +
                "price=" + price +
                ", owner='" + owner + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

