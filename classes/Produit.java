class Produit{
    private String RefProduit;
    private String DescriptifProduit;
    private String DatePeremption;
    private int QuantiteProduit;
    private double PrixProduit;
    private String RefReangement;
    private String RefIngredient;
    public Produit(String RefProduit, String DescriptifProduit, String DatePeremption, int QuantiteProduit, double PrixProduit, String RefReangement, String RefIngredient){
        this.RefProduit = RefProduit;
        this.DescriptifProduit = DescriptifProduit;
        this.DatePeremption = DatePeremption;
        this.QuantiteProduit = QuantiteProduit;
        this.PrixProduit = PrixProduit;
        this.RefReangement = RefReangement;
        this.RefIngredient = RefIngredient;
    }
    public Produit(){
        this.RefProduit = null;;
        this.DescriptifProduit = null;
        this.DatePeremption = null;
        this.QuantiteProduit = 0;
        this.PrixProduit = 0;
        this.RefReangement = null;
        this.RefIngredient = null;
    }
    public String getRefProduit(){
        return RefProduit;
    }
    public void setRefProduit(String RefProduit){
        this.RefProduit = RefProduit;
    }
    public String getDescriptifProduit(){
        return DescriptifProduit;
    }
    public void setDescriptifProduit(String DescriptifProduit){
        this.DescriptifProduit = DescriptifProduit;
    }
    public String getDatePeremption(){
        return DatePeremption;
    }
    public void setDatePeremption(String DatePeremption){
        this.DatePeremption = DatePeremption;
    }
    public int getQuantiteProduit(){
        return QuantiteProduit;
    }
    public void setQuantiteProduit(int QuantiteProduit){
        this.QuantiteProduit = QuantiteProduit;
    }
    public double getPrixProduit(){
        return PrixProduit;
    }
    public void setPrixProduit(double PrixProduit){
        this.PrixProduit = PrixProduit;
    }
    public String getRefReangement(){
        return RefReangement;
    }
    public void setRefReangement(String RefReangement){
        this.RefReangement = RefReangement;
    }
    public String getRefIngredient(){
        return RefIngredient;
    }
    public void setRefIngredient(String RefIngredient){
        this.RefIngredient = RefIngredient;
    }
}