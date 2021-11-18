package admin.dao;

import admin.dto.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImp implements VehicleDAO {

    @Override
    public boolean addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return  CrudUtil.getExecuteUpdate("INSERT INTO vehicale VALUES(?,?,?,?,?)",vehicle.getVehicleNo(),vehicle.getVehicleType(),vehicle.getVehicleKm(),vehicle.getAccidentCount(),vehicle.getNoOfWheel());
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean deleteVehicle(String id) {
        return false;
    }

    @Override
    public ArrayList<Vehicle> getAllVehicle() {
        return null;
    }
}
