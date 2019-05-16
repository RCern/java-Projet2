package GUI;

import javax.swing.*;
import notesElevesProfesseurs.*;

public class BulletinFrame {

    private JPanel contentpane = new JPanel();

    private Bulletin bulletin;

    public JPanel getContentPane(){
        return contentpane;
    }

    public BulletinFrame(Eleve eleve) {
        bulletin = new Bulletin(eleve);
        JTable table = new JTable(bulletin);
        table.setAutoCreateRowSorter(true);
        contentpane.add(new JScrollPane(table));
    }
}
