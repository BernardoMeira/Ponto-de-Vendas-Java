
package trabalhoprj.Modelos;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import trabalhoprj.Classes.Cliente;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Executar.ControleCadastroCliente;

public class ModeloTabelaCliente extends AbstractTableModel{
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_TELEFONE = 2;
    private static final int COLUNA_EMAIL = 3;
    
    private String[] colunas = new String[]{"Codigo","Nome","Telefone","Email"};
    private List<Cliente> clientes;
    
    public ModeloTabelaCliente(List<Cliente>clientes){
    this.clientes = new ArrayList<Cliente>(clientes);
    }
@Override
    public int getColumnCount(){
        return colunas.length;
    }
@Override
    public int getRowCount(){
        return clientes.size();
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
        Cliente cliente = clientes.get(row);
        switch(col){
            case COLUNA_NOME:
                return cliente.obterNome();
            case COLUNA_CODIGO:
                return cliente.obterCodigo();
            case COLUNA_TELEFONE:
                return cliente.obterTelefone();
            case COLUNA_EMAIL:
                return cliente.obterEmail();
        }
        return "";
    }
@Override
    public void setValueAt(Object aValue, int row, int column){
        Cliente cliente = clientes.get(row);
        switch(column){
            case COLUNA_NOME:
                cliente.atualizarNome(aValue.toString());
                break;
            case COLUNA_TELEFONE:
                cliente.atualizarTelefone(aValue.toString());
                break;
            case COLUNA_CODIGO:
                cliente.atualizarCodigo(Integer.valueOf(aValue.toString()));
                break;
            case COLUNA_EMAIL:
                cliente.atualizarEmail(aValue.toString());
                break;
        }
    }
public Cliente obterCliente(int index){
    return clientes.get(index);
}
public void incluirCliente(Cliente cliente){
    try{
        ControleCadastroCliente controleCadastroCliente = new ControleCadastroCliente();
        controleCadastroCliente.incluir(cliente);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    clientes.add(cliente);
    int ultimo = getRowCount()-1;
    fireTableRowsInserted(ultimo, ultimo);
}

public void atualizarCliente(int index, Cliente cliente){
    try{
        ControleCadastroCliente controleCadastroCliente = new ControleCadastroCliente();
        controleCadastroCliente.alterar(cliente);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    clientes.set(index, cliente);
    fireTableRowsUpdated(index, index);
}

public void excluirCliente(int index, Cliente cliente){
    try{
        ControleCadastroCliente controleCadastroCliente = new ControleCadastroCliente();
        controleCadastroCliente.excluir(cliente);
        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    clientes.remove(index);
    fireTableRowsDeleted(index, index);
}

public void carregar(){
    try{
        ControleCadastroCliente controleCadastroCliente = new ControleCadastroCliente();
        ArrayList<Entidade> entidades = controleCadastroCliente.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Cliente cliente = (Cliente)entidades.get(i);
            clientes.add(cliente);
            //System.out.println(cliente.obterCodigo() + " " + cliente.obterNome() + " " + cliente.obterTelefone() + " " + cliente.obterEmail());
        }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
}