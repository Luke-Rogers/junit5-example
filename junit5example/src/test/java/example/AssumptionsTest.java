package example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {

    static Stream<Transport> transports() {
        return Stream.of(
                new Transport(TransportType.BIKE, 2),
                new Transport(TransportType.CAR, 4)
        );
    }

    /**
     * assumeTrue will only continue with the rest of the test if the assumption is true, otherwise
     * it is reported as ignored, not failed
     */
    @ParameterizedTest
    @MethodSource("transports")
    public void assumingTrue(Transport transport) {
        assumeTrue(TransportType.BIKE.equals(transport.getTransportType()), () -> "Not a bike!");
        assertEquals(2, transport.getWheels());
        assertNotNull(transport);
    }

    /**
     * assumingThat will only run the contents of the assumption if true
     */
    @ParameterizedTest
    @MethodSource("transports")
    public void assumeThat(Transport transport) {
        // Will run the contents of the assumption if true
        assumingThat(TransportType.BIKE.equals(transport.getTransportType()), () -> {
            assertEquals(2, transport.getWheels());
        });
        assumingThat(TransportType.CAR.equals(transport.getTransportType()), () -> {
            assertEquals(4, transport.getWheels());
        });
        assertNotNull(transport);
    }

    enum TransportType {
        CAR,
        BIKE
    }

    static class Transport {
        final TransportType transportType;
        final int wheels;

        Transport(TransportType transportType, int wheels) {
            this.transportType = transportType;
            this.wheels = wheels;
        }

        public TransportType getTransportType() {
            return transportType;
        }

        public int getWheels() {
            return wheels;
        }
    }

}
