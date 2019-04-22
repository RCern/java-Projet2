package notesElevesProfesseurs;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static csvUtils.lectureCsv.*;

public class Professeur {

    private String nom;
    private String prenom;
    private static int identify = 0;
    private int id;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = identify + 1;
        identify++;
    }
    public Professeur(int id,String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }


    public Eleve rechercheEleve(Promotion promotion , int id){

        for(int i = 0;i < promotion.getEleves().size();i++){
            if(promotion.getEleves().get(i).getId() == id)
                return promotion.getEleves().get(i);
        }

        throw new IllegalStateException("L'éleve est introuvable.");
    }

    public int getId() {
        return id;
    }

    public void setNote(Promotion promotion, int id, double note, int indice){

        for(int i = 0;i < promotion.getEleves().size();i++) {

            if(promotion.getEleves().get(i).getId() == id) {
                if (promotion.getEleves().get(i).getEvaluations().get(indice) != null)
                    promotion.getEleves().get(i).getEvaluations().get(indice).setNote(note);
                else{

                    promotion.getEleves().get(i).getEvaluations().add(new Evaluation(" ", note, promotion.getEleves().get(i), this));
                }
            }

        }

    }

    public void setNoteCsv(Promotion promotion, int id, double note) throws IOException {
        List<Eleve> eleves = lireElevesCsv();
        List<Professeur> professeurs = lireProfesseursCsv();
        List<Evaluation> evals = lireEvaluations(eleves,professeurs);

        //System.out.println(evals);

        for (int i = 0; i < evals.size();i++){
            if(evals.get(i).getEleve().getId() == id && evals.get(i).getProfesseur().getId() == this.id)
                evals.get(i).setNote(note);
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("evaluations.csv"));

        for (int i = 0; i < evals.size();i++){
            System.out.println(evals.get(i).getMatiere() + "," + evals.get(i).getNote() + "," + evals.get(i).getEleve().getId() + "," + evals.get(i).getProfesseur().getId());
            out.write(evals.get(i).getMatiere() + "," + evals.get(i).getNote() + "," + evals.get(i).getEleve().getId() + "," + evals.get(i).getProfesseur().getId());
            out.newLine();

        }

        out.flush();
        out.close();


    }

    @Override
    public String toString() {
        return "(" + nom + ", " + prenom + ')';
    }
}
