public class Composition {
    private String refComposition;
    private double quantiteComposition;
    private String refRecette;
    private String refIngredient;
    
    public Composition() {
    }
        
    public Composition(String refComposition, double quantiteComposition, String refRecette, String refIngredient) {
        this.refComposition = refComposition;
        this.quantiteComposition = quantiteComposition;
        this.refRecette = refRecette;
        this.refIngredient = refIngredient;
    }
    
    public String getRefComposition() {
        return refComposition;
    }
    
    public void setRefComposition(String refComposition) {
        this.refComposition = refComposition;
    }
    
    public double getQuantiteComposition() {
        return quantiteComposition;
    }
    
    public void setQuantiteComposition(double quantiteComposition) {
        this.quantiteComposition = quantiteComposition;
    }
    
    public String getRefRecette() {
        return refRecette;
    }
    
    public void setRefRecette(String refRecette) {
        this.refRecette = refRecette;
    }
    
    public String getRefIngredient() {
        return refIngredient;
    }
    
    public void setRefIngredient(String refIngredient) {
        this.refIngredient = refIngredient;
    }
}
