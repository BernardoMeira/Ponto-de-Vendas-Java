
package trabalhoprj.Classes;

import java.io.Serializable;
import java.sql.*;

public abstract class Entidade implements Serializable{
    public abstract void transferirDados(PreparedStatement ps) throws SQLException;
    public abstract void transferirDadosChave(PreparedStatement ps) throws SQLException;
    public abstract void lerDados(ResultSet resultado)throws SQLException;
    
}

