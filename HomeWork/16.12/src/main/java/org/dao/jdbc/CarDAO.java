package org.dao.jdbc;

import components.*;
import org.dao.ICarDAO;
import org.example.BasicConnectionPool;
import vehicles.cars.Car;
import vehicles.cars.CasualCar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO {

    static BasicConnectionPool connectionPool = BasicConnectionPool.create();
    @Override
    public Car getEntityById(int id) {
        CasualCar car = new CasualCar();
        String sql = "SELECT * FROM cars.cars inner join cars.enginesQ on cars.cars._engine = cars.enginesQ.id where id = ?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                switch(resultSet.getInt("car_body")){
                    case 1:
                        car.setCarBody(CarBody.SUV);
                        break;
                    case 2:
                        car.setCarBody(CarBody.SEDAN);
                        break;
                    case 3:
                        car.setCarBody(CarBody.CROSSOVER);
                        break;
                    case 4:
                        car.setCarBody(CarBody.COUPE);
                        break;
                    case 5:
                        car.setCarBody(CarBody.MICRO);
                        break;
                    case 6:
                        car.setCarBody(CarBody.HATCHBACK);
                        break;
                    case 7:
                        car.setCarBody(CarBody.OFF_ROAD);
                        break;
                    case 8:
                        car.setCarBody(CarBody.PICK_UP);
                        break;
                    case 9:
                        car.setCarBody(CarBody.WAGON);
                        break;
                    case 10:
                        car.setCarBody(CarBody.VAN);
                        break;
                    case 11:
                        car.setCarBody(CarBody.LIMOUSINE);
                        break;
                    case 12:
                        car.setCarBody(CarBody.SPORT);
                        break;
                }
                car.setTopSpeed(resultSet.getInt("top_speed"));
                car.setWeight(resultSet.getDouble("weight"));
                car.setTitle(resultSet.getString("title"));
                car.setTankCapacity(resultSet.getDouble("tank_capacity"));
                car.setFuelConsumption(resultSet.getDouble("fuel_consumption"));
                car.setFuelLevel(resultSet.getDouble("fuel_level"));
                car.setNumberOfSeats(resultSet.getInt("numberOfSeats"));

                switch(resultSet.getInt("transmission")){
                    case 1:
                        car.setTransmission(new Transmission(Transmissions.SPORT));
                        break;
                    case 2:
                        car.setTransmission(new Transmission(Transmissions.CASUAL));
                        break;
                    case 3:
                        car.setTransmission(new Transmission(Transmissions.OFF_ROAD));
                        break;
                }

                car.setEngine(new Engine(
                        resultSet.getString("etitle"),
                        resultSet.getInt("horse_powers"),
                        resultSet.getDouble("capacity"),
                        resultSet.getInt("fuel_type") == 1 ? FuelTypes.DIESEL : (
                                resultSet.getInt("fuel_type") == 2 ? FuelTypes.GAS :
                                        (resultSet.getInt("fuel_type") == 3 ? FuelTypes.PETROL : FuelTypes.ELECTRICITY)
                        ))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error");
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return car;
    }

    @Override
    public List<Car> getEntities() {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM cars.cars";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/cars", "root", "root")){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CasualCar car = new CasualCar();
                switch(resultSet.getInt("car_body")){
                    case 1:
                        car.setCarBody(CarBody.SUV);
                        break;
                    case 2:
                        car.setCarBody(CarBody.SEDAN);
                        break;
                    case 3:
                        car.setCarBody(CarBody.CROSSOVER);
                        break;
                    case 4:
                        car.setCarBody(CarBody.COUPE);
                        break;
                    case 5:
                        car.setCarBody(CarBody.MICRO);
                        break;
                    case 6:
                        car.setCarBody(CarBody.HATCHBACK);
                        break;
                    case 7:
                        car.setCarBody(CarBody.OFF_ROAD);
                        break;
                    case 8:
                        car.setCarBody(CarBody.PICK_UP);
                        break;
                    case 9:
                        car.setCarBody(CarBody.WAGON);
                        break;
                    case 10:
                        car.setCarBody(CarBody.VAN);
                        break;
                    case 11:
                        car.setCarBody(CarBody.LIMOUSINE);
                        break;
                    case 12:
                        car.setCarBody(CarBody.SPORT);
                        break;
                }
                car.setTopSpeed(resultSet.getInt("top_speed"));
                car.setWeight(resultSet.getDouble("weight"));
                car.setTitle(resultSet.getString("title"));
                car.setTankCapacity(resultSet.getDouble("tank_capacity"));
                car.setFuelConsumption(resultSet.getDouble("fuel_consumption"));
                car.setFuelLevel(resultSet.getDouble("fuel_level"));
                car.setNumberOfSeats(resultSet.getInt("numberOfSeats"));

                switch(resultSet.getInt("transmission")){
                    case 1:
                        car.setTransmission(new Transmission(Transmissions.SPORT));
                        break;
                    case 2:
                        car.setTransmission(new Transmission(Transmissions.CASUAL));
                        break;
                    case 3:
                        car.setTransmission(new Transmission(Transmissions.OFF_ROAD));
                        break;
                }

                car.setEngine(new Engine(
                        resultSet.getString("etitle"),
                        resultSet.getInt("horse_powers"),
                        resultSet.getDouble("capacity"),
                        resultSet.getInt("fuel_type") == 1 ? FuelTypes.DIESEL : (
                                resultSet.getInt("fuel_type") == 2 ? FuelTypes.GAS :
                                        (resultSet.getInt("fuel_type") == 3 ? FuelTypes.PETROL : FuelTypes.ELECTRICITY)
                        ))
                );
                list.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }

        return list;
    }

    @Override
    public void insert(Car car) {
        String sql = "INSERT INTO `cars`.`cars`(`title`,`car_body`,`top_speed`,`tank_capacity`, 'weight', 'fuel_consumption', 'fuel_level', 'transmission')VALUES(?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getTitle());
            preparedStatement.setInt(2, car.getCarBody().ordinal());
            preparedStatement.setInt(3, car.getTopSpeed());
            preparedStatement.setDouble(4, car.getTankCapacity());
            preparedStatement.setDouble(5, car.getWeight());
            preparedStatement.setDouble(6, car.getFuelConsumption());
            preparedStatement.setDouble(7, car.getFuelLevel());
            preparedStatement.setInt(8, car.getTransmission().getTransmission().ordinal());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void update(int id, Car car) {
        String sql = "UPDATE 'cars'.'cars' SET title = ? WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getTitle());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM 'cars'.'cars' WHERE id = ?";
        try (Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
}
