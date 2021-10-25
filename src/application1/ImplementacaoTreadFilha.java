package application1;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoTreadFilha extends Thread {

	private  ConcurrentLinkedQueue<ObjThread> pilha = new ConcurrentLinkedQueue<ObjThread>();

	public  void add(ObjThread objfilhathread) { // adiciona na pilha
		pilha.add(objfilhathread);

	}

	public void run() {
				System.out.println("Fila Rodando"); 
		while (true) {
			
			synchronized (pilha) { // Não deixa fazer pegar nenhum processo dessa lista enquanto não acabar
				Iterator<ObjThread> interator = pilha.iterator();
				while (interator.hasNext()) { // Enquanto conter dados na lista irá processar

					ObjThread processar = interator.next();

					// Processar NF-e

					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					// Imprimir as NF-e

					// Envio das NF-e em PDF por e-mail

					try {
						Thread.sleep(1000); /// Dá um tempo para descarga de memoria
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					interator.remove();
				}

			}

			try {
				Thread.sleep(100); // Depois de executar todo processo, dá um tempo para entrar outros processos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
