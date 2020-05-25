public class BuilderPattern {

    public static void main(String[] args) {

        System.out.println(Car_.builder()
                .setModel(21)
                .setName("alex")
                .build());
    }
}

class Car_ {
    private int model;
    private String name;
    private String color;
    private String owner;

    public Car_(int model, String name, String color, String owner) {
        this.model = model;
        this.name = name;
        this.color = color;
        this.owner = owner;
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car_{" +
                "model=" + model +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}

class CarBuilder {
    private int model;
    private String name;
    private String color;
    private String owner;

    public CarBuilder setModel(int model) {
        this.model = model;
        return this;
    }

    public CarBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public Car_ build() {
        return new Car_(model, name, color, owner);
    }


}
