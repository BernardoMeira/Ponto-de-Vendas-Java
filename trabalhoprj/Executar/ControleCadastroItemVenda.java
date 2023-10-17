
package trabalhoprj.Executar;

import javax.swing.JOptionPane;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.ItemVenda;

public class ControleCadastroItemVenda extends ControleCadastro {
    protected void inicializarComandos(){
        try{
        prepararComandoInclusao("INSERT INTO ITEM_VENDA2 (QUANTIDADE_VENDA,PRECO,TOTAL_ITEM,ID_PRODUTO,ID_VENDA) VALUES (?,?,?,?,?)");
        prepararComandoAlteracao("UPDATE ITEM_VENDA2 SET QUANTIDADE_VENDA = ?,PRECO = ?,TOTAL_ITEM = ?,ID_VENDA = ? WHERE ID_PRODUTO = ?");
        prepararComandoExclusao("DELETE FROM ITEM_VENDA2 WHERE ID_VENDA = ?");
        prepararComandoSelecao("SELECT * FROM ITEM_VENDA2");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
   
    public Entidade criarEntidade(){
        return new ItemVenda();
    }
}
