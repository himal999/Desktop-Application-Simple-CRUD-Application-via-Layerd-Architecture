package admin.dao;

import admin.dto.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDAO {
    boolean addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException;
    boolean updateVehicle(Vehicle vehicle);
    boolean deleteVehicle(String id);
    ArrayList<Vehicle> getAllVehicle();
}
