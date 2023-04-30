import java.sql.*;
import java.util.ArrayList;

public class RangementDAO extends DAO<Rangement> {

    public RangementDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Rangement rangement) {
        try{
            if (find(rangement.getRefRangement()) != null) {
                return false;
            }
            PreparedStatement statement = conn.prepareStatement("INSERT INTO rangement (refRangement, nomRangement) VALUES (?, ?)");
            statement.setInt(1, rangement.getRefRangement());
            statement.setString(2, rangement.getNomRangement());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id)  {
        try{
            PreparedStatement statement = conn.prepareStatement("DELETE FROM rangement WHERE refRangement = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){ e.printStackTrace();
            return false;
        }      
        return true;
    }

    @Override
    public boolean update(Rangement rangement)  {
        try{
            if (find(rangement.getRefRangement()) == null) {
                return false;
            }
            PreparedStatement statement = conn.prepareStatement("UPDATE rangement SET nomRangement = ? WHERE refRangement = ?");
            statement.setString(1, rangement.getNomRangement());
            statement.setInt(2, rangement.getRefRangement());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        } 
        return true;
    }

    @Override
    public ArrayList<Rangement> findAll()  {
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rangement");
            ArrayList<Rangement> rangements = new ArrayList<>();
            while (resultSet.next()) {
                Rangement rangement = new Rangement(resultSet.getInt("refRangement"),resultSet.getString("nomRangement"));
                rangements.add(rangement);
            }
            return rangements;
        }catch(SQLException e){ e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public ArrayList<Rangement> findAll(String champ, String nomChamp)  {
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rangement"+nomChamp+champ);
            ArrayList<Rangement> rangements = new ArrayList<>();
            while (resultSet.next()) {
                Rangement rangement = new Rangement(resultSet.getInt("refRangement"),resultSet.getString("nomRangement"));
                rangements.add(rangement);
            }
            return rangements;
        }catch(SQLException e){ e.printStackTrace();
            return null;
        }
    }

    @Override
    public Rangement find(int id) {
        try{
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM rangement WHERE refRangement = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Rangement rangement = null;
        if (resultSet.next()) {
            rangement = new Rangement(resultSet.getInt("refRangement"),resultSet.getString("nomRangement"));
        }
        return rangement;
        }catch(SQLException e){ e.printStackTrace();
            return null;
        }
    }
}
