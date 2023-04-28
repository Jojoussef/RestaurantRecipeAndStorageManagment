import java.util.ArrayList;
import java.sql.*;
abstract class DAO <T> {
    protected Connection conn;
    protected DAO(Connection conn){
        this.conn=conn;
    }
    public abstract ArrayList<T> findAll();
    public abstract  T find(int id);
    public abstract boolean create(T o);
    public abstract boolean update(T o);
    public abstract boolean delete(T o);
}