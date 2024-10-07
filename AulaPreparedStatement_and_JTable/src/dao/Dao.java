package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import entidade.Pato;

public class Dao {
	
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
	
	
	static List<Pato> todosPatos() {
		
		List<Pato> patos = new ArrayList<>();
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			String comando = "SELECT * FROM Pato";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(comando);
			while(rs.next()) {
				Pato p = new Pato(rs.getString("nome"), rs.getInt("id"));
				patos.add(p);
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return patos;
		
	}
	
	
	static List<Pato> buscaPatos(String nome) {
		
		List<Pato> patos = new ArrayList<>();
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			String comando = ""
					+ "SELECT * FROM Pato "
					+ "WHERE LOWER(nome) "
					+ "LIKE LOWER(?)";
			
			PreparedStatement s = c.prepareStatement(comando);
			s.setString(1, '%'+nome+'%');
			
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				Pato p = new Pato(rs.getString("nome"), rs.getInt("id"));
				patos.add(p);
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return patos;
		
	}
	
	
	public static void main(String[] args) {
//		for(Pato p : todosPatos())
//			System.out.println(p);
		for(Pato p : buscaPatos("Jao"))
			System.out.println(p);
	}

}
