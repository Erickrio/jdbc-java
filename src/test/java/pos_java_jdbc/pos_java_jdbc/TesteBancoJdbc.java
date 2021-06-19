package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.UserPosJava;

public class TesteBancoJdbc {
	@Test
	public void initBanco() {
		//SingleConnection.getConnection();
		UserPosDao userPosDAO = new UserPosDao(); //obj dao
		UserPosJava userposJava = new UserPosJava();
		userposJava.setId(4L);
		userposJava.setNome("Java");
		userposJava.setEmail("java@mail.com");
		userPosDAO.salvar(userposJava);
		
		
	}

}
