package admin.bo;

import admin.dao.VehicleDAO;
import admin.dao.VehicleDAOImp;
import admin.dto.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImp implements VehicleBO {

    VehicleDAO vehicleDAO = new VehicleDAOImp();

    @Override
    public boolean addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return vehicleDAO.addVehicle(vehicle);

    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return vehicleDAO.updateVehicle(vehicle);

    }

    @Override
    public boolean deleteVehicle(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.deleteVehicle(id);

    }

    @Override
    public ArrayList<Vehicle> getAllVehicle() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getAllVehicle();
    }

    @Override
    public Vehicle getVehicle(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.getVehicle(id);
    }
}
