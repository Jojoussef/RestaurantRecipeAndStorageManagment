public class Ingredient {
    private int refIngredient;
    private String nomIngredient;
    private int refType;
    
    public Ingredient(int refIngredient, String nomIngredient, int refType) {
        this.refIngredient = refIngredient;
        this.nomIngredient = nomIngredient;
        this.refType = refType;
    }
    
    public Ingredient() {
        
    }
    
    public int getRefIngredient() {
        return refIngredient;
    }
    
    public void setRefIngredient(int refIngredient) {
        this.refIngredient = refIngredient;
    }
    
    public String getNomIngredient() {
        return nomIngredient;
    }
    
    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }
    
    public int getRefType() {
        return refType;
    }
    
    public void setRefType(int refType) {
        this.refType = refType;
    }
}
