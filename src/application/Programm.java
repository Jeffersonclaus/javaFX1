package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Programm {

public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Digite o caminho do arquivo: ");
	String path = sc.nextLine();

	
	try (BufferedReader bf = new BufferedReader(new FileReader(path))){
		
		Set<LogEntry> set = new HashSet<>();
		
		String ler = bf.readLine();
		
		while(ler !=null) {
		
			
			String [] ler1 = ler.split(" ");
			String product = ler1[0];
			Date momnet = Date.from(Instant.parse(ler1[1]));
			
			
			set.add(new LogEntry(product,momnet));
			
			ler = bf.readLine();
			
		
		}
			System.out.println("total de elementos: " + set.size());
		
		
		
		sc.close();
		
		
		
		} catch (Exception e) {
		
		System.out.println(e.getMessage());
	}

}
}
