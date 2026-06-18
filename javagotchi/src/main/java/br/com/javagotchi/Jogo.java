package br.com.javagotchi;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jogo {
    static ArrayList<String> listaJavagotchi = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	static Javagotchi jc = new Javagotchi();
	static int opcao;

    public static void startGame(Javagotchi jc){
        System.out.println("JOGO INICIADO: JAVAGOTCHI");
        do{
            System.out.print("\n1 - Alimentar\n2 - Brincar\n3 - Banho\n4 - Dormir\n\n0 - Sair e Salvar\nDigite a sua opção: ");
			opcao = Integer.parseInt(sc.nextLine());
			switch(opcao){
					case 0 -> {
						System.out.print("ESCREVENDO OS STATUS ATUAIS");
                        for(int i = 0; i < 3; i++){
                            System.out.print(".");
                            try{
                                Thread.sleep(1000);
                            }catch (InterruptedException e) {
                                Thread.currentThread().interrupt(); 
                            }
                        }
					}
					case 1 -> jc.Alimentar(jc.getFome());
					//case 2 -> jc.brincar();
					//case 3 -> jc.banho();
					//case 4 -> jc.dormir();
					default -> System.out.println("OPÇÃO INVÁLIDA");
				}
		}while(opcao != 0);
    }
}
