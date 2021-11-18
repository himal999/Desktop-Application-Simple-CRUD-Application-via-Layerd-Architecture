package admin.dto;

public class Vehicle {
   private String vehicleNo;
   private String vehicleType;
   private int vehicleKm;
   private int accidentCount;
   private int noOfWheel;

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVehicleKm() {
        return vehicleKm;
    }

    public void setVehicleKm(int vehicleKm) {
        this.vehicleKm = vehicleKm;
    }

    public int getAccidentCount() {
        return accidentCount;
    }

    public void setAccidentCount(int accidentCount) {
        this.accidentCount = accidentCount;
    }

    public int getNoOfWheel() {
        return noOfWheel;
    }

    public void setNoOfWheel(int noOfWheel) {
        this.noOfWheel = noOfWheel;
    }

    public Vehicle() {
    }

    public Vehicle(String vehicleNo, String vehicleType, int vehicleKm, int accidentCount, int noOfWheel) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.vehicleKm = vehicleKm;
        this.accidentCount = accidentCount;
        this.noOfWheel = noOfWheel;
    }
}
