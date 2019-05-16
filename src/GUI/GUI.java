package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import notesElevesProfesseurs.*;

public class GUI extends JFrame{

    final static int extraWindowWidth = 100;

    private Promotion[] promos = new Promotion[1];
    private Eleve[] eleves = new Eleve[2];
    private Professeur[] professeurs = new Professeur[2];
    private Evaluation[] evaluations = new Evaluation[6];

    public GUI(Container pane){
        promos[0] = new Promotion("2021");

        eleves[0] = new Eleve("Radu", "Cernaianu", new Date(1956, 02, 03), promos[0]);
        eleves[1] = new Eleve("Mathis", "Bicheyre", new Date(1998, 07, 20), promos[0]);

        professeurs[0] = new Professeur(0, "Paul", "Calvert");
        professeurs[1] = new Professeur(1, "Jack", "Papeur");

        evaluations[0] = new Evaluation("Physique", 12.0, eleves[0], professeurs[0]);
        evaluations[1] = new Evaluation("Mathematiques", 15.0, eleves[0], professeurs[1]);
        evaluations[2] = new Evaluation("Informatique", 17.0, eleves[0], professeurs[0]);

        evaluations[3] = new Evaluation("Physique", 20.0, eleves[1], professeurs[0]);
        evaluations[4] = new Evaluation("Mathematiques", 19.0, eleves[1], professeurs[1]);
        evaluations[5] = new Evaluation("Informatique", 18.0, eleves[1], professeurs[0]);

        eleves[0].getEvaluations().add(evaluations[0]);
        eleves[0].getEvaluations().add(evaluations[1]);
        eleves[0].getEvaluations().add(evaluations[2]);

        eleves[1].getEvaluations().add(evaluations[3]);
        eleves[1].getEvaluations().add(evaluations[4]);
        eleves[1].getEvaluations().add(evaluations[5]);

        promos[0].getEleves().add(eleves[0]);
        promos[0].getEleves().add(eleves[1]);


        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the "cards".
        JPanel card1 = new JPanel() {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                return size;
            }
        };
        card1.add(new JLabel("ID Eleve:"));

        JTextField tf1 = new JTextField("", 20);
        card1.add(tf1);

        JButton valider1 = new JButton("Valider");
        valider1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                if(id < eleves.length){
                    eleves_menu(id);
                }
            }
        });
        card1.add(valider1);

        JPanel card2 = new JPanel();
        card2.add(new JLabel("ID Prof:"));

        JTextField tf2 = new JTextField("", 20);
        card2.add(tf2);

        JButton valider2 = new JButton("Valider");
        valider2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf2.getText());
                if(id < professeurs.length){
                    //professeurs_stats(id);

                }
            }
        });
        card2.add(valider2);

        tabbedPane.addTab("Login Eleve", card1);
        tabbedPane.addTab("Login Professeur", card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    private void eleves_menu(int id){
        //Frame Menu
        JFrame frame = new JFrame("Menu de "+eleves[id].getNames());

        MenuEleve menu = new MenuEleve(eleves[id]);

        frame.setContentPane(menu.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        GUI demo = new GUI(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
        public static void vue_eleve(JFrame e, Eleve eleve) {

            e.dispose();
            JFrame frame = new JFrame("Vue eleve");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel nom = new JLabel("Eleve: " + eleve.getNames() + " Promotion: " + eleve.getPromotion().getNom() + " Identifient: " + eleve.getId());

            JButton correcteurs = new JButton("Voir Correcteurs");
            correcteurs.addActionListener(e1 -> JOptionPane.showMessageDialog(frame, eleve.getCorrecteurs()));

            JButton bulletin = new JButton("Voir Bulletin");
            bulletin.addActionListener(e1 -> JOptionPane.showMessageDialog(frame, eleve.bulletin()));


            frame.add(nom, BorderLayout.NORTH);
            frame.add(correcteurs, BorderLayout.EAST);
            frame.add(bulletin, BorderLayout.AFTER_LAST_LINE);


            frame.setVisible(true);

        }

        public static void main(String[] args) {

            try {
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            /* Turn off metal's use of bold fonts */
            UIManager.put("swing.boldMetal", Boolean.FALSE);

            //Schedule a job for the event dispatch thread:
            //creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });


        }
    }
