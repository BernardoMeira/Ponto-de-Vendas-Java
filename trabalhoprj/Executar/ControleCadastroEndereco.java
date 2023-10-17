
package trabalhoprj.Executar;

import javax.swing.JOptionPane;
import trabalhoprj.Classes.Endereco;
import trabalhoprj.Classes.Entidade;


public class ControleCadastroEndereco extends ControleCadastro {
    protected void inicializarComandos(){
        try{
        prepararComandoInclusao("INSERT INTO ENDERECO (CEP,RUA,BAIRRO,CIDADE,ESTADO,ID_CLIENTE) VALUES (?,?,?,?,?,?)");
        prepararComandoAlteracao("UPDATE ENDERECO SET CEP = ?,RUA = ?,BAIRRO = ?,CIDADE =?,ESTADO = ? WHERE ID_CLIENTE = ?");
        prepararComandoExclusao("DELETE FROM ENDERECO WHERE ID_CLIENTE = ?");
        prepararComandoSelecao("SELECT * FROM ENDERECO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
   
    public Entidade criarEntidade(){
        return new Endereco();
    }
}
