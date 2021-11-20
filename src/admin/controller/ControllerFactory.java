package admin.controller;

import admin.bo.VehicleBOImp;

public class ControllerFactory {
    private static ControllerFactory controllerFactory;

    private ControllerFactory(){

    }

    public static ControllerFactory getSingleton(){
        if(controllerFactory==null){
          return   controllerFactory = new ControllerFactory();
        }
        return null;
    }

    public VehicleBOImp getInstance(getType type){
        switch (type){
            case VEHICLE: return new VehicleBOImp();
        }
        return null;
    }

    public enum getType{
        VEHICLE
    }
}
