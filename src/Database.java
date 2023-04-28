import java.sql.*;

public class Database implements Interface{
	private Connection connection;
	private Statement statement;

	//CONECTANDO O BANCO DE DADOS
	@Override
	public void Conectar(String dblink, String dbuser, String dbpassword) {
		try {
			connection = DriverManager.getConnection(dblink, dbuser, dbpassword);
			statement = connection.createStatement();
			System.out.println("Conexão concluída!");
		}
		catch(SQLException error){
			System.out.println("Conexão falhou: "+error.getMessage());
		}
	}

	//CONSULTA NO BANCO DE DADOS
	@Override
	public void Consultar(String dbquery) {
		try {
			ResultSet result = statement.executeQuery(dbquery);
			while(result.next()) {
				System.out.println(result.getString(1)+" | "+result.getString(1)+" | "+result.getString(3));
			}
		}catch(SQLException error) {
			System.out.println("Não foi possível consultar: "+error.getMessage());
		}
	}

	//DESCONECTANDO NO BANCO DE DADOS
	@Override
	public void Desconectar() {
		try {
			statement.close();
			connection.close();
			System.out.println("Sua conexão foi encerrada.");
		}catch(SQLException error) {
			System.out.println("Não foi possível desconectar: "+error.getMessage());
		}
	}

	//INSERIR, ALTERAR E EXCLUIR (CRUD) NO BANCO DE DADOS
	@Override
	public int CRUD(String dbquery) {
		try {
			int linhas = statement.executeUpdate(dbquery);
			System.out.println(linhas + " linha(as) afetada(as)");
			return linhas;
		}catch(SQLException error) {
			System.out.println("Não foi possível executar essa operação: "+error.getMessage());
			return 0;
		}
		
		
	}
	 
}
