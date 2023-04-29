public class Recette {
    private int refRecette;
    private String nomRecette;
    private String descriptifRecette;
    private int calorieRecette;
    private int difficulte;
    private int tempsPreparation;
    private int tempsCuisson;
    private int nbPersonnes;
    
    public Recette(int refRecette, String nomRecette, String descriptifRecette, int calorieRecette, int difficulte, int tempsPreparation, int tempsCuisson, int nbPersonnes) {
        this.refRecette = refRecette;
        this.nomRecette = nomRecette;
        this.descriptifRecette = descriptifRecette;
        this.calorieRecette = calorieRecette;
        this.difficulte = difficulte;
        this.tempsPreparation = tempsPreparation;
        this.tempsCuisson = tempsCuisson;
        this.nbPersonnes = nbPersonnes;
    }

    public int getRefRecette() {
        return refRecette;
    }
    
    public void setRefRecette(int refRecette) {
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
    
    public int getDifficulte() {
        return difficulte;
    }
    
    public void setDifficulte(int difficulte) {
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
