package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.UserPosJava;

public class UserPosDao {
	
	private Connection connection;
	
	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (UserPosJava userposJava) {
		
		try {
			String sql = "insert into userposjava(id,nome,email)values(?,?,?)";
			// Prepara o Insert
			PreparedStatement insert = connection.prepareStatement(sql);
			//Estaticos os dados
//			insert.setLong(1, 2);
//			insert.setString(2, "Erick - Salvado Dao");
//			insert.setString(3, "erick@teste.com");
			
			//Dinamicos os dados
			insert.setLong(1,userposJava.getId());
			insert.setString(2, userposJava.getNome());
			insert.setString(3,userposJava.getEmail() );
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
}
