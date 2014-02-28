package ifrn.poo.projetoLembretes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;


public class GerenciadorDeNotas {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GerenciadorDeUsuarios gu = new GerenciadorDeUsuarios();
		String op, entradaL, entradaS;
		Usuario user, novoUsuario;
		Notas tarefa= null, lembrete = null;
		Calendar calendario = Calendar.getInstance();
		int numLog = 0;
		boolean status = false;
		
		
		
		while(true){
			System.out.println("BEM VINDO AO GERENCIADOR DE NOTAS!");
			System.out.println("Digite '1' para realizar login, ou digite '2' para realizar cadastro:");
			op = sc.next();
			
			
			switch (op) {
			case "1":
				if(!gu.isEmpty()){

					System.out.println("LOGIN:\nDigite o seu login:");
					entradaL = sc.next();
					if (entradaL.equals('n')){
						break;
					}
					System.out.println("Digite a sua senha:");
					entradaS = sc.next();
					user = gu.autenticar(entradaL, entradaS);
					if (user == null){
						status = false;
					}else{
					status = true;
					}
					/////// PÁGINA INICIAL
					while(status){
						System.out.println("Olá "+user.getLogin()+"!\nEsses são todos os seus lembretes:");
						//Imprimir lembretes
						user.imprimeTodasNotas(user);
						System.out.println("Digite o número do lembrete que deseja visualizar. Ou digite 'menu' para acessar outras funções:");
						op = sc.next();
						if (!op.equals("menu")){
							int op2 = Integer.parseInt(op);
							// Tratar erro em caso de entrada errada (diferente de numeros).
							System.out.println("Imprimiu lembrete.");
						}else{
							System.out.println("---------------------------\nMENU:\nDigite o numero da operação que deseja realizar:\n 1 - Insetir lembrete;\n 2 - Pesquisar por dia;\n 3 - Pesquisar por mês;\n 4 - Pesquisar por TAG;\n 5 - Deletar usuário;\n 6 - Fazer logout.");
							op = sc.next();
							switch (op) {
							case "1":
								System.out.println("Este lembrete possui data de expiração?\n(Digite '1' se houver ou '2' se não houver)");
								int op2 = sc.nextInt();
								if (op2 == 1) {
									System.out.println("Digite o título da tarefa: ");
									String titulo = sc.next(); // Dá erro no Scanner quando uso espaço.
									System.out.println("Digite o data de expiração dessa tarefa (em número): ");
									System.out.print("Dia: ");
									int dia = sc.nextInt();
									System.out.print("Mês: ");
									int mes = sc.nextInt();
									System.out.print("Ano: ");
									int ano = sc.nextInt();
									calendario.set(ano, (mes - 1), dia); // (mes-1) pq o metodo set recebe os meses de 0 a 11 (jan .. dez)
									Date expData = calendario.getTime();
									System.out.println("Digite a descrição dessa tarefa (Ou digite 'n' caso não haja descrição): ");
									String descricao = sc.next();
									System.out.println("Digite um local para essa tarefa (Ou digite 'n' caso não haja local): ");
									String local = sc.next();
									System.out.println("Digite ums tag para essa tarefa: ");
									String tag = sc.next();

									if (!descricao.equals("n") && !local.equals("n")) {
										tarefa = new Tarefas(titulo, expData, tag, descricao, local);
										System.out.println("titulo, expData, tag, descricao, local"); // Para testar os ifs
									} else if (descricao.equals("n") && !local.equals("n")) {
										tarefa = new Tarefas(titulo, expData, tag, local);
										System.out.println("titulo, expData, tag, local"); // Para testar os ifs
									} else if (!descricao.equals("n") && local.equals("n")) {
										tarefa = new Tarefas(titulo, expData, tag, descricao);
										System.out.println("titulo, expData, tag, descricao"); // Para testar os ifs
									} else if (descricao.equals("n") && local.equals("n")) {
										tarefa = new Tarefas(titulo, expData, tag);
										System.out.println("titulo, expData, tag"); // Para testar os ifs
									}
									user.setArrayList(tarefa); // Se Tarefas herda de Notas, pq não funcionou?
									// numeroDeLembretes++

								} else if (op2 == 2) {
									System.out.println("Digite o título da tarefa:");
									String titulo = sc.next();
									System.out.println("Digite a descrição dessa tarefa (Ou digite 'n' caso não haja descrição): ");
									String descricao = sc.next();
									System.out.println("Digite um local para essa tarefa (Ou digite 'n' caso não haja local): ");
									String local = sc.next();
									System.out.println("Digite ums tag para essa tarefa: ");
									String tag = sc.next();
									if (!descricao.equals("n") && !local.equals("n")) {
										lembrete = new Lembretes(titulo, tag, descricao, local);
										System.out.println("titulo, tag, descricao, local"); // Para testar os ifs
									} else if (descricao.equals("n") && !local.equals("n")) {
										lembrete = new Lembretes(titulo, tag, local);
										System.out.println("titulo, tag, local"); // Para testar os ifs
									} else if (!descricao.equals("n") && local.equals("n")) {
										lembrete = new Lembretes(titulo, tag, descricao);
										System.out.println("titulo, tag, descricao"); // Para testar os ifs
									} else if (descricao.equals("n") && local.equals("n")) {
										lembrete = new Lembretes(titulo, tag);
										System.out.println("titulo, tag"); // Para testar os ifs
									}
									user.setArrayList(lembrete); // Se Lembretes herda de Notas, pq não funcionou?
									// numeroDeLembretes++
								}
								
								break;
								
							case "2":
								System.out.println("Logout realizado com sucesso.\n---------------------------");
								
								break;
								
							case "3":
								System.out.println("Logout realizado com sucesso.\n---------------------------");
								
								break;
								
							case "4":
								System.out.println("Logout realizado com sucesso.\n---------------------------");
								
								break;
								
							case "5":
								gu.deletarUsuario(user);
								status = false;
								System.out.println("Usuário deletado com sucesso.\n---------------------------");
								break;
								
							case "6":
								status = false;
								System.out.println("Logout realizado com sucesso.\n---------------------------");
								break;

							default:
								break;
							}
						}
					}
	
				}else{
					System.out.println("Não há nenhum usuário cadastrado.\n---------------------------");
				}
				break;
				
			case "2":
				if (numLog < 51){
					System.out.println("REALIZAR CADASTRO:\nDigite o login que deseja utulizar:");
					entradaL = sc.next();
					if (!gu.checarNomes(entradaL)) { //if do try
						System.out.println("Digite a sua senha:");
						entradaS = sc.next();
						novoUsuario = new Usuario(entradaL, entradaS);
						gu.cadastrar(novoUsuario);
						numLog++;
					}
					break;
				}

			default:
				System.out.println("Entrada errada. Digite uma das duas opções.\n---------------------------");
				break;
			}
			
			
		}
		
		
		

	}

}
