import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeIngredientDAO extends DAO<TypeIngredient> {

    protected TypeIngredientDAO(Connection conn) {
        super(conn);
        
    }

    @Override
    public ArrayList<TypeIngredient> findAll() {
        ArrayList<TypeIngredient> typeIngredients = new ArrayList<>();
        try {
            PreparedStatement prepare = conn.prepareStatement("SELECT * FROM typeingredient");
            ResultSet  result = prepare.executeQuery();
            while(result.next()){
                typeIngredients.add(new TypeIngredient(result.getInt("RefType"), result.getString("nomType")));
            }
            return typeIngredients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    @Override
    public ArrayList<TypeIngredient> findAll(String valChamp, String nomChamp) {
        ArrayList<TypeIngredient> typeIngredients = new ArrayList<>();
        try {
            PreparedStatement prepare = conn.prepareStatement("SELECT * FROM typeingredient WHERE "+nomChamp+valChamp);
            prepare.setString(1, nomChamp);
            ResultSet  result = prepare.executeQuery();
            while(result.next()){
                typeIngredients.add(new TypeIngredient(result.getInt("RefType"), result.getString("nomType")));
            }
            return typeIngredients;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TypeIngredient find(int id) {
        try {
            PreparedStatement prepare = conn.prepareStatement("SELECT * FROM typeingredient WHERE RefType = ?");
            prepare.setInt(1, id);
            ResultSet  result = prepare.executeQuery();
            if(result.next()){
                return new TypeIngredient(result.getInt("RefType"), result.getString("nomType"));
            }
        
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    @Override
    public boolean create(TypeIngredient o) {
        try {
            PreparedStatement prepare = conn.prepareStatement("INSERT INTO typeingredient(RefType, nomType) VALUES(?,?)");
            prepare.setInt(1, o.getRefType());
            prepare.setString(2, o.getNomType());
            prepare.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    

    @Override
    public boolean update(TypeIngredient o) {
        try {
            PreparedStatement prepare = conn.prepareStatement("UPDATE typeingredient SET nomType = ? WHERE RefType = ?");
            prepare.setString(1, o.getNomType());
            prepare.setInt(2, o.getRefType());
            prepare.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement prepare = conn.prepareStatement("DELETE FROM typeingredient WHERE RefType = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return true;
        
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
