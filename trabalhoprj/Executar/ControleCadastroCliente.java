
package trabalhoprj.Executar;

import javax.swing.JOptionPane;
import trabalhoprj.Classes.Cliente;
import trabalhoprj.Classes.Entidade;


public class ControleCadastroCliente extends ControleCadastro {
    protected void inicializarComandos(){
        try{
        prepararComandoInclusao("INSERT INTO CLIENTE (NOME,TELEFONE,EMAIL,ID_CLIENTE) VALUES (?,?,?,?)");
        prepararComandoAlteracao("UPDATE CLIENTE SET NOME = ?,TELEFONE = ?,EMAIL = ? WHERE ID_CLIENTE = ?");
        prepararComandoExclusao("DELETE FROM CLIENTE WHERE ID_CLIENTE = ?");
        prepararComandoSelecao("SELECT * FROM CLIENTE");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
   
    public Entidade criarEntidade(){
        return new Cliente();
    }
}
