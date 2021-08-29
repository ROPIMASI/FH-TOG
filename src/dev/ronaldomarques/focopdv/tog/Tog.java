package dev.ronaldomarques.focopdv.tog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;



public final class Tog {
	
	private static final String PROJECTS_PATH_FILE = "resources\\projetos.tcsv";
	private static final String FIELD_SEPARATOR = ";";
	private static final String ERR_PATH_FILE_NOT_FOUND = "ERRO de caminho e/ou arquivo não encontrado: ";
	private static final String STATUS_COLUMN_NAME = "ON_OFF_STATUS";
	
	/* Índice do array onde fica o campo STATUS DO PROJETO.
	 * Tem que ser calculado ao iniciar o programa para dectar em qual coluna fica o status,
	 * dinamicamente,
	 * assim, se o layout do arquivo CSV for alterado, o programa reconhece automaticamente qual é a
	 * nova
	 * posição da coluna STATUS. */
	private static int PROJECT_STATUS_INDEX;
	
	
	
	public static void main(String[] args) {
		
		try {
			syncProjectStatusIndex();
		}
		catch (IOException excep) {
			// TODO: Auto-generated catch block
			excep.printStackTrace();
		}
		
		String howManyOrders = askHowManyOrders();
		
		/* Interagir com usuario, perguntando Rep Lab Dis do projeto. */
		/* String representation = askRepresentation();
		 * String laboratory = askLaboratory();
		 * String distributor = askDistributor();
		 * 
		 * if (validateProject(representation, laboratory, distributor)
		 * && !(howManyOrders = askHowManyOrders()).isEmpty()) {
		 * System.out.println("Fazer " + howManyOrders + " pedidos...");
		 * } */
		/* Se validar relacao a cima como ativo, então FAZER OS PEDIDOS DE FATO. */
		
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
		
		/* ### ALTERNATIVA: menu com código */
		makeTestOrders(getProjectFromMenu(), Integer.parseInt(howManyOrders));
		
		System.out.println("concluído.");
		
	} // FIM DA MAIN.
	
	
	
	private static int getProjectFromMenu() {
		
		// imprime menu
		printProjectMenuByStatus(1);
		
		// scan codigo
		// retorna codigo
		return Integer.parseInt(askMenuOption());
		
	}
	
	
	
	private static void printProjectMenuByStatus(int status) {
		
		// ler o arquivo projeto.
		BufferedReader myCsvContent = loadMyFile(PROJECTS_PATH_FILE);
		
		// split em cada linha que for COLUNA STATUS 1.
		// imprimir legivel intuitivo
		Stream.of(myCsvContent.lines().filter(projectByStatus(1)).toString().split(FIELD_SEPARATOR))
				.forEach(System.out::print);
		
	}
	
	
	
	private static String askMenuOption() {
		
		System.out.print("\nDigite o núme do projeto: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
		// scan.close();
		return temp;
		
	}
	
	
	
	private static String askRepresentation() {
		
		System.out.print("\nNome da REPRESENTAÇÃO: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
		// scan.close();
		return temp;
		
	}
	
	
	
	private static String askLaboratory() {
		
		System.out.print("\nNome do LABORATORY: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
		// scan.close();
		return temp;
		
	}
	
	
	
	private static String askDistributor() {
		
		System.out.print("\nNome do DISTRIBUTOR: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
		// scan.close();
		return temp;
		
	}
	
	
	
	private static String askHowManyOrders() {
		
		System.out.print("\nQuantos PEDIDOS: ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		// verificacoes.
		// scan.close();
		return temp;
		
	}
	
	
	
	private static Predicate<String> projectByStatus(int status) {
		
		return p -> p.contains(FIELD_SEPARATOR + status + FIELD_SEPARATOR);
		
	}
	
	
	
	private static Predicate<String> specificProject(String r, String l, String d) {
		
		return p -> p.contains(r) && p.contains(l) && p.contains(d);
		
	}
	
	
	
	private static boolean validateProject(String rep, String lab, String dis) {
		
		// abre arquivo.
		BufferedReader myCsvContent = loadMyFile(PROJECTS_PATH_FILE);
		String theLine = "";
		
		// varredura buscando as 3 Strings.
		if (!(theLine = myCsvContent.lines().filter(specificProject(rep, lab, dis)).findFirst().get()).isEmpty()) { // FIXME:
																													// .get()
																													// por
																													// .orElse()
																													// ?
			System.out.println(theLine + "\n" + theLine.split(FIELD_SEPARATOR)[PROJECT_STATUS_INDEX]);
			
			// verifica se status é 0 ou 1.
			if (theLine.split(FIELD_SEPARATOR)[PROJECT_STATUS_INDEX].equalsIgnoreCase("1")) {
				// conforme o Q achou retorna boolean.
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	
	/* Carregador de arquivo texto ou csv para um BufferedReader. */
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
	
	
	
	private static void syncProjectStatusIndex() throws IOException {
		
		// abre arquivo.
		BufferedReader myCsvContent = loadMyFile(PROJECTS_PATH_FILE);
		String firstLine = "";
		
		// varredura buscando as 3 Strings.
		if ((firstLine = myCsvContent.readLine()) != null) {
			String[] firstVector = firstLine.split(FIELD_SEPARATOR);
			
			for (int i = 0; i < firstVector.length; i++) {
				
				if (firstVector[i].equalsIgnoreCase(STATUS_COLUMN_NAME)) { PROJECT_STATUS_INDEX = i; }
				
			}
			
		}
		
	}
	
	
	
	private static void makeTestOrders(int code, int howMany) {
		
	}
	
}
