import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompositionDAO extends DAO<Composition> {

    public CompositionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Composition composition) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO composition (refComposition, quantiteComposition, refRecette, refIngredient) VALUES (?, ?, ?, ?)");
        statement.setInt(1, composition.getRefComposition());
        statement.setDouble(2, composition.getQuantiteComposition());
        statement.setInt(3, composition.getRefRecette());
        statement.setInt(4, composition.getRefIngredient());
        statement.executeUpdate();
    }

    @Override
    public void delete(Composition composition) throws SQLException {
        PreparedStatement statement = connection.prepareStatement( "DELETE FROM composition WHERE refComposition = ?");
        statement.setInt(1, composition.getRefComposition());
        statement.executeUpdate();
    }

    @Override
    public void update(Composition composition) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE composition SET quantiteComposition = ?, refRecette = ?, refIngredient = ? WHERE refComposition = ?");
        statement.setDouble(1, composition.getQuantiteComposition());
        statement.setInt(2, composition.getRefRecette());
        statement.setInt(3, composition.getRefIngredient());
        statement.setInt(4, composition.getRefComposition());
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Composition> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( "SELECT * FROM composition");
        ArrayList<Composition> compositions = new ArrayList<>();
        while (resultSet.next()) {
            Composition composition = new Composition();
            composition.setRefComposition(resultSet.getInt("refComposition"));
            composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
            composition.setRefRecette(resultSet.getInt("refRecette"));
            composition.setRefIngredient(resultSet.getInt("refIngredient"));
            compositions.add(composition);
        }
        return compositions;
    }

    @Override
    public Composition find(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_QUERY);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Composition composition = null;
        if (resultSet.next()) {
            composition = new Composition();
            composition.setRefComposition(resultSet.getInt("refComposition"));
            composition.setQuantiteComposition(resultSet.getDouble("quantiteComposition"));
            composition.setRefRecette(resultSet.getInt("refRecette"));
            composition.setRefIngredient(resultSet.getInt("refIngredient"));
        }
        return composition;
    }
}

