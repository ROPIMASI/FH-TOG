package dev.ronaldomarques.focopdv.tog.domain.Entity;

import java.util.List;



public class Laboratory {
	
	private String name;
	private List<Product> products;
	private String resourcesFolder;
	
	
	
	public Laboratory() { super(); }
	
	
	
	public Laboratory(String name) {
		
		super();
		this.name = name;
		
	}
	
	
	
	public Laboratory(String name, String resourcesFolder) {
		
		super();
		this.name = name;
		this.resourcesFolder = resourcesFolder;
		
	}
	
	
	
	public Laboratory(String name, List<Product> products, String resourcesFolder) {
		
		super();
		this.name = name;
		this.products = products;
		this.resourcesFolder = resourcesFolder;
		
	}
	
	
	
	public String getName() { return this.name; }
	
	
	
	public void setName(String name) { this.name = name; }
	
	
	
	public List<Product> getProdutos() { return this.products; }
	
	
	
	public void setProdutos(List<Product> products) { this.products = products; }
	
	
	
	public String getResourcesFolder() { return this.resourcesFolder; }
	
	
	
	public void setResourcesFolder(String resourcesFolder) { this.resourcesFolder = resourcesFolder; }
	
}
