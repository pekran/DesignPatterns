import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class AbstractFactoryPattern1 {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = AbstractFActoryProducer.getFactory(true);
        abstractFactory.getVehicle("scooter").move();

        abstractFactory.getVehicle("car").move();
    }
}

// package-private, no-modifiers

interface Vehicle {
    void move();
}

abstract class WheelVehicle implements Vehicle{

    @Override
    public void move() {

    }
}

class __Car extends WheelVehicle {
    @Override
    public void move() {
        System.out.println("I can move maximum in 180km/h");
    }
}

class __Scooter extends WheelVehicle {
    @Override
    public void move() {
        System.out.println("I can move in maximum 40 km/h");
    }
}


abstract class NonWheelVehicle implements Vehicle{

    @Override
    public void move() {

    }
}

class __Helicopter extends NonWheelVehicle {
}

class __Plane extends NonWheelVehicle {
}







abstract class AbstractFactory{
    abstract Vehicle getVehicle(String vehicleType);
}






class WheelVehicleFactory extends AbstractFactory{

    @Override
    Vehicle getVehicle(String vehicleType) {
        if(vehicleType.equalsIgnoreCase("Scooter")){
            return new __Scooter();
        }
        else if(vehicleType.equalsIgnoreCase("Car")){
            return new __Car();
        }
        return null;
    }
}


class NonWheelVechileFactory extends AbstractFactory{

    @Override
    Vehicle getVehicle(String vehicleType) {
       if(vehicleType.equalsIgnoreCase("Helicopter")){
           return new __Helicopter();
       }
       else if(vehicleType.equalsIgnoreCase("Plane")){
           return new __Plane();
       }
       return null;
    }
}


class AbstractFActoryProducer{
    public static AbstractFactory getFactory(boolean isWheelVehicle){
        if(isWheelVehicle){
            return new WheelVehicleFactory();
        }else {
            return new NonWheelVechileFactory();
        }
    }
}
