package test;

import notesElevesProfesseurs.Eleve;
import notesElevesProfesseurs.Evaluation;
import notesElevesProfesseurs.Professeur;
import notesElevesProfesseurs.Promotion;

import java.io.IOException;
import java.util.*;

public class main {


    public static void main(String[] args) throws IOException {

        Promotion promo2021 = new Promotion("2021");

        Eleve eleve1 = new Eleve("Radu","Cernaianu",new Date(1998,02,03),promo2021);
        Eleve eleve2 = new Eleve("Mathis","Bicheyre",new Date(1998,02,03),promo2021);
        Eleve eleve3 = new Eleve("Alexia","Blum",new Date(1997,02,03),promo2021);


        Professeur prof1 = new Professeur(0,"Jean" ,"Paul");
        Professeur prof2 = new Professeur(1,"Georges" ,"Dusac");
        Professeur prof3 = new Professeur(2,"Jean" ,"Pierre");

        Evaluation evaluation1 = new Evaluation("Physique", 10.0, eleve2,prof1);
        Evaluation evaluation2 = new Evaluation("Mathematiques", 15.0, eleve2,prof2);
        Evaluation evaluation3 = new Evaluation("Informatique", 12.0, eleve2,prof3);


        Evaluation evaluation4 = new Evaluation("Physique", 8.0, eleve2,prof1);
        Evaluation evaluation5 = new Evaluation("Mathematiques", 15.0, eleve2,prof2);
        Evaluation evaluation6 = new Evaluation("Informatique", 12.0, eleve2,prof3);



        Evaluation evaluation7 = new Evaluation("Physique", 11.0, eleve3,prof1);
        Evaluation evaluation8 = new Evaluation("Mathematiques", 12.5, eleve3,prof2);
        Evaluation evaluation9 = new Evaluation("Informatique", 14.0, eleve3,prof3);



        eleve1.getEvaluations().add(evaluation1);
        eleve1.getEvaluations().add(evaluation2);
        eleve1.getEvaluations().add(evaluation3);

        eleve2.getEvaluations().add(evaluation4);
        eleve2.getEvaluations().add(evaluation5);
        eleve2.getEvaluations().add(evaluation6);

        eleve3.getEvaluations().add(evaluation7);
        eleve3.getEvaluations().add(evaluation8);
        eleve3.getEvaluations().add(evaluation9);

        promo2021.getEleves().add(eleve1);
        promo2021.getEleves().add(eleve2);
        promo2021.getEleves().add(eleve3);



        //Tests fonction eleves

        System.out.println(eleve1);


        System.out.println("\n");

        // Tests promotion
        System.out.println("Promotion 2021: " + promo2021);
       System.out.println("Eleve avec l'identifiant 1 dans la promotion 2021: "+promo2021.rechercher(1));

       promo2021.croissantMediane();
       System.out.println("Croissant mediane: "+promo2021);

        promo2021.croissantMoyenne();
        System.out.println("Croissant moyenne: "+promo2021);

        promo2021.decroissantMediane();
        System.out.println("Decroissant mediane: "+promo2021);

        promo2021.decroissantMoyenne();
        System.out.println("Decroissant moyenne: "+promo2021);






    }

    }

