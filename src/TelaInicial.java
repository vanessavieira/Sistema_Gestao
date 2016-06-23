import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import Usuarios.Aluno;
import Usuarios.Professor;
import Usuarios.Pesquisador;
import Usuarios.Administrador;

public class TelaInicial {

	private static Scanner input;

	public static void main(String[] args) {

		Administrador Baldoino = new Administrador("Baldoino", "123senha");

		int num_usuarios, num_recursos_alocacao, num_recursos_alocado, num_recursos_andamento, num_recursos_concluido,
				num_alocacoes, num_aula_tradicional, num_apresentacao, num_laboratorio;
		num_usuarios = 1;
		num_recursos_alocacao = 0;
		num_recursos_alocado = 0;
		num_recursos_andamento = 0;
		num_recursos_concluido = 0;
		num_aula_tradicional = 0;
		num_apresentacao = 0;
		num_laboratorio = 0;
		int escolha;
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
		ArrayList<Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();

		do {
			System.out.println("  SISTEMA DE GESTAO\n     DE RECURSOS\n      (2016.1)\n\n");
			System.out.println("Escolha uma opcao:");
			System.out.println("1. Login");
			System.out.println("2. Cadastro");
			System.out.println("3. Locacao de Recursos");
			System.out.println("4. Consulta");
			System.out.println("5. Relatorio Atual");
			System.out.println("6. Sair do Sistema");

			input = new Scanner(System.in);
			escolha = input.nextInt();

			input.nextLine();

			if (escolha == 1) {
				System.out.print("foi");

			} else if (escolha == 2) {
				int novaEscolha;
				do {
					System.out.println("Escolha um Tipo de Usuario:");
					System.out.println("1. Aluno de Graduacao, Mestrado ou Doutorado");
					System.out.println("2. Professor");
					System.out.println("3. Pesquisador");
					System.out.println("4. Sair do Sistema");

					novaEscolha = input.nextInt();
					input.nextLine();

					if (novaEscolha == 1) {

						while (novaEscolha != 0) {

							Scanner scan = new Scanner(System.in);

							Aluno usuario = new Aluno();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());
							
							/*if(usuario.getNome.equals("vanessa")){
								System.out.print("foi1");
							}*/

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());
							boolean x;
							do{
								x=false;
								System.out.println("Email");
								usuario.setEmail(input.nextLine());
								String email = usuario.getEmail();
								
								for (Aluno alunos : listaAlunos){
									//System.out.println("entrou");
									//System.out.println(alunos.getEmail());
									//verificar primeiro e depois adicionar a lista caso nao exista
									if (email.equals(alunos.getEmail())){
										System.out.println("Esse e-mail ja esta cadastrado");
										x=true;
										break;
									}
								}
							}while(x);
							
							
							System.out.println("Tipo de Aluno (graduacao, mestrado ou doutorado)");
							String tipo = scan.nextLine();

							if (tipo.equals("graduacao") || tipo.equals("mestrado") || tipo.equals("doutorado")) {
								listaAlunos.add(usuario);
								num_usuarios++;
								novaEscolha = input.nextInt();
								input.nextLine();

								if (novaEscolha != 0) {
									break;
								}	

							} else {
								System.out.println(
										"Ops! Um erro ocorreu no cadastro, certifique-se que voce digitou todas as informacoes corretamente!\n");
								break;
							}
						}
					}

					else if (novaEscolha == 2) {

						while (novaEscolha != 0) {

							Professor usuario = new Professor();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());

							listaProfessores.add(usuario);
							num_usuarios++;

							System.out.println("Professor cadastrado com sucesso!");
							System.out.println(
									"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario");

							novaEscolha = input.nextInt();
							input.nextLine();

							if (novaEscolha != 0) {
								break;
							}
						}
					}

					else if (novaEscolha == 3) {

						while (novaEscolha != 0) {

							Pesquisador usuario = new Pesquisador();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());

							listaPesquisadores.add(usuario);
							num_usuarios++;

							System.out.println("Pesquisador cadastrado com sucesso!");
							System.out.println(
									"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario");

							novaEscolha = input.nextInt();
							input.nextLine();

							if (novaEscolha != 0) {
								break;
							}
						}
					}

					else if (novaEscolha == 4) {
						escolha = 6;
						break;
					}

				} while (novaEscolha != 0);
			}

			else if (escolha == 5) {
				num_alocacoes = num_recursos_alocacao + num_recursos_alocado + num_recursos_andamento
						+ num_recursos_concluido;
				System.out.println("RELATORIO ATUAL\n");
				System.out.println("Numero de Usuarios:" + num_usuarios);
				System.out.println("Numero de Recursos em Processo de Alocacao:" + num_recursos_alocacao);
				System.out.println("Numero de Recursos Alocados:" + num_recursos_alocado);
				System.out.println("Numero de Recursos em Andamento:" + num_recursos_andamento);
				System.out.println("Numero de Recursos Concluidos:" + num_recursos_concluido);
				System.out.println("Numero Total de Alocacoes:" + num_alocacoes);
				System.out.println("Numero de Aulas Tradicionais:" + num_aula_tradicional);
				System.out.println("Numero de Apresentacoes:" + num_apresentacao);
				System.out.println("Numero de Atividades em Laboratorio:" + num_laboratorio);
				System.out.println("");
				
				/*for (Aluno usuario : listaAlunos){
					System.out.println(usuario.getNome());
				}*/
			}
		} while (escolha != 6);
	}

}
