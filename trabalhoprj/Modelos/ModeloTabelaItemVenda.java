
package trabalhoprj.Modelos;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.ItemVenda;
import trabalhoprj.Executar.ControleCadastroItemVenda;

public class ModeloTabelaItemVenda extends AbstractTableModel{
    private static final int COLUNA_CODIGOPRODUTO = 0;
    private static final int COLUNA_QUANTIDADEVENDA = 1;
    private static final int COLUNA_PRECO = 2;
    private static final int COLUNA_TOTALITEM = 3;
    
    private String[] colunas = new String[]{"Codigo do Produto","Quantidade Vendida","Preco","Total do Item"};
    private List<ItemVenda> itemvendas;
    
    public ModeloTabelaItemVenda(List<ItemVenda>itemvendas){
    this.itemvendas = new ArrayList<ItemVenda>(itemvendas);
    }
@Override
    public int getColumnCount(){
        return colunas.length;
    }
@Override
    public int getRowCount(){
        return itemvendas.size();
    }
@Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
@Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
@Override
    public Object getValueAt(int row, int col){
        ItemVenda itemvenda = itemvendas.get(row);
        switch(col){
            case COLUNA_CODIGOPRODUTO:
                return itemvenda.obterCodigoProduto();
            case COLUNA_QUANTIDADEVENDA:
                return itemvenda.obterQuantidadeVenda();
            case COLUNA_PRECO:
                return itemvenda.obterPreco();
            case COLUNA_TOTALITEM:
                return itemvenda.obterTotalItem();
        }
        return "";
    }
@Override
    public void setValueAt(Object aValue, int row, int column){
        ItemVenda itemvenda = itemvendas.get(row);
        switch(column){
            case COLUNA_CODIGOPRODUTO:
                itemvenda.atualizarCodigoProduto(Integer.valueOf(aValue.toString()));
                break;
            case COLUNA_QUANTIDADEVENDA:
                itemvenda.atualizarQuantidadeVenda(Integer.valueOf(aValue.toString()));
                break;
            case COLUNA_PRECO:
                itemvenda.atualizarPreco(Float.valueOf(aValue.toString()));
                break;
            case COLUNA_TOTALITEM:
                itemvenda.atualizarTotalItem(Integer.valueOf(aValue.toString()));
                break;
        }
    }
public ItemVenda obterItemVenda(int index){
    return itemvendas.get(index);
}
public void incluirItemVenda(ItemVenda itemvenda){
    try{
        ControleCadastroItemVenda controleCadastroItemVenda = new ControleCadastroItemVenda();
        controleCadastroItemVenda.incluir(itemvenda);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    itemvendas.add(itemvenda);
    int ultimo = getRowCount()-1;
    fireTableRowsInserted(ultimo, ultimo);
}

public void atualizarItemVenda(int index, ItemVenda itemvenda){
    try{
        ControleCadastroItemVenda controleCadastroItemVenda = new ControleCadastroItemVenda();
        controleCadastroItemVenda.alterar(itemvenda);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    itemvendas.set(index, itemvenda);
    fireTableRowsUpdated(index, index);
}

public void excluirItemVenda(int index, ItemVenda itemvenda){
    try{
        ControleCadastroItemVenda controleCadastroItemVenda = new ControleCadastroItemVenda();
        controleCadastroItemVenda.excluir(itemvenda);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    //itemvendas.remove(index);
    //fireTableRowsDeleted(index, index);
}

public void carregar(int codigovenda){
    try{
        ControleCadastroItemVenda controleCadastroItemVenda = new ControleCadastroItemVenda();
        ArrayList<Entidade> entidades = controleCadastroItemVenda.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            ItemVenda itemvenda = (ItemVenda)entidades.get(i);
            if (itemvenda.obterCodigoVenda() == codigovenda){
                itemvendas.add(itemvenda);
            }
        }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
public ItemVenda acharItemVenda(int codigo){
    ItemVenda achou = null;
    try{
        ControleCadastroItemVenda controleCadastroItemVenda = new ControleCadastroItemVenda();
        ArrayList<Entidade> entidades = controleCadastroItemVenda.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            ItemVenda itemvenda = (ItemVenda)entidades.get(i);
            if (itemvenda.obterCodigoVenda() == codigo){
                achou = itemvenda;
            }
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return achou;
}
}