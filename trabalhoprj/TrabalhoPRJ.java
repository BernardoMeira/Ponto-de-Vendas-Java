
package trabalhoprj;

import trabalhoprj.GUI.JanelaMenus;


public class TrabalhoPRJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        JanelaMenus quadroDialogo = new JanelaMenus();
        quadroDialogo.setLocationRelativeTo(null);
        quadroDialogo.setVisible(true);
    }
    
}
 /*
Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Bebe2002");
            
            conexao.setAutoCommit(false);
            
            try{
            PreparedStatement comandoInclusao = conexao.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?)");
            comandoInclusao.setInt(1,4);
            comandoInclusao.setString(2,"why");
            comandoInclusao.setString(3,"223572SSSSSSSSS32");
            comandoInclusao.setString(4,"why");
            comandoInclusao.executeUpdate();
            conexao.commit();
            } catch(Exception e1) {
                try{
                    conexao.rollback();
                } catch(Exception e2){
                    System.out.println(e2.getMessage());
                }
                System.out.println(e1.getMessage());
            }
            
            
            PreparedStatement comandoSelecao = conexao.prepareStatement("SELECT * FROM CLIENTE");
            ResultSet resultado = comandoSelecao.executeQuery();
            try{
                while(resultado.next()){
                    int ID_CLIENTE = resultado.getInt("ID_CLIENTE");
                    String NOME = resultado.getString("NOME");
                    System.out.println(ID_CLIENTE + " " + NOME);
                }
            } finally{
                resultado.close();
                
                conexao.close();
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
*/