package admin.controller;

import admin.bo.VehicleBO;
import admin.bo.VehicleBOImp;
import admin.dto.Vehicle;
import admin.view.dtoTM.VehicleTM;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;


public class VehicleFormController {
    public TableView<VehicleTM> tblVehicle;
    public JFXTextField txtVehicleNo;
    public JFXTextField txtNoOfWheels;
    public JFXTextField txtRunning;
    public JFXComboBox cmbVehicleType;
    public JFXTextField txtAccidentCount;
    public JFXButton btnDynamic;
    private VehicleBO vehicleBO = new VehicleBOImp();

    public void initialize() throws SQLException, ClassNotFoundException {
        btnDynamic.setDisable(true);
        txtVehicleNo.setDisable(true);
        cmbVehicleType.setDisable(true);
        txtNoOfWheels.setDisable(true);
        txtRunning.setDisable(true);
        txtAccidentCount.setDisable(true);

        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vehicleKm"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("accidentCount"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("noOfWheel"));
        tblVehicle.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("hbox"));

        loadTable();

        tblVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDynamic.setDisable(newValue != null);

        });
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
        clearField();

    }

    public void changeItSelfOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (btnDynamic.getText().equalsIgnoreCase("Add")) {
            Vehicle vehicle = new Vehicle(
                    txtVehicleNo.getText(),
                    cmbVehicleType.getValue().toString(),
                    Integer.parseInt(txtRunning.getText()),
                    Integer.parseInt(txtAccidentCount.getText()),
                    Integer.parseInt(txtNoOfWheels.getText())
            );

            if (vehicleBO.addVehicle(vehicle)) {
                loadTable();
                clearField();
                btnDynamic.setDisable(true);
                new Alert(Alert.AlertType.CONFIRMATION, "Added Success").show();
                return;
            } else {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
                return;
            }
        } else if(btnDynamic.getText().equalsIgnoreCase("Update")){
           Vehicle vehicle =  vehicleBO.getVehicle(txtVehicleNo.getText());
                if(vehicle.getVehicleType().equalsIgnoreCase(cmbVehicleType.getSelectionModel().selectedItemProperty().getName()) && String.valueOf(vehicle.getAccidentCount()).equalsIgnoreCase(txtAccidentCount.getText()) && String.valueOf(vehicle.getNoOfWheel()).equalsIgnoreCase(txtNoOfWheels.getText()) && String.valueOf(vehicle.getVehicleKm()).equalsIgnoreCase(txtRunning.getText())){
                    new Alert(Alert.AlertType.ERROR,"Please Enter New Value Data").show();
                    btnDynamic.setDisable(true);
                    return;
                }else{
                    Vehicle tempVehicle = new Vehicle(
                            vehicle.getVehicleNo(),
                            cmbVehicleType.getValue().toString(),
                            Integer.parseInt(txtRunning.getText()),
                            Integer.parseInt(txtAccidentCount.getText()),
                            Integer.parseInt(txtNoOfWheels.getText())
                    );

                    if(vehicleBO.updateVehicle(tempVehicle)){
                        clearField();
                        loadTable();
                        cmbVehicleType.getSelectionModel().clearSelection();
                        btnDynamic.setDisable(true);
                        tblVehicle.getSelectionModel().clearSelection();
                        new Alert(Alert.AlertType.CONFIRMATION,"Update Success").show();
                        return;
                    }else{
                        new Alert(Alert.AlertType.ERROR,"Try Again").show();
                        return;
                    }
                }
        }
    }

    private void loadUI() {
        ObservableList<String> type = FXCollections.observableArrayList("Van", "Lorry", "Car");
        cmbVehicleType.setItems(type);
    }

    private void loadTable() throws SQLException, ClassNotFoundException {
        tblVehicle.getItems().clear();
        VehicleBO vehicleBO = new VehicleBOImp();
        ArrayList<Vehicle> vehicles = vehicleBO.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            Button update = new Button("Update");
            Button delete = new Button("Delete");
            HBox hbox = new HBox(update,delete);
            tblVehicle.getItems().add(new VehicleTM(vehicle.getVehicleNo(), vehicle.getVehicleType(), vehicle.getNoOfWheel(), vehicle.getAccidentCount(), vehicle.getVehicleKm(),hbox));

            update.setOnAction(event -> {
                btnDynamic.setDisable(false);
                btnDynamic.setText("Update");
                txtVehicleNo.setDisable(false);
                txtVehicleNo.setEditable(false);
                txtVehicleNo.setText(vehicle.getVehicleNo());
                cmbVehicleType.setDisable(false);
                cmbVehicleType.setId(vehicle.getVehicleType());
                txtAccidentCount.setDisable(false);
                txtAccidentCount.setText(String.valueOf(vehicle.getAccidentCount()));
                txtRunning.setDisable(false);
                txtRunning.setText(String.valueOf(vehicle.getVehicleKm()));
                txtNoOfWheels.setDisable(false);
                txtNoOfWheels.setText(String.valueOf(vehicle.getNoOfWheel()));
                loadUI();
            });
        }
    }

    private void clearField(){
        txtVehicleNo.clear();
        cmbVehicleType.setId("");
        txtRunning.clear();
        txtAccidentCount.clear();
        txtNoOfWheels.clear();
    }
}
