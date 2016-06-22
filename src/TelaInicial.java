import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class TelaInicial {

	private static Scanner scanner;
	private static Scanner novoInput;
	private static Scanner input;

	public static void main(String[] args) {
		System.out
				.print("  SISTEMA DE GESTAO\n     DE RECURSOS\n      (2016.1)\n\n");
		System.out.print("Escolha uma opcao:\n");
		System.out.print("1. Login\n");
		System.out.print("2. Cadastro\n");
		System.out.print("3. Locaçao de Recursos\n");
		System.out.print("4. Consulta\n");
		System.out.print("5. Relatório Atual\n");
		System.out.print("6. Sair do Sistema\n");

		int num_usuarios, num_recursos_alocacao, num_recursos_alocado, num_recursos_andamento, num_recursos_concluido, num_alocacoes, num_aula_tradicional, num_apresentacao, num_laboratorio;
		num_usuarios = 0;
		num_recursos_alocacao = 0;
		num_recursos_alocado = 0;
		num_recursos_andamento = 0;
		num_recursos_concluido = 0;
		num_aula_tradicional = 0;
		num_apresentacao = 0;
		num_laboratorio = 0;

		input = new Scanner(System.in);
		int escolha = input.nextInt();

		if (escolha == 1) {
			System.out.print("foi");
		} else if (escolha == 2) {
			System.out.print("Escolha um Tipo de Usuario:\n");
			System.out.print("1. Aluno de Graduacao, Mestrado ou Doutorado\n");
			System.out.print("2. Professor\n");
			System.out.print("3. Pesquisador\n");
			System.out.print("4. Sair do Sistema\n");

			novoInput = new Scanner(System.in);
			int novaEscolha = novoInput.nextInt();

			if (novaEscolha == 1) {
				scanner = new Scanner(System.in);
				ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
				
				while(novaEscolha != 0){
					
					Aluno usuario = new Aluno();
					
					System.out.println("Nome do Usuario");
					usuario.setNome(scanner.nextLine());
					
					System.out.println("Senha");
					usuario.setSenha(scanner.nextLine());
					
					System.out.println("Email");
					usuario.setEmail(scanner.nextLine());
					
					listaAlunos.add(usuario);
					num_usuarios++;
					
					System.out.println("Digite 0 para voltar ao menu");
					novaEscolha = scanner.nextInt();
				}

				/*Scanner ler = new Scanner(System.in);
				ArrayList<String> listaAlunos = new ArrayList<String>();

				System.out.print("Nome do Usuário:\n");
				String nome;
				nome = ler.nextLine();
				listaAlunos.add(nome);
				
				System.out.print("E-mail:\n");
				String nome;
				nome = ler.nextLine();
				listaAlunos.add(nome);
				

				for (String nomes : listaAlunos) {
					System.out.println(nomes);
				}*/
				
		} else if (escolha == 5) {
			num_alocacoes = num_recursos_alocacao + num_recursos_alocado
					+ num_recursos_andamento + num_recursos_concluido;
			System.out.print("RELATORIO ATUAL\n");
			System.out.print("\nNumeros de Usuarios:" + num_usuarios);
			System.out.print("\nNumero de Recursos em Processo de Alocacao:"
					+ num_recursos_alocacao);
			System.out.print("\nNumero de Recursos Alocados:"
					+ num_recursos_alocado);
			System.out.print("\nNumero de Recursos em Andamento:"
					+ num_recursos_andamento);
			System.out.print("\nNumero de Recursos Concluidos:"
					+ num_recursos_concluido);
			System.out.print("\nNumero Total de Alocacoes:" + num_alocacoes);
			System.out.print("\nNumero de Aulas Tradicionais:"
					+ num_aula_tradicional);
			System.out.print("\nNumero de Apresentacoes:" + num_apresentacao);
			System.out.print("\nNumero de Atividades em Laboratorio:"
					+ num_laboratorio);

		}
	}
}
}