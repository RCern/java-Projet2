package notesElevesProfesseurs;

import java.util.*;

public class Eleve {
    private String nom;
    private String prenom;
    private static int identify = 0;
    private int id;
    private Date dateNaissance;
    private List<Evaluation> evaluations = new LinkedList<>();
    private Promotion promotion;
    private final int NB_EVALUATIONS = 10;

    public Eleve(String prenom, String nom, Date dateNaissance, Promotion promotion) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.id = identify + 1;
        identify++;
        this.promotion = promotion;
    }

    public Eleve(int id, String prenom, String nom, Date dateNaissance, Promotion promotion) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.id = id;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public double moyenne() {
        // System.out.println(evaluations.get().getNote());
        if (evaluations.size() == 0) {
            //throw new IllegalStateException("Evaluations vide");
            return 0;
        } else {
            double moyenne = 0;
            for (int i = 0; i < evaluations.size(); i++) {
                moyenne += evaluations.get(i).getNote();
            }
            return moyenne / evaluations.size();
        }
    }

    public double moyenneMatiere(String matiere) {

        if (evaluations.size() == 0) {
            //throw new IllegalStateException("Evaluations vide");
            return 0;
        } else {
            double moyenne = 0;
            int balise = 0;
            for (int i = 0; i < evaluations.size(); i++) {
                if (evaluations.get(i).getMatiere().compareTo(matiere) == 0) {
                    moyenne += evaluations.get(i).getNote();
                    balise++;
                }
            }
            return moyenne / balise;
        }

    }

    public double mediane() {
        if (evaluations.size() == 0) {
            // throw new IllegalStateException("Evaluations vide");
            return 0;
        } else {
            double mediane = 0;

            evaluations.sort(Comparator.comparing(Evaluation::getNote));
            if (evaluations.size() % 2 == 0) {

                mediane = (evaluations.get(evaluations.size() / 2).getNote() + evaluations.get((evaluations.size() / 2) - 1).getNote()) / 2;
            } else {
                mediane = evaluations.get(evaluations.size() / 2).getNote();
            }
            return mediane;
        }
    }

    public double medianeMatiere(String matiere) {
        if (evaluations.size() == 0) {
            // throw new IllegalStateException("Evaluations vide");
            return 0;
        } else {
            double mediane = 0;

            for (int i = 0; i < evaluations.size(); i++) {
                if (evaluations.get(i).getMatiere().compareTo(matiere) == 0) {
                    evaluations.sort(Comparator.comparing(Evaluation::getNote));
                    if (evaluations.size() % 2 == 0) {

                        mediane = (evaluations.get(evaluations.size() / 2).getNote() + evaluations.get((evaluations.size() / 2) - 1).getNote()) / 2;
                    } else {
                        mediane = evaluations.get(evaluations.size() / 2).getNote();
                    }
                    return mediane;

                }
                else return mediane;
            }
        }
        return 0;
    }


    public Set<Professeur> getCorrecteurs() {
        Set<Professeur> correcteurs = new HashSet<>();

        for (int i = 0; i < evaluations.size(); i++) {
            correcteurs.add(evaluations.get(i).getProfesseur());
        }
        return correcteurs;
    }

    public String getNames(){
        return "(" + prenom + ", " + nom + ") ";
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public String bulletin(){
        String bul = "Nom: " + this.nom +" Prenom: " + this.prenom + " Promotion: " +this.promotion.getNom() + "\n";

        for (int i = 0; i < this.getEvaluations().size();i++){
            bul += this.getEvaluations().get(i).toString() + " Moyenne matiere: " + moyenneMatiere(this.getEvaluations().get(i).getMatiere()) +
            " Mediane matiere: " + medianeMatiere(this.getEvaluations().get(i).getMatiere()) + " Moyenne matiere promotion: " + promotion.moyenneMatiere(this.getEvaluations().get(i).getMatiere()) +
                    " Mediane matiere promotion: " + promotion.medianeMatiere(this.getEvaluations().get(i).getMatiere()) +"\n";
        }

        bul += "Moyenne generale: " + moyenne() + " Mediane generale: " + mediane() +"\n";

        bul += "Moyenne promotion: " + promotion.moyenne() + " Mediane promotion: " + promotion.mediane() +" Moyenne maximale: " + promotion.maximux() + " Moyenne minimale: " + promotion.minimum()+ "\n";

        return bul;
    }

    @Override
    public String toString() {
        String evals = "";
        for(int i = 0; i < evaluations.size();i++){
            evals += evaluations.get(i).getMatiere();
            evals += " ";
            evals += evaluations.get(i).getNote();
        }

        return "(" + prenom + ", " + nom +")" + id + "\n" + "notes: " + evals + "\nmoyenne = " + moyenne() + "\nmediane = " + mediane() + "\ncorrecteur(s); " + getCorrecteurs() + " " +
                promotion.getNom();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleve eleve = (Eleve) o;
        return NB_EVALUATIONS == eleve.NB_EVALUATIONS &&
                Objects.equals(nom, eleve.nom) &&
                Objects.equals(prenom, eleve.prenom) &&
                Objects.equals(dateNaissance, eleve.dateNaissance) &&
                Objects.equals(evaluations, eleve.evaluations) &&
                Objects.equals(promotion, eleve.promotion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, dateNaissance, evaluations, promotion, NB_EVALUATIONS);
    }
}