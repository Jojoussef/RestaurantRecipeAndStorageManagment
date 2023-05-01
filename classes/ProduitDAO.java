
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProduitDAO extends DAO<Produit> {
    public ProduitDAO(Connection conn){
        super(conn);
    }
    public ArrayList<Produit> findAll(){
        ArrayList<Produit> arrProduit = new ArrayList<>();
        Produit prod= new Produit();
        
        
        try {
            Statement stat= conn.createStatement();
            ResultSet res= stat.executeQuery("SELECT * FROM PRODUIT");
            while (res.next()) {                
                prod.setDatePeremption(res.getString("DatePeremption"));
                prod.setDescriptifProduit(res.getString("DescriptifProduit"));
                prod.setPrixProduit(res.getDouble("PrixProduit"));
                prod.setQuantiteProduit(res.getInt("QuantiteProduit"));
                prod.setRefIngredient(res.getString("RefIngredient"));
                prod.setRefProduit(res.getString("RefProduit"));
                prod.setRefReangement(res.getString("RefReangement"));
                arrProduit.add(prod);
            }
            stat.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return arrProduit;
    }

    public ArrayList<Produit> findAll(String champ, String nomChamp){
        ArrayList<Produit> arrProduit = new ArrayList<>();
        Produit prod= new Produit();
        
        
        try {
            Statement stat= conn.createStatement();
            ResultSet res= stat.executeQuery("SELECT * FROM PRODUIT"+nomChamp+champ);
            while (res.next()) {                
                prod.setDatePeremption(res.getString("DatePeremption"));
                prod.setDescriptifProduit(res.getString("DescriptifProduit"));
                prod.setPrixProduit(res.getDouble("PrixProduit"));
                prod.setQuantiteProduit(res.getInt("QuantiteProduit"));
                prod.setRefIngredient(res.getString("RefIngredient"));
                prod.setRefProduit(res.getString("RefProduit"));
                prod.setRefReangement(res.getString("RefReangement"));
                arrProduit.add(prod);
            }
            stat.close();
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
        return arrProduit;
    }

    public Produit find(String id){
        Produit prod= new Produit();
        try {
            PreparedStatement stat= conn.prepareStatement("SELECT * FROM PRODUIT WHERE RefProduit = ?");
            stat.setString(1, id);
            ResultSet res= stat.executeQuery();            
                prod.setDatePeremption(res.getString("DatePeremption"));
                prod.setDescriptifProduit(res.getString("DescriptifProduit"));
                prod.setPrixProduit(res.getDouble("PrixProduit"));
                prod.setQuantiteProduit(res.getInt("QuantiteProduit"));
                prod.setRefIngredient(res.getString("RefIngredient"));
                prod.setRefProduit(id);
                prod.setRefReangement(res.getString("RefReangement"));
                
        
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return prod;
    }
    @Override
    public boolean create(Produit o){
        try {
            PreparedStatement stat = this.conn.prepareStatement("INSERT INTO Produit (RefProduit, DescriptifProduit, DatePeremption, QuantiteProduit, PrixProduit, RefReangement, RefIngredient) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stat.setString(1, o.getRefProduit());
            stat.setString(2, o.getDescriptifProduit());
            stat.setString(3, o.getDatePeremption());
            stat.setInt(4, o.getQuantiteProduit());
            stat.setDouble(5, o.getPrixProduit());
            stat.setString(6, o.getRefReangement());
            stat.setString(7, o.getRefIngredient());
            int res = stat.executeUpdate();
            return res==1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    

    @Override
    public boolean update(Produit o) {
         try {
            PreparedStatement stat = this.conn.prepareStatement(
                "UPDATE Produit SET DescriptifProduit = ?, DatePeremption = ?, QuantiteProduit = ?, PrixProduit = ?, RefReangement = ?, RefIngredient = ? WHERE RefProduit = ?"
            );
            stat.setString(1, o.getDescriptifProduit());
            stat.setString(2, o.getDatePeremption());
            stat.setInt(3, o.getQuantiteProduit());
            stat.setDouble(4, o.getPrixProduit());
            stat.setString(5, o.getRefReangement());
            stat.setString(6, o.getRefIngredient());
            stat.setString(7, o.getRefProduit());
            int res = stat.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            PreparedStatement stat = conn.prepareStatement("DELETE FROM PRODUIT WHERE RefProduit=?");
            stat.setString(1, id);
            int res = stat.executeUpdate();
            stat.close();
            return res==1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
