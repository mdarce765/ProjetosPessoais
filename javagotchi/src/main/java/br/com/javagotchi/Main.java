package br.com.javagotchi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		Javagotchi jc = new Javagotchi();

		jc.setNome("Izanagi");
		jc.setEnergia(100);

		System.out.println("Nome = " + jc.getNome());
	}

}
