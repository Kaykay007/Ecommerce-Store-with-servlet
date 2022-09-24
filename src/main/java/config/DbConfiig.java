package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiig {
    public static Connection connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet" , "root" , "/Authenticator02");
            return  conn;
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
