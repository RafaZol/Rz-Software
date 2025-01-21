/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzsoftware.conectbd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Rafael
 */
public class Conexao {
    
    public static Connection connection;
    
    public static Connection getConnection(){
        try {
            connection = Conexao.connect("postgresql", "localhost", "postgres", "5432", "my_db", "5432", "");
            
            connection.setAutoCommit(false);
        } catch (SQLException sx){
            sx.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
    
    public static void setConnection(Connection connection){
        Conexao.connection = connection;
    }
    
    private static Connection connect(String type, String host, String user, String pass,
            String db_name, String port, String aux) throws SQLException, Exception {
        registrar(type);
        //jdbc:postgresql://<host>:<port>/<database>?user=<username>&password=<password>
        String url = "jdbc:" + type + "://" + host + ":" + port + "/" + db_name + "?ApplicationName=APILite" +
                 ((aux.isEmpty() ? "" : "&Parameter1=" + aux));
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);
        return DriverManager.getConnection(url, props);
    }
    
    private static void registrar(String type) throws ClassNotFoundException{
        if(type.equals("postgresql")){
            type = "org.postgresql.Driver";
        } 
        if (type.equals("mysql")){
            type = "com.mysql.jdbc.Driver";
        }
        Class.forName(type);
    }
    
    
    
}
