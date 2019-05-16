package GUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.AbstractDocument;

import notesElevesProfesseurs.*;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class Bulletin extends AbstractTableModel {

    private final String[] entetes = { "Matière", "Professeur", "Note" };

    private Eleve eleve;


    public Bulletin(Eleve eleve) {
        this.eleve = eleve;
    }

    @Override
    public String getColumnName(int column) {
        return entetes[column];
    }

    public List<Evaluation> getEvaluations(){
        return eleve.getEvaluations();
    }

    @Override
    public int getRowCount() {
        return eleve.getEvaluations().size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return eleve.getEvaluations().get(rowIndex).getMatiere();
            case 1:
                return eleve.getEvaluations().get(rowIndex).getProfesseur().getNom()+" "+eleve.getEvaluations().get(rowIndex).getProfesseur().getPrenom();
            case 2:
                return eleve.getEvaluations().get(rowIndex).getNote();
            default:
                return 0;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Float.class;
            default:
                throw new IllegalArgumentException();
        }
    }





}
