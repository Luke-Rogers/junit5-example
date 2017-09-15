import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssertionsTest {

    @Test
    public void mathAddTest() {
        assertEquals("Assertion message", 3, 1 + 2);
    }

    @Test
    public void groupedAssertions() {
        Car bmw = new Car("BMW", "M3", "M3 Competition Pack", null);
        assertEquals("AUDI", bmw.getMake());
        assertEquals("M3", bmw.getModel());
        assertEquals("M3 Standard", bmw.getVariant());
    }

    class Car {
        final String make;
        final String model;
        final String variant;
        final Price price;

        Car (String make, String model, String variant, Price price) {
            this.make = make;
            this.model = model;
            this.variant = variant;
            this.price = price;
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
    }

    class Price {
        final double net;
        final double gross;

        Price (double net, double gross) {
            this.net = net;
            this.gross = gross;
        }

        public double getNet() {
            return net;
        }

        public double getGross() {
            return gross;
        }
    }

}
