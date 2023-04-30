import java.sql.Connection;
import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.Attr;

public class Menu extends JFrame{
    private JButton gestionProduit;
    private JButton gestionIngredient;
    private JButton gestionComposition;
    private JButton gestionTypeIngredient;
    private JButton gestionRecette;
    private JButton gestionRangement;
    private JPanel pan;

    private String[] attRecette,attComposition,attProduit,attIngredient,attTypeIngredient,attRangement;
    public Menu(Connection conn){
        
        super("Menu");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //defining attributes of the data classes
        attRecette = new String[]{"refRecette","nomRecette","tempsPreparation","tempsCuisson","nbPersonnes","difficulte"};
        attComposition = new String[]{"refComposition","refProduit","quantite"};

        pan.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        pan.add(gestionComposition);
        pan.add(gestionProduit);
        pan.add(gestionIngredient);
        pan.add(gestionTypeIngredient);
        pan.add(gestionRecette);
        this.add(pan);

        gestionRecette.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionRecette)
                new AppGestion<Recette>(new RecetteDAO(conn),attRecette);
            }
        });
        gestionComposition.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionComposition)
                new AppGestion<Composition>(new CompositionDAO(conn),attComposition);
            }
        });
        gestionIngredient.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionIngredient)
                new AppGestion<Ingredient>(new IngredientDAO(conn),attIngredient);
            }
        });
        gestionProduit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionProduit)
                new AppGestion<Produit>(new ProduitDAO(conn),attProduit);
            }
        });
        gestionTypeIngredient.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionTypeIngredient)
                new AppGestion<TypeIngredient>(new TypeIngredientDAO(conn),attTypeIngredient);
            }
        });
        gestionRangement.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionRangement)
                new AppGestion<Rangement>(new RangementDAO(conn),attRangement);
            }
        });
        
        

        
    }

    public static void main(String[] args) {
        DBMSConnection dbConnection=new DBMSConnection();
        if(dbConnection.getState()==false){
            return;
        }
        new Menu(dbConnection.getConnection());
    }
}
