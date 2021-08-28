package dev.ronaldomarques.focopdv.tog.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import dev.ronaldomarques.focopdv.tog.domain.Entity.Project;



public class ProjectRepository {
	
	private final String PROJECTS_PATH_FILE = "resources\\projetos.tcsv";
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
	public boolean hasProject() {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				if (aRecord.length == 5) return true;
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
	public boolean hasProject(String r, String l, String d) {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 5) && (aRecord[0].equalsIgnoreCase(r)) && (aRecord[1].equalsIgnoreCase(l))
						&& (aRecord[2].equalsIgnoreCase(d))) {
					return true;
				}
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	/* Se tem algum projeto na lista com representante r, então true, se não false. */
	public boolean hasProjectByRepresentation(String r) {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 5) && (aRecord[0].equalsIgnoreCase(r))) { return true; }
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	/* Se tem algum projeto na lista com laboratório l, então true, se não false. */
	public boolean hasProjectByLaboratory(String l) {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 5) && (aRecord[1].equalsIgnoreCase(l))) { return true; }
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	/* Se tem algum projeto na lista com distribuidor d, então true, se não false. */
	public boolean hasProjectByDistributor(String d) {
		
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 5) && (aRecord[2].equalsIgnoreCase(d))) { return true; }
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
	public Optional<Project> getProjectByRepName(String repName) {
		
		Project rtnProj = null;
		BufferedReader brCsvContent = null;
		String line = "";
		String[] aRecord = null;
		
		brCsvContent = loadFile(PROJECTS_PATH_FILE);
		
		try {
			
			while ((line = brCsvContent.readLine()) != null) {
				aRecord = line.split(FILD_SEPARATOR);
				
				if ((aRecord.length == 5) && (aRecord[0].equalsIgnoreCase(repName))) {
					rtnProj = new Project();
					rtnProj.setRepresentation(null);// FIXME: trocar null por uma instancia do representation.
					rtnProj.setLaboratory(null); // FIXME: trocar null por uma instancia do laboratory.
					rtnProj.setDistributor(null); // FIXME: trocar null por uma instancia do distributor.
					rtnProj.setOnOffStatus((aRecord[3] == "1") ? true : false);
					rtnProj.setResourcesFolder(aRecord[4]);
				}
				
			}
			
		}
		catch (IOException e) {
			System.out.println("\n" + ERR_FILE_SWEEPING + PROJECTS_PATH_FILE + "\n");
			e.printStackTrace();
		}
		
		return Optional.of(rtnProj);
		
	}
	
}
