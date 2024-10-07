import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class TesteJDBC {
	
	private final static String USER = "vinicius";
	private final static String PASS = "123456";
	private final static String DATABASE = "Animais";
	private final static String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
	
	
	static boolean testaConnection() {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			System.out.println("conexao feita");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	
	static boolean testaStatement() {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			String comando = "INSERT INTO Pato(id, nome) VALUES (4, 'ze jao')";
			Statement s = c.createStatement();
			int res = s.executeUpdate(comando);
			System.out.println("resultado: " + res);
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	static boolean testaResult() {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			String comando = "SELECT * FROM Pato";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(comando);
			while(rs.next()) {
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Id: " + rs.getInt("id"));
				System.out.println("");
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		testaResult();
	}

}
