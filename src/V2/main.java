package V2;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

import java.io.IOException;
import java.util.*;

import static csvUtils.lectureCsv.*;


public class main {


    public static void main(String[] args) throws IOException {



        List<Eleve> el = lireElevesCsv();
        List<Professeur> prfs = lireProfesseursCsv();
        List<Evaluation> evals = lireEvaluations(el,prfs);

        List<Promotion> prom = lirePromotionCsv(el);

        System.out.println("Eleve: ");
        System.out.println(el.get(0));

        System.out.println("Promotion: ");
        System.out.println(prom.get(0));

        System.out.println("Eleve d'une promotion: ");
        System.out.println(prom.get(0).rechercher(0));

        prom.get(0).croissantMediane();
        System.out.println("Croissant mediane: "+prom.get(0));

        prom.get(0).croissantMoyenne();
        System.out.println("Croissant moyenne: "+prom.get(0));

        prom.get(0).decroissantMediane();
        System.out.println("Decroissant mediane: "+prom.get(0));

        prom.get(0).decroissantMoyenne();
        System.out.println("Decroissant moyenne: "+prom.get(0));




    }

}

