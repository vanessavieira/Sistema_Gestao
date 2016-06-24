import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import Usuarios.Aluno;
import Usuarios.Professor;
import Usuarios.Pesquisador;
import Usuarios.Administrador;

public class TelaInicial {

	private static Scanner input;
	private static Scanner scan;

	public static void main(String[] args) throws NumberFormatException {

		Administrador Baldoino = new Administrador();

		int num_usuarios, num_recursos_alocacao, num_recursos_alocado, num_recursos_andamento, num_recursos_concluido,
				num_alocacoes, num_aula_tradicional, num_apresentacao, num_laboratorio;
		int escolhaMenu, cadastrado;
		int logouAluno, logouProfessor, logouPesquisador, logouAdministrador;

		String emailUsuario = "nenhum";
		String senhaUsuario = "nenhuma";
		String emailAdministrador = "baldoino@ic.ufal.br";
		String senhaAdministrador = "senha123";
		
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
		ArrayList<Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.set(2016, Calendar.JUNE,29);
		dataAtual.set(Calendar.HOUR_OF_DAY,1);
		DateFormat formatoData = DateFormat.getDateInstance();
		Date data = dataAtual.getTime();	
		
		num_usuarios = 1;
		num_recursos_alocacao = 0;
		num_recursos_alocado = 0;
		num_recursos_andamento = 0;
		num_recursos_concluido = 0;
		num_aula_tradicional = 0;
		num_apresentacao = 0;
		num_laboratorio = 0;
		cadastrado = 0;
		logouAluno = 0;
		logouProfessor = 0;
		logouPesquisador = 0;
		logouAdministrador = 0;	

		do {
			data = dataAtual.getTime();
			System.out.println("Data: "+formatoData.format(data));
			System.out.println("Hora: "+dataAtual.get(Calendar.HOUR_OF_DAY));
			System.out.println(
					"  ----------SISTEMA DE GESTAO----------\n     ----------DE RECURSOS----------\n      ----------(2016.1)----------\n\n");
			System.out.println("Escolha uma opcao:");
			System.out.println("1. Login/Logout");
			System.out.println("2. Cadastro");
			System.out.println("3. Locacao de Recursos");
			System.out.println("4. Consulta");
			System.out.println("5. Relatorio Atual");
			System.out.println("6. Sair do Sistema");

			input = new Scanner(System.in);
			escolhaMenu = input.nextInt();

			input.nextLine();

			if (escolhaMenu == 1) {
				int escolhaLogin = 0;
				int escolhaLogout = 0;

				do {
					if (logouAluno == 0 && logouProfessor == 0 && logouPesquisador == 0 && logouAdministrador == 0) {
						System.out.println("\n----------LOGIN----------\n\n");
						System.out.println("Escolha o Tipo de Usuario:");
						System.out.println("1. Aluno de Graduacao, Mestrado ou Doutorado");
						System.out.println("2. Professor");
						System.out.println("3. Pesquisador");
						System.out.println("4. Administrador");
						System.out.println("5. Voltar ao Menu");

						escolhaLogin = input.nextInt();
						input.nextLine();

						if (escolhaLogin == 1) {
							scan = new Scanner(System.in);
							Aluno usuario = new Aluno();
							int posicaoAluno = 0;

							System.out.println("\n----------LOGIN DE ALUNO(A)----------\n\n");

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
									escolhaLogin = 5;
									break;
								}
								posicaoAluno++;
							}

							if (posicaoAluno == listaAlunos.size()) {
								System.out.println(
										"\nEmail e/ou senha incorretos. (Certifique-se de que voce esta cadastrado no Sistema).\n\n");
								break;
							}

							/*
							 * for (Aluno usuarioss : listaAlunos){
							 * System.out.println(usuarioss.getEmail()); }
							 * System.out.println("posicao no array:"
							 * +posicaoAluno);
							 */
						} else if (escolhaLogin == 2) {
							scan = new Scanner(System.in);
							Professor usuario = new Professor();
							int posicaoProfessor = 0;

							System.out.println("\n----------LOGIN DE PROFESSOR(A)----------\n\n");

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
									escolhaLogin = 5;
									break;
								}
								posicaoProfessor++;
							}

							if (posicaoProfessor == listaProfessores.size()) {
								System.out.println(
										"\nEmail e/ou senha incorretos. (Certifique-se de que voce esta cadastrado no Sistema).\n\n");
								break;
							}
						} else if (escolhaLogin == 3) {
							scan = new Scanner(System.in);
							Pesquisador usuario = new Pesquisador();
							int posicaoPesquisador = 0;

							System.out.println("\n----------LOGIN DE PESQUISADOR(A)----------\n\n");

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
									escolhaLogin = 5;
									break;
								}
								posicaoPesquisador++;
							}

