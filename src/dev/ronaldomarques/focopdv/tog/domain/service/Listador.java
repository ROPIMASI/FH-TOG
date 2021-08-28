package dev.ronaldomarques.focopdv.tog.domain.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Listador {

	public static void listarProjetos() {
		String projectFile = "resources\\projetos.tcsv";
		BufferedReader brCsvContent = null;
		String line = "";
		String fieldSeparator = ";";
		String[] artifact = null;
		int counter;

		System.out.println("\nLer arquivo de projetos...");
		counter = 0;
		try {
			brCsvContent = new BufferedReader(new FileReader(projectFile));
		} catch (IOException e) {
			System.out.println("\nERRO na leitura em [ " + projectFile + " ] .\n");
			e.printStackTrace();
		}

		try {
			System.out.println("\nListar arquivo de projetos...");
			while ((line = brCsvContent.readLine()) != null) {
				System.out.print("[Project " + ++counter + "] ");
				artifact = line.split(fieldSeparator);
				for (String a : artifact) {
					System.out.print(a + ", ");
				}
				System.out.println("\n");
			}
		} catch (IOException e) {
			System.out.println("\nERRO na listagem/impress�o de [ " + projectFile + " ] .\n");
			e.printStackTrace();
		}
	}
}
