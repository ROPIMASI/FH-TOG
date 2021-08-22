package dev.ronaldomarques.focopdv.tog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class Tog {

	public static void main(String[] args) throws IOException {

		System.out.println("\ninício\n");

		String projectFile = "resources\\projetos.tcsv";
		String dealerFile = "resources\\distribuidores.tcsv";
		String costumerFile = "resources\\clientes.tcsv";
		String product1File = "resources\\produtos1.tcsv";
		String product2File = "resources\\produtos2.tcsv";
//		String file = "C:\\Users\\DESENVOLVIMENTO04\\Desktop\\projetos.tcsv";
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

		System.out.println("\nListar arquivo de projetos...");
		while ((line = brCsvContent.readLine()) != null) {

			System.out.print("[Projeto " + ++counter + "] ");

			artifact = line.split(fieldSeparator);
			for (String a : artifact) {
				System.out.print(a + ", ");
			}
			System.out.println("\n");

		}

		System.out.println("\nLer arquivo de distribuidores...");
		counter = 0;
		try {
			brCsvContent = new BufferedReader(new FileReader(dealerFile));
		} catch (IOException e) {
			System.out.println("\nERRO na leitura em [ " + dealerFile + " ] .\n");
			e.printStackTrace();
		}

		System.out.println("\nListar arquivo de distribuidores...");
		while ((line = brCsvContent.readLine()) != null) {

			System.out.print("[Distribuidor " + ++counter + "] ");

			artifact = line.split(fieldSeparator);
			for (String a : artifact) {
				System.out.print(a + ", ");
			}
			System.out.println("\n");

		}

		System.out.println("\nLer arquivo de clientes...");
		counter = 0;
		try {
			brCsvContent = new BufferedReader(new FileReader(costumerFile));
		} catch (IOException e) {
			System.out.println("\nERRO na leitura em [ " + costumerFile + " ] .\n");
			e.printStackTrace();
		}

		System.out.println("\nListar arquivo de clientes...");
		while ((line = brCsvContent.readLine()) != null) {

			System.out.print("[Cliente " + ++counter + "] ");

			artifact = line.split(fieldSeparator);
			for (String a : artifact) {
				System.out.print(a + ", ");
			}
			System.out.println("\n");

		}

		System.out.println("\nLer arquivo de produtos-1...");
		counter = 0;
		try {
			brCsvContent = new BufferedReader(new FileReader(product1File));
		} catch (IOException e) {
			System.out.println("\nERRO na leitura em [ " + product1File + " ] .\n");
			e.printStackTrace();
		}

		System.out.println("\nListar arquivo de produtos-1...");
		while ((line = brCsvContent.readLine()) != null) {

			System.out.print("[Produto-1 " + ++counter + "] ");

			artifact = line.split(fieldSeparator);
			for (String a : artifact) {
				System.out.print(a + ", ");
			}
			System.out.println("\n");

		}

		System.out.println("\nLer arquivo de produtos-2...");
		counter = 0;
		try {
			brCsvContent = new BufferedReader(new FileReader(product2File));
		} catch (IOException e) {
			System.out.println("\nERRO na leitura em [ " + product2File + " ] .\n");
			e.printStackTrace();
		}

		System.out.println("\nListar arquivo de produtos-2...");
		while ((line = brCsvContent.readLine()) != null) {

			System.out.print("[Produto-2 " + ++counter + "] ");

			artifact = line.split(fieldSeparator);
			for (String a : artifact) {
				System.out.print(a + ", ");
			}
			System.out.println("\n");

		}

		System.out.println("\nfim\n");
	}

}
