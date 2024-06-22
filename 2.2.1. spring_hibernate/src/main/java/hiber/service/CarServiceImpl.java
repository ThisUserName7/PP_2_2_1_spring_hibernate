package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService{
    public CarDao carDa;
    @Override
    public void save(Car car) {
        carDa.addCar(car);
    }

    @Override
    public List<Car> listCat() {
        return carDa.listCars();
    }
}
