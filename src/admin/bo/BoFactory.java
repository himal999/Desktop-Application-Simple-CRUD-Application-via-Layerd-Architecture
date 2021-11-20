package admin.bo;

import admin.dao.VehicleDAOImp;


public class BoFactory {
    private static  BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getSingleton(){
     if(boFactory==null){
         boFactory = new BoFactory();
     }
     return boFactory;
    }

    public  VehicleDAOImp getInstance(getType type){
        switch (type){
             case VEHICLE:return new VehicleDAOImp();
        }
        return null;
    }


    public enum getType{
        VEHICLE
    }


}
