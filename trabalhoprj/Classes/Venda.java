
package trabalhoprj.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Venda extends Entidade{
    private static final String ID_VENDA = "ID_VENDA";
    private static final String DATA = "DATA";
    private static final String HORA = "HORA";
    private static final String VALORTOTAL = "VALOR_TOTAL";
    private static final String CLIENTE = "CLIENTE";
    private static final String FORMAPAGAMENTO = "FORMA_PAGAMENTO";
    private int codigovenda;
    private String data;
    private String hora;
    private float valortotal;
    private String cliente;
    private String formapagamento;
    
    public void transferirDados(PreparedStatement ps) throws SQLException{
        ps.setString(1, data);
        ps.setString(2, hora);
        ps.setFloat(3, valortotal);
        ps.setString(4, cliente);
        ps.setString(5, formapagamento);
        ps.setInt(6, codigovenda);
    }
    public void transferirDadosChave(PreparedStatement ps)throws SQLException{
        ps.setInt(1, codigovenda);  
    }
    
    public void lerDados(ResultSet resultado)throws SQLException{
        codigovenda = resultado.getInt("ID_VENDA");
        data = resultado.getString("DATA");
        hora = resultado.getString("HORA");
        valortotal = resultado.getFloat("VALOR_TOTAL");
        cliente = resultado.getString("CLIENTE");
        formapagamento = resultado.getString("FORMA_PAGAMENTO");
    }
    
    public int obterCodigoVenda(){
        return codigovenda;
    }
    public String obterData(){
        return data;
    }
    public String obterHora(){
        return hora;
    }
    public Float obterValorTotal(){
        return valortotal;
    }
    public String obterCliente(){
        return cliente;
    }
    public String obterFormaPagamento(){
        return formapagamento;
    }
    public void atualizarCodigoVenda(int codigovenda){
        this.codigovenda = codigovenda;
    }
    public void atualizarData(String data){
        this.data = data;
    }
    public void atualizarHora(String hora){
        this.hora = hora;
    }
    public void atualizarValorTotal(Float valortotal){
        this.valortotal = valortotal;
    }
    public void atualizarCliente(String cliente){
        this.cliente = cliente;
    }
    public void atualizarFormaPagamento(String formapagamento){
        this.formapagamento = formapagamento;
    }
}
