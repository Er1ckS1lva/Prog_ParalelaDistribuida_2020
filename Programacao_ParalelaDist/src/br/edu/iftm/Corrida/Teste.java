package br.edu.iftm;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		int quantidade;
		String pessoa;
		int veloci;

		ArrayList<String> jogadores = new ArrayList<String>();
		ArrayList<Integer> velocidades = new ArrayList<Integer>();

		
		try (Scanner teclado = new Scanner(System.in)) {
			System.out.println("Quantos Jogadores paticiparão da corrida ?");
			quantidade = Integer.parseInt(teclado.nextLine());
			
			for (int i = 0; i < quantidade;i++) {
				System.out.println("Informações Jogador "+(i+1));
				System.out.println("Nome : ");
				pessoa = teclado.nextLine();
				System.out.println("Velocidade : ");
				veloci = Integer.parseInt(teclado.nextLine());
				jogadores.add(pessoa);
				velocidades.add(veloci);
			}
		}	
		Thread race[] = new Thread[jogadores.size()];		
		for(int i = 0;i<jogadores.size();i++) {
			
			Corrida corrida = new Corrida(jogadores.get(i), velocidades.get(i));
			race[i] = new Thread(corrida);
			race[i].start();
			}
		
		for(int i = 0;i<jogadores.size();i++) {
			try {
				race[i].join(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("A corrida parou !");
		}	
		
	}
