
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RecetteDAO extends DAO<Recette>{
    public RecetteDAO(Connection conn){
        super(conn);
    }
    @Override
    public ArrayList<Recette> findAll() {
        try{
            PreparedStatement stat= conn.prepareStatement("SELECT * FROM RECETTE;");
            ResultSet res = stat.executeQuery();
            ArrayList<Recette> recettes = new ArrayList<Recette>();
            while(res.next()){
                Recette recette = new Recette(res.getInt("refRecette"), res.getString("nomRecette"), res.getString("descriptionRecette"), res.getInt("calorieRecette"),res.getInt("difficulte"),res.getInt("tempsPreparation"),
                 res.getInt("tempsCuisson"), res.getInt("nbPersonnes"));
                recettes.add(recette);
                return recettes;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Recette> findAll(String champ, String nomChamp) {
        try{
            PreparedStatement stat= conn.prepareStatement("SELECT * FROM RECETTE WHERE "+nomChamp+champ+";");
            ResultSet res = stat.executeQuery();
            ArrayList<Recette> recettes = new ArrayList<Recette>();
            while(res.next()){
                Recette recette = new Recette(res.getInt("refRecette"), res.getString("nomRecette"), res.getString("descriptionRecette"), res.getInt("calorieRecette"),res.getInt("difficulte"),res.getInt("tempsPreparation"),
                 res.getInt("tempsCuisson"), res.getInt("nbPersonnes"));
                recettes.add(recette);
                return recettes;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Recette find(int id) {
        PreparedStatement stat;
        try{
            
            stat = conn.prepareStatement("SELECT * FROM RECETTE WHERE refRecette=?;");
            stat.setInt(1, id);
            ResultSet res = stat.executeQuery();
            if(res.next()){
                Recette recette = new Recette(res.getInt("refRecette"), res.getString("nomRecette"), res.getString("descriptionRecette"), res.getInt("calorieRecette"),res.getInt("difficulte"),res.getInt("tempsPreparation"),
                 res.getInt("tempsCuisson"), res.getInt("nbPersonnes"));
                return recette;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
            
        }

    @Override
    public boolean create(Recette o) {
        try{
            PreparedStatement stat = conn.prepareStatement("INSERT INTO RECETTE VALUES(?,?,?,?,?,?,?);");
            stat.setInt(1, o.getRefRecette());
            stat.setString(2, o.getNomRecette());
            stat.setString(3, o.getDescriptifRecette());
            stat.setInt(4, o.getCalorieRecette());
            stat.setInt(5, o.getDifficulte());
            stat.setInt(6, o.getTempsPreparation());
            stat.setInt(7, o.getTempsCuisson());
            stat.setInt(8, o.getNbPersonnes());
            stat.executeUpdate();
            
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Recette o) {
        try{
            PreparedStatement stat= conn.prepareStatement("UPDATE RECETTE SET nomRecette=?, descriptionRecette=?, calorieRecette=?, difficulte=?, tempsPreparation=?, tempsCuisson=?, nbPersonnes=? WHERE refRecette=?;");
            stat.setString(2, o.getNomRecette());
            stat.setString(3, o.getDescriptifRecette());
            stat.setInt(4, o.getCalorieRecette());
            stat.setInt(5, o.getDifficulte());
            stat.setInt(6, o.getTempsPreparation());
            stat.setInt(7, o.getTempsCuisson());
            stat.setInt(8, o.getNbPersonnes());
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try{
            PreparedStatement stat= conn.prepareStatement("DELETE FROM RECETTE WHERE refRecette=?");
            stat.setInt(1, id);
            stat.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
}
