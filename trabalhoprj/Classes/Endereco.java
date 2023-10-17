
package trabalhoprj.Classes;

import java.sql.*;

public class Endereco extends Entidade {
    private static final String ID_CLIENTE = "ID_CLIENTE";
    private static final String CEP = "CEP";
    private static final String RUA = "RUA";
    private static final String BAIRRO = "BAIRRO";
    private static final String CIDADE = "CIDADE";
    private static final String ESTADO = "ESTADO";
    private int codigo;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    
    public void transferirDados(PreparedStatement ps) throws SQLException{
        ps.setString(1, cep);
        ps.setString(2, rua);
        ps.setString(3, bairro);
        ps.setString(4, cidade);
        ps.setString(5, estado);
        ps.setInt(6, codigo);
    }
    public void transferirDadosChave(PreparedStatement ps)throws SQLException{
        ps.setInt(1, codigo);  
    }
    
    public void lerDados(ResultSet resultado)throws SQLException{
        codigo = resultado.getInt(ID_CLIENTE);
        cep = resultado.getString(CEP);
        rua = resultado.getString(RUA);
        bairro = resultado.getString(BAIRRO);
        cidade = resultado.getString(CIDADE);
        estado = resultado.getString(ESTADO);
    }
    
    public String obterCEP(){
        return cep;
    }
    public int obterCodigo(){
        return codigo;
    }
    public String obterRua(){
        return rua;
    }
    public String obterBairro(){
        return bairro;
    }
    public String obterCidade(){
        return cidade;
    }
    public String obterEstado(){
        return estado;
    }
    public void atualizarCEP(String cep){
        this.cep = cep;
    }
    public void atualizarRua(String rua){
        this.rua = rua;
    }
    public void atualizarBairro(String bairro){
        this.bairro = bairro;
    }
    public void atualizarCidade(String cidade){
        this.cidade = cidade;
    }
    public void atualizarEstado(String estado){
        this.estado = estado;
    }
    public void atualizarCodigo(int codigo){
        this.codigo = codigo;
    }
}
