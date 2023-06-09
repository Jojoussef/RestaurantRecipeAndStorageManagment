public class Recette {
    private String refRecette;
    private String nomRecette;
    private String descriptifRecette;
    private int calorieRecette;
    private String difficulte;
    private int tempsPreparation;
    private int tempsCuisson;
    private int nbPersonnes;
    
    public Recette(String refRecette, String nomRecette, String descriptifRecette, int calorieRecette, String difficulte, int tempsPreparation, int tempsCuisson, int nbPersonnes) {
        this.refRecette = refRecette;
        this.nomRecette = nomRecette;
        this.descriptifRecette = descriptifRecette;
        this.calorieRecette = calorieRecette;
        this.difficulte = difficulte;
        this.tempsPreparation = tempsPreparation;
        this.tempsCuisson = tempsCuisson;
        this.nbPersonnes = nbPersonnes;
    }
    
    public Recette(){
        this.refRecette = null;
        this.nomRecette = null;
        this.descriptifRecette = null;
        this.calorieRecette = 0;
        this.difficulte = null;
        this.tempsPreparation = 0;
        this.tempsCuisson = 0;
        this.nbPersonnes = 0;
    }

    public String getRefRecette() {
        return refRecette;
    }
    
    public void setRefRecette(String refRecette) {
        this.refRecette = refRecette;
    }
    
    public String getNomRecette() {
        return nomRecette;
    }
    
    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }
    
    public String getDescriptifRecette() {
        return descriptifRecette;
    }
    
    public void setDescriptifRecette(String descriptifRecette) {
        this.descriptifRecette = descriptifRecette;
    }
    
    public int getCalorieRecette() {
        return calorieRecette;
    }
    
    public void setCalorieRecette(int calorieRecette) {
        this.calorieRecette = calorieRecette;
    }
    
    public String getDifficulte() {
        return difficulte;
    }
    
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
    
    public int getTempsPreparation() {
        return tempsPreparation;
    }
    
    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }
    
    public int getTempsCuisson() {
        return tempsCuisson;
    }
    
    public void setTempsCuisson(int tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }
    
    public int getNbPersonnes() {
        return nbPersonnes;
    }
    
    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }
}
