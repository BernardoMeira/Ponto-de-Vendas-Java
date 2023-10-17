
package trabalhoprj.Executar;

import java.sql.*;
import javax.swing.JOptionPane;


public class BancoDados {
    private Connection conexao;
    private static BancoDados instancia = null;
    
    public static BancoDados obterInstancia(){
        if(instancia == null){
            instancia = new BancoDados();
        }
        return instancia;
    }
    private void inicializar(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","password");

        conexao.setAutoCommit(false);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private BancoDados(){
        inicializar();
    }
    
    public void confirmarTransacao() throws SQLException{
        if (conexao != null && !conexao.isClosed()){
            conexao.commit();
        }
    }
    
    public void cancelarTransacao() throws SQLException{
        if (conexao != null && !conexao.isClosed()){
            conexao.rollback();
        }
    }
    
    public PreparedStatement criarComando(String comandoSQL) throws SQLException{
        return conexao.prepareStatement(comandoSQL);
    }
    
}
