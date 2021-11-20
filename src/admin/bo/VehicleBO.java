package admin.bo;

import admin.dto.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBO {
     boolean addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException;
     boolean updateVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException;
     boolean deleteVehicle(String id) throws SQLException, ClassNotFoundException;
     ArrayList<Vehicle> getAllVehicle() throws SQLException, ClassNotFoundException;
     Vehicle getVehicle(String id) throws SQLException, ClassNotFoundException;
}
