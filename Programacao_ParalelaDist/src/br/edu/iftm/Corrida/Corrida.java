package br.edu.iftm;

public class Corrida implements Runnable {

	@SuppressWarnings("unused")
	private String Nome;
	@SuppressWarnings("unused")
	private Integer Veloc;
	
	//private Thread thread;
	//private Boolean Venceu = false;
	private Integer Pos = 0;

	public  Corrida(String name, Integer velocidade) {
		this.Nome = name;
		this.Veloc = velocidade;
	}
	
	public void run() {
		System.out.println(this.Nome+" começou !");
		while(this.Pos<10){
			try {
				
				if(Pos < 10) {
					Pos = Pos+1;
					System.out.println(Nome + " Avançou");
					Thread.sleep(Veloc*20);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.Nome+ " terminou !");
	}
	
}

