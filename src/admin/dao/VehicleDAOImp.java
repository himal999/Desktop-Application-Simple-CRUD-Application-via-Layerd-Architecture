package admin.dao;

import admin.dto.Vehicle;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
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
    public ArrayList<Vehicle> getAllVehicle() throws SQLException, ClassNotFoundException {
     ArrayList<Vehicle> vehicles = new ArrayList<>();
     ResultSet rst = CrudUtil.getExecuteQuery("SELECT * FROM vehicale");
     while(rst.next()){
         vehicles.add(new Vehicle(
             rst.getString("v_no"),
             rst.getString("v_type"),
             rst.getInt("v_km"),
             rst.getInt("v_aCount"),
             rst.getInt("v_noOfWheel")
         ));
     }
        return vehicles;
    }
}
