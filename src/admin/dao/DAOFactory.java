package admin.dao;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private  DAOFactory(){

    }
    public  static DAOFactory getSingleton(){
        if(daoFactory==null){
           return daoFactory = new DAOFactory();
        }
        return daoFactory;
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
