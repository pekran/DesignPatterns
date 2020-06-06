import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingBucket shoppingBucket = new ShoppingBucket();
        shoppingBucket.addItem(new ItemX("alienWareComputer", 2000));
        shoppingBucket.addItem(new ItemX("Macbook Pro 13", 1400));

        shoppingBucket.makePayment(new CreditCardStrategy("swedbank", 123487787, 222, "2102"));
        shoppingBucket.makePayment(new PayPalStrategy("araz_ga@gmail.com", "iphoneX", 123234555));
    }
}

interface PayStrategy{
    void pay(int amount);
}

class CreditCardStrategy implements PayStrategy{
    String bankName;
    int cardNumber;
    int cvs;
    String expDate;

    public CreditCardStrategy(String bankName, int cardNumber, int cvs, String expDate) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.cvs = cvs;
        this.expDate = expDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvs() {
        return cvs;
    }

    public void setCvs(int cvs) {
        this.cvs = cvs;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Payed by creditcard " + amount + " $");
    }
}


class PayPalStrategy implements PayStrategy{
    String email;
    String phone;
    int cardNumber;

    public PayPalStrategy(String email, String phone, int cardNumber) {
        this.email = email;
        this.phone = phone;
        this.cardNumber = cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Payed by PayPal " + amount +" $");
    }
}

class ItemX {
    String name;
    int price;

    public ItemX(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ItemX{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


class ShoppingBucket {
    private final List<ItemX> items;

    public ShoppingBucket() {
        this.items = new ArrayList<>();
    }

    public void addItem(ItemX item){
        items.add(item);
    }

    public int totalPrice(){
       int amount = 0;
        for (ItemX item : items){
            amount += item.price;
        }
        return amount;
    }
    public void makePayment(PayStrategy payStrategy) {
        int amount = totalPrice();
        if (amount > 0) {
            payStrategy.pay(amount);
        } else {
            System.out.println("Skip payment");
        }
    }
}