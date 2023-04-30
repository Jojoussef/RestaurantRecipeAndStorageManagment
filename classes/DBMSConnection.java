import java.sql.*;

public class DBMSConnection{
    private static String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static String driver= "oracle.jdbc.driver.OracleDriver";
    private static String user = "c##TPjava";
    private static String password = "system";
    private Connection connection;
    private boolean status;
    public DBMSConnection(){
        try {
            Class.forName(driver);
        this.connection = DriverManager.getConnection(url, user, password);
        status=true;
        }catch(Exception e){
            status=false;
        }
    }

    public boolean getState(){
        return status;
    }

    public Connection getConnection(){
        return connection;   
    }

    public void closeConnection(){
        try{
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}