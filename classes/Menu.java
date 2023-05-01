import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        

        //defining attributes of the data classes
        attRecette = new String[]{"refRecette","nomRecette","tempsPreparation","tempsCuisson","nbPersonnes","difficulte"};
        attComposition = new String[]{"refComposition","refProduit","quantite"};
        
        
        gestionComposition = new JButton("Gestion Des Compositions");
        gestionProduit = new JButton("Gestion Des Produits");
        gestionIngredient= new JButton("Gestion Des Ingredients");
        gestionTypeIngredient= new JButton("Gestion Des Types D'ingredients");
        gestionRecette= new JButton("Gestion Des Recettes");
        gestionRangement= new JButton("Gestion Des Rangements");
        
        pan= new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.add(gestionComposition);
        pan.add(gestionProduit);
        pan.add(gestionIngredient);
        pan.add(gestionTypeIngredient);
        pan.add(gestionRecette);
        this.add(pan);

        gestionRecette.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionRecette){
                new AppGestion<Recette>(new RecetteDAO(conn),attRecette);}
            }
        });
        gestionComposition.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionComposition){
                new AppGestion<Composition>(new CompositionDAO(conn),attComposition);}
            }
        });
        gestionIngredient.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionIngredient){
                new AppGestion<Ingredient>(new IngredientDAO(conn),attIngredient);}
            }
        });
        gestionProduit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionProduit){
                new AppGestion<Produit>(new ProduitDAO(conn),attProduit);}
            }
        });
        gestionTypeIngredient.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==gestionTypeIngredient){
                new AppGestion<TypeIngredient>(new TypeIngredientDAO(conn),attTypeIngredient);}
            }
        });
        gestionRangement.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gestionRangement==e.getSource()){
                    new AppGestion<Rangement>(new RangementDAO(conn),attRangement);
                }
            }
        });
        
        this.setSize(400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        

        
    }

    public static void main(String[] args) {
        DBMSConnection dbConnection=new DBMSConnection();
        if(!dbConnection.getState()){
            return;
        }
        new Menu(dbConnection.getConnection());
    }
}
