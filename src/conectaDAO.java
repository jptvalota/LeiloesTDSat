
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;





public class conectaDAO {
    
    public Connection connectDB(){
        
        
        try {
                         Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost/uc11", 
                                "root", 
                                "Jpaulo21"
                        );
                         return conn;
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
            return null;
        }
        
    }
    
}
