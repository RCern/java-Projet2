/***
 * NOT USED ANYMORE :x
 */

package GUI;

import notesElevesProfesseurs.*;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class Notes extends AbstractTableModel {
    private final String[] entetes = { "Eleve", "Promotion", "Matiere", "Note"};

    private Professeur professeur;
    private Promotion[] promotions;
    private List<Eleve> allEleves;

    public Notes(Professeur professeur, Promotion[] promotions) {
        this.professeur = professeur;
        this.promotions = promotions;
    }

    @Override
    public int getRowCount() {
        int total=0, i=0, class_per_prom;
        for(Promotion prom : promotions){
            class_per_prom = 0;
            List<Eleve> eleves = prom.getEleves();
            while(i<eleves.get(0).getEvaluations().size()){
                if(eleves.get(0).getEvaluations().get(i).getProfesseur().getNom() == professeur.getNom()){
                    class_per_prom++;
                }
                i++;
            }
            if(class_per_prom>0){
                total += class_per_prom * prom.getEleves().size();
            }
            allEleves.addAll(eleves);
        }
        return total;
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return allEleves.get(rowIndex).getNames();
            case 1:
                return allEleves.get(rowIndex).getPromotion().getNom();


        }
        return null;
    }
}
