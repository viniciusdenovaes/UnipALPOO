package dao;

import java.io.IOException;
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

public class DaoConcreto implements Dao{
	
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
	
	
	

	@Override
	public List<Pato> buscaPatosByName(String name) {
		
		List<Pato> patos = new ArrayList<>();
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			String comando = ""
					+ "SELECT * FROM Pato "
					+ "WHERE LOWER(nome) "
					+ "LIKE LOWER(?)";
			
			PreparedStatement s = c.prepareStatement(comando);
			s.setString(1, '%'+name+'%');
			
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


	@Override
	public boolean adicionaPato(Pato pato) throws SQLIntegrityConstraintViolationException {
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			String comando = "INSERT INTO Pato(id, nome) VALUES (?, ?)";
			PreparedStatement s = c.prepareStatement(comando);
			
			s.setInt(1, pato.getId());
			s.setString(2, pato.getNome());
			
			int res = s.executeUpdate();
			System.out.println("resultado: " + res);
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public Pato buscaPatoById(int id) {
		
		Pato pato = null;
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			String comando = ""
					+ "SELECT * FROM Pato "
					+ "WHERE id "
					+ "LIKE ?";
			
			PreparedStatement s = c.prepareStatement(comando);
			s.setInt(1, id);
			
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				pato = new Pato(rs.getString("nome"), rs.getInt("id"));
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel adicionar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return pato;
		
	}


	@Override
	public boolean apagaPato(int id) {
		
		Pato pato = null;
		
		try(Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			String comando = ""
					+ "DELETE FROM Pato "
					+ "WHERE id "
					+ "LIKE ?";
			
			PreparedStatement s = c.prepareStatement(comando);
			s.setInt(1, id);
			
			int res = s.executeUpdate();
			System.out.println(res);
			if(res==0) {
				return false;
			}
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Nao foi possivel apagar: " + e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		DaoConcreto dao = new DaoConcreto();
		
		for(Pato p : dao.buscaPatosByName(""))
			System.out.println(p);
		
		dao.apagaPato(9);
		
		for(Pato p : dao.buscaPatosByName(""))
			System.out.println(p);
		
		
		try {
			dao.adicionaPato(new Pato("Donaldo", 5));
		}catch(SQLIntegrityConstraintViolationException e) {}
		
		for(Pato p : dao.buscaPatosByName(""))
			System.out.println(p);
		
		System.out.println(dao.buscaPatoById(7));
		
		
		
	}



}
