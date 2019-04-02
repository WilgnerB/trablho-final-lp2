package ComBoxModel;

import Model.Bean.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class MarcaComboModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {

    private List<Marca> listMarcas;
    private Marca selectedMarca;
    private final static int FIRSTINDEX = 0;

    public MarcaComboModel() {
        this.listMarcas = new ArrayList<>();
    }

    public MarcaComboModel(List<Marca> listMarcas) {
        this();
        this.listMarcas.addAll(listMarcas);
        if (getSize() > 0) {
            setSelectedItem(this.listMarcas.get(FIRSTINDEX));
        }

    }

    @Override
    public int getSize() {
        return listMarcas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listMarcas.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedMarca = (Marca) anItem;
        fireContentsChanged(anItem, FIRSTINDEX, FIRSTINDEX);
    }

    @Override
    public Object getSelectedItem() {
        return selectedMarca;
    }

    public void addListEstado(List<Marca> marcas) {
        int primeiraLinha = getSize();
        listMarcas.addAll(marcas);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha + marcas.size());
        setSelectedItem(listMarcas.get(getSize() - 1));
    }

    public void removeEstado() {
        listMarcas.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listMarcas.get(FIRSTINDEX));
    }

    public void clear() {
        listMarcas.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
    
}
