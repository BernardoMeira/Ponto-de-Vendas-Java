
package trabalhoprj.Modelos;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.Venda;
import trabalhoprj.Executar.ControleCadastroVenda;

public class ModeloTabelaVendas extends AbstractTableModel{
    private static final int COLUNA_DATA = 0;
    private static final int COLUNA_HORA = 1;
    private static final int COLUNA_CLIENTE = 2;
    private static final int COLUNA_FORMAPAGAMENTO = 3;
    private static final int COLUNA_VALORTOTAL = 4;
    
    private String[] colunas = new String[]{"Data","Hora","Cliente","Forma de Pagamento","Valor Total"};
    private List<Venda> vendas;
    
    public ModeloTabelaVendas(List<Venda> vendas){
    this.vendas = new ArrayList<Venda>(vendas);
    }
@Override
    public int getColumnCount(){
        return colunas.length;
    }
@Override
    public int getRowCount(){
        return vendas.size();
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
        Venda venda = vendas.get(row);
        switch(col){
            case COLUNA_DATA:
                return venda.obterData();
            case COLUNA_HORA:
                return venda.obterHora();
            case COLUNA_CLIENTE:
                return venda.obterCliente();
            case COLUNA_FORMAPAGAMENTO:
                return venda.obterFormaPagamento();
            case COLUNA_VALORTOTAL:
                return venda.obterValorTotal();
        }
        return "";
    }
@Override
    public void setValueAt(Object aValue, int row, int column){
        Venda venda = vendas.get(row);
        switch(column){
            case COLUNA_DATA:
                venda.atualizarData(aValue.toString());
                break;
            case COLUNA_HORA:
                venda.atualizarHora(aValue.toString());
                break;
            case COLUNA_CLIENTE:
                venda.atualizarCliente(aValue.toString());
                break;
            case COLUNA_FORMAPAGAMENTO:
                venda.atualizarFormaPagamento(aValue.toString());
                break;
            case COLUNA_VALORTOTAL:
                venda.atualizarValorTotal(Float.valueOf(aValue.toString()));
                break;
        }
    }
public Venda obterVenda(int index){
    return vendas.get(index);
}

public void incluirVenda(Venda venda){
    try{
        ControleCadastroVenda controleCadastroVenda = new ControleCadastroVenda();
        controleCadastroVenda.incluir(venda);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    vendas.add(venda);
    int ultimo = getRowCount()-1;
    fireTableRowsInserted(ultimo, ultimo);
}

public void atualizarVenda(int index, Venda venda){
    try{
        ControleCadastroVenda controleCadastroVenda = new ControleCadastroVenda();
        controleCadastroVenda.alterar(venda);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    vendas.set(index, venda);
    fireTableRowsUpdated(index, index);
}

public void excluirVenda(int index, Venda venda){
    try{
        ControleCadastroVenda controleCadastroVenda = new ControleCadastroVenda();
        controleCadastroVenda.excluir(venda);
        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    vendas.remove(index);
    fireTableRowsDeleted(index, index);
}

public void carregar(){
    try{
        ControleCadastroVenda controleCadastroVenda = new ControleCadastroVenda();
        ArrayList<Entidade> entidades = controleCadastroVenda.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Venda venda = (Venda)entidades.get(i);
            vendas.add(venda);
        }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}

public float calcularDinheiro(){
    float dinheiro = 0;
    try{
        ControleCadastroVenda controleCadastroVenda = new ControleCadastroVenda();
        ArrayList<Entidade> entidades = controleCadastroVenda.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Venda venda = (Venda)entidades.get(i);
            if (venda.obterFormaPagamento().equals("Dinheiro")){
                dinheiro += venda.obterValorTotal();
            }
        }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return dinheiro;
}

public float calcularCartao(){
    float cartao = 0;
    try{
        ControleCadastroVenda controleCadastroVenda = new ControleCadastroVenda();
        ArrayList<Entidade> entidades = controleCadastroVenda.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Venda venda = (Venda)entidades.get(i);
            if (venda.obterFormaPagamento().equals("Cartão de Crédito")){
                cartao += venda.obterValorTotal();
            }
        }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return cartao;
}
}