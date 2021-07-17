package org.itstep.Lesson10.service;

import org.itstep.Lesson10.dao.DbManager;
import org.itstep.Lesson10.entity.Car;

import java.util.List;

public class DbServiceImpl implements DbService{

    private DbManager dbManager;

    public DbServiceImpl() {
        this.dbManager = new DbManager();
        dbManager.connect();
    }

    @Override
    public List<Car> getAllCars() {
        return dbManager.getCars();
    }

    @Override
    public void addCar(final Car car) {
        dbManager.addCar(car);
    }

    @Override
    public void removeCar(Long id) {
        dbManager.removeCar(id);
    }
}
