
package trabalhoprj.Classes;

import java.sql.*;

public class Cliente extends Entidade {
    private static final String ID_CLIENTE = "ID_CLIENTE";
    private static final String NOME = "NOME";
    private static final String TELEFONE = "TELEFONE";
    private static final String EMAIL = "EMAIL";
    private int codigo;
    private String nome;
    private String telefone;
    private String email;
    
    public void transferirDados(PreparedStatement ps) throws SQLException{
        ps.setString(1, nome);
        ps.setString(2, telefone);
        ps.setString(3, email);
        ps.setInt(4, codigo);
    }
    public void transferirDadosChave(PreparedStatement ps)throws SQLException{
        ps.setInt(1, codigo);  
    }
    
    public void lerDados(ResultSet resultado)throws SQLException{
        codigo = resultado.getInt(ID_CLIENTE);
        nome = resultado.getString(NOME);
        telefone = resultado.getString(TELEFONE);
        email = resultado.getString(EMAIL);
    }
    
    public String obterNome(){
        return nome;
    }
    public int obterCodigo(){
        return codigo;
    }
        public String obterTelefone(){
        return telefone;
    }
        public String obterEmail(){
        return email;
    }
    public void atualizarTelefone(String telefone){
        this.telefone = telefone;
    }
    public void atualizarEmail(String email){
        this.email = email;
    }
    public void atualizarNome(String nome){
        this.nome = nome;
    }
    public void atualizarCodigo(int codigo){
        this.codigo = codigo;
    }
}
