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
		System.out.println("-- CARREGANDO JAVAGOTCHI --");
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

		System.out.println("-- JAVAGOTCHI CARREGADO -- ");
		
	}

	private static void criarJavagotchi(){

		System.out.println("-- CRIANDO UM NOVO JAVAGOTCHI --");

		try(FileWriter escritor = new FileWriter("Javagotchis.txt", true);){
			escritor.write(criar("") + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia() + "\n");
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
		}

		System.out.println("-- JAVAGOTCHI CRIADO E SALVO --");
	}

	private static void verJavagotchis(){
		System.out.println("-- VISUALIZAÇÃO DE JAVAGOTCHIS --");
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

		for(int i = 0; i < listaJavagotchi.size(); i++){
			System.out.println(i + " - " + listaJavagotchi.get(i));
		}

		System.out.println("-- FIM DA LEITURA --");
	}

	private static void atualizarJavagotchi(){
		System.out.println("-- ATUALIZAÇÃO DE JAVAGOTCHI --");
		verJavagotchis();
		System.out.print("Digite o id do Javagotchi que deseja atualizar: ");
		int id = Integer.parseInt(sc.nextLine());

		listaJavagotchi.set(id, criar("novo") + "," + jc.getHp() + "," + jc.getFome() + "," + jc.getIdade() + "," + jc.getHigiene() + "," + jc.getEnergia());

		escreverArquivo(listaJavagotchi);

		System.out.println("-- JAVAGOTCHI ATUALIZADO E SALVO COM SUCESSO --");
	}

	private static void apagarJavagotchi(){
		System.out.println("-- APAGAR JAVAGOTCHI -- tem certeza disso? precisa mesmo apagar? não pode só editar? :(");
		verJavagotchis();

		System.out.print("Digite o id do Javagotchi que deseja apagar: ");
		opcao = Integer.parseInt(sc.nextLine());

		listaJavagotchi.remove(opcao);

		escreverArquivo(listaJavagotchi);
		
		System.out.println("-- VOCÊ APAGOU UM JAVAGOTCHI, ISSO NÃO LHE ENTRISTECE? VOCÊ É MESMO HUMANO? --");
	}

	private static void escreverArquivo(ArrayList<String> lista){
		try(FileWriter escritor = new FileWriter("Javagotchis.txt");){
			for(int i = 0; i < listaJavagotchi.size(); i++){
				escritor.write(listaJavagotchi.get(i) + "\n");
			}
		}catch(IOException e) {
			System.out.println("Algum erro aconteceu durante a escrita!");
			e.printStackTrace();
		}
	}

	private static String criar(String mensagem){
		String nome;
		do{
			System.out.print("Digite o " + mensagem + " nome do seu Javagotchi: ");
			nome = sc.nextLine();
			System.out.print("\nNOVO NOME: " + nome + "\nDeseja manter o nome? \n1 - Sim\n2 - Não\n\nDigite sua escolha: ");
			opcao = Integer.parseInt(sc.nextLine());
		}while(opcao != 1);

		return nome;
	}
}
