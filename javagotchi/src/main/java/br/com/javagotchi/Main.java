package br.com.javagotchi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	static ArrayList<String> listaJavagotchi = new ArrayList<String>();
	static ArrayList<String> listaUsado = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	static Javagotchi jc = new Javagotchi();
	static int opcao;

	public static void main(String[] args) {
		do{
			System.out.print("\n1 - Carregar Javagotchi\n2 - Criar novo Javagotchi\n3 - Ver Javagotchis\n\n0 - Sair\nDigite a sua opção: ");
			opcao = Integer.parseInt(sc.nextLine());
			switch(opcao){
					case 0 -> {
						System.out.println("SAINDO... NÃO SE ESQUEÇA DE NÓS :)");
						System.exit(0);
					}
					//case 1 -> carregarJavagotchi();
					case 1 -> carregarJavagotchi();
					case 2 -> criarJavagotchi();
					case 3 -> verJavagotchis();
					default -> System.out.println("OPÇÃO INVÁLIDA");
				}
		}while(true);
	}

	private static void carregarJavagotchi(){
		verJavagotchis();
		System.out.print("Digite o id do Javagotchi que deseja carregar: ");
		opcao = Integer.parseInt(sc.nextLine());

		String[] escolhido = listaJavagotchi.get(opcao).replace(";", "").trim().split(",");
		System.out.println("Javagotchi escolhido é: " + escolhido);
		//String teste = escolhido.split(",");

		for(int i = 0; i<6; i++){
			System.out.println(escolhido[i]);
		}

		for(int i =0; i<listaUsado.size(); i++){
			System.out.println(i + " - " + listaUsado.get(i));
		}
		
	}

	private static void criarJavagotchi(){
		String nome;

		do{
			System.out.print("Digite o nome do seu Javagotchi: ");
			nome = sc.nextLine();
			jc.setNome(nome);
			System.out.print("\nNOME: " + jc.getNome() + "\nDeseja manter o nome? \n1 - Sim\n2 - Não\n\nDigite sua escolha: ");
			opcao = Integer.parseInt(sc.nextLine());
		}while(opcao != 1);

		try(FileWriter escritor = new FileWriter("Javagotchi.txt", true);){
			escritor.write(nome + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia() + "\n");
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
		}
	}

	private static void verJavagotchis(){
		File arquivo = new File("Javagotchi.txt");
		listaJavagotchi.clear();
		System.out.println("id - NOME");
		try(Scanner leitor = new Scanner(arquivo)){
			while(leitor.hasNextLine()){
				String dados = leitor.nextLine();
				listaJavagotchi.add(dados);
			}
		}catch(IOException e) {
			System.out.println("Aconteceu algum erro durante a leitura!");
			e.printStackTrace();
		}

		for(int i =0; i<listaJavagotchi.size(); i++){
			System.out.println(i + " - " + listaJavagotchi.get(i));
		}
	}
}
