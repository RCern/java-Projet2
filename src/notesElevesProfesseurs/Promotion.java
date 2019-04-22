package notesElevesProfesseurs;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Promotion {
    private List<Eleve> eleves = new LinkedList<>();
    private String nom;

    public Promotion(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public Eleve rechercher(int id){

        for(int i = 0;i < eleves.size();i++){
            if(eleves.get(i).getId() == id)
                return eleves.get(i);
        }

        return null;
    }

    public void croissantMoyenne(){
       eleves.sort(Comparator.comparing(Eleve::moyenne));

    }
    public void croissantMediane(){

        eleves.sort(Comparator.comparing(Eleve::mediane));


    }
    public void decroissantMoyenne(){

        eleves.sort(Comparator.comparing(Eleve::moyenne).reversed());


    }
    public void decroissantMediane(){

        eleves.sort(Comparator.comparing(Eleve::moyenne).reversed());


    }

    public double moyenne(){
        double moyenne = 0;
        for (int i = 0; i < eleves.size();i++){
            moyenne += eleves.get(i).moyenne();
        }

        return moyenne/eleves.size();
    }

    public double moyenneMatiere(String matiere){
        double moyenne = 0;
        int balise = 0;
        for (int i = 0; i < eleves.size();i++){
            for (int j = 0; j < eleves.get(i).getEvaluations().size();j++)
            if (matiere.compareTo(this.eleves.get(i).getEvaluations().get(j).getMatiere()) == 0) {
                //System.out.println(eleves.get(i).moyenneMatiere(this.eleves.get(i).getEvaluations().get(j).getMatiere()));
                moyenne += eleves.get(i).moyenneMatiere(this.eleves.get(i).getEvaluations().get(j).getMatiere());
                balise++;
            }
        }

        return moyenne/balise;
    }


    //To do mathis
    public double mediane(){
        List<Double> temp = new LinkedList<>();

        for (int i = 0; i < eleves.size();i++){
            temp.add(eleves.get(i).moyenne());
        }
        if (temp.size() == 0) {
            // throw new IllegalStateException("Evaluations vide");
            return 0;
        } else {
            double mediane = 0;

            Collections.sort(temp);
            if (temp.size() % 2 == 0) {

                mediane = (temp.get(temp.size() / 2) + temp.get((temp.size() / 2) - 1)) / 2;
            } else {
                mediane = temp.get(temp.size() / 2);
            }
            return mediane;
        }

    }

    public double medianeMatiere(String matiere){
        List<Double> temp = new LinkedList<>();

        for (int i = 0; i < eleves.size();i++){
            for (int j = 0; j < eleves.get(i).getEvaluations().size();j++){
            if(eleves.get(i).getEvaluations().get(j).getMatiere().compareTo(matiere) == 0){

                temp.add(eleves.get(i).getEvaluations().get(j).getNote());
            }
            }
        }
        if (temp.size() == 0) {
            // throw new IllegalStateException("Evaluations vide");
            return 0;
        } else {
            System.out.println(temp);
            double mediane = 0;

            Collections.sort(temp);
            if (temp.size() % 2 == 0) {

                mediane = (temp.get(temp.size() / 2) + temp.get((temp.size() / 2) - 1)) / 2;
            } else {
                mediane = temp.get(temp.size() / 2);
            }
            return mediane;
        }

    }

    public double maximux(){
            Eleve temp =  Collections.max(eleves,Comparator.comparing(Eleve::moyenne));
            return temp.moyenne();
    }

    public double minimum(){
        Eleve temp =  Collections.min(eleves,Comparator.comparing(Eleve::moyenne));
        return temp.moyenne();
    }

    @Override
    public String toString() {
        String temp = "";

        for (int i = 0; i < eleves.size();i++){
            temp += eleves.get(i).getNames();
            temp += " ";
        }
        return temp;
    }
}
