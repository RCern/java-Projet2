package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static csvUtils.lectureCsv.*;

public class main {


    public static void main(String[] args) throws IOException {

        Promotion promo2021 = new Promotion("2021");
        Eleve gicu = new Eleve("Radu","Cernaianu",new Date(1956,02,03),promo2021);
        Eleve gicu1 = new Eleve("Mathis","Bicheyre",new Date(1956,02,03),promo2021);
        Eleve gicu2 = new Eleve("Warren","Djedir",new Date(1956,02,03),promo2021);


        Professeur boss = new Professeur(0,"Abina" ,"Abi");
        Professeur boss1 = new Professeur(1,"Vinaver" ,"Georges");
        Professeur boss2 = new Professeur(2,"Nicolas" ,"Flasque");

        Evaluation ievalueare = new Evaluation("Physique", 12.0, gicu,boss);
        Evaluation ievalueare2 = new Evaluation("Mathematiques", 15.0, gicu,boss1);
        Evaluation ievalueare3 = new Evaluation("Informatique", 17.0, gicu,boss2);


        Evaluation ievalueare4 = new Evaluation("Physique", 15.0, gicu1,boss);
        Evaluation ievalueare5 = new Evaluation("Mathematiques", 17.0, gicu1,boss1);
        Evaluation ievalueare6 = new Evaluation("Informatique", 10.0, gicu1,boss2);


        Evaluation ievalueare7 = new Evaluation("Physique", 5.0, gicu2,boss);
        Evaluation ievalueare8 = new Evaluation("Mathematiques", 15.0, gicu2,boss1);
        Evaluation ievalueare9 = new Evaluation("Informatique", 19.0, gicu2,boss2);



        gicu.getEvaluations().add(ievalueare);
        gicu.getEvaluations().add(ievalueare2);
        gicu.getEvaluations().add(ievalueare3);

        gicu1.getEvaluations().add(ievalueare4);
        gicu1.getEvaluations().add(ievalueare5);
        gicu1.getEvaluations().add(ievalueare6);

        gicu2.getEvaluations().add(ievalueare7);
        gicu2.getEvaluations().add(ievalueare8);
        gicu2.getEvaluations().add(ievalueare9);

        promo2021.getEleves().add(gicu);
        promo2021.getEleves().add(gicu1);
        promo2021.getEleves().add(gicu2);




        //System.out.println(gicu1.getId());
        //System.out.println(boss.rechercheEleve(promo2021,1));


        System.out.println(promo2021.moyenneMatiere("Physique"));

        System.out.println(gicu.bulletin());

        //System.out.println(gicu1.bulletin());
        //System.out.println(gicu2.bulletin());

        /*


        List<Eleve> el = lireElevesCsv();
        List<Professeur> prfs = lireProfesseursCsv();
        List<Evaluation> evals = lireEvaluations(el,prfs);

        List<Promotion> prom = lirePromotionCsv(el);


        System.out.println(prom.get(0).getEleves().get(1).bulletin());
*/




    }

    }

