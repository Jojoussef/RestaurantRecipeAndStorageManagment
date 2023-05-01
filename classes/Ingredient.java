public class Ingredient {
    private String refIngredient;
    private String nomIngredient;
    private String refType;
    
    public Ingredient(String refIngredient, String nomIngredient, String refType) {
        this.refIngredient = refIngredient;
        this.nomIngredient = nomIngredient;
        this.refType = refType;
    }
    
    public Ingredient() {
        
    }
    
    public String getRefIngredient() {
        return refIngredient;
    }
    
    public void setRefIngredient(String refIngredient) {
        this.refIngredient = refIngredient;
    }
    
    public String getNomIngredient() {
        return nomIngredient;
    }
    
    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }
    
    public String getRefType() {
        return refType;
    }
    
    public void setRefType(String refType) {
        this.refType = refType;
    }
}
