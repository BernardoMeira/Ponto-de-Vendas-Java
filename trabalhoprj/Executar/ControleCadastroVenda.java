
package trabalhoprj.Executar;

import javax.swing.JOptionPane;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.Venda;


public class ControleCadastroVenda extends ControleCadastro {
    protected void inicializarComandos(){
        try{
        prepararComandoInclusao("INSERT INTO VENDAS (DATA,HORA,VALOR_TOTAL,CLIENTE,FORMA_PAGAMENTO,ID_VENDA) VALUES (?,?,?,?,?,?)");
        prepararComandoAlteracao("UPDATE VENDAS SET DATA = ?,HORA = ?,VALOR_TOTAL = ?,CLIENTE = ?,FORMA_PAGAMENTO = ? WHERE ID_VENDA = ?");
        prepararComandoExclusao("DELETE FROM VENDAS WHERE ID_VENDA = ?");
        prepararComandoSelecao("SELECT * FROM VENDAS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
   
    public Entidade criarEntidade(){
        return new Venda();
    }
}
