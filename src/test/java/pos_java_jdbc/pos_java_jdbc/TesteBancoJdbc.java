package pos_java_jdbc.pos_java_jdbc;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.UserPosJava;

public class TesteBancoJdbc {
	@Test
	public void initBanco() {
		//SingleConnection.getConnection();
		UserPosDao userPosDAO = new UserPosDao(); //obj userPosDAO
		UserPosJava userposJava = new UserPosJava();
		
		userposJava.setNome("Java");
		userposJava.setEmail("java@mail.com");
		userPosDAO.salvar(userposJava);
		
		
	}
	
	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();
		try {
			List<UserPosJava> list = dao.listar();
			for (UserPosJava userPosJava : list) {
				System.out.println(userPosJava.getNome());
				System.out.println("--------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		try {
			UserPosJava userposJava = dao.buscar(3L);
			
			System.out.println(userposJava.getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		
		try {
			UserPosDao dao = new UserPosDao();
			
			UserPosJava userposJava = dao.buscar(4L);
			
			userposJava.setNome("mudar metodo atualizar @@@@@@@");
			
			dao.atualizar(userposJava);
			
			System.out.println(userposJava.getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDao dao = new UserPosDao();
			dao.deletar(2L);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
