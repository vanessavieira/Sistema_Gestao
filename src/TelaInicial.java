import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Usuarios.Pessoa;
import Usuarios.Aluno;
import Usuarios.Professor;
import Usuarios.Pesquisador;
import Usuarios.Administrador;
import recursos.Recursos;
import recursos.Auditorio;
import recursos.Laboratorios;
import recursos.Projetores;
import recursos.Salas;

public class TelaInicial {

	private static Scanner input;
	private static Scanner scan;

	public static boolean verificacaoData(String data) {
		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/2016");
		dtf.setLenient(false);
		try {
			dtf.parse(data);
		} catch (ParseException e) {
			System.err.println("Data em formato invalido.");
			return false;
		}
		return true;
	}

	public static boolean verificacaoHora(String hora) {
		try {
			Calendar data = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			sdf.setLenient(false);
			data.setTime(sdf.parse(hora));
			sdf.parse(hora);
		} catch (ParseException e) {
			System.err.println("Horario em formato invalido.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		Administrador Baldoino = new Administrador();

		int num_usuarios, num_recursos_alocacao, num_recursos_alocado, num_recursos_andamento, num_recursos_concluido,
				num_alocacoes, num_aula_tradicional, num_apresentacao, num_laboratorio;
		int escolhaMenu, cadastrado, locouProfessor, locouPesquisador;
		int logouAluno, logouProfessor, logouPesquisador, logouAdministrador;
		int[] statusAuditorio = { 0 };
		int[] statusLaboratorio = { 0, 0, 0 };
		int[] statusProjetor = { 0, 0, 0 };
		int[] statusSala = { 0, 0, 0 };

		String emailUsuario = "nenhum";
		String senhaUsuario = "nenhuma";
		String emailAdministrador = "baldoino@ic.ufal.br";
		String senhaAdministrador = "senha123";

		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		ArrayList<Professor> listaProfessores = new ArrayList<Professor>();
		ArrayList<Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		ArrayList<Auditorio> listaAuditorio = new ArrayList<Auditorio>();
		ArrayList<Laboratorios> listaLaboratorios = new ArrayList<Laboratorios>();
		ArrayList<Projetores> listaProjetores = new ArrayList<Projetores>();
		ArrayList<Salas> listaSalas = new ArrayList<Salas>();

		num_usuarios = 1;
		num_recursos_alocacao = 10;
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
		locouProfessor = 0;
		locouPesquisador = 0;
		escolhaMenu = 0;

		while (escolhaMenu != 6) {
			System.out.println(
					"\n\n  ----------SISTEMA DE GESTAO----------\n     ----------DE RECURSOS----------\n      ----------(2016.1)----------\n\n");
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
				// login/logout
				int escolhaLogin = 0;
				int escolhaLogout = 0;
				while (escolhaLogin != 5) {
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
								System.err.println(
										"\nEmail e/ou senha incorretos. (Certifique-se de que voce esta cadastrado no Sistema).\n\n");
								break;
							}
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
								System.err.println(
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
								System.err.println(
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
								System.err.println("Email e/ou senha de administrador incorretos");
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
				}
			} else if (escolhaMenu == 2) {
				int escolhaCadastro = 1;
				while (escolhaCadastro != 0) {
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
							System.out.println("Nome do Usuario:");
							usuario.setNome(input.nextLine());

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());

							System.out.println("Email:");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							System.out.println("Tipo de Aluno (graduacao, mestrado ou doutorado)");
							usuario.setTipo(input.nextLine());
							String tipo = usuario.getTipo();

							if (tipo.equals("graduacao") || tipo.equals("mestrado") || tipo.equals("doutorado")) {
								for (Aluno alunos : listaAlunos) {
									if (email.equals(alunos.email) || email.equals("baldoino@ic.ufal.br")) {
										System.err.println(
												"Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
										cadastrado++;
										break;
									}
								}
								for (Professor professores : listaProfessores) {
									if (email.equals(professores.email) || email.equals("baldoino@ic.ufal.br")) {
										System.err.println(
												"Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
										cadastrado++;
										break;
									}
								}
								for (Pesquisador pesquisadores : listaPesquisadores) {
									if (email.equals(pesquisadores.email) || email.equals("baldoino@ic.ufal.br")) {
										System.err.println(
												"Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
										cadastrado++;
										break;
									}
								}

								if (cadastrado == 0) {
									listaAlunos.add(usuario);
									num_usuarios++;

									System.out.println("Aluno(a) cadastrado com sucesso!\n");
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
								System.err.println(
										"Ops! Um erro ocorreu no cadastro, certifique-se que voce digitou todas as informacoes corretamente!\n");
								break;
							}
						}
					} else if (escolhaCadastro == 2) {
						while (escolhaCadastro != 0) {
							scan = new Scanner(System.in);
							Professor usuario = new Professor();

							System.out.println("\n----------CADASTRAMENTO DE PROFESSOR(A)----------\n\n");
							System.out.println("Nome do Usuario:");
							usuario.setNome(input.nextLine());

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());

							System.out.println("Email:");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							for (Aluno alunos : listaAlunos) {
								if (email.equals(alunos.email) || email.equals("baldoino@ic.ufal.br")) {
									System.err.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}
							for (Professor professores : listaProfessores) {
								if (email.equals(professores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.err.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}
							for (Pesquisador pesquisadores : listaPesquisadores) {
								if (email.equals(pesquisadores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.err.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							if (cadastrado == 0) {
								listaProfessores.add(usuario);
								num_usuarios++;

								System.out.println("Professor(a) cadastrado com sucesso!\n");
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
							System.out.println("Nome do Usuario:");
							usuario.setNome(input.nextLine());

							System.out.println("Senha:");
							usuario.setSenha(input.nextLine());

							System.out.println("Email:");
							usuario.setEmail(input.nextLine());
							String email = usuario.getEmail();

							for (Aluno alunos : listaAlunos) {
								if (email.equals(alunos.email) || email.equals("baldoino@ic.ufal.br")) {
									System.err.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}
							for (Professor professores : listaProfessores) {
								if (email.equals(professores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.err.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}
							for (Pesquisador pesquisadores : listaPesquisadores) {
								if (email.equals(pesquisadores.email) || email.equals("baldoino@ic.ufal.br")) {
									System.err.println("Esse e-mail ja esta cadastrado. Cadastre um usuario valido.\n");
									cadastrado++;
									break;
								}
							}

							if (cadastrado == 0) {
								listaPesquisadores.add(usuario);
								num_usuarios++;

								System.out.println("Pesquisador(a) cadastrado com sucesso!\n");
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

				}
			} else if (escolhaMenu == 3) {
				Auditorio auditorio1 = new Auditorio();
				Laboratorios laboratorio = new Laboratorios();
				Projetores projetor = new Projetores();
				Salas sala = new Salas();

				int escolhaLocacao = 0;
				int confirmacaoLocacao = 0;
				int podeAlocar = 1;

				while (escolhaLocacao != 5) {
					for (Professor professores : listaProfessores) {
						if (professores.getEmail().equals(emailUsuario)) {
							if (professores.getAlocou() == null) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("auditorio 1") && statusAuditorio[0] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("laboratorio 1") && statusLaboratorio[0] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("laboratorio 2") && statusLaboratorio[1] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("laboratorio 3") && statusLaboratorio[2] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("projetor 1") && statusProjetor[0] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("projetor 2") && statusProjetor[1] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("projetor 3") && statusProjetor[2] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("sala 1") && statusSala[0] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("sala 2") && statusSala[1] == 3) {
								podeAlocar = 0;
							} else if (professores.getAlocou().equals("sala 3") && statusSala[2] == 3) {
								podeAlocar = 0;
							}
						}
					}

					for (Pesquisador pesquisadores : listaPesquisadores) {
						if (pesquisadores.getEmail().equals(emailUsuario)) {
							if (pesquisadores.getAlocou() == null) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("auditorio 1") && statusAuditorio[0] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("laboratorio 1") && statusLaboratorio[0] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("laboratorio 2") && statusLaboratorio[1] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("laboratorio 3") && statusLaboratorio[2] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("projetor 1") && statusProjetor[0] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("projetor 2") && statusProjetor[1] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("projetor 3") && statusProjetor[2] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("sala 1") && statusSala[0] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("sala 2") && statusSala[1] == 3) {
								podeAlocar = 0;
							} else if (pesquisadores.getAlocou().equals("sala 3") && statusSala[2] == 3) {
								podeAlocar = 0;
							}
						}
					}

					if (podeAlocar == 1 && logouProfessor == 1) {
						System.err.println("Voce ja esta com um Recurso em andamento.");
						break;
					} else if (podeAlocar == 1 && logouPesquisador == 1) {
						System.err.println("Voce ja esta com um Recurso em andamento.");
						break;
					} else if (logouAluno == 0 && logouProfessor == 0 && logouPesquisador == 0
							&& logouAdministrador == 0) {
						System.err.println("Voce nao esta logado no Sistema.\n");
						break;
					} else if (logouAluno == 1) {
						System.err.println("Voce nao tem permissao para locar recursos.\n");
						break;
					} else if (logouProfessor == 1 && locouProfessor == 0 && podeAlocar == 0) {
						while (escolhaLocacao != 5) {
							System.out.println("\n----------LOCACAO DE RECURSOS----------\n\n");
							System.out.println("Bem-vindo, Professor(a), que recurso voce deseja locar?");
							System.out.println("1. Auditorio");
							System.out.println("2. Laboratorio");
							System.out.println("3. Projetor");
							System.out.println("4. Sala");
							System.out.println("5. Voltar ao Menu");
							escolhaLocacao = input.nextInt();
							input.nextLine();

							if (escolhaLocacao == 1) {
								scan = new Scanner(System.in);

								if (statusAuditorio[0] == 0) {
									System.out.println("\n----------LOCACAO DE AUDITORIO----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out.println("Identificacao do Recurso (auditorio 1):");
									auditorio1.setIdentidade(input.nextLine());
									String identidade = auditorio1.getIdentidade();

									if (identidade.equals("auditorio 1")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										auditorio1.setDataInicio(input.nextLine());
										String dataInicio = auditorio1.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											auditorio1.setDataFinal(input.nextLine());
											String dataFinal = auditorio1.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												auditorio1.setHoraInicio(input.nextLine());
												String horaInicial = auditorio1.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													auditorio1.setHoraFinal(input.nextLine());
													String horaFinal = auditorio1.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");

														auditorio1.setResponsavel(emailUsuario);

														statusAuditorio[0] = 1;
														num_recursos_alocacao--;
														num_recursos_alocado++;
														locouProfessor++;
														break;
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusAuditorio[0] != 0) {
									System.err.println("O Auditorio nao esta disponivel.\n");
									break;
								}
							} else if (escolhaLocacao == 2) {
								if (statusLaboratorio[0] == 0 || statusLaboratorio[1] == 0
										|| statusLaboratorio[2] == 0) {
									System.out.println("\n----------LOCACAO DE LABORATORIO----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out.println(
											"Identificacao do Recurso (laboratorio 1, laboratorio 2, laboratorio 3):");

									laboratorio.setIdentidade(input.nextLine());
									String identidade = laboratorio.getIdentidade();

									if (identidade.equals("laboratorio 1") && statusLaboratorio[0] != 0) {
										System.err.println("O laboratorio 1 nao esta disponivel.");
										break;
									} else if (identidade.equals("laboratorio 2") && statusLaboratorio[1] != 0) {
										System.err.println("O laboratorio 2 nao esta disponivel.");
										break;
									} else if (identidade.equals("laboratorio 3") && statusLaboratorio[2] != 0) {
										System.err.println("O laboratorio 3 nao esta disponivel.");
										break;
									}

									if (identidade.equals("laboratorio 1") || identidade.equals("laboratorio 2")
											|| identidade.equals("laboratorio 3")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										laboratorio.setDataInicio(input.nextLine());
										String dataInicio = laboratorio.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											laboratorio.setDataFinal(input.nextLine());
											String dataFinal = laboratorio.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												laboratorio.setHoraInicio(input.nextLine());
												String horaInicial = laboratorio.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													laboratorio.setHoraFinal(input.nextLine());
													String horaFinal = laboratorio.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");
														laboratorio.setResponsavel(emailUsuario);

														if (identidade.equals("laboratorio 1")) {
															statusLaboratorio[0] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														} else if (identidade.equals("laboratorio 2")) {
															statusLaboratorio[1] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														} else if (identidade.equals("laboratorio 3")) {
															statusLaboratorio[2] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														}
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusLaboratorio[0] != 0 && statusLaboratorio[1] != 0
										&& statusLaboratorio[2] != 0) {
									System.err.println("Os laboratorios nao estao disponiveis.\n");
									break;
								}
							} else if (escolhaLocacao == 3) {
								if (statusProjetor[0] == 0 || statusProjetor[1] == 0 || statusProjetor[2] == 0) {
									System.out.println("\n----------LOCACAO DE PROJETOR----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out
											.println("Identificacao do Recurso (projetor 1, projetor 2, projetor 3):");

									projetor.setIdentidade(input.nextLine());
									String identidade = projetor.getIdentidade();

									if (identidade.equals("projetor 1") && statusProjetor[0] != 0) {
										System.err.println("O projetor 1 nao esta disponivel.");
										break;
									} else if (identidade.equals("projetor 2") && statusProjetor[1] != 0) {
										System.err.println("O projetor 2 nao esta disponivel.");
										break;
									} else if (identidade.equals("projetor 3") && statusProjetor[2] != 0) {
										System.err.println("O projetor 3 nao esta disponivel.");
										break;
									}

									if (identidade.equals("projetor 1") || identidade.equals("projetor 2")
											|| identidade.equals("projetor 3")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										projetor.setDataInicio(input.nextLine());
										String dataInicio = projetor.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											projetor.setDataFinal(input.nextLine());
											String dataFinal = projetor.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												projetor.setHoraInicio(input.nextLine());
												String horaInicial = projetor.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													projetor.setHoraFinal(input.nextLine());
													String horaFinal = projetor.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");
														projetor.setResponsavel(emailUsuario);

														if (identidade.equals("projetor 1")) {
															statusProjetor[0] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														} else if (identidade.equals("projetor 2")) {
															statusProjetor[1] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														} else if (identidade.equals("projetor 3")) {
															statusProjetor[2] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														}
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusProjetor[0] != 0 && statusProjetor[1] != 0 && statusProjetor[2] != 0) {
									System.err.println("Os projetores nao estao disponiveis.\n");
									break;
								}
							} else if (escolhaLocacao == 4) {
								if (statusSala[0] == 0 || statusSala[1] == 0 || statusSala[2] == 0) {
									System.out.println("\n----------LOCACAO DE SALA----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out.println("Identificacao do Recurso (sala 1, sala 2, sala 3):");

									sala.setIdentidade(input.nextLine());
									String identidade = sala.getIdentidade();

									if (identidade.equals("sala 1") && statusSala[0] != 0) {
										System.err.println("A sala 1 nao esta disponivel.");
										break;
									} else if (identidade.equals("sala 2") && statusSala[1] != 0) {
										System.err.println("A sala 2 nao esta disponivel.");
										break;
									} else if (identidade.equals("sala 3") && statusSala[2] != 0) {
										System.err.println("A sala 3 nao esta disponivel.");
										break;
									}

									if (identidade.equals("sala 1") || identidade.equals("sala 2")
											|| identidade.equals("sala 3")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										sala.setDataInicio(input.nextLine());
										String dataInicio = sala.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											sala.setDataFinal(input.nextLine());
											String dataFinal = sala.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												sala.setHoraInicio(input.nextLine());
												String horaInicial = sala.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													sala.setHoraFinal(input.nextLine());
													String horaFinal = sala.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");
														sala.setResponsavel(emailUsuario);

														if (identidade.equals("sala 1")) {
															statusSala[0] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														} else if (identidade.equals("sala 2")) {
															statusSala[1] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														} else if (identidade.equals("sala 3")) {
															statusSala[2] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouProfessor++;
															break;
														}
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusSala[0] != 0 && statusSala[1] != 0 && statusSala[2] != 0) {
									System.err.println("As salas nao estao disponiveis.\n");
									break;
								}
							} else if (escolhaLocacao == 5) {
								break;
							}
						}
					} else if (logouPesquisador == 1 && locouPesquisador == 0 && podeAlocar == 0) {
						while (escolhaLocacao != 5) {
							System.out.println("\n----------LOCACAO DE RECURSOS----------\n\n");
							System.out.println("Bem-vindo, Pesquisador(a), que recurso voce deseja locar?");
							System.out.println("1. Auditorio");
							System.out.println("2. Laboratorio");
							System.out.println("3. Projetor");
							System.out.println("4. Sala");
							System.out.println("5. Voltar ao Menu");
							escolhaLocacao = input.nextInt();
							input.nextLine();

							if (escolhaLocacao == 1) {
								scan = new Scanner(System.in);

								if (statusAuditorio[0] == 0) {
									System.out.println("\n----------LOCACAO DE AUDITORIO----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out.println("Identificacao do Recurso (auditorio 1):");
									auditorio1.setIdentidade(input.nextLine());
									String identidade = auditorio1.getIdentidade();

									if (identidade.equals("auditorio 1")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										auditorio1.setDataInicio(input.nextLine());
										String dataInicio = auditorio1.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											auditorio1.setDataFinal(input.nextLine());
											String dataFinal = auditorio1.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												auditorio1.setHoraInicio(input.nextLine());
												String horaInicial = auditorio1.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													auditorio1.setHoraFinal(input.nextLine());
													String horaFinal = auditorio1.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");

														auditorio1.setResponsavel(emailUsuario);

														statusAuditorio[0] = 1;
														num_recursos_alocacao--;
														num_recursos_alocado++;
														locouPesquisador++;
														break;
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusAuditorio[0] != 0) {
									System.err.println("O Auditorio nao esta disponivel.\n");
									break;
								}
							} else if (escolhaLocacao == 2) {
								if (statusLaboratorio[0] == 0 || statusLaboratorio[1] == 0
										|| statusLaboratorio[2] == 0) {
									System.out.println("\n----------LOCACAO DE LABORATORIO----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out.println(
											"Identificacao do Recurso (laboratorio 1, laboratorio 2, laboratorio 3):");

									laboratorio.setIdentidade(input.nextLine());
									String identidade = laboratorio.getIdentidade();

									if (identidade.equals("laboratorio 1") && statusLaboratorio[0] != 0) {
										System.err.println("O laboratorio 1 nao esta disponivel.");
										break;
									} else if (identidade.equals("laboratorio 2") && statusLaboratorio[1] != 0) {
										System.err.println("O laboratorio 2 nao esta disponivel.");
										break;
									} else if (identidade.equals("laboratorio 3") && statusLaboratorio[2] != 0) {
										System.err.println("O laboratorio 3 nao esta disponivel.");
										break;
									}

									if (identidade.equals("laboratorio 1") || identidade.equals("laboratorio 2")
											|| identidade.equals("laboratorio 3")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										laboratorio.setDataInicio(input.nextLine());
										String dataInicio = laboratorio.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											laboratorio.setDataFinal(input.nextLine());
											String dataFinal = laboratorio.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												laboratorio.setHoraInicio(input.nextLine());
												String horaInicial = laboratorio.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													laboratorio.setHoraFinal(input.nextLine());
													String horaFinal = laboratorio.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");
														laboratorio.setResponsavel(emailUsuario);

														if (identidade.equals("laboratorio 1")) {
															statusLaboratorio[0] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														} else if (identidade.equals("laboratorio 2")) {
															statusLaboratorio[1] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														} else if (identidade.equals("laboratorio 3")) {
															statusLaboratorio[2] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														}
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusLaboratorio[0] != 0 && statusLaboratorio[1] != 0
										&& statusLaboratorio[2] != 0) {
									System.err.println("Os laboratorios nao estao disponiveis.\n");
									break;
								}
							} else if (escolhaLocacao == 3) {
								if (statusProjetor[0] == 0 || statusProjetor[1] == 0 || statusProjetor[2] == 0) {
									System.out.println("\n----------LOCACAO DE PROJETOR----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out
											.println("Identificacao do Recurso (projetor 1, projetor 2, projetor 3):");

									projetor.setIdentidade(input.nextLine());
									String identidade = projetor.getIdentidade();

									if (identidade.equals("projetor 1") && statusProjetor[0] != 0) {
										System.err.println("O projetor 1 nao esta disponivel.");
										break;
									} else if (identidade.equals("projetor 2") && statusProjetor[1] != 0) {
										System.err.println("O projetor 2 nao esta disponivel.");
										break;
									} else if (identidade.equals("projetor 3") && statusProjetor[2] != 0) {
										System.err.println("O projetor 3 nao esta disponivel.");
										break;
									}

									if (identidade.equals("projetor 1") || identidade.equals("projetor 2")
											|| identidade.equals("projetor 3")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										projetor.setDataInicio(input.nextLine());
										String dataInicio = projetor.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											projetor.setDataFinal(input.nextLine());
											String dataFinal = projetor.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												projetor.setHoraInicio(input.nextLine());
												String horaInicial = projetor.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													projetor.setHoraFinal(input.nextLine());
													String horaFinal = projetor.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");
														projetor.setResponsavel(emailUsuario);

														if (identidade.equals("projetor 1")) {
															statusProjetor[0] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														} else if (identidade.equals("projetor 2")) {
															statusProjetor[1] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														} else if (identidade.equals("projetor 3")) {
															statusProjetor[2] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														}
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusProjetor[0] != 0 && statusProjetor[1] != 0 && statusProjetor[2] != 0) {
									System.err.println("Os projetores nao estao disponiveis.\n");
									break;
								}
							} else if (escolhaLocacao == 4) {
								if (statusSala[0] == 0 || statusSala[1] == 0 || statusSala[2] == 0) {
									System.out.println("\n----------LOCACAO DE SALA----------\n\n");
									System.out.println("Informacoes basicas\n");
									System.out.println("Identificacao do Recurso (sala 1, sala 2, sala 3):");

									sala.setIdentidade(input.nextLine());
									String identidade = sala.getIdentidade();

									if (identidade.equals("sala 1") && statusSala[0] != 0) {
										System.err.println("A sala 1 nao esta disponivel.");
										break;
									} else if (identidade.equals("sala 2") && statusSala[1] != 0) {
										System.err.println("A sala 2 nao esta disponivel.");
										break;
									} else if (identidade.equals("sala 3") && statusSala[2] != 0) {
										System.err.println("A sala 3 nao esta disponivel.");
										break;
									}

									if (identidade.equals("sala 1") || identidade.equals("sala 2")
											|| identidade.equals("sala 3")) {
										// verificar se a data eh valida
										System.out.println("Data de Inicio da Atividade (dd/mm/aaaa):");
										sala.setDataInicio(input.nextLine());
										String dataInicio = sala.getDataInicio();

										if (verificacaoData(dataInicio) == true) {
											// verificar se a data eh valida
											System.out.println("Data de Termino da Atividade (dd/mm/aaaa):");
											sala.setDataFinal(input.nextLine());
											String dataFinal = sala.getDataFinal();

											if (verificacaoData(dataFinal) == true) {
												// verificar se a hora eh valida
												System.out.println("Horario de Inicio (HH:mm):");
												sala.setHoraInicio(input.nextLine());
												String horaInicial = sala.getHoraInicio();

												if (verificacaoHora(horaInicial) == true) {
													// verificar se a hora eh
													// valida
													System.out.println("Horario de Termino(HH:mm):");
													sala.setHoraFinal(input.nextLine());
													String horaFinal = sala.getHoraFinal();

													if (verificacaoHora(horaFinal) == true) {
														System.out.println(
																"\nStatus: de 'Em processo de alocacao' para 'alocado'");
														sala.setResponsavel(emailUsuario);

														if (identidade.equals("sala 1")) {
															statusSala[0] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														} else if (identidade.equals("sala 2")) {
															statusSala[1] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														} else if (identidade.equals("sala 3")) {
															statusSala[2] = 1;
															num_recursos_alocacao--;
															num_recursos_alocado++;
															locouPesquisador++;
															break;
														}
													}
												}
											}
										}
									} else {
										System.err.println("Titulo da Atividade invalido. Tente novamente");
										break;
									}
								} else if (statusSala[0] != 0 && statusSala[1] != 0 && statusSala[2] != 0) {
									System.err.println("As salas nao estao disponiveis.\n");
									break;
								}
							} else if (escolhaLocacao == 5) {
								break;
							}
						}
					} else if (logouAdministrador == 1 && podeAlocar == 1) {
						int escolhaAdministrador;
						if (statusAuditorio[0] != 0) {
							System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
							System.out
									.println("Deseja alterar o Status de alocacao do 'auditorio 1' para 'concluido'?");
							System.out.println("1. Sim");
							System.out.println("2. Nao");
							escolhaAdministrador = input.nextInt();
							input.nextLine();

							if (escolhaAdministrador == 1) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println("Status: 'concluido'");
								num_recursos_alocado--;
								num_recursos_concluido++;
								statusAuditorio[0] = 3;
								break;
							} else if (escolhaAdministrador == 2) {
								break;
							}
						} else if (statusLaboratorio[0] != 0 || statusLaboratorio[1] != 0
								|| statusLaboratorio[2] != 0) {
							if (statusLaboratorio[0] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println(
										"Deseja alterar o Status de alocacao do 'laboratorio 1' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusLaboratorio[0] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							} else if (statusLaboratorio[1] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println(
										"Deseja alterar o Status de alocacao do 'laboratorio 2' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusLaboratorio[1] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							} else if (statusLaboratorio[2] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println(
										"Deseja alterar o Status de alocacao do 'laboratorio 3' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusLaboratorio[2] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							}
						} else if (statusProjetor[0] != 0 || statusProjetor[1] != 0 || statusProjetor[2] != 0) {
							if (statusProjetor[0] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println(
										"Deseja alterar o Status de alocacao do 'projetor 1' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusProjetor[0] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							} else if (statusProjetor[1] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println(
										"Deseja alterar o Status de alocacao do 'projetor 2' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusProjetor[1] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							} else if (statusProjetor[2] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println(
										"Deseja alterar o Status de alocacao do 'projetor 3' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusProjetor[2] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							}
						} else if (statusSala[0] != 0 || statusSala[1] != 0 || statusSala[2] != 0) {
							if (statusSala[0] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println("Deseja alterar o Status de alocacao da 'sala 1' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusSala[0] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							} else if (statusSala[1] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println("Deseja alterar o Status de alocacao da 'sala 2' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusSala[1] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							} else if (statusSala[2] == 2) {
								System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
								System.out.println("Deseja alterar o Status de alocacao da 'sala 3' para 'concluido'?");
								System.out.println("1. Sim");
								System.out.println("2. Nao");
								escolhaAdministrador = input.nextInt();
								input.nextLine();

								if (escolhaAdministrador == 1) {
									System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
									System.out.println("Status: 'concluido'");
									num_recursos_alocado--;
									num_recursos_concluido++;
									statusSala[2] = 3;
									break;
								} else if (escolhaAdministrador == 2) {
									break;
								}
							}
						} else {
							System.out.println("\n----------VERIFICACAO DA LOCACAO DE RECURSOS----------\n\n");
							System.err.println("Nao ha recursos para serem confirmados.");
							break;
						}
					} else if (logouProfessor == 1 && locouProfessor == 1) {
						if (statusAuditorio[0] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE AUDITORIO----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");
								auditorio1.setTitulo(input.nextLine());
								String titulo = auditorio1.getTitulo();

								if (titulo.equals("aula tradicional") || titulo.equals("apresentacoes")
										|| titulo.equals("laboratorio")) {

									for (Professor professores : listaProfessores) {
										if (emailUsuario.equals(professores.email)) {
											professores.setAlocou("auditorio 1");
											professores.setAtividade(auditorio1.getTitulo());
											break;
										}
									}
									System.out.println("Descricao da Atividade:");
									auditorio1.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									auditorio1.setMaterial(input.nextLine());

									listaAuditorio.add(auditorio1);

									for (Auditorio recursos : listaAuditorio) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao do auditorio?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println(
												"\n----------CONFIRMACAO DE LOCACAO DE AUDITORIO----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Auditorio Confirmado.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");
										statusAuditorio[0] = 2;
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouProfessor--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						} else if (statusLaboratorio[0] == 1 || statusLaboratorio[1] == 1
								|| statusLaboratorio[2] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE LABORATORIO----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");

								laboratorio.setTitulo(input.nextLine());
								String titulo = laboratorio.getTitulo();

								if (titulo.equals("aula tradicional") || titulo.equals("apresentacoes")
										|| titulo.equals("laboratorio")) {

									for (Professor professores : listaProfessores) {
										if (emailUsuario.equals(professores.email)) {
											if (laboratorio.getIdentidade().equals("laboratorio 1")) {
												professores.setAlocou("laboratorio 1");
												professores.setAtividade(laboratorio.getTitulo());
												break;
											} else if (laboratorio.getIdentidade().equals("laboratorio 2")) {
												professores.setAlocou("laboratorio 2");
												professores.setAtividade(laboratorio.getTitulo());
												break;
											} else if (laboratorio.getIdentidade().equals("laboratorio 3")) {
												professores.setAlocou("laboratorio 3");
												professores.setAtividade(laboratorio.getTitulo());
												break;
											}
										}
									}
									System.out.println("Descricao da Atividade:");
									laboratorio.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									laboratorio.setMaterial(input.nextLine());

									listaLaboratorios.add(laboratorio);

									for (Laboratorios recursos : listaLaboratorios) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao do laboratorio?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println(
												"\n----------CONFIRMACAO DE LOCACAO DE LABORATORIO----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Laboratorio Confirmado.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");

										if (laboratorio.getIdentidade().equals("laboratorio 1")) {
											statusLaboratorio[0] = 2;
										} else if (laboratorio.getIdentidade().equals("laboratorio 2")) {
											statusLaboratorio[1] = 2;
										} else if (laboratorio.getIdentidade().equals("laboratorio 3")) {
											statusLaboratorio[2] = 2;
										}
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouProfessor--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						} else if (statusProjetor[0] == 1 || statusProjetor[1] == 1 || statusProjetor[2] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE PROJETOR----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");

								projetor.setTitulo(input.nextLine());
								String titulo1 = projetor.getTitulo();

								if (titulo1.equals("aula tradicional") || titulo1.equals("apresentacoes")
										|| titulo1.equals("laboratorio")) {

									for (Professor professores : listaProfessores) {
										if (emailUsuario.equals(professores.email)) {
											if (projetor.getIdentidade().equals("projetor 1")) {
												professores.setAlocou("projetor 1");
												professores.setAtividade(projetor.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("projetor 2")) {
												professores.setAlocou("projetor 2");
												professores.setAtividade(projetor.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("projetor 3")) {
												professores.setAlocou("projetor 3");
												professores.setAtividade(projetor.getTitulo());
												break;
											}
										}
									}
									System.out.println("Descricao da Atividade:");
									projetor.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									projetor.setMaterial(input.nextLine());

									listaProjetores.add(projetor);

									for (Projetores recursos : listaProjetores) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao do projetor?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo1.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo1.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo1.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println(
												"\n----------CONFIRMACAO DE LOCACAO DE PROJETOR----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Projetor Confirmado.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");

										if (projetor.getIdentidade().equals("projetor 1")) {
											statusProjetor[0] = 2;
										} else if (projetor.getIdentidade().equals("projetor 2")) {
											statusProjetor[1] = 2;
										} else if (projetor.getIdentidade().equals("projetor 3")) {
											statusProjetor[2] = 2;
										}
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouProfessor--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						} else if (statusSala[0] == 1 || statusSala[1] == 1 || statusSala[2] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE SALA----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");

								sala.setTitulo(input.nextLine());
								String titulo1 = sala.getTitulo();

								if (titulo1.equals("aula tradicional") || titulo1.equals("apresentacoes")
										|| titulo1.equals("laboratorio")) {

									for (Professor professores : listaProfessores) {
										if (emailUsuario.equals(professores.email)) {
											if (projetor.getIdentidade().equals("sala 1")) {
												professores.setAlocou("sala 1");
												professores.setAtividade(sala.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("sala 2")) {
												professores.setAlocou("sala 2");
												professores.setAtividade(sala.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("sala 3")) {
												professores.setAlocou("sala 3");
												professores.setAtividade(sala.getTitulo());
												break;
											}
										}
									}
									System.out.println("Descricao da Atividade:");
									sala.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									sala.setMaterial(input.nextLine());

									listaSalas.add(sala);

									for (Salas recursos : listaSalas) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao da sala?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo1.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo1.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo1.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println("\n----------CONFIRMACAO DE LOCACAO DE SALA----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Sala Confirmada.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");

										if (sala.getIdentidade().equals("sala 1")) {
											statusSala[0] = 2;
										} else if (sala.getIdentidade().equals("sala 2")) {
											statusSala[1] = 2;
										} else if (sala.getIdentidade().equals("sala 3")) {
											statusSala[2] = 2;
										}
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouProfessor--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						}
					} else if (logouPesquisador == 1 && locouPesquisador == 1) {
						if (statusAuditorio[0] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE AUDITORIO----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");
								auditorio1.setTitulo(input.nextLine());
								String titulo = auditorio1.getTitulo();

								if (titulo.equals("aula tradicional") || titulo.equals("apresentacoes")
										|| titulo.equals("laboratorio")) {

									for (Pesquisador pesquisadores : listaPesquisadores) {
										if (emailUsuario.equals(pesquisadores.email)) {
											pesquisadores.setAlocou("auditorio 1");
											pesquisadores.setAtividade(auditorio1.getTitulo());
											break;
										}
									}
									System.out.println("Descricao da Atividade:");
									auditorio1.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									auditorio1.setMaterial(input.nextLine());

									listaAuditorio.add(auditorio1);

									for (Auditorio recursos : listaAuditorio) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao do auditorio?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println(
												"\n----------CONFIRMACAO DE LOCACAO DE AUDITORIO----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Auditorio Confirmado.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");
										statusAuditorio[0] = 2;
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouPesquisador--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						} else if (statusLaboratorio[0] == 1 || statusLaboratorio[1] == 1
								|| statusLaboratorio[2] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE LABORATORIO----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");

								laboratorio.setTitulo(input.nextLine());
								String titulo = laboratorio.getTitulo();

								if (titulo.equals("aula tradicional") || titulo.equals("apresentacoes")
										|| titulo.equals("laboratorio")) {

									for (Pesquisador pesquisadores : listaPesquisadores) {
										if (emailUsuario.equals(pesquisadores.email)) {
											if (laboratorio.getIdentidade().equals("laboratorio 1")) {
												pesquisadores.setAlocou("laboratorio 1");
												pesquisadores.setAtividade(laboratorio.getTitulo());
												break;
											} else if (laboratorio.getIdentidade().equals("laboratorio 2")) {
												pesquisadores.setAlocou("laboratorio 2");
												pesquisadores.setAtividade(laboratorio.getTitulo());
												break;
											} else if (laboratorio.getIdentidade().equals("laboratorio 3")) {
												pesquisadores.setAlocou("laboratorio 3");
												pesquisadores.setAtividade(laboratorio.getTitulo());
												break;
											}
										}
									}
									System.out.println("Descricao da Atividade:");
									laboratorio.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									laboratorio.setMaterial(input.nextLine());

									listaLaboratorios.add(laboratorio);

									for (Laboratorios recursos : listaLaboratorios) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao do laboratorio?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println(
												"\n----------CONFIRMACAO DE LOCACAO DE LABORATORIO----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Laboratorio Confirmado.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");

										if (laboratorio.getIdentidade().equals("laboratorio 1")) {
											statusLaboratorio[0] = 2;
										} else if (laboratorio.getIdentidade().equals("laboratorio 2")) {
											statusLaboratorio[1] = 2;
										} else if (laboratorio.getIdentidade().equals("laboratorio 3")) {
											statusLaboratorio[2] = 2;
										}
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouPesquisador--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						} else if (statusProjetor[0] == 1 || statusProjetor[1] == 1 || statusProjetor[2] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE PROJETOR----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");

								projetor.setTitulo(input.nextLine());
								String titulo1 = projetor.getTitulo();

								if (titulo1.equals("aula tradicional") || titulo1.equals("apresentacoes")
										|| titulo1.equals("laboratorio")) {

									for (Pesquisador pesquisadores : listaPesquisadores) {
										if (emailUsuario.equals(pesquisadores.email)) {
											if (projetor.getIdentidade().equals("projetor 1")) {
												pesquisadores.setAlocou("projetor 1");
												pesquisadores.setAtividade(projetor.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("projetor 2")) {
												pesquisadores.setAlocou("projetor 2");
												pesquisadores.setAtividade(projetor.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("projetor 3")) {
												pesquisadores.setAlocou("projetor 3");
												pesquisadores.setAtividade(projetor.getTitulo());
												break;
											}
										}
									}
									System.out.println("Descricao da Atividade:");
									projetor.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									projetor.setMaterial(input.nextLine());

									listaProjetores.add(projetor);

									for (Projetores recursos : listaProjetores) {
										System.out.println("\nIdentificacao: " + recursos.getIdentidade());
										System.out.println("\nTitulo: " + recursos.getTitulo());
										System.out.println("\nDescricao: " + recursos.getDescricao());
										System.out.println("\nMaterial: " + recursos.getMaterial());
										System.out.println("\nData de Inicio: " + recursos.getDataInicio());
										System.out.println("\nData de Termino: " + recursos.getDataFinal());
										System.out.println("\nHora de Inicio: " + recursos.getHoraInicio());
										System.out.println("\nHora de Final: " + recursos.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao do projetor?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo1.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo1.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo1.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println(
												"\n----------CONFIRMACAO DE LOCACAO DE PROJETOR----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Projetor Confirmado.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");

										if (projetor.getIdentidade().equals("projetor 1")) {
											statusProjetor[0] = 2;
										} else if (projetor.getIdentidade().equals("projetor 2")) {
											statusProjetor[1] = 2;
										} else if (projetor.getIdentidade().equals("projetor 3")) {
											statusProjetor[2] = 2;
										}
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouPesquisador--;
										escolhaLocacao = 5;
										break;
									}

								}
							}
						} else if (statusSala[0] == 1 || statusSala[1] == 1 || statusSala[2] == 1) {
							while (confirmacaoLocacao != 2) {
								System.out.println("\n----------CONFIRMACAO DE LOCACAO DE SALA----------\n\n");
								System.out.println(
										"Titulo da Atividade (aula tradicional, apresentacoes ou laboratorio):");

								sala.setTitulo(input.nextLine());
								String titulo1 = sala.getTitulo();

								if (titulo1.equals("aula tradicional") || titulo1.equals("apresentacoes")
										|| titulo1.equals("laboratorio")) {

									for (Pesquisador pesquisadores : listaPesquisadores) {
										if (emailUsuario.equals(pesquisadores.email)) {
											if (projetor.getIdentidade().equals("sala 1")) {
												pesquisadores.setAlocou("sala 1");
												pesquisadores.setAtividade(sala.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("sala 2")) {
												pesquisadores.setAlocou("sala 2");
												pesquisadores.setAtividade(sala.getTitulo());
												break;
											} else if (projetor.getIdentidade().equals("sala 3")) {
												pesquisadores.setAlocou("sala 3");
												pesquisadores.setAtividade(sala.getTitulo());
												break;
											}
										}
									}
									System.out.println("Descricao da Atividade:");
									sala.setDescricao(input.nextLine());

									System.out.println("Material Utilizado na Atividade:");
									sala.setMaterial(input.nextLine());

									listaSalas.add(sala);

									for (Salas top : listaSalas) {
										System.out.println("\nIdentificacao: " + top.getIdentidade());
										System.out.println("\nTitulo: " + top.getTitulo());
										System.out.println("\nDescricao: " + top.getDescricao());
										System.out.println("\nMaterial: " + top.getMaterial());
										System.out.println("\nData de Inicio: " + top.getDataInicio());
										System.out.println("\nData de Termino: " + top.getDataFinal());
										System.out.println("\nHora de Inicio: " + top.getHoraInicio());
										System.out.println("\nHora de Final: " + top.getHoraFinal());
									}
									System.out.println("\nDeseja confimar a locacao da sala?");
									System.out.println("1. Sim");
									System.out.println("2. Nao");

									if (titulo1.equals("aula tradicional")) {
										num_aula_tradicional++;
									} else if (titulo1.equals("apresentacoes")) {
										num_apresentacao++;
									} else if (titulo1.equals("laboratorio")) {
										num_laboratorio++;
									}

									confirmacaoLocacao = input.nextInt();
									input.nextLine();

									if (confirmacaoLocacao == 1) {
										System.out.println("\n----------CONFIRMACAO DE LOCACAO DE SALA----------\n\n");
										System.out.println("\nStatus: de 'alocado' para 'em andamento'");
										System.out.println("Sala Confirmada.");
										System.out.println(
												"O Status so constara como 'concluido' com a permissao do Administrador do Sistema.");

										if (sala.getIdentidade().equals("sala 1")) {
											statusSala[0] = 2;
										} else if (sala.getIdentidade().equals("sala 2")) {
											statusSala[1] = 2;
										} else if (sala.getIdentidade().equals("sala 3")) {
											statusSala[2] = 2;
										}
										num_recursos_alocado--;
										num_recursos_andamento++;
										locouPesquisador--;
										escolhaLocacao = 5;
										break;
									}
								}
							}
						}
					}
				} 
			} else if (escolhaMenu == 4) {
				int escolhaConsulta = 0;

				while (escolhaConsulta != 3) {
					System.out.println("\n----------CONSULTA----------\n\n");
					System.out.println("Escolha o Tipo de Consulta:");
					System.out.println("1. Por Usuario");
					System.out.println("2. Por Recurso");
					System.out.println("3. Voltar ao Menu");
					escolhaConsulta = input.nextInt();
					input.nextLine();

					if (escolhaConsulta == 1) {
						int escolhaConsulta1 = 0;
						while (escolhaConsulta != 5) {
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
									System.err.println("\nNao existe cadastro de alunos no Sistema.\n");
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
											System.err.println("\nNao existe cadastro de aluno com tal e-mail.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 2) {
								scan = new Scanner(System.in);
								Professor usuario = new Professor();

								if (listaProfessores.size() == 0) {
									System.err.println("\nNao existe cadastro de professores no Sistema.\n");
								} else {
									System.out.println("\n----------CONSULTA POR PROFESSOR(A)----------\n\n");
									System.out.println(
											"Digite o Email do(a) professor(a) para obter informacoes sobre ele(a):");

									usuario.setEmail(input.nextLine());
									String email = usuario.getEmail();

									for (Professor usuarios : listaProfessores) {
										if (email.equals(usuarios.getEmail())) {
											if (locouProfessor == 1) {
												System.out.println("\nNome:  " + usuarios.getNome());
												System.out.println("E-mail:  " + usuarios.getEmail());
												System.out.println("Recurso Alocado:  " + usuarios.getAlocou());
												System.out.println("Atividade Realizada:  " + usuarios.getAtividade());
											} else {
												System.out.println("\nNome:  " + usuarios.getNome());
												System.out.println("E-mail:  " + usuarios.getEmail());
											}
										} else {
											System.err.println("\nNao existe cadastro de professor com tal e-mail.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 3) {
								scan = new Scanner(System.in);
								Pesquisador usuario = new Pesquisador();
								if (listaPesquisadores.size() == 0) {
									System.err.println("\nNao existe cadastro de pesquisadores no Sistema.\n");
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
											System.err
													.println("\nNao existe cadastro de pesquisador com tal e-mail.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 4) {
								System.out.println("\nNome:  Baldoino Fonseca");
								System.out.println("\nE-mail:  baldoino@ic.ufal.br");
							} else if (escolhaConsulta1 == 5) {
								escolhaConsulta = 3;
								break;
							}
						}
					} else if (escolhaConsulta == 2) {
						int escolhaConsulta1 = 0;
						do {
							System.out.println("\n----------CONSULTA POR RECURSO----------\n\n");
							System.out.println("Escolha o Tipo de Recurso:");
							System.out.println("1. Auditorio");
							System.out.println("2. Laboratorios");
							System.out.println("3. Projetores");
							System.out.println("4. Salas");
							System.out.println("5. Voltar ao Menu");
							escolhaConsulta1 = input.nextInt();
							input.nextLine();

							if (escolhaConsulta1 == 1) {
								Auditorio auditorio = new Auditorio();

								if (listaAuditorio.size() == 0) {
									System.err.println("\nNenhuma atividade foi realizada no Auditorio.\n");
								} else {
									System.out.println("\n----------CONSULTA POR AUDITORIO----------\n\n");
									System.out.println("digite a identificacao do recurso (auditorio 1):");
									auditorio.setIdentidade(input.nextLine());
									String identificacao = auditorio.getIdentidade();

									for (Auditorio usuarios : listaAuditorio) {
										if (identificacao.equals(usuarios.getIdentidade())) {
											System.out.println("Nome do responsavel:  " + usuarios.getResponsavel());
											System.out.println("Recurso:  " + usuarios.getIdentidade());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Descricao da atividade:  " + usuarios.getDescricao());
											System.out.println("Material utilizado:  " + usuarios.getMaterial());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Data de inicio:  " + usuarios.getDataInicio());
											System.out.println("Data de termino:  " + usuarios.getDataFinal());
											System.out.println("Horario de inicio:  " + usuarios.getHoraInicio());
											System.out.println("Horario de termino:  " + usuarios.getHoraFinal());
										} else {
											System.err.println(
													"\nNao existe cadastro de recurso com tal identificacao.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 2) {
								Laboratorios lab = new Laboratorios();

								if (listaLaboratorios.size() == 0) {
									System.err.println("\nNenhuma atividade foi realizada nos Laboratorios.\n");
								} else {
									System.out.println("\n----------CONSULTA POR LABORATORIO----------\n\n");
									System.out.println(
											"digite a identificacao do recurso (laboratorio 1, laboratorio 2 ou laboratorio 3):");

									lab.setIdentidade(input.nextLine());
									String identificacao = lab.getIdentidade();

									for (Laboratorios usuarios : listaLaboratorios) {
										if (identificacao.equals(usuarios.getIdentidade())) {
											System.out.println("Nome do responsavel:  " + usuarios.getResponsavel());
											System.out.println("Recurso:  " + usuarios.getIdentidade());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Descricao da atividade:  " + usuarios.getDescricao());
											System.out.println("Material utilizado:  " + usuarios.getMaterial());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Data de inicio:  " + usuarios.getDataInicio());
											System.out.println("Data de termino:  " + usuarios.getDataFinal());
											System.out.println("Horario de inicio:  " + usuarios.getHoraInicio());
											System.out.println("Horario de termino:  " + usuarios.getHoraFinal());
										} else {
											System.err.println(
													"\nNao existe cadastro de recurso com tal identificacao.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 3) {
								Projetores proj = new Projetores();

								if (listaProjetores.size() == 0) {
									System.err.println("\nNenhuma atividade foi realizada com os Projetores.\n");
								} else {
									System.out.println("\n----------CONSULTA POR PROJETOR----------\n\n");
									System.out.println(
											"digite a identificacao do recurso (projetor 1, projetor 2 ou projetor 3):");

									proj.setIdentidade(input.nextLine());
									String identificacao = proj.getIdentidade();

									for (Projetores usuarios : listaProjetores) {
										if (identificacao.equals(usuarios.getIdentidade())) {
											System.out.println("Nome do responsavel:  " + usuarios.getResponsavel());
											System.out.println("Recurso:  " + usuarios.getIdentidade());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Descricao da atividade:  " + usuarios.getDescricao());
											System.out.println("Material utilizado:  " + usuarios.getMaterial());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Data de inicio:  " + usuarios.getDataInicio());
											System.out.println("Data de termino:  " + usuarios.getDataFinal());
											System.out.println("Horario de inicio:  " + usuarios.getHoraInicio());
											System.out.println("Horario de termino:  " + usuarios.getHoraFinal());
										} else {
											System.err.println(
													"\nNao existe cadastro de recurso com tal identificacao.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 4) {
								Salas salas = new Salas();

								if (listaSalas.size() == 0) {
									System.err.println("\nNenhuma atividade foi realizada nas Salas.\n");
								} else {
									System.out.println("\n----------CONSULTA POR SALAS----------\n\n");
									System.out
											.println("digite a identificacao do recurso (sala 1, sala 2 ou sala 3): ");

									salas.setIdentidade(input.nextLine());
									String identificacao = salas.getIdentidade();

									for (Salas usuarios : listaSalas) {
										if (identificacao.equals(usuarios.getIdentidade())) {
											System.out.println("Nome do responsavel:  " + usuarios.getResponsavel());
											System.out.println("Recurso:  " + usuarios.getIdentidade());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Descricao da atividade:  " + usuarios.getDescricao());
											System.out.println("Material utilizado:  " + usuarios.getMaterial());
											System.out.println("Atividade realizada:  " + usuarios.getTitulo());
											System.out.println("Data de inicio:  " + usuarios.getDataInicio());
											System.out.println("Data de termino:  " + usuarios.getDataFinal());
											System.out.println("Horario de inicio:  " + usuarios.getHoraInicio());
											System.out.println("Horario de termino:  " + usuarios.getHoraFinal());
										} else {
											System.err.println(
													"\nNao existe cadastro de recurso com tal identificacao.\n");
										}
									}
								}
							} else if (escolhaConsulta1 == 5) {
								escolhaConsulta = 3;
								break;
							}
						} while (escolhaConsulta != 5);
					}
				}
			} else if (escolhaMenu == 5) {
				num_alocacoes = num_recursos_alocado + num_recursos_andamento + num_recursos_concluido;
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
			}
		}
	}
}