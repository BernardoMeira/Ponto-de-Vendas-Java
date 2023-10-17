
package trabalhoprj.Modelos;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.Produto;
import trabalhoprj.Executar.ControleCadastroProduto;

public class ModeloTabelaProdutos extends AbstractTableModel{
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_UNIDADE = 2;
    private static final int COLUNA_PRECO = 3;
    private static final int COLUNA_QUANTIDADEESTOQUE = 4;
    private static final int COLUNA_ULTIMAVENDA = 5;
    
    private String[] colunas = new String[]{"Codigo","Nome","Unidade","Preco","Quantidade Estoque","Ultima Venda"};
    private List<Produto> produtos;
    
    public ModeloTabelaProdutos(List<Produto>produtos){
    this.produtos = new ArrayList<Produto>(produtos);
    }
@Override
    public int getColumnCount(){
        return colunas.length;
    }
@Override
    public int getRowCount(){
        return produtos.size();
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
        Produto produto = produtos.get(row);
        switch(col){
            case COLUNA_CODIGO:
                return produto.obterCodigo();
            case COLUNA_NOME:
                return produto.obterNome();
            case COLUNA_UNIDADE:
                return produto.obterUnidade();
            case COLUNA_PRECO:
                return produto.obterPreco();
            case COLUNA_QUANTIDADEESTOQUE:
                return produto.obterQuantidadeEstoque();
            case COLUNA_ULTIMAVENDA:
                return produto.obterUltimaVenda();
        }
        return "";
    }
@Override
    public void setValueAt(Object aValue, int row, int column){
        Produto produto = produtos.get(row);
        switch(column){
            case COLUNA_CODIGO:
                produto.atualizarCodigo(Integer.valueOf(aValue.toString()));
                break;
            case COLUNA_NOME:
                produto.atualizarNome(aValue.toString());
                break;
            case COLUNA_UNIDADE:
                produto.atualizarUnidade(Integer.valueOf(aValue.toString()));
                break;
            case COLUNA_PRECO:
                produto.atualizarPreco(Float.valueOf(aValue.toString()));
                break;
            case COLUNA_QUANTIDADEESTOQUE:
                produto.atualizarQuantidadeEstoque(Integer.valueOf(aValue.toString()));
                break;
            case COLUNA_ULTIMAVENDA:
                produto.atualizarUltimaVenda(aValue.toString());
                break;
        }
    }
public Produto obterProduto(int index){
    return produtos.get(index);
}
public void incluirProduto(Produto produto){
    try{
        ControleCadastroProduto controleCadastroProduto = new ControleCadastroProduto();
        controleCadastroProduto.incluir(produto);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    produtos.add(produto);
    int ultimo = getRowCount()-1;
    fireTableRowsInserted(ultimo, ultimo);
}

public void atualizarProduto(int index, Produto produto){
    try{
        ControleCadastroProduto controleCadastroProduto = new ControleCadastroProduto();
        controleCadastroProduto.alterar(produto);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    if(index != -1){
        produtos.set(index, produto);
        fireTableRowsUpdated(index, index);
    }
}

public void excluirProduto(int index, Produto produto){
    try{
        ControleCadastroProduto controleCadastroProduto = new ControleCadastroProduto();
        controleCadastroProduto.excluir(produto);
        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    produtos.remove(index);
    fireTableRowsDeleted(index, index);
}

public void carregar(){
    try{
        ControleCadastroProduto controleCadastroProduto = new ControleCadastroProduto();
        ArrayList<Entidade> entidades = controleCadastroProduto.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Produto produto = (Produto)entidades.get(i);
            produtos.add(produto);
            //System.out.println(cliente.obterCodigo() + " " + cliente.obterNome() + " " + cliente.obterTelefone() + " " + cliente.obterEmail());
        }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}

public Produto acharProduto(String nome){
    Produto achou = null;
    try{
        ControleCadastroProduto controleCadastroProduto = new ControleCadastroProduto();
        ArrayList<Entidade> entidades = controleCadastroProduto.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Produto produto = (Produto)entidades.get(i);
            if (produto.obterNome().equals(nome)){
                achou = produto;
            }
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return achou;
}

}