package dev.ronaldomarques.focopdv.tog.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import dev.ronaldomarques.focopdv.tog.domain.Entity.Laboratory;



public class LaboratoryRepository {
	
	private final String PROJECTS_PATH_FILE = "resources\\laboratorios.tcsv";
	private final String FILD_SEPARATOR = ";";
	private final String ERR_PATH_FILE_NOT_FOUND = "ERRO de caminho e/ou arquivo não encontrado: ";
	private final String ERR_FILE_SWEEPING = "ERRO na varredura do arquivo: ";
	
	
	
	/* Carregador de arquivo texto ou cs para um BufferedReader. */
	private BufferedReader loadFile(String pf) {
		
		BufferedReader brCsvContent = null;
		
		try {
			brCsvContent = new BufferedReader(new FileReader(pf));
		}
		catch (FileNotFoundException excep) {
			System.out.println("\n" + ERR_PATH_FILE_NOT_FOUND + pf + "\n");
			excep.printStackTrace();
		}
		
		return brCsvContent;
		
	}
	
	
	
	/* Se tem algum projeto na lista, então true, se não false. */
	public boolean hasLaboratory() {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				if (aRecord.length == 2) return true;
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	/* Se tem algum projeto na listas com os 3 itens representante r laboratório l distribuidor r,
	 * então true, se não false. */
	public boolean hasLaboratoryByLabName(String labName) {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 2) && (aRecord[0].equalsIgnoreCase(labName))) { return true; }
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	public Optional<Laboratory> getLaboratoryByLabName(String labName) {
		
		Laboratory rtnLab = null;
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 2) && (aRecord[0].equalsIgnoreCase(labName))) {
					rtnLab = new Laboratory();
					rtnLab.setName(aRecord[0]);
					
					rtnLab.setResourcesFolder(aRecord[1]);
				}
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return Optional.of(rtnLab);
		
	}
	
}
