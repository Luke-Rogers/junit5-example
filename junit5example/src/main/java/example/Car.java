package example;

public class Car {

    enum Type {
        NEW,
        USED
    }

    final String make;
    final String model;
    final String variant;
    final Price price;
    final String regPlate;
    final Type type;

    public static Car newCar(String make, String model, String variant, Price price) {
        return new Car(make, model, variant, price, null, Type.NEW);
    }

    public static Car usedCar(String make, String model, String variant, Price price, String regPlate) {
        return new Car(make, model, variant, price, regPlate, Type.USED);
    }

    public Car (String make, String model, String variant, Price price, String regPlate, Type type) {
        this.make = make;
        this.model = model;
        this.variant = variant;
        this.price = price;
        this.regPlate = regPlate;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVariant() {
        return variant;
    }

    public Price getPrice() {
        return price;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public boolean isNew() {
        return Type.NEW.equals(this.type);
    }

    public boolean isUsed() {
        return Type.USED.equals(this.type);
    }
}