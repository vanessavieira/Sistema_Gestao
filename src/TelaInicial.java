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
	private static Scanner scan;

	public static void main(String[] args) {

		Administrador baldoino = new Administrador();

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
		int escolha, cadastrado, logouAluno, logouProfessor, logouPesquisador, logouAdministrador;
		cadastrado = 0;
		logouAluno = 0;
		logouProfessor = 0;
		logouPesquisador = 0;
		logouAdministrador = 0;
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
		ArrayList<Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		String emailUsuario = "nenhum";
		String senhaUsuario = "nenhuma";
		String emailAdministrador = "baldoino@ic.ufal.br";
		String senhaAdministrador = "senha123";

		do {
			System.out.println(
					"  ----------SISTEMA DE GESTAO----------\n     ----------DE RECURSOS----------\n      ----------(2016.1)----------\n\n");
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
				int Novaescolha = 0;

				do {
					if (logouAluno == 0 && logouProfessor == 0 && logouPesquisador == 0 && logouAdministrador == 0) {
						System.out.println("\n----------LOGIN----------\n\n");
						System.out.println("Escolha o Tipo de Usuario:");
						System.out.println("1. Aluno de Graduacao, Mestrado ou Doutorado");
						System.out.println("2. Professor");
						System.out.println("3. Pesquisador");
						System.out.println("4. Administrador");
						System.out.println("5. Voltar ao Menu");

						Novaescolha = input.nextInt();
						input.nextLine();

						if (Novaescolha == 1) {
							scan = new Scanner(System.in);
							Aluno usuario = new Aluno();
							int posicaoAluno = 0;

							System.out.println("Email do Aluno(a):");
							usuario.setEmail(input.nextLine());
							emailUsuario = usuario.getEmail();

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());
							senhaUsuario = usuario.getSenha();

							for (Aluno usuarios : listaAlunos) {
								if (emailUsuario.equals(usuarios.getEmail())
										&& senhaUsuario.equals(usuarios.getSenha())) {
									System.out.println("Bem-vindo ao Sistema de Gerenciamento!\n");
									logouAluno = 1;
									Novaescolha = 5;
									break;
								}
								posicaoAluno++;
							}

							if (posicaoAluno == listaAlunos.size()) {
								System.out.println("\nEmail e/ou senha incorretos\n\n");
								break;
							}

							/*
							 * for (Aluno usuarioss : listaAlunos){
							 * System.out.println(usuarioss.getEmail()); }
							 * System.out.println("posicao no array:"
							 * +posicaoAluno);
							 */
						} else if (Novaescolha == 2) {
							scan = new Scanner(System.in);
							Professor usuario = new Professor();
							int posicaoProfessor = 0;

							System.out.println("Email do Professor(a):");
							usuario.setEmail(input.nextLine());
							emailUsuario = usuario.getEmail();

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());
							senhaUsuario = usuario.getSenha();

							for (Professor usuarios : listaProfessores) {
								if (emailUsuario.equals(usuarios.getEmail())
										&& senhaUsuario.equals(usuarios.getSenha())) {
									System.out.println("Bem-vindo ao Sistema de Gerenciamento!\n");
									logouProfessor = 1;
									Novaescolha = 5;
									break;
								}
								posicaoProfessor++;
							}

							if (posicaoProfessor == listaProfessores.size()) {
								System.out.println("\nEmail e/ou senha incorretos\n\n");
								break;
							}
						} else if (Novaescolha == 3) {
							scan = new Scanner(System.in);
							Pesquisador usuario = new Pesquisador();
							int posicaoPesquisador = 0;

							System.out.println("Email do Pesquisador(a):");
							usuario.setEmail(input.nextLine());
							emailUsuario = usuario.getEmail();

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());
							senhaUsuario = usuario.getSenha();

							for (Pesquisador usuarios : listaPesquisadores) {
								if (emailUsuario.equals(usuarios.getEmail())
										&& senhaUsuario.equals(usuarios.getSenha())) {
									System.out.println("Bem-vindo ao Sistema de Gerenciamento!\n");
									logouPesquisador = 1;
									Novaescolha = 5;
									break;
								}
								posicaoPesquisador++;
							}

							if (posicaoPesquisador == listaPesquisadores.size()) {
								System.out.println("\nEmail e/ou senha incorretos\n\n");
								break;
							}
						} else if (Novaescolha == 4) {
							scan = new Scanner(System.in);
							Administrador usuario = new Administrador();

							System.out.println("Email do Administrador:");
							usuario.setEmail(input.nextLine());
							emailUsuario = usuario.getEmail();

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());
							senhaUsuario = usuario.getSenha();

							if (emailUsuario.equals(emailAdministrador) && senhaUsuario.equals(senhaAdministrador)) {
								System.out.println("Bem-vindo ao Sistema de Gerenciamento!\n");
								logouAdministrador = 1;
								Novaescolha = 5;
								break;
							} else {
								System.out.println("Email e/ou senha de administrador incorretos");
							}
						}
					} else {
						System.out.println("Voce ja esta logado. Email:" + emailUsuario);
						System.out.println("");
						Novaescolha = 5;
						break;
					}
				} while (Novaescolha != 5);

			} else if (escolha == 2) {
				int novaEscolha;
				do {
					System.out.println("\n----------CADASTRO----------\n\n");
					System.out.println("Escolha um Tipo de Usuario:");
					System.out.println("1. Aluno de Graduacao, Mestrado ou Doutorado");
					System.out.println("2. Professor");
					System.out.println("3. Pesquisador");
					System.out.println("4. Sair do Sistema");

					novaEscolha = input.nextInt();
					input.nextLine();

					if (novaEscolha == 1) {

						while (novaEscolha != 0) {

							scan = new Scanner(System.in);

							Aluno usuario = new Aluno();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							System.out.println("Tipo de Aluno (graduacao, mestrado ou doutorado)");
							String tipo = scan.nextLine();

							if (tipo.equals("graduacao") || tipo.equals("mestrado") || tipo.equals("doutorado")) {

								for (Aluno alunos : listaAlunos) {
									if (email.equals(alunos.email) || email.equals("baldoino@ic.ufal.br")) {
										System.out.println(
												"Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
										cadastrado++;
										break;
									}
								}

								for (Professor professores : listaProfessores) {
									if (email.equals(professores.email) || email.equals("baldoino@ic.ufal.br")) {
										System.out.println(
												"Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
										cadastrado++;
										break;
									}
								}

								for (Pesquisador pesquisadores : listaPesquisadores) {
									if (email.equals(pesquisadores.email) || email.equals("baldoino@ic.ufal.br")) {
										System.out.println(
												"Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
										cadastrado++;
										break;
									}
								}

								if (cadastrado == 0) {
									listaAlunos.add(usuario);
									num_usuarios++;
									// System.out.println(listaAlunos.size());
									System.out.println("Aluno(a) cadastrado com sucesso!");
									System.out.println(
											"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario\n");

									novaEscolha = input.nextInt();
									input.nextLine();

									if (novaEscolha != 0) {
										break;
									}
								} else {
									cadastrado--;
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

							scan = new Scanner(System.in);

							Professor usuario = new Professor();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							for (Aluno alunos : listaAlunos) {
								if (email.equals(alunos.email) || email.equals("baldoino@ic.ufal.br")) {
									System.out.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							for (Professor professores : listaProfessores) {
								if (email.equals(professores.email)|| email.equals("baldoino@ic.ufal.br")) {
									System.out.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							for (Pesquisador pesquisadores : listaPesquisadores) {
								if (email.equals(pesquisadores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.out.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							if (cadastrado == 0) {
								listaProfessores.add(usuario);
								num_usuarios++;

								System.out.println("Professor(a) cadastrado com sucesso!");
								System.out.println(
										"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario\n");

								novaEscolha = input.nextInt();
								input.nextLine();

								if (novaEscolha != 0) {
									break;
								}
							} else {
								cadastrado--;
								break;
							}
						}
					}

					else if (novaEscolha == 3) {

						while (novaEscolha != 0) {

							scan = new Scanner(System.in);

							Pesquisador usuario = new Pesquisador();

							System.out.println("Nome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							for (Aluno alunos : listaAlunos) {
								if (email.equals(alunos.email) || email.equals("baldoino@ic.ufal.br")) {
									System.out.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							for (Professor professores : listaProfessores) {
								if (email.equals(professores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.out.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							for (Pesquisador pesquisadores : listaPesquisadores) {
								if (email.equals(pesquisadores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.out.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							if (cadastrado == 0) {
								listaPesquisadores.add(usuario);
								num_usuarios++;

								System.out.println("Pesquisador(a) cadastrado com sucesso!");
								System.out.println(
										"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario\n");

								novaEscolha = input.nextInt();
								input.nextLine();

								if (novaEscolha != 0) {
									break;
								}
							} else {
								cadastrado--;
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
				System.out.println("\n----------RELATORIO ATUAL----------\n\n");
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

				/*
				 * for (Aluno usuario : listaAlunos){
				 * System.out.println(usuario.getNome()); }
				 */
			}
		} while (escolha != 6);
	}

}