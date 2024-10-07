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

public interface Dao {
	
	
	public List<Pato> buscaPatosByName(String name);
	public boolean adicionaPato(Pato pato) throws SQLIntegrityConstraintViolationException;
	// Retorna null caso o pato nao exista
	public Pato buscaPatoById(int id);
	public boolean apagaPato(int id);
}
