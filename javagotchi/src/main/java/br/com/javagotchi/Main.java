package br.com.javagotchi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	static Scanner sc = new Scanner(System.in);
	static Javagotchi jc = new Javagotchi();
	static File arq = new File("Javagotchi.txt");

	public static void main(String[] args) {
		do{
			System.out.print("""
							1 - Carregar Javagotchi
							2 - Criar novo Javagotchi
							0 - Sair\n
							Digite a sua opção:
							""");
			int opcao = sc.nextInt();
			switch(opcao){
					case 0 -> {
						System.out.println("SAINDO... NÃO SE ESQUEÇA DE NÓS :)");
						System.exit(0);
					}
					//case 1 -> carregarJavagotchi();
					case 2 -> criarJavagotchi();
					//case 3 -> verJavagotchis();
					default -> System.out.println("OPÇÃO INVÁLIDA");
				}
		}while(true);
	}

	private static void criarJavagotchi(){
		int escolha;
		String nome;
		do{
			System.out.print("Digite o nome do seu Javagotchi: ");
			nome = sc.next();
			jc.setNome(nome);

			System.out.print("NOME: " + jc.getNome() + "\nDeseja mudar o nome? \n1 - Sim\n2 - Não\n\nDigite sua escolha: ");
			escolha = sc.nextInt();
		}while(escolha != 2);

		try{
				FileWriter escritor = new FileWriter("Javagotchi.txt");
				escritor.write(nome + "," + 100 + "," + 0 + "," + 0 + "," + 100 + "," + 100 + ";");
				escritor.close();
			}catch(IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
	}

	/*private static void verJavagotchis(){
			
	}*/
}
