
package trabalhoprj.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVenda extends Entidade{
    private static final String ID_VENDA = "ID_VENDA";
    private static final String ID_PRODUTO = "ID_PRODUTO";
    private static final String QUANTIDADE_VENDA = "QUANTIDADE_VENDA";
    private static final String PRECO = "PRECO";
    private static final String TOTAL_ITEM = "TOTAL_ITEM";
    private int codigoproduto;
    private int codigovenda;
    private int quantidadevenda;
    private float preco;
    private int totalitem;
    
    public void transferirDados(PreparedStatement ps) throws SQLException{
        ps.setInt(1, quantidadevenda);
        ps.setFloat(2, preco);
        ps.setInt(3, totalitem);
        ps.setInt(4, codigoproduto);
        ps.setInt(5, codigovenda);
    }
    public void transferirDadosChave(PreparedStatement ps)throws SQLException{
        ps.setInt(1, codigoproduto);  
    }
    
    public void lerDados(ResultSet resultado)throws SQLException{
        codigoproduto = resultado.getInt("ID_PRODUTO");
        codigovenda = resultado.getInt("ID_VENDA");
        quantidadevenda = resultado.getInt("QUANTIDADE_VENDA");
        preco = resultado.getFloat("PRECO");
        totalitem = resultado.getInt("TOTAL_ITEM");
    }
    
    public int obterCodigoProduto(){
        return codigoproduto;
    }
    public int obterCodigoVenda(){
        return codigovenda;
    }
    public int obterQuantidadeVenda(){
        return quantidadevenda;
    }
    public float obterPreco(){
        return preco;
    }
    public int obterTotalItem(){
        return totalitem;
    }
    public void atualizarCodigoProduto(int codigoproduto){
        this.codigoproduto = codigoproduto;
    }
    public void atualizarCodigoVenda(int codigovenda){
        this.codigovenda = codigovenda;
    }
    public void atualizarQuantidadeVenda(int quantidadevenda){
        this.quantidadevenda = quantidadevenda;
    }
    public void atualizarPreco(float preco){
        this.preco = preco;
    }
    public void atualizarTotalItem(int totalitem){
        this.totalitem = totalitem;
    }
}
