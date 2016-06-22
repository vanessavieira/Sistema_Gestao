import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class TelaInicial {

	private static Scanner input;
	

	public static void main(String[] args) {
		int num_usuarios, num_recursos_alocacao, num_recursos_alocado, num_recursos_andamento, num_recursos_concluido, num_alocacoes, num_aula_tradicional, num_apresentacao, num_laboratorio;
		num_usuarios = 0;
		num_recursos_alocacao = 0;
		num_recursos_alocado = 0;
		num_recursos_andamento = 0;
		num_recursos_concluido = 0;
		num_aula_tradicional = 0;
		num_apresentacao = 0;
		num_laboratorio = 0;
		int escolha;
		
		do{
			
			System.out.print("  SISTEMA DE GESTAO\n     DE RECURSOS\n      (2016.1)\n\n");
			System.out.print("Escolha uma opcao:\n");
			System.out.print("1. Login\n");
			System.out.print("2. Cadastro\n");
			System.out.print("3. Locacao de Recursos\n");
			System.out.print("4. Consulta\n");
			System.out.print("5. Relatorio Atual\n");
			System.out.print("6. Sair do Sistema\n");

			input = new Scanner(System.in);
			escolha = input.nextInt();
		
			input.nextLine();
			
			if (escolha == 1) {
				System.out.print("foi");
			} else if (escolha == 2) {
				int novaEscolha;
				do {
					System.out.print("Escolha um Tipo de Usuario:\n");
					System.out.print("1. Aluno de Graduacao, Mestrado ou Doutorado\n");
					System.out.print("2. Professor\n");
					System.out.print("3. Pesquisador\n");
					System.out.print("4. Sair do Sistema\n");

					novaEscolha = input.nextInt();
					input.nextLine();

					if (novaEscolha == 1) {
						ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
						while(novaEscolha != 0){

							Aluno usuario = new Aluno();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());

							listaAlunos.add(usuario);
							num_usuarios++;

							System.out.println("Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario");
							novaEscolha = input.nextInt();
							input.nextLine();
						}
					}
				} while (novaEscolha != 0);
			}

			/*Scanner ler = new Scanner(System.in);
					ArrayList<String> listaAlunos = new ArrayList<String>();

					System.out.print("Nome do Usuario:\n");
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

			else if (escolha == 5) {
				num_alocacoes = num_recursos_alocacao + num_recursos_alocado
						+ num_recursos_andamento + num_recursos_concluido;
				System.out.println("RELATORIO ATUAL\n");
				System.out.println("Numero de Usuarios:" + num_usuarios);
				System.out.println("Numero de Recursos em Processo de Alocacao:"
						+ num_recursos_alocacao);
				System.out.println("Numero de Recursos Alocados:"
						+ num_recursos_alocado);
				System.out.println("Numero de Recursos em Andamento:"
						+ num_recursos_andamento);
				System.out.println("Numero de Recursos Concluidos:"
						+ num_recursos_concluido);
				System.out.println("Numero Total de Alocacoes:" + num_alocacoes);
				System.out.println("Numero de Aulas Tradicionais:"
						+ num_aula_tradicional);
				System.out.println("Numero de Apresentacoes:" + num_apresentacao);
				System.out.println("Numero de Atividades em Laboratorio:"
						+ num_laboratorio);
				System.out.println("");

			}
	}while(escolha != 6);
}

}