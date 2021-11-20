package admin.dao;

import admin.dto.Vehicle;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDAOImp implements VehicleDAO {

    @Override
    public boolean addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return  CrudUtil.getExecuteUpdate("INSERT INTO vehicale VALUES(?,?,?,?,?)",vehicle.getVehicleNo(),vehicle.getVehicleType(),vehicle.getVehicleKm(),vehicle.getAccidentCount(),vehicle.getNoOfWheel());
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
       return CrudUtil.getExecuteUpdate("UPDATE vehicale SET v_type=?,v_km=?,v_aCount=?,v_noOfWheel=? WHERE v_no=?",vehicle.getVehicleType(),vehicle.getVehicleKm(),vehicle.getAccidentCount(),vehicle.getNoOfWheel(),vehicle.getVehicleNo());
    }

    @Override
    public boolean deleteVehicle(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.getExecuteUpdate("DELETE FROM vehicale WHERE v_no=?",id);

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

    @Override
    public Vehicle getVehicle(String id) throws SQLException, ClassNotFoundException {
        Vehicle vehicle=null;
        ResultSet rst =  CrudUtil.getExecuteQuery("SELECT * FROM vehicale WHERE v_no=?",id);
        if(rst.next()){
            vehicle = new Vehicle(rst.getString("v_no"),rst.getString("v_type"),rst.getInt("v_km"),rst.getInt("v_aCount"),rst.getInt("v_noOfWheel"));
        }
        return vehicle;
    }
}
