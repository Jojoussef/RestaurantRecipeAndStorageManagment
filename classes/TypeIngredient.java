public class TypeIngredient {
    private int refType;
    private String nomType;
    
    public TypeIngredient(int refType, String nomType) {
        this.refType = refType;
        this.nomType = nomType;
    }
    
    public TypeIngredient() {
    
    }

    
    public int getRefType() {
        return refType;
    }
    
    public void setRefType(int refType) {
        this.refType = refType;
    }
    
    public String getNomType() {
        return nomType;
    }
    
    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
}
