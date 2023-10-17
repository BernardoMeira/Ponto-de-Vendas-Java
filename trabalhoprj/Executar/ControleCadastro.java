
package trabalhoprj.Executar;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import trabalhoprj.Classes.Entidade;


public abstract class ControleCadastro {
    private PreparedStatement psInclusao;
    private PreparedStatement psAlteracao;
    private PreparedStatement psExclusao;
    private PreparedStatement psSelecao;
    
    protected abstract void inicializarComandos();
    
    protected void prepararComandoInclusao(String comnandoInclusao) throws SQLException{
        psInclusao = BancoDados.obterInstancia().criarComando(comnandoInclusao);
    }
 
    protected void prepararComandoAlteracao(String comandoAlteracao) throws SQLException{
        psAlteracao = BancoDados.obterInstancia().criarComando(comandoAlteracao);
    }
  
    protected void prepararComandoExclusao(String comandoExclusao) throws SQLException{
        psExclusao = BancoDados.obterInstancia().criarComando(comandoExclusao);
    }
  
    protected void prepararComandoSelecao(String comandoSelecao) throws SQLException{
        psSelecao = BancoDados.obterInstancia().criarComando(comandoSelecao);
    }
    
    public ControleCadastro(){
        inicializarComandos();
    }
    
    private void executarOperacao(PreparedStatement ps, Entidade entidade) throws  SQLException{
        try{
            entidade.transferirDados(ps);
            ps.executeUpdate();
            BancoDados.obterInstancia().confirmarTransacao();
        } catch(Exception e){
            BancoDados.obterInstancia().cancelarTransacao();
            throw e;
        }
    }
    
    public void incluir(Entidade entidade) throws SQLException{
        executarOperacao(psInclusao, entidade);
    }
    
    public void alterar(Entidade entidade) throws SQLException{
        executarOperacao(psAlteracao, entidade);
    }
    
    public void excluir(Entidade entidade) throws SQLException{
        try{
            entidade.transferirDadosChave(psExclusao);
            psExclusao.executeUpdate();
            BancoDados.obterInstancia().confirmarTransacao();
        } catch(Exception e){
            BancoDados.obterInstancia().cancelarTransacao();
            throw e;
        }
    }
    
    public abstract Entidade criarEntidade();
    
    public ArrayList<Entidade> obterLista() throws SQLException{
        ArrayList<Entidade> entidades = new ArrayList<Entidade>();
        try{
            ResultSet resultado = psSelecao.executeQuery();
            while(resultado.next()){
                Entidade entidade = criarEntidade();
                entidade.lerDados(resultado);
                entidades.add(entidade);
            }
            BancoDados.obterInstancia().confirmarTransacao();
            return entidades;
        } catch(Exception e){
            BancoDados.obterInstancia().cancelarTransacao();
            throw e;
        }
    }
}
