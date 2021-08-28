package dev.ronaldomarques.focopdv.tog.domain.Entity;

public class Distributor {
	
	private String name;
	private String cnpj;
	private String city;
	private String fu; // Federal Unit, State, Province.
	private String resourcesFolder;
	// private List<Costumer> clientes;
	
	
	
	public Distributor() { super(); }
	
	
	
	public Distributor(String name) {
		
		super();
		this.name = name;
		
	}
	
	
	
	public Distributor(String name, String cnpj) {
		
		super();
		this.name = name;
		this.cnpj = cnpj;
		
	}
	
	
	
	public Distributor(String name, String cnpj, String fu, String city) {
		
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.fu = fu;
		this.city = city;
		
	}
	
	
	
	public Distributor(String name, String cnpj, String fu, String city, String resourcesFolder) {
		
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.fu = fu;
		this.city = city;
		this.resourcesFolder = resourcesFolder;
		
	}
	
	
	
	public String getName() { return this.name; }
	
	
	
	public void setName(String name) { this.name = name; }
	
	
	
	public String getCnpj() { return this.cnpj; }
	
	
	
	public void setCnpj(String cnpj) { this.cnpj = cnpj; }
	
	
	
	public String getCity() { return this.city; }
	
	
	
	public void setCity(String city) { this.city = city; }
	
	
	
	public String getFu() { return this.fu; }
	
	
	
	public void setFu(String fu) { this.fu = fu; }
	
	
	
	public String getResourcesFolder() { return this.resourcesFolder; }
	
	
	
	public void setResourcesFolder(String resourcesFolder) { this.resourcesFolder = resourcesFolder; }
	
}
