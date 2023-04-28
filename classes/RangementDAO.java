import java.sql.*;
import java.util.ArrayList;

public class RangementDAO extends DAO<Rangement> {

    public RangementDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Rangement rangement) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO rangement (refRangement, nomRangement) VALUES (?, ?)");
        statement.setInt(1, rangement.getRefRangement());
        statement.setString(2, rangement.getNomRangement());
        statement.executeUpdate();
    }

    @Override
    public void delete(Rangement rangement) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM rangement WHERE refRangement = ?");
        statement.setInt(1, rangement.getRefRangement());
        statement.executeUpdate();
    }

    @Override
    public void update(Rangement rangement) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE rangement SET nomRangement = ? WHERE refRangement = ?");
        statement.setString(1, rangement.getNomRangement());
        statement.setInt(2, rangement.getRefRangement());
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Rangement> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM rangement");
        ArrayList<Rangement> rangements = new ArrayList<>();
        while (resultSet.next()) {
            Rangement rangement = new Rangement();
            rangement.setRefRangement(resultSet.getInt("refRangement"));
            rangement.setNomRangement(resultSet.getString("nomRangement"));
            rangements.add(rangement);
        }
        return rangements;
    }

    @Override
    public Rangement find(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM rangement WHERE refRangement = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Rangement rangement = null;
        if (resultSet.next()) {
            rangement = new Rangement();
            rangement.setRefRangement(resultSet.getInt("refRangement"));
            rangement.setNomRangement(resultSet.getString("nomRangement"));
        }
        return rangement;
    }
}
