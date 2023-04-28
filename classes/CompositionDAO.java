import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompositionDAO extends DAO<Composition> {
    public CompositionDAO(Connection connection) {
        super(connection);
    }

    public void insert(Composition composition) throws SQLException {
        String query = "INSERT INTO composition (recette_id, produit_id, quantite) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, composition.getRecetteId());
            statement.setInt(2, composition.getProduitId());
            statement.setInt(3, composition.getQuantite());
            statement.executeUpdate();
        }
    }
  
    public ArratList<Composition> findAll() throws SQLException {
        String query = "SELECT * FROM composition";
        ArratList<Composition> compositions = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int recetteId = resultSet.getInt("recette_id");
                int produitId = resultSet.getInt("produit_id");
                int quantite = resultSet.getInt("quantite");
                compositions.add(new Composition(id, recetteId, produitId, quantite));
            }
        }

        return compositions;
    }

    public void update(Composition composition) throws SQLException {
        String query = "UPDATE composition SET recette_id = ?, produit_id = ?, quantite = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, composition.getRecetteId());
            statement.setInt(2, composition.getProduitId());
            statement.setInt(3, composition.getQuantite());
            statement.setInt(4, composition.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM composition WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
