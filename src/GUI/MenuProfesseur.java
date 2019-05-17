package GUI;

import notesElevesProfesseurs.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


public class MenuProfesseur {

    JPanel pane;
    JLabel label;
    JTextField tf1;
    JComboBox combo1;
    JComboBox combo2;
    JButton bouton1;
    JButton bouton2;

    private Professeur professeur;
    private Promotion[] promotion;

    public JPanel getContentPane(){
        return pane;
    }

    public MenuProfesseur(Professeur professeur, Promotion[] promotion) {
        this.professeur = professeur;
        this.promotion = promotion;

        init_pane();
    }

    private void init_pane(){

        pane = new JPanel();
        GridBagLayout gbpane = new GridBagLayout();
        GridBagConstraints gbcpane = new GridBagConstraints();
        pane.setLayout(gbpane);

        label = new JLabel( "Entrer une note:"  );
        gbcpane.gridx = 0;
        gbcpane.gridy = 1;
        gbcpane.gridwidth = 4;
        gbcpane.gridheight = 2;
        gbcpane.fill = GridBagConstraints.BOTH;
        gbcpane.weightx = 1;
        gbcpane.weighty = 1;
        gbcpane.anchor = GridBagConstraints.NORTH;
        gbpane.setConstraints(label, gbcpane);
        pane.add(label);

        tf1 = new JTextField("Entrer la note");
        gbcpane.gridx = 5;
        gbcpane.gridy = 1;
        gbcpane.gridwidth = 3;
        gbcpane.gridheight = 2;
        gbpane.setConstraints(tf1, gbcpane);
        pane.add(tf1);

        combo1 = new JComboBox(matieres());
        gbcpane.gridx = 9;
        gbcpane.gridy = 1;
        gbcpane.gridwidth = 5;
        gbpane.setConstraints(combo1, gbcpane);
        pane.add(combo1);

        combo2 = new JComboBox(eleves());
        gbcpane.gridx = 15;
        gbcpane.gridy = 1;
        gbpane.setConstraints(combo2, gbcpane);
        pane.add(combo2);

        bouton1 = new JButton("Valider");
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double note;
                String[] matiere;
                String[] eleve;

                try {
                    note = Double.parseDouble(tf1.getText());
                } catch (Exception exception) {
                    tf1.setText("Entrer la note");
                    note = -20;
                }

                if(note >= 0) {
                    matiere = combo1.getSelectedItem().toString().split(" - ");
                    eleve = combo2.getSelectedItem().toString().split(" - ");
                    Promotion currProm = promotion[0];

                    for(Promotion prom : promotion){
                        if(eleve[2] == prom.getNom()){
                            currProm = prom;
                        }
                    }
                    professeur.setNote(currProm, Integer.parseInt(eleve[0]), note, Integer.parseInt(matiere[0]), matiere[1]);
                }

            }
        });
        gbcpane.gridx = 7;
        gbcpane.gridy = 4;
        gbcpane.gridwidth = 7;
        gbcpane.gridheight = 3;
        gbpane.setConstraints(bouton1, gbcpane );
        pane.add(bouton1);

        /*** NOT USED ANYMORE
        bouton2 = new JButton( "Voir toutes les notes"  );
        gbcpane.gridx = 1;
        gbcpane.gridy = 8;
        gbcpane.gridwidth = 18;
        gbcpane.gridheight = 4;
        gbpane.setConstraints(bouton2, gbcpane );
        pane.add(bouton2);
         ***/

    }

    private String[] matieres(){
        int i=0, j=0;
        String[] matieres = new String[0];

        for(Promotion prom : promotion){
            List<Eleve> eleves = prom.getEleves();
            matieres = new String[matieres.length + eleves.get(0).getEvaluations().size()];
            while(i<eleves.get(0).getEvaluations().size()){
                if(eleves.get(0).getEvaluations().get(i).getProfesseur().getNom() == professeur.getNom())
                    matieres[j++] = i + " - " + eleves.get(0).getEvaluations().get(i).getMatiere();
                i++;
            }
        }

        return matieres;
    }

    private String[] eleves(){
        int i=0, j=0;
        String[] eleves = new String[0];

        for(Promotion prom : promotion){
            List<Eleve> list_eleves = prom.getEleves();
            eleves = new String[eleves.length + prom.getEleves().size()];
            while(i<list_eleves.get(0).getEvaluations().size()) {
                if (list_eleves.get(0).getEvaluations().get(i).getProfesseur().getNom() == professeur.getNom()) {
                    for (Eleve eleve : list_eleves) {
                        eleves[j++] = eleve.getId() + " - " + eleve.getNames() + " - " + prom.getNom();
                    }
                    break;
                }
                i++;
            }
        }
        return eleves;
    }
}
