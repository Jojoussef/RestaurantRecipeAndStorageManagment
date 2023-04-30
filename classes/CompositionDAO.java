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
            statement.setString(1, composition.getRefComposition());
            statement.setDouble(2, composition.getQuantiteComposition());
            statement.setString(3, composition.getRefRecette());
            statement.setString(4, composition.getRefIngredient());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try{
            
            PreparedStatement statement = conn.prepareStatement( "DELETE FROM composition WHERE refComposition = ?");
            statement.setString(1, id);
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
            statement.setString(2, composition.getRefRecette());
            statement.setString(3, composition.getRefIngredient());
            statement.setString(4, composition.getRefComposition());
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
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM composition");
            ResultSet resultSet = statement.executeQuery( );
            while (resultSet.next()) {
                Composition composition = new Composition();
                composition.setRefComposition(resultSet.getString("refComposition"));
                composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
                composition.setRefRecette(resultSet.getString("refRecette"));
                composition.setRefIngredient(resultSet.getString("refIngredient"));
                compositions.add(composition);
            }
            return compositions;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
    }
    public ArrayList<Composition> findAll(String champ, String nomChamp)  {
        ArrayList<Composition> compositions = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM composition"+nomChamp+champ);
            while (resultSet.next()) {
                Composition composition = new Composition();
                composition.setRefComposition(resultSet.getString("refComposition"));
                composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
                composition.setRefRecette(resultSet.getString("refRecette"));
                composition.setRefIngredient(resultSet.getString("refIngredient"));
                compositions.add(composition);
        }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return compositions;
    }

    @Override
    public Composition find(String id)  {
        Composition composition=null;
        try{
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM composition WHERE refComposition = ?");
        statement.setString(1,id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            composition = new Composition();
            composition.setRefComposition(resultSet.getString("refComposition"));
            composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
            composition.setRefRecette(resultSet.getString("refRecette"));
            composition.setRefIngredient(resultSet.getString("refIngredient"));
        }
    }catch(SQLException e){
        e.printStackTrace();
        return composition;
    }
        return composition;
    }

    
}

