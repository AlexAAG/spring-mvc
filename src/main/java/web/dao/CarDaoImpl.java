package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getCars(Integer count) {

        List<Car> listCar = new ArrayList<>();

        listCar.add(new Car("AUDI", 7, 3150000, "Business"));
        listCar.add(new Car("BMW", 5, 3410000, "Business"));
        listCar.add(new Car("Mercedes", 1, 3750000, "Business"));
        listCar.add(new Car("ВАЗ", 2, 475000, "Econom"));
        listCar.add(new Car("ГАЗ", 3, 575000, "Econom"));

        if(count == null) {
            return listCar;
        } else {
            return listCar.stream().limit(count).collect(Collectors.toList());
        }
    }
}
