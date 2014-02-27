package ifrn.poo.projetoLembretes;

import ifrn.poo.excecao.UsuarioExistenteException;
import ifrn.poo.excecao.UsuarioSenhaErradoException;

import java.util.Scanner;

public class Main { // classe main

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GerenciadorDeLembretes gl = new GerenciadorDeLembretes();
		GerenciadorDeUsuarios gu = new GerenciadorDeUsuarios();
		Scanner sc = new Scanner(System.in);
		int op;
		Usuario novoUsuario;
		Usuario user;
		int numLog = 0;
		String entradaL, entradaS;
		

				System.out.println("BEM VINDO AO GERENCIADOR DE LEMBRETES!");
				while (true) { //primeiro while
					System.out.println("Digite a operação que deseja realizar:\n 1 - Para realizar login.\n 2 - Para criar um login.");
					op = sc.nextInt();

					switch (op) { // primeiro switch
					case 1:
						if(!gu.isEmpty()){ // if do caso 1
							while(true){ // primeiro while do caso 1
								try { // try do caso 1
									System.out.println("Digite seu login (ou digite 'n' para sair):");
									entradaL = sc.next();
									if (entradaL.equals('n')){
										break;
									}
									System.out.println("Digite a sua senha:");
									entradaS = sc.next();
									user = gu.autenticar(entradaL, entradaS);
									
									/////// PÁGINA INICIAL
									
									System.out.println("Olá "+ user.getLogin() + ".\nEsses são todos os seus lembretes.");
									// Imprima todos os lembretes do usuário
									System.out.println("Digite o número do lembrete para visualizar seus detalhes.\nOu digite '0' para acessar outras funções:");
									op = sc.nextInt();
									if (op == 0){ // if do try caso 1
										
										////////MUNU DE FUNÇÕES

											System.out.println("MENU:\nDigite o numero da operação de deseja realizar:\n 1 - Inserir lembrete;\n 2 - Pesquisar por dia;\n 3 - Pesquisar por mês;\n 4 - Deletar usuário;\n 5 - Fazer logout.");
											op = sc.nextInt();
											switch (op) { //swich do menu de funções
												case 1:
													gl.inserirLembrete();
													break;
								
												case 2:
													gl.pesquisarDia();
													break;
												case 3:
													gl.pesquisarMes();
													break;
												case 4:
													gu.deletarUsuario(user);
													numLog--;
													break;
												case 5:
													break;
													
												default:
													System.out.println("Operação inválida. Digite novamente.\n---------------------------");
													break;
											} //swich do menu de funções
												if (op == 5 || op == 4) { // para sair do usuario caso ele realize logout, ou delete o usuario.
													break;
												}
									} // if do try caso 1
								} catch (UsuarioSenhaErradoException e) { // try e catch do caso 1
										e.getMsg(); // Essa Exception já é lançada dentro do metodo autenticar da GU
								} //catch do caso 1
							}// primeiro while do caso 1
						}else{ // if e else do caso 1
							System.out.println("Não há usuários cadastrados.\n---------------------------");
						break;
						} // else do caso 1

					case 2:
						if (numLog < 51) { //primeiro if do caso 2
							boolean criou = false;
							while(!criou){ // primeiro while do caso 2
								try { // try do caso 2
									System.out.println("Digite o login que deseja utilizar:");
									entradaL = sc.next();
									if (!gu.checarNomes(entradaL)) { //if do try
										System.out.println("Digite a sua senha:");
										entradaS = sc.next();
										novoUsuario = new Usuario(entradaL, entradaS);
										System.out.println("Usuário '"+ entradaL+ "' cadastrado com sucesso.\n---------------------------");
										gu.cadastrar(novoUsuario);
									} //if do try
									criou = true;
									numLog++;
								} catch (UsuarioExistenteException e) { // try e catch do caso 2
									e.getMsg();
								}// catch do caso 2
							} // primeiro while do caso 2

						} else { //primeiro e else if do caso 2
							System.out.println("Não há mais espaço para usuários nesse aplicativo. Delete algum usuário para continuar.");
						} // else if do caso 2
						break;

					default:
						break;
					
					}// primeiro switch
			
				} //primeiro while
				
				
	}
				
} // CLASSE MAIN
