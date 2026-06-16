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
	//static ArrayList<String> listaUsado = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	static Javagotchi jc = new Javagotchi();
	static int opcao;

	public static void main(String[] args) {
		do{
			System.out.print("\n1 - Carregar Javagotchi\n2 - Criar novo Javagotchi\n3 - Ver Javagotchis\n4 - Atualizar Javagotchi\n5 - Apagar Javagotchis\n\n0 - Sair\nDigite a sua opção: ");
			opcao = Integer.parseInt(sc.nextLine());
			switch(opcao){
					case 0 -> {
						System.out.println("SAINDO... NÃO SE ESQUEÇA DE NÓS :)");
						System.exit(0);
					}
					case 1 -> carregarJavagotchi();
					case 2 -> criarJavagotchi();
					case 3 -> verJavagotchis();
					case 4 -> atualizarJavagotchi();
					case 5 -> apagarJavagotchi();
					default -> System.out.println("OPÇÃO INVÁLIDA");
				}
		}while(true);
	}

	private static void carregarJavagotchi(){
		verJavagotchis();
		System.out.print("Digite o id do Javagotchi que deseja carregar: ");
		opcao = Integer.parseInt(sc.nextLine());

		String[] escolhido = listaJavagotchi.get(opcao).trim().split(",");

		String save = "Save" + escolhido[0].replaceAll("\\s+","") + ".txt";

		try(FileWriter escritor = new FileWriter(save)){
			escritor.write(escolhido[0] + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia() + "\n");
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
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

		try(FileWriter escritor = new FileWriter("Javagotchis.txt", true);){
			escritor.write(nome + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia() + "\n");
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
		}
	}

	private static void verJavagotchis(){
		File arquivo = new File("Javagotchis.txt");
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

	private static void atualizarJavagotchi(){
		String novoNome;
		verJavagotchis();
		System.out.print("Digite o id do Javagotchi que deseja atualizar: ");
		int id = Integer.parseInt(sc.nextLine());

		//String[] escolhido = listaJavagotchi.get(opcao).trim().split(",");

		//System.out.println(escolhido[0]);
		System.out.println(listaJavagotchi);

		do{
			System.out.print("Digite o novo nome do seu Javagotchi: ");
			novoNome = sc.nextLine();
			System.out.print("\nNOVO NOME: " + novoNome + "\nDeseja manter o nome? \n1 - Sim\n2 - Não\n\nDigite sua escolha: ");
			opcao = Integer.parseInt(sc.nextLine());
		}while(opcao != 1);

		listaJavagotchi.set(id, novoNome + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia());
		//escolhido[0] = novoNome;

		//System.out.println(escolhido[0]);
		System.out.println(listaJavagotchi);

		try(FileWriter escritor = new FileWriter("Javagotchis.txt");){
			for(int i = 0; i < listaJavagotchi.size(); i++){
				escritor.write(listaJavagotchi.get(i) + "\n");
			}
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
		}

	}

	private static void apagarJavagotchi(){
		verJavagotchis();

		System.out.print("Digite o id do Javagotchi que deseja apagar: ");
		opcao = Integer.parseInt(sc.nextLine());

		listaJavagotchi.remove(opcao);

		try(FileWriter escritor = new FileWriter("Javagotchis.txt");){
			for(int i = 0; i < listaJavagotchi.size(); i++){
				escritor.write(listaJavagotchi.get(i) + "\n");
			}
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
		}
	}
}
