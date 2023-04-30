public class Composition {
    private int refComposition;
    private double quantiteComposition;
    private int refRecette;
    private int refIngredient;
    
    public Composition() {
        }
        
    public Composition(int refComposition, double quantiteComposition, int refRecette, int refIngredient) {
        this.refComposition = refComposition;
        this.quantiteComposition = quantiteComposition;
        this.refRecette = refRecette;
        this.refIngredient = refIngredient;
    }
    
    public int getRefComposition() {
        return refComposition;
    }
    
    public void setRefComposition(int refComposition) {
        this.refComposition = refComposition;
    }
    
    public double getQuantiteComposition() {
        return quantiteComposition;
    }
    
    public void setQuantiteComposition(double quantiteComposition) {
        this.quantiteComposition = quantiteComposition;
    }
    
    public int getRefRecette() {
        return refRecette;
    }
    
    public void setRefRecette(int refRecette) {
        this.refRecette = refRecette;
    }
    
    public int getRefIngredient() {
        return refIngredient;
    }
    
    public void setRefIngredient(int refIngredient) {
        this.refIngredient = refIngredient;
    }
}
