import java.sql.*;

public class DBMSConnection{
    private static String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static String driver= "oracle.jdbc.driver.OracleDriver";
    private static String user = "system";
    private static String password = "Azer2014";

    public static void main(String args[]){
        try {
            Class.forName(driver);
        Connection connection;
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connexion effective !"); 
        connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
        
}