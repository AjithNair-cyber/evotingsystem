package app;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public abstract class DBInterface{

    private final static String url = Config.DATABASE_URL;
    private final static String user = Config.DATABASE_USER;
    private final static String password = Config.DATABASE_PASSWORD;

    public static ArrayList<HashMap<String, Object>> executeQuery(String query) {
        Connection conn;
        ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> row = null;

        try{
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();

            while(result.next()){
                row = new HashMap<String, Object>();
                for(int i = 1; i <= columnCount; i++){
                    row.put(metaData.getColumnName(i), result.getObject(i));
                }
                resultList.add(row);
            }
            conn.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "An error occured while processing the request");
            resultList = null;
        }finally{
            return resultList;
        }
    }

    public static int executeUpdate(String query) {
        int result = 0;
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(query);
            conn.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "An error occured while processing the request");
            result = -1;
        }finally{
            return result;
        }
    }
}
