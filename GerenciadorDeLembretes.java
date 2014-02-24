package ifrn.poo.projetoLembretes;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class GerenciadorDeLembretes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar calendario = Calendar.getInstance();
		int op;
		int numLog = 0;
		String entradaL, entradaS;
		System.out.println("BEM VINDO AO GERENCIADOR DE LEMBRETES!");
		while(true){
			System.out.println("Digite a operação que deseja realizar:\n 1 - Para realizar login.\n 2 - Para criar um login.");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				if (numLog > 0){
					System.out.println("Digite seu login:");
					entradaL = sc.next();
					for (int i = 0; i < numLog; i++){
						if (arrayDeLogin[i].getLogin().equals(entradaL)){
							System.out.println("Digite sua senha:");
							entradaS = sc.next();
							if (arrayDeLogin[i].getSenha().equals(entradaS)){
								System.out.println("Usuário encontrado.\n---------------------------");
								
								// PAGINA INICIAL QUE IMPRIME TODOS OS LEMBRETES
								
								while(true){
									System.out.println("Olá "+arrayDeLogin[i].getLogin()+".\nEsses são todos os seus lembretes.");
									//Imprima todos os lembretes de arrayDeListas[i] com seu indice acrecido de 1
									System.out.println("Digite o número do lembrete para visualizar seus detalhes.\nOu digite '0' para acessar outras funções:");
									op = sc.nextInt();
										if (op != 0){
											//Imprima o lembrete com indice (op-1) da Lista arrayDeListas[i].
										}else{
											
										//////// MENU DE OPERAÇÕES
											
											System.out.println("MENU:\nDigite o numero da operação de deseja realizar:\n 1 - Inserir lembrete;\n 2 - Pesquisar por dia;\n 3 - Pesquisar por mês;\n 4 - Deletar usuário;\n 5 - Fazer logout.");
											op = sc.nextInt();
											switch (op) {
											case 1:
												System.out.println("Este lembrete possui data de expiração?\n(Digite '1' se houver ou '2' se não houver)");
												op = sc.nextInt();
												if (op == 1){
													System.out.println("Digite o título da tarefa: ");
													String titulo = sc.next();
													System.out.println("Digite o data de expiração dessa tarefa (em número): ");
													System.out.print("Dia: ");
													int dia = sc.nextInt();
													System.out.print("Mês: ");
													int mes = sc.nextInt();
													System.out.print("Ano: ");
													int ano = sc.nextInt();
													calendario.set(ano, (mes-1), dia); // (mes-1) pq o metodo set recebe os meses de 0 a 11 (jan .. dez)
													Date expData = calendario.getTime();
													System.out.println("Digite a descrição dessa tarefa (Ou digite 'n' caso não haja descrição): ");
													String descricao =  sc.next();
													System.out.println("Digite um local para essa tarefa (Ou digite 'n' caso não haja local): ");
													String local =  sc.next();
													System.out.println("Digite ums tag para essa tarefa: ");
													String tag =  sc.next();
													
													if (!descricao.equals("n") && !local.equals("n")){
														Notas tarefa = new Tarefas(titulo, expData, tag, descricao, local);
														System.out.println("titulo, expData, tag, descricao, local"); // Para testar os ifs
													}else if (descricao.equals("n") && !local.equals("n")){
														Notas tarefa = new Tarefas(titulo, expData, tag, local);
														System.out.println("titulo, expData, tag, local"); // Para testar os ifs
													}else if (!descricao.equals("n") && local.equals("n")){
														Notas tarefa = new Tarefas(titulo, expData, tag, descricao);
														System.out.println("titulo, expData, tag, descricao"); // Para testar os ifs
													}else if (descricao.equals("n") && local.equals("n")){
														Notas tarefa = new Tarefas(titulo, expData, tag);
														System.out.println("titulo, expData, tag"); // Para testar os ifs
													}
													//arrayDeListas[i].vectorDeLembretes[numeroDeLembretes] = nota;
													//numeroDeLembretes++
													
												}else if(op == 2){
													System.out.println("Digite o título da tarefa:");
													String titulo = sc.next();
													System.out.println("Digite a descrição dessa tarefa (Ou digite 'n' caso não haja descrição): ");
													String descricao = sc.next();
													System.out.println("Digite um local para essa tarefa (Ou digite 'n' caso não haja local): ");
													String local = sc.next();
													System.out.println("Digite ums tag para essa tarefa: ");
													String tag = sc.next();
													if (!descricao.equals("n") && !local.equals("n")){
														Notas lembrete = new Lembretes(titulo, tag, descricao, local);
														System.out.println("titulo, tag, descricao, local"); // Para testar os ifs
													}else if (descricao.equals("n") && !local.equals("n")){
														Notas lembrete = new Lembretes(titulo, tag, local);
														System.out.println("titulo, tag, local"); // Para testar os ifs
													}else if (!descricao.equals("n") && local.equals("n")){
														Notas lembrete = new Lembretes(titulo, tag, descricao);
														System.out.println("titulo, tag, descricao"); // Para testar os ifs
													}else if (descricao.equals("n") && local.equals("n")){
														Notas lembrete = new Lembretes(titulo, tag);
														System.out.println("titulo, tag"); // Para testar os ifs
													}
													//arrayDeListas[i].vectorDeLembretes[numeroDeLembretes] = nota;
													//numeroDeLembretes++
												}
												break;
												
											case 2:
												
												break;
												
											case 3:
												
												break;
												
											case 4:
												System.out.println("Tem certeza que deseja deletar o usuário '"+arrayDeLogin[i].getLogin()+"'?\nDigite '1' para confirmar ou '2' para desistir)");
												op = sc.nextInt();
												if(op == 1){
													Login[] arrayAux = new Login[50];
													arrayDeLogin[i] = null;
													for (int j = 0; j < 50; j++){
														int ind = 0;
														if (arrayDeLogin[j] != null){
															arrayAux[ind] = arrayDeLogin[j];
															ind++;
														}						
													}
													arrayDeLogin = arrayAux;
													numLog--;
													op = 4;
													System.out.println("Usuário deletado com sucesso.\n---------------------------");
													break;
												} if (op == 2){
													System.out.println("O usuário não foi deletado.\n---------------------------");
													break;
												}
												
											case 5:
												System.out.println("Logout realizado com sucesso.\n---------------------------");
												break;
												
												default:
													System.out.println("Operação inválida.\n---------------------------");
													break;
											}
											
											if (op == 5 || op == 4){
												break;
											}
											
										}
										
										//////// FIM DO MENU DE OPERAÇÕES
										
										// FIM DA PAGINA INICIAL
										
								}
							}else{
								System.out.println("Senha inválida. Repita a operação.\n---------------------------");
							}
						}else{
							System.out.println("Usuário não encontrado. Repita a operação.\n---------------------------");
						}
						
					}
				}else{
					System.out.println("Não há nenhum usuário cadastrado. Digite 2 para realizar cadastro.\n---------------------------");
				}
				
				break;

			case 2:
				if (numLog < 51){
					arrayDeLogin[numLog] = new Login();
					System.out.println("Digite o login que deseja utilizar:");
					entradaL = sc.next();
					arrayDeLogin[numLog].setLogin(entradaL);
					System.out.println("Digite a sua senha:");
					entradaS = sc.next();
					arrayDeLogin[numLog].setSenha(entradaS);
					System.out.println("Usuário '"+arrayDeLogin[numLog].getLogin()+"' cadastrado com sucesso.\n---------------------------");
					//arrayDeListas[i] = new Listas();
					numLog++;
				}else{
					System.out.println("Não há mais espaço para usuários nesse aplicativo. Delete algum usuário.");
				}
				break;
				
			default:
				System.out.println("Operação inválida.\n---------------------------");
				break;
			}
				
			
		}
		
	}

	public static Login[] arrayDeLogin = new Login[50];
	//public static Listas[] arrayDeListas = new Listas[50];
	
	
}
