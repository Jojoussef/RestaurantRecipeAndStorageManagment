public class Rangement {
    private int refRangement;
    private String nomRangement;
    
    public Rangement(int refRangement, String nomRangement) {
        this.refRangement = refRangement;
        this.nomRangement = nomRangement;
    }
    
    public Rangement() {
        
    }
    
    
    public int getRefRangement() {
        return refRangement;
    }
    
    public void setRefRangement(int refRangement) {
        this.refRangement = refRangement;
    }
    
    public String getNomRangement() {
        return nomRangement;
    }
    
    public void setNomRangement(String nomRangement) {
        this.nomRangement = nomRangement;
    }
}
