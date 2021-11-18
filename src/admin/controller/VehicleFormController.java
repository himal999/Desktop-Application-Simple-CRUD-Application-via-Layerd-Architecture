package admin.controller;

import admin.bo.VehicleBO;
import admin.bo.VehicleBOImp;
import admin.dto.Vehicle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

import java.sql.SQLException;


public class VehicleFormController {
    public TableView tblVehicle;
    public JFXTextField txtVehicleNo;
    public JFXTextField txtNoOfWheels;
    public JFXTextField txtRunning;
    public JFXComboBox cmbVehicleType;
    public JFXTextField txtAccidentCount;
    public JFXButton btnDynamic;
    private VehicleBO vehicleBO = new VehicleBOImp();

    public void initialize(){
        btnDynamic.setDisable(true);
        txtVehicleNo.setDisable(true);
        cmbVehicleType.setDisable(true);
        txtNoOfWheels.setDisable(true);
        txtRunning.setDisable(true);
        txtAccidentCount.setDisable(true);
    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
        btnDynamic.setText("Add");
        btnDynamic.setDisable(false);
        txtVehicleNo.setDisable(false);
        cmbVehicleType.setDisable(false);
        txtNoOfWheels.setDisable(false);
        txtRunning.setDisable(false);
        txtAccidentCount.setDisable(false);
        loadUI();
    }

    public void changeItSelfOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(btnDynamic.getText().equalsIgnoreCase("Add")){
            Vehicle vehicle = new Vehicle(
                    txtVehicleNo.getText(),
                    cmbVehicleType.getValue().toString(),
                    Integer.parseInt(txtRunning.getText()),
                    Integer.parseInt(txtAccidentCount.getText()),
                    Integer.parseInt(txtNoOfWheels.getText())
            );

            if(vehicleBO.addVehicle(vehicle)){
                new Alert(Alert.AlertType.CONFIRMATION,"Added Success").show();
                return;
            }else{
                new Alert(Alert.AlertType.ERROR,"Try Again").show();
                return;
            }
        }else{

        }
    }

    private void loadUI(){
        ObservableList<String> type = FXCollections.observableArrayList("Van","Lorry","Car");
        cmbVehicleType.setItems(type);
    }
}
