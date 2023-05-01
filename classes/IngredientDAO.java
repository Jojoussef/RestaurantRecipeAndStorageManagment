import java.sql.*;
import java.util.ArrayList;


public class IngredientDAO extends DAO<Ingredient> {
    public IngredientDAO(Connection conn) {
        super(conn);
    }
    
    public ArrayList<Ingredient> findAll() {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ingredient");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient(resultSet.getString("refIngredient"), resultSet.getString("nomIngredient"), resultSet.getString("refType"));
                ingredients.add(ingredient);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public ArrayList<Ingredient> findAll(String champ, String nomChamp) {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ingredient WHERE " + nomChamp + champ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient(resultSet.getString("refIngredient"), resultSet.getString("nomIngredient"), resultSet.getString("refType"));
                ingredients.add(ingredient);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public Ingredient find(String id) {
        Ingredient ingredient = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ingredient WHERE refIngredient = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ingredient = new Ingredient(resultSet.getString("refIngredient"), resultSet.getString("nomIngredient"), resultSet.getString("refType"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredient;
    }

    public boolean create(Ingredient o) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO ingredient(refIngredient, nomIngredient, refType) VALUES (?, ?, ?)");
            preparedStatement.setString(1, o.getRefIngredient());
            preparedStatement.setString(2, o.getNomIngredient());
            preparedStatement.setString(3, o.getRefType());
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Ingredient o) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE ingredient SET nomIngredient = ?, refType = ? WHERE refIngredient = ?");
            preparedStatement.setString(1, o.getNomIngredient());
            preparedStatement.setString(2, o.getRefType());
            preparedStatement.setString(3, o.getRefIngredient());
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM ingredient WHERE refIngredient = ?");
            preparedStatement.setString(1, id);
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
