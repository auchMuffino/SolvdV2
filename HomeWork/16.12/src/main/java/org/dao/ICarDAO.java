package org.dao;

import vehicles.cars.Car;
import vehicles.cars.CasualCar;

import java.util.List;

public interface ICarDAO extends IBaseDao<Car>{

    @Override
    Car getEntityById(int id);

    @Override
    List<Car> getEntities();

    @Override
    void insert(Car car);

    @Override
    void update(int id, Car car);

    @Override
    void delete(int id);

}
