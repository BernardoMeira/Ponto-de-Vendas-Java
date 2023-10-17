
package trabalhoprj.Modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trabalhoprj.Classes.Endereco;
import trabalhoprj.Classes.Entidade;
import trabalhoprj.Executar.ControleCadastroEndereco;

public class ModeloEndereco {
    private List<Endereco> enderecos;
    
    public ModeloEndereco(List<Endereco>enderecos){
    this.enderecos = new ArrayList<Endereco>(enderecos);
    }
    
    public Endereco obterEndereco(int index){
    return enderecos.get(index);
    }
            
    public void incluirEndereco(Endereco endereco){
        try{
        ControleCadastroEndereco controleCadastroEndereco = new ControleCadastroEndereco();
        controleCadastroEndereco.incluir(endereco);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

public void atualizarEndereco(Endereco endereco){
    try{
        ControleCadastroEndereco controleCadastroEndereco = new ControleCadastroEndereco();
        controleCadastroEndereco.alterar(endereco);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}

public void excluirEndereco(Endereco endereco){
    try{
        ControleCadastroEndereco controleCadastroEndereco = new ControleCadastroEndereco();
        controleCadastroEndereco.excluir(endereco);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}

public Endereco acharEndereco(int codigo){
    Endereco achou = null;
    try{
        ControleCadastroEndereco controleCadastroEndereco = new ControleCadastroEndereco();
        ArrayList<Entidade> entidades = controleCadastroEndereco.obterLista();
        
        for(int i = 0; i < entidades.size(); i++){
            Endereco endereco = (Endereco)entidades.get(i);
            if (endereco.obterCodigo() == codigo){
                achou = endereco;
            }
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return achou;
}
}

