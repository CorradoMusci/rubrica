package rubricaDB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import it.polito.tdp.rubrica.model.Voce;

public class VoceDAO {
	
	
	
	public Voce findVoceByNome(String nome) {
		
		String jbdcURL = "jdbc:mysql://localhost/rubrica?user=root";
		try {
			
			Connection conn = (Connection) DriverManager.getConnection(jbdcURL);
			
			Statement st = conn.createStatement();
			
			
			String  sql = "Select nome,email,telefono from voce where nome = \""+nome+"\"";
			
			ResultSet res = st.executeQuery(sql);
			
			if( res.next() ){
				
				//found
				Voce v = new Voce(
						res.getString("nome"),
						res.getString("email"),
						res.getString("telefono"));
				
				res.close();
				conn.close();
				
				return v;
			}else{
				//not found
				res.close();
				conn.close();
				return null;
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	
	}
	
	
	public boolean addVoce(Voce v){
		String jbdcURL = "jdbc:mysql://localhost/rubrica?user=root";
		try {
			
			Connection conn = (Connection) DriverManager.getConnection(jbdcURL);
			
			Statement st = conn.createStatement();
			
			
			String  sql = " INSERT INTO `rubrica`.`voce` (`nome`, `email`, `telefono`) VALUES ('"+
			v.getNome()+"','"+v.getEmail()+"', '"+v.getTelefono()+"')";
			
			int res = st.executeUpdate(sql);
			
			conn.close();
			
			if(res == 1)
				return true;
			else
				return false;
		
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	}

}
