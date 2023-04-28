import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//CONECTANDO COM O BANCO DE DADOS
		String link ="jdbc:mysql://localhost:3306/dbjdbc";
		String user = "root";
		String password = "root";

		//INSTANCIANDO O BANCO DE DADOS
		Database database = new Database();
		database.Conectar(link, user, password);
		Scanner scanner = new Scanner(System.in);
		
		//RECEBENDO OS DADOS DO USUÁRIO
		System.out.println("Olá, por favor digite seu CPF: ");
		int cpf = scanner.nextInt();
		System.out.println("Por favor digite o seu nome: ");
		String nome = scanner.nextLine();
		System.out.println("Por favor, digite sua idade: ");
		int idade = scanner.nextInt();
		
		//INSERINDO A QUERRY PARA ADICIONAR NO BANCO DE DADOS
		String insert = "INSERT INTO pessoa (CPF, NOME, IDADE) VALUE (cpf, nome, idade)";
		database.CRUD(insert);
		
		//CONSULTAR O DADO NO BANCO DE DADOS
		String consultar = "SELECT * FROM pessoa";
		database.Consultar(consultar);
		System.out.println("Caso deseje inserir mais dados digite 1, senão digite 2: ");
		boolean alternativa = scanner.nextBoolean();
		//IF PARA IDENTIFICAR A OPÇÃO DO USUÁRIO
		if(alternativa = true) {
			String insertp = "INSERT INTO pessoa (CPF, NOME, IDADE) VALUE (cpf, nome, idade)";
			database.CRUD(insertp);
		}else {
			database.Desconectar();
		}
	}

}
