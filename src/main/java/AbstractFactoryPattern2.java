public class AbstractFactoryPattern2 {
    public static void main(String[] args) {
        _FactoryProducer factoryProducer = new _FactoryProducer();
        _AbstractFactory abstractFactory = factoryProducer.getFactory(true);
        abstractFactory.getVehicle("car").move();

    }


}


interface ___Vehicle{
    void move();
}

class ___Car implements ___Vehicle{
    @Override
    public void move() {
        System.out.println("I can move fast!");
    }
}

class ___Scooter implements ___Vehicle{

    @Override
    public void move() {
        System.out.println("Im not so fast!");
    }
}

class ___Plane implements  ___Vehicle{
    @Override
    public void move() {
        System.out.println("Im really fast in sky!");
    }
}
class ___Helicopter implements ___Vehicle{

    @Override
    public void move() {
        System.out.println("Im not as fast in sky as plane!");
    }
}





abstract class _AbstractFactory {
     abstract ___Vehicle getVehicle(String vehicle);
}



class ___WheelVehicleFactory extends _AbstractFactory {
    @Override
    ___Vehicle getVehicle(String vehicle) {
        if(vehicle.equalsIgnoreCase("car")){
            return new ___Car();
        } else if(vehicle.equalsIgnoreCase("scooter")){
            return new ___Scooter();
        }
        return null;
    }
}


class NonWheelVehicleFactory extends _AbstractFactory {

    @Override
    ___Vehicle getVehicle(String vehicle) {
        if(vehicle.equalsIgnoreCase("Plane")){
            return new ___Plane();
        } else if(vehicle.equalsIgnoreCase("Helicopter")){
            return new ___Helicopter();
        }
        return null;
    }
}

class _FactoryProducer{
    public _AbstractFactory getFactory(boolean isWheelVehicle){
        if(isWheelVehicle){
            return new ___WheelVehicleFactory();
        } else {
            return new NonWheelVehicleFactory();
        }
    }
}



