
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
            ResultSet res= stat.executeQuery("SELECT * FROM PRODUIT;");
            while (res.next()) {                
                prod.setDatePeremption(res.getString("DatePeremption"));
                prod.setDescriptifProduit(res.getString("DescriptifProduit"));
                prod.setPrixProduit(Integer.parseInt(res.getString("PrixProduit")));
                prod.setQuantiteProduit(Integer.parseInt(res.getString("QuantiteProduit")));
                prod.setRefIngredient(Integer.parseInt(res.getString("RefIngredient")));
                prod.setRefProduit(Integer.parseInt(res.getString("RefProduit")));
                prod.setRefReangement(Integer.parseInt(res.getString("RefReangement")));
                arrProduit.add(prod);
            }
            stat.close();
        } catch (NumberFormatException | SQLException e) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return arrProduit;
    }
    public Produit find(int id){
        Produit prod= new Produit();
        try {
            Statement stat= conn.createStatement();
            ResultSet res= stat.executeQuery("SELECT * FROM PRODUIT");            
                prod.setDatePeremption(res.getString("DatePeremption"));
                prod.setDescriptifProduit(res.getString("DescriptifProduit"));
                prod.setPrixProduit(Integer.parseInt(res.getString("PrixProduit")));
                prod.setQuantiteProduit(Integer.parseInt(res.getString("QuantiteProduit")));
                prod.setRefIngredient(Integer.parseInt(res.getString("RefIngredient")));
                prod.setRefProduit(Integer.parseInt(res.getString("RefProduit")));
                prod.setRefReangement(Integer.parseInt(res.getString("RefReangement")));
                
        
        }catch (Exception e) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return prod;
    }
    @Override
    public boolean create(Produit o){
        try {
            PreparedStatement stat = this.conn.prepareStatement("INSERT INTO Produit (RefProduit, DescriptifProduit, DatePeremption, QuantiteProduit, PrixProduit, RefReangement, RefIngredient) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stat.setInt(1, o.getRefProduit());
            stat.setString(2, o.getDescriptifProduit());
            stat.setString(3, o.getDatePeremption());
            stat.setInt(4, o.getQuantiteProduit());
            stat.setDouble(5, o.getPrixProduit());
            stat.setInt(6, o.getRefReangement());
            stat.setInt(7, o.getRefIngredient());
            int res = stat.executeUpdate();
            return res==1;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex); //auto-generated by Netbeans
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
            stat.setInt(5, o.getRefReangement());
            stat.setInt(6, o.getRefIngredient());
            stat.setInt(7, o.getRefProduit());
            int res = stat.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Produit o) {
        try {
            PreparedStatement stat = conn.prepareStatement("DELETE FROM PRODUIT WHERE RefProduit=?");
            stat.setInt(1, o.getRefProduit());
            int res = stat.executeUpdate();
            stat.close();
            return res==1;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}