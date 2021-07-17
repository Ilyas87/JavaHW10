package org.itstep.Lesson10.service;

import org.itstep.Lesson10.entity.Car;

import java.util.List;

public interface DbService {

    List<Car> getAllCars();

    void addCar(Car car);

    void removeCar(Long id);
}
