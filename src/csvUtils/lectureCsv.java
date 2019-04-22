package csvUtils;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class lectureCsv {
    public static List<Evaluation> lireEvaluations(List<Eleve> eleves, List<Professeur> professeurs) throws FileNotFoundException {
        List<Evaluation> evals = new LinkedList<>();

        Scanner scanner = new Scanner(new File("evaluations.csv"));

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lines = line.split(",");
            String name = lines[0];
            double note = Double.parseDouble(lines[1]);

            Evaluation eval = new Evaluation(name, note);

            evals.add(eval);

            int idEleve = Integer.parseInt(lines[2]);
            int idProf = Integer.parseInt(lines[3]);



            for (int j = 0; j < eleves.size(); j++) {
                for (int k = 0; k < professeurs.size(); k++) {
                    if (eleves.get(j).getId() == idEleve && professeurs.get(k).getId() == idProf) {
                        eval.setEleve(eleves.get(j));
                        eval.setProfesseur(professeurs.get(k));
                        eleves.get(j).getEvaluations().add(eval);
                    }
                }
            }
        }

        return evals;
    }

    public static List<Promotion> lirePromotionCsv(List<Eleve> eleves) throws FileNotFoundException {
        List<Promotion> promotions = new LinkedList<>();

        Scanner scanner = new Scanner(new File("promotions.csv"));

        while(scanner.hasNext()){
            String line =  scanner.nextLine();
            String[] lines = line.split(",");
            String name = lines[0];
            Promotion prom = new Promotion(name);
            promotions.add(prom);
            for (int i  = 1; i < lines.length;i++){
                int  id = Integer.parseInt(lines[i]);
                for (int j = 0; j < eleves.size();j++){
                    if(eleves.get(j).getId() == id){
                        prom.getEleves().add(eleves.get(j));
                    }
                }
            }
        }

        return promotions;

    }

    @SuppressWarnings("Duplicates")
    public static List<Professeur> lireProfesseursCsv() throws FileNotFoundException {
        List<Professeur> professeurs = new LinkedList<>();
        Scanner scanner = new Scanner(new File("prof.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            String line =  scanner.nextLine();
            String[] lines = line.split(",");
            int id = Integer.parseInt(lines[0]);
            String prenom = lines[1];
            String nom = lines[2];

            professeurs.add(new Professeur(id,prenom,nom));
        }

        scanner.close();
        return professeurs;
    }

    public static List<Eleve> lireElevesCsv() throws FileNotFoundException {
        List<Eleve> eleves = new LinkedList<>();
        Scanner scanner = new Scanner(new File("eleves.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            String line =  scanner.nextLine();
            String[] lines = line.split(",");
            int id = Integer.parseInt(lines[0]);
            String prenom = lines[1];
            String nom = lines[2];
            String promotion  = lines[4];
            String[] parts = lines[3].split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            eleves.add(new Eleve(id,prenom,nom,new Date(year,month,day),new Promotion(promotion)));
        }

        scanner.close();
        return eleves;

    }
}
