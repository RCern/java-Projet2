package GUI;



import notesElevesProfesseurs.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEleve{


    private Eleve eleve;

    private JPanel pane;
    private JPanel pane2;

    private JButton bouton0;
    private JButton bouton1;
    private JButton bouton2;

    private JTextArea tf1;

    public JPanel getContentPane(){
        return pane;
    }

    public MenuEleve(Eleve eleve) {
        this.eleve = eleve;

        initPane();
    }


    private void initPane(){
        pane = new JPanel();
        GridBagLayout gbpane = new GridBagLayout();
        GridBagConstraints gbcpane = new GridBagConstraints();
        pane.setLayout(gbpane);

        pane2 = new JPanel();
        GridBagLayout gbpane2 = new GridBagLayout();
        GridBagConstraints gbcpane2 = new GridBagConstraints();
        pane2.setLayout(gbpane2);

        bouton0 = new JButton( "Voir Bulletin"  );
        bouton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Bulletin de "+eleve.getNames());
                BulletinFrame bulletin = new BulletinFrame(eleve);
                frame.setContentPane(bulletin.getContentPane());
                frame.pack();
                frame.setVisible(true);
            }
        });
        gbcpane2.gridx = 1;
        gbcpane2.gridy = 1;
        gbcpane2.gridwidth = 15;
        gbcpane2.gridheight = 2;
        gbcpane2.fill = GridBagConstraints.BOTH;
        gbcpane2.weightx = 1;
        gbcpane2.weighty = 0;
        gbcpane2.anchor = GridBagConstraints.NORTH;
        gbpane2.setConstraints(bouton0, gbcpane2);
        pane2.add(bouton0);

        bouton1 = new JButton( "Voir Moyenne Promo"  );
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moyennesPromo = "";

                for(int i=0; i<eleve.getEvaluations().size(); i++){
                    moyennesPromo += "La moyenne de promo de " + eleve.getEvaluations().get(i).getMatiere()
                            + " est de : " + eleve.getPromotion().moyenneMatiere(eleve.getEvaluations().get(i).getMatiere());
                    moyennesPromo += "\n";
                }

                tf1.setText(moyennesPromo);
            }
        });
        gbcpane2.gridx = 11;
        gbcpane2.gridy = 4;
        gbcpane2.gridwidth = 5;
        gbcpane2.gridheight = 2;
        gbpane2.setConstraints(bouton1, gbcpane2);
        pane2.add(bouton1);

        bouton2 = new JButton( "Voir Moyenne"  );
        bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String moyennes = "";

                for(int i=0; i<eleve.getEvaluations().size(); i++){
                    moyennes+= "La moyenne de " + eleve.getEvaluations().get(i).getMatiere()
                            + " est de : " + eleve.moyenneMatiere(eleve.getEvaluations().get(i).getMatiere());
                    moyennes += "\n";
                }

                moyennes += "La moyenne générale est de : " + eleve.moyenne();

                tf1.setText(moyennes);
            }
        });
        gbcpane2.gridx = 1;
        gbcpane2.gridy = 4;
        gbcpane2.gridwidth = 8;
        gbpane2.setConstraints(bouton2, gbcpane2);
        pane2.add(bouton2);

        gbcpane.gridx = 2;
        gbcpane.gridy = 2;
        gbcpane.gridwidth = 17;
        gbcpane.gridheight = 17;
        gbpane.setConstraints(pane2, gbcpane);
        pane.add(pane2);

        tf1 = new JTextArea(2,10);
        gbcpane2.gridx = 1;
        gbcpane2.gridy = 7;
        gbcpane2.gridwidth = 15;
        gbcpane2.gridheight = 9;
        gbcpane2.fill = GridBagConstraints.BOTH;
        gbcpane2.weightx = 1;
        gbcpane2.weighty = 1;
        gbcpane2.anchor = GridBagConstraints.NORTH;
        gbpane2.setConstraints(tf1, gbcpane2);
        pane2.add(tf1);
    }
}
