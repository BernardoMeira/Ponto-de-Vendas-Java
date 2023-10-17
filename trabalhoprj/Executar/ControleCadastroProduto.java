
package trabalhoprj.Executar;

import javax.swing.JOptionPane;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Classes.Produto;


public class ControleCadastroProduto extends ControleCadastro {
    protected void inicializarComandos(){
        try{
        prepararComandoInclusao("INSERT INTO PRODUTO (NOME,UNIDADE,PRECO,QUANTIDADE,ULTIMA_VENDA,ID_PRODUTO) VALUES (?,?,?,?,?,?)");
        prepararComandoAlteracao("UPDATE PRODUTO SET NOME = ?,UNIDADE = ?,PRECO = ?,QUANTIDADE = ?,ULTIMA_VENDA = ? WHERE ID_PRODUTO = ?");
        prepararComandoExclusao("DELETE FROM PRODUTO WHERE ID_PRODUTO = ?");
        prepararComandoSelecao("SELECT * FROM PRODUTO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
   
    public Entidade criarEntidade(){
        return new Produto();
    }
}
