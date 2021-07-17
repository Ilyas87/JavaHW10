package org.itstep.Lesson10.dao;

import org.itstep.Lesson10.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private static final String GET_ALL_CARS = "select * from mysql.cars";
    private static final String ADD_CAR = "insert into mysql.cars values(NULL, ?, ?, ?)";
    private static final String DELETE_CAR = "delete from mysql.cars where id=?";
    private final String url = "jdbc:mysql://localhost:3306";
    private final String user = "root";
    private final String password = "root";
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_CARS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                Double engineVolume = resultSet.getDouble(4);
                cars.add(new Car(id, name, price, engineVolume));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public void addCar(final Car car) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_CAR);
            statement.setString(1, car.getName());
            statement.setDouble(2, car.getPrice());
            statement.setDouble(3, car.getEngineVolume());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCar(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CAR);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
