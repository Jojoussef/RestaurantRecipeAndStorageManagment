
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
            PreparedStatement stat= conn.prepareStatement("SELECT * FROM RECETTE");
            ResultSet res = stat.executeQuery();
            ArrayList<Recette> recettes = new ArrayList<Recette>();
            while(res.next()){
                Recette recette = new Recette();
                recette.setTempsCuisson(res.getInt("tempsCuisson"));
                recette.setCalorieRecette(res.getInt("calorieRecette"));
                recette.setNomRecette(res.getString("nomRecette"));
                recette.setDescriptifRecette(res.getString("descriptifRecette"));
                recette.setDifficulte(res.getString("difficulte"));
                recette.setRefRecette(res.getString("refRecette"));
                recette.setNbPersonnes(res.getInt("nbPersonnes"));
                recette.setTempsPreparation(res.getInt("tempsPreparation"));
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
            PreparedStatement stat= conn.prepareStatement("SELECT * FROM RECETTE WHERE "+nomChamp+champ+"");
            ResultSet res = stat.executeQuery();
            ArrayList<Recette> recettes = new ArrayList<Recette>();
            while(res.next()){
                Recette recette = new Recette(res.getString("refRecette"), res.getString("nomRecette"), res.getString("descriptionRecette"), res.getInt("calorieRecette"),res.getString("difficulte"),res.getInt("tempsPreparation"),
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
    public Recette find(String id) {
        PreparedStatement stat;
        try{
            
            stat = conn.prepareStatement("SELECT * FROM RECETTE WHERE refRecette=?");
            stat.setString(1, id);
            ResultSet res = stat.executeQuery();
            if(res.next()){
                Recette recette = new Recette(res.getString("refRecette"), res.getString("nomRecette"), res.getString("descriptionRecette"), res.getInt("calorieRecette"),res.getString("difficulte"),res.getInt("tempsPreparation"),
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
            PreparedStatement stat = conn.prepareStatement("INSERT INTO RECETTE VALUES(?,?,?,?,?,?,?)");
            stat.setString(1, o.getRefRecette());
            stat.setString(2, o.getNomRecette());
            stat.setString(3, o.getDescriptifRecette());
            stat.setInt(4, o.getCalorieRecette());
            stat.setString(5, o.getDifficulte());
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
            PreparedStatement stat= conn.prepareStatement("UPDATE RECETTE SET nomRecette=?, descriptionRecette=?, calorieRecette=?, difficulte=?, tempsPreparation=?, tempsCuisson=?, nbPersonnes=? WHERE refRecette=?");
            stat.setString(1, o.getNomRecette());
            stat.setString(2, o.getDescriptifRecette());
            stat.setInt(3, o.getCalorieRecette());
            stat.setString(4, o.getDifficulte());
            stat.setInt(5, o.getTempsPreparation());
            stat.setInt(6, o.getTempsCuisson());
            stat.setInt(7, o.getNbPersonnes());
            stat.setString(8, o.getRefRecette());
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try{
            PreparedStatement stat= conn.prepareStatement("DELETE FROM RECETTE WHERE refRecette=?");
            stat.setString(1, id);
            stat.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
}
