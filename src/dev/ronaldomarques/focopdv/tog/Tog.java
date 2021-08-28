package dev.ronaldomarques.focopdv.tog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.function.Predicate;



public final class Tog {
	
	private static final String PROJECTS_PATH_FILE = "resources\\projetos.tcsv";
	private static final String FILD_SEPARATOR = ";";
	private static final String ERR_PATH_FILE_NOT_FOUND = "ERRO de caminho e/ou arquivo não encontrado: ";
	
	
	
	public static void main(String[] args) {
		
		/* Interagir com usuario, para selecionar qual projeto. */
		String representation = askRepresentation();
		
		String laboratory = askLaboratory();
		
		String distributor = askDistributor();
		
		String howManyOrders;
		
		if (validateProject(representation, laboratory, distributor)
				&& !(howManyOrders = askHowManyOrders()).isEmpty()) {
			// entrar quantidade de pedidos
			System.out.println(howManyOrders);
		}
		
		// se validar relacao a cima como ativo
		
		/* ### DOUBT: JULIO ###
		 * instancio uma classe Project, e entao chamo dela um metodo de auto avaliação ?
		 * ou
		 * só passo as Strings que coletei (com os nomes dos ATORES) para uma instancia Project com
		 * metodo de auto validacao ?
		 * ou
		 * instancio uma classe project, e passo ela como argumento para ser validada numa classe
		 * Validator (tipo service) ?
		 * ou
		 * só passo as Strings que coletei (com os nomes dos ATORES) para uma Validator (tipo
		 * service) ? */
		System.out.println("concluído.");
	}
	
	
	
	private static String askRepresentation() {
		
		System.out.print("\nNome da REPRESENTAÇÃO: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
//		scan.close();
		return temp;
		
	}
	
	
	
	private static String askLaboratory() {
		
		System.out.print("\nNome do LABORATORY: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
//		scan.close();
		return temp;
		
	}
	
	
	
	private static String askDistributor() {
		
		System.out.print("\nNome do DISTRIBUTOR: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
//		scan.close();
		return temp;
		
	}
	
	
	
	private static String askHowManyOrders() {
		
		System.out.print("\nQuantos PEDIDOS: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
		scan.close();
		return temp;
		
	}
	
	
	
	private static Predicate<String> specificProject(String r, String l, String d) {
		return p -> p.contains(r) && p.contains(l) && p.contains(d);
		
	}
	
	
	
	private static boolean validateProject(String rep, String lab, String dis) {
		
		// abre arquivo.
		BufferedReader myCsvContent = loadMyFile(PROJECTS_PATH_FILE);
		String theLine = "";
		
		// varredura buscando as 3 Strings.
		if (!(theLine = myCsvContent.lines().filter(specificProject(rep, lab, dis)).findFirst().get()).isEmpty()) {
			
			System.out.println(theLine+"\n"+theLine.split(FILD_SEPARATOR)[3]);
			
			// verifica se status é 0 ou 1.
			if (theLine.split(FILD_SEPARATOR)[3].equalsIgnoreCase("1")) {
				// conforme o Q achou retorna boolean.
				return true;
			}
			
		}
		return false;
		
	}
	
	
	
	/* Carregador de arquivo texto ou cs para um BufferedReader. */
	public static BufferedReader loadMyFile(String pf) {
		BufferedReader brCsvContent = null;
		
		try {
			brCsvContent = new BufferedReader(new FileReader(pf));
		}
		catch (FileNotFoundException excep) {
			System.out.println("\n" + ERR_PATH_FILE_NOT_FOUND + pf + "\n");
		}
		
		return brCsvContent;
		
	}
	
}
