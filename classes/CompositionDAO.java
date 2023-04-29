import java.sql.*;
import java.util.ArrayList;


public class CompositionDAO extends DAO<Composition> {

    public CompositionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Composition composition) {
        try{
            if (find(composition.getRefComposition()) != null) {
                return false;
            }
            PreparedStatement statement = conn.prepareStatement("INSERT INTO composition (refComposition, quantiteComposition, refRecette, refIngredient) VALUES (?, ?, ?, ?)");
            statement.setInt(1, composition.getRefComposition());
            statement.setDouble(2, composition.getQuantiteComposition());
            statement.setInt(3, composition.getRefRecette());
            statement.setInt(4, composition.getRefIngredient());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try{
            
            PreparedStatement statement = conn.prepareStatement( "DELETE FROM composition WHERE refComposition = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Composition composition) {
        try{
            if (find(composition.getRefComposition()) == null) {
                return false;
            }
            PreparedStatement statement = conn.prepareStatement("UPDATE composition SET quantiteComposition = ?, refRecette = ?, refIngredient = ? WHERE refComposition = ?");
            statement.setDouble(1, composition.getQuantiteComposition());
            statement.setInt(2, composition.getRefRecette());
            statement.setInt(3, composition.getRefIngredient());
            statement.setInt(4, composition.getRefComposition());
            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Composition> findAll()  {
        ArrayList<Composition> compositions = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM composition");
            while (resultSet.next()) {
                Composition composition = new Composition();
                composition.setRefComposition(resultSet.getInt("refComposition"));
                composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
                composition.setRefRecette(resultSet.getInt("refRecette"));
                composition.setRefIngredient(resultSet.getInt("refIngredient"));
                compositions.add(composition);
        }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return compositions;
    }

    @Override
    public Composition find(int id)  {
        Composition composition=null;
        try{
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM composition WHERE refComposition = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            composition = new Composition();
            composition.setRefComposition(resultSet.getInt("refComposition"));
            composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
            composition.setRefRecette(resultSet.getInt("refRecette"));
            composition.setRefIngredient(resultSet.getInt("refIngredient"));
        }
    }catch(SQLException e){
        e.printStackTrace();
        return composition;
    }
        return composition;
    }
}

