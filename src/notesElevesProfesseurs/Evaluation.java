package notesElevesProfesseurs;

public class Evaluation {
    private String matiere;
    private double note;
    private Eleve eleve;
    private Professeur professeur;

    public Evaluation(String matiere, double note, Eleve eleve, Professeur professeur) {
        this.matiere = matiere;
        this.note = note;
        this.eleve = eleve;
        this.professeur = professeur;
    }
    public Evaluation(String matiere,double note){
        this.matiere = matiere;
        this.note = note;
    }


    public double getNote() {
        return note;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public String getMatiere(){
        return matiere;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        return "(" + professeur + " " + matiere + " " + note;
    }
}
