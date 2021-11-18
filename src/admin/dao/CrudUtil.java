package admin.dao;

import admin.db.DbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    private static PreparedStatement getPrepareStatement(String sql, Object... args) throws SQLException, ClassNotFoundException {
       Connection connection = DbConnection.getInstance().getConnection();
       PreparedStatement pstm = connection.prepareStatement(sql);
       for(int i=0;i < args.length ; i++){
           pstm.setObject(i+1,args[i]);
       }
       return pstm;
    }

    public static boolean getExecuteUpdate(String sql,Object...args) throws SQLException, ClassNotFoundException {
        return getPrepareStatement(sql,args).executeUpdate()>0;
    }
    public static ResultSet getExecuteQuery(String sql,Object...args) throws SQLException, ClassNotFoundException {
        return getPrepareStatement(sql,args).executeQuery();
    }
}
