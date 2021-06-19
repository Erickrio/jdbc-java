package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

public class UserPosDao {
	
	private Connection connection;
	
	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (UserPosJava userposJava) {
		
		try {
			String sql = "insert into userposjava(nome,email)values(?,?)";
			// Prepara o Insert
			PreparedStatement insert = connection.prepareStatement(sql);
			
			//Dinamicos os dados
			insert.setString(1, userposJava.getNome());
			insert.setString(2,userposJava.getEmail() );
			insert.execute();
			connection.commit(); //salva no bd
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<UserPosJava> listar () throws Exception {
		List<UserPosJava> list = new ArrayList<>();
		
		String sql = "select * from userposjava";
		
		PreparedStatement statement= connection.prepareStatement(sql);
		ResultSet resultado= statement.executeQuery();
		
		//enquanto tiver dados na lista
		while (resultado.next()) {
			//instanciar objetos
			UserPosJava userposjava= new UserPosJava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			list.add(userposjava);
		}
		
		return list;
		
	}
	
	//Retorna apenas uma lista
	public UserPosJava buscar (Long id) throws Exception {
		
		UserPosJava retorno = new UserPosJava();
		
		String sql = "select * from userposjava where id = "+ id;
		
		//prepara o Statement
		PreparedStatement statement= connection.prepareStatement(sql);
		//executa a consulta
		ResultSet resultado= statement.executeQuery();
		
		//enquanto tiver dados na lista
		while (resultado.next()) { //retorna apenas 1 ou nenhum
		
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			
		}
		
		return retorno;
		
	}


	public void atualizar(UserPosJava userposjava) {

		try {
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());

			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}


}
