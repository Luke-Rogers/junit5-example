package example;

import org.springframework.stereotype.Service;

@Service
public class CarValidator {

    public boolean valid(Car car) {
        if (car.isNew()) {
            return car.getRegPlate() == null;
        }
        return car.getRegPlate() != null;
    }
}