							if (posicaoPesquisador == listaPesquisadores.size()) {
								System.out.println(
										"\nEmail e/ou senha incorretos. (Certifique-se de que voce esta cadastrado no Sistema).\n\n");
								break;
							}
						} else if (escolhaLogin == 4) {
							scan = new Scanner(System.in);
							Administrador usuario = new Administrador();

							System.out.println("\n----------LOGIN DE ADMINISTRADOR----------\n\n");

							System.out.println("Email do Administrador:");
							usuario.setEmail(input.nextLine());
							emailUsuario = usuario.getEmail();

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());
							senhaUsuario = usuario.getSenha();

							if (emailUsuario.equals(emailAdministrador) && senhaUsuario.equals(senhaAdministrador)) {
								System.out.println("Bem-vindo ao Sistema de Gerenciamento!\n");
								logouAdministrador = 1;
								escolhaLogin = 5;
								break;
							} else {
								System.out.println("Email e/ou senha de administrador incorretos");
							}
						}
					} else {
						System.out.println("\n----------LOGOUT----------\n\n");
						System.out.println("Voce esta logado com a conta: " + emailUsuario);
						System.out.println("Deseja desconectar dessa conta?");
						System.out.println("1. Sim");
						System.out.println("2. Nao");

						escolhaLogout = input.nextInt();
						input.nextLine();

						if (escolhaLogout == 1) {
							logouAluno = 0;
							logouProfessor = 0;
							logouPesquisador = 0;
							logouAdministrador = 0;
							emailUsuario = "nenhum";
							senhaUsuario = "nenhuma";
							System.out.println("Voce foi desconectado.\n");
							escolhaLogin = 5;
							break;
						} else if (escolhaLogout == 2) {
							escolhaLogin = 5;
							break;
						}
					}
				} while (escolhaLogin != 5);

			} else if (escolhaMenu == 2) {
				int escolhaCadastro;
				do {
					System.out.println("\n----------CADASTRO----------\n\n");
					System.out.println("Escolha um Tipo de Usuario:");
					System.out.println("1. Aluno de Graduacao, Mestrado ou Doutorado");
					System.out.println("2. Professor");
					System.out.println("3. Pesquisador");
					System.out.println("4. Voltar ao Menu");

					escolhaCadastro = input.nextInt();
					input.nextLine();

					if (escolhaCadastro == 1) {

						while (escolhaCadastro != 0) {

							scan = new Scanner(System.in);

							Aluno usuario = new Aluno();

							System.out.println("\n----------CADASTRAMENTO DE ALUNO(A)----------\n\n");

							System.out.println("\nNome do Usuario");
							usuario.setNome(input.nextLine());

							System.out.println("Senha");
							usuario.setSenha(input.nextLine());

							System.out.println("Email");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							System.out.println("Tipo de Aluno (graduacao, mestrado ou doutorado)");
							usuario.setTipo(input.nextLine());
							String tipo = usuario.getTipo();

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

									System.out.println("Aluno(a) cadastrado com sucesso!");
									System.out.println(
											"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario\n");

									escolhaCadastro = input.nextInt();
									input.nextLine();

									if (escolhaCadastro != 0) {
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
					} else if (escolhaCadastro == 2) {

						while (escolhaCadastro != 0) {

							scan = new Scanner(System.in);

							Professor usuario = new Professor();

							System.out.println("\n----------CADASTRAMENTO DE PROFESSOR(A)----------\n\n");

							System.out.println("\nNome do Usuario");
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
								listaProfessores.add(usuario);
								num_usuarios++;

								System.out.println("Professor(a) cadastrado com sucesso!");
								System.out.println(
										"Digite 0 para voltar ao menu ou qualquer outro número para cadastrar um novo usuario\n");

								escolhaCadastro = input.nextInt();
								input.nextLine();

								if (escolhaCadastro != 0) {
									break;
								}
							} else {
								cadastrado--;
								break;
							}
						}
					} else if (escolhaCadastro == 3) {

						while (escolhaCadastro != 0) {

							scan = new Scanner(System.in);

							Pesquisador usuario = new Pesquisador();

							System.out.println("\n----------CADASTRAMENTO DE PESQUISADOR(A)----------\n\n");

							System.out.println("\nNome do Usuario");
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

								escolhaCadastro = input.nextInt();
								input.nextLine();

								if (escolhaCadastro != 0) {
									break;
								}
							} else {
								cadastrado--;
								break;
							}
						}
					} else if (escolhaCadastro == 4) {
						break;
					}

				} while (escolhaCadastro != 0);

			} else if (escolhaMenu == 3) {

				// locacao de recursos

			} else if (escolhaMenu == 4) {
				int escolhaConsulta = 0;

				do {
					System.out.println("\n----------CONSULTA----------\n\n");
					System.out.println("Escolha o Tipo de Consulta:");
					System.out.println("1. Por Usuario");
					System.out.println("2. Por Recurso");
					System.out.println("3. Voltar ao Menu");

					escolhaConsulta = input.nextInt();
					input.nextLine();

					if (escolhaConsulta == 1) {
						int escolhaConsulta1 = 0;
						do {
							System.out.println("\n----------CONSULTA----------\n\n");
							System.out.println("Escolha o Tipo de Usuario:");
							System.out.println("1. Aluno(a) (Graduacao, Mestrado ou Doutorado");
							System.out.println("2. Professor(a)");
							System.out.println("3. Pesquisador(a)");
							System.out.println("4. Administrador");
							System.out.println("5. Voltar ao Menu");

							escolhaConsulta1 = input.nextInt();
							input.nextLine();

							if (escolhaConsulta1 == 1) {
								scan = new Scanner(System.in);

								Aluno usuario = new Aluno();

								if (listaAlunos.size() == 0) {
									System.out.println("\nNao existe cadastro de alunos no Sistema.\n");
								} else {

									System.out.println("\n----------CONSULTA POR ALUNO(A)----------\n\n");
									System.out.println(
											"Digite o Email do(a) aluno(a) para obter informacoes sobre ele(a):");

									usuario.setEmail(input.nextLine());
									String email = usuario.getEmail();

									for (Aluno usuarios : listaAlunos) {
										if (email.equals(usuarios.getEmail())) {
											System.out.println("\nNome:  " + usuarios.getNome());
											System.out.println("Tipo de Aluno:  " + usuarios.getTipo());
											System.out.println("E-mail:  " + usuarios.getEmail());
										} else {
											System.out.println("\nNao existe cadastro de aluno com tal e-mail.\n");
										}
									}
								}

							} else if (escolhaConsulta1 == 2) {
								scan = new Scanner(System.in);

								Professor usuario = new Professor();

								if (listaProfessores.size() == 0) {
									System.out.println("\nNao existe cadastro de professores no Sistema.\n");
								} else {

									System.out.println("\n----------CONSULTA POR PROFESSOR(A)----------\n\n");
									System.out.println(
											"Digite o Email do(a) professor(a) para obter informacoes sobre ele(a):");

									usuario.setEmail(input.nextLine());
									String email = usuario.getEmail();

									for (Professor usuarios : listaProfessores) {
										if (email.equals(usuarios.getEmail())) {
											System.out.println("\nNome:  " + usuarios.getNome());
											System.out.println("E-mail:  " + usuarios.getEmail());
										} else {
											System.out.println("\nNao existe cadastro de professor com tal e-mail.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 3) {
								scan = new Scanner(System.in);

								Pesquisador usuario = new Pesquisador();
								if (listaPesquisadores.size() == 0) {
									System.out.println("\nNao existe cadastro de pesquisadores no Sistema.\n");
								} else {

									System.out.println("\n----------CONSULTA POR PESQUISADOR(A)----------\n\n");
									System.out.println(
											"Digite o Email do(a) pesquisador(a) para obter informacoes sobre ele(a):");

									usuario.setEmail(input.nextLine());
									String email = usuario.getEmail();

									for (Pesquisador usuarios : listaPesquisadores) {
										if (email.equals(usuarios.getEmail())) {
											System.out.println("\nNome:  " + usuarios.getNome());
											System.out.println("E-mail:  " + usuarios.getEmail());
										} else {
											System.out
													.println("\nNao existe cadastro de pesquisador com tal e-mail.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 4) {
								// administrador
								System.out.println("\nNome:  Baldoino Fonseca");
								System.out.println("\nE-mail:  baldoino@ic.ufal.br");
							} else if (escolhaConsulta1 == 5) {
								escolhaConsulta = 3;
								break;
							}

						} while (escolhaConsulta != 5);
					}

				} while (escolhaConsulta != 3);

			} else if (escolhaMenu == 5) {
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
		} while (escolhaMenu != 6);
	}

}