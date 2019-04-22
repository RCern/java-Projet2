package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import notesElevesProfesseurs.*;


public class GUI {


    public static void vue_eleve(JFrame e, Eleve eleve){

        e.dispose();
        JFrame frame = new JFrame("Vue eleve");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nom =  new JLabel("Eleve: " + eleve.getNames() + " Promotion: " + eleve.getPromotion().getNom() + " Identifient: " + eleve.getId());

        JButton correcteurs = new JButton("Voir Correcteurs");
        correcteurs.addActionListener(e1 -> JOptionPane.showMessageDialog(frame,eleve.getCorrecteurs()));

        JButton bulletin = new JButton("Voir Bulletin");
        bulletin.addActionListener(e1 -> JOptionPane.showMessageDialog(frame,eleve.bulletin()));


        frame.add(nom,BorderLayout.NORTH);
        frame.add(correcteurs,BorderLayout.EAST);
        frame.add(bulletin,BorderLayout.AFTER_LAST_LINE);



        frame.setVisible(true);

    }

    public static void main(String[] args){

        Promotion promo2021 = new Promotion("2021");
        Eleve gicu = new Eleve("Radu","Cernaianu",new Date(1956,02,03),promo2021);
        Professeur boss = new Professeur(0,"Abina" ,"Abi");
        Evaluation ievalueare = new Evaluation("Physique", 12.0, gicu,boss);
        Evaluation ievalueare2 = new Evaluation("Mathematiques", 15.0, gicu,boss);
        Evaluation ievalueare3 = new Evaluation("Informatique", 17.0, gicu,boss);

        gicu.getEvaluations().add(ievalueare);
        gicu.getEvaluations().add(ievalueare2);
        gicu.getEvaluations().add(ievalueare3);

        promo2021.getEleves().add(gicu);


        JFrame frame = new JFrame("Choix menu");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton eleveVue =new JButton("Eleve");
        eleveVue.addActionListener(e->vue_eleve(frame,gicu));

        frame.add(eleveVue);
        frame.add(new JButton("Professeur"));


        frame.setVisible(true);


    }

}
