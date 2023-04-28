class Produit{
    private int RefProduit;
    private String DescriptifProduit;
    private String DatePeremption;
    private int QuantiteProduit;
    private double PrixProduit;
    private int RefReangement;
    private int RefIngredient;
    public Produit(int RefProduit, String DescriptifProduit, String DatePeremption, int QuantiteProduit, double PrixProduit, int RefReangement, int RefIngredient){
        this.RefProduit = RefProduit;
        this.DescriptifProduit = DescriptifProduit;
        this.DatePeremption = DatePeremption;
        this.QuantiteProduit = QuantiteProduit;
        this.PrixProduit = PrixProduit;
        this.RefReangement = RefReangement;
        this.RefIngredient = RefIngredient;
    }
    public Produit(){
        this.RefProduit = 0;
        this.DescriptifProduit = null;
        this.DatePeremption = null;
        this.QuantiteProduit = 0;
        this.PrixProduit = 0;
        this.RefReangement = 0;
        this.RefIngredient = 0;
    }
    public int getRefProduit(){
        return RefProduit;
    }
    public void setRefProduit(int RefProduit){
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
    public int getRefReangement(){
        return RefReangement;
    }
    public void setRefReangement(int RefReangement){
        this.RefReangement = RefReangement;
    }
    public int getRefIngredient(){
        return RefIngredient;
    }
    public void setRefIngredient(int RefIngredient){
        this.RefIngredient = RefIngredient;
    }
}