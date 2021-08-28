package dev.ronaldomarques.focopdv.tog.domain.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Buscador {
	
	public static int temProjeto(String representante, String laboratorio, String distribuidor) throws IOException {
		
		String projectFile = "resources\\projetoss.tcsv";
		BufferedReader brCsvContent = null;
		String line = "";
		String fieldSeparator = ";";
		String[] artifact = null;
		
		brCsvContent = new BufferedReader(new FileReader(projectFile));
		System.out.println("\nERRO na leitura em [ " + projectFile + " ] .\n");
		
		while ((line = brCsvContent.readLine()) != null) {
			artifact = line.split(fieldSeparator);
			if (artifact[0].equalsIgnoreCase(representante)) {
				System.out.println("não existe este representante disponivel em projetos.");
				return 0;
			}
			if (artifact[1].equalsIgnoreCase(laboratorio)) return 0;
			if (artifact[2].equalsIgnoreCase(distribuidor)) return 0;
			if (artifact[3].equalsIgnoreCase("1")) return 0;
		}
		
		brCsvContent.close();
		return 1;
		
	}
	
	/* public static Optional<String[]> buscarDistribuidor(String nomePadrao, String pastaRecurProj)
	 * {
	 * 
	 * // abrir o arquivo na pasta do recurso do projeto, 5� campo
	 * String projectFile = "resources\\" + pastaRecurProj + "\\distribuidores.tcsv";
	 * BufferedReader brCsvContent = null;
	 * String line = "";
	 * String fieldSeparator = ";";
	 * String[] artifact = null;
	 * int counter;
	 * int closer = 4;
	 * 
	 * try {
	 * brCsvContent = new BufferedReader(new FileReader(projectFile));
	 * } catch (IOException e) {
	 * System.out.println("\nERRO na leitura em [ " + projectFile + " ] .\n");
	 * e.printStackTrace();
	 * }
	 * 
	 * // varrer o arquivo comparando nome, 2� campo
	 * try {
	 * while ((line = brCsvContent.readLine()) != null) {
	 * artifact = line.split(fieldSeparator);
	 * 
	 * counter = 4; // lista ok nao vazia.
	 * if (artifact[0].equalsIgnoreCase(r)) {
	 * --counter; // 4-> 3 rep ok.
	 * if (artifact[1].equalsIgnoreCase(l)) {
	 * --counter; // 3-> 2 lab ok.
	 * if (artifact[2].equalsIgnoreCase(d)) {
	 * --counter; // 2-> 1 dis ok.
	 * if (artifact[3].equalsIgnoreCase("1")) {
	 * --counter; // 1-> 0 on.
	 * return counter; // se j� achou, n�o precisa mais procurar.
	 * }
	 * }
	 * }
	 * } // fim dos ifs.
	 * if (counter < closer) {
	 * closer = counter;
	 * }
	 * 
	 * } // fim do while.
	 * } catch (IOException e) {
	 * System.out.println("\nERRO na listagem/impress�o de [ " + projectFile + " ] .\n");
	 * e.printStackTrace();
	 * }
	 * 
	 * // se encontrado -> retorna todos os campos
	 * // se n�o -> retorna null
	 * 
	 * return null;
	 * } */
	
}
