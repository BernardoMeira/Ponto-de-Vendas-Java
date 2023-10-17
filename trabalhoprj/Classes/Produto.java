
package trabalhoprj.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto extends Entidade{
    private static final String ID_PRODUTO = "ID_PRODUTO";
    private static final String NOME = "NOME";
    private static final String UNIDADE = "UNIDADE";
    private static final String PRECO = "PRECO";
    private static final String QUANTIDADE = "QUANTIDADE";
    private static final String ULTIMA_VENDA = "ULTIMA_VENDA";
    private int codigo;
    private String nome;
    private int unidade;
    private float preco;
    private int quantidade;
    private String venda;
    
    public void transferirDados(PreparedStatement ps) throws SQLException{
        ps.setString(1, nome);
        ps.setInt(2, unidade);
        ps.setFloat(3, preco);
        ps.setInt(4, quantidade);
        ps.setString(5, venda);
        ps.setInt(6, codigo);
    }
    public void transferirDadosChave(PreparedStatement ps)throws SQLException{
        ps.setInt(1, codigo);  
    }
    
    public void lerDados(ResultSet resultado)throws SQLException{
        codigo = resultado.getInt("ID_PRODUTO");
        nome = resultado.getString("NOME");
        unidade = resultado.getInt("UNIDADE");
        preco = resultado.getFloat("PRECO");
        quantidade = resultado.getInt("QUANTIDADE");
        venda = resultado.getString("ULTIMA_VENDA");
        
    }
    
    public String obterNome(){
        return nome;
    }
    public int obterCodigo(){
        return codigo;
    }
    public int obterUnidade(){
        return unidade;
    }
        public Float obterPreco(){
        return preco;
    }
        public int obterQuantidadeEstoque(){
        return quantidade;
    }
        public String obterUltimaVenda(){
        return venda;
    }
    public void atualizarUnidade(int unidade){
        this.unidade = unidade;
    }
    public void atualizarPreco(Float preco){
        this.preco = preco;
    }
    public void atualizarQuantidadeEstoque(int quantidade){
        this.quantidade = quantidade;
    }
    public void atualizarUltimaVenda(String venda){
        this.venda = venda;
    }
    public void atualizarNome(String nome){
        this.nome = nome;
    }
    public void atualizarCodigo(int codigo){
        this.codigo = codigo;
    }
}
