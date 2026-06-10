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

	public static void main(String[] args) {
		do{
			System.out.print("""
							\n1 - Carregar Javagotchi
							2 - Criar novo Javagotchi
							3 - Ver Javagotchis
							0 - Sair\n
							Digite a sua opção: """);
			int opcao = sc.nextInt();
			switch(opcao){
					case 0 -> {
						System.out.println("SAINDO... NÃO SE ESQUEÇA DE NÓS :)");
						System.exit(0);
					}
					//case 1 -> carregarJavagotchi();
					case 2 -> criarJavagotchi();
					case 3 -> verJavagotchis();
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
			System.out.print("\nNOME: " + jc.getNome() + "\nDeseja manter o nome? \n1 - Sim\n2 - Não\n\nDigite sua escolha: ");
			escolha = sc.nextInt();
		}while(escolha != 1);

		try(FileWriter escritor = new FileWriter("Javagotchi.txt", true);){
			escritor.write(nome + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia() + ";\n");
		}catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static void verJavagotchis(){
		File arquivo = new File("Javagotchi.txt");
		try(Scanner leitor = new Scanner(arquivo)){
			while(leitor.hasNextLine()){
				String dados = leitor.nextLine();
				System.out.println(dados);
			}
		}catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
