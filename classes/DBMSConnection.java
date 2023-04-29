import java.sql.*;

public class DBMSConnection{
    private static String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static String driver= "oracle.jdbc.driver.OracleDriver";
    private static String user = "system";
    private static String password = "Azer2014";
    private static Connection connection;
    public DBMSConnection(){
        try {
            Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connexion effective !"); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;   
    }

    public void closeConnection(){
        try{
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
}