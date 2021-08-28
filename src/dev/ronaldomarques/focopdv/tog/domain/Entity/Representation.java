package dev.ronaldomarques.focopdv.tog.domain.Entity;

import java.util.List;



public class Representation {
	
	private String nome;
	private List<Costumer> costumers;
	private List<Laboratory> laboratories;
	
	
	
	public Representation() { super(); }
	
	
	
	public Representation(String nome) {
		
		super();
		this.nome = nome;
		
	}
	
	
	
	public Representation(String nome, List<Costumer> costumers, List<Laboratory> laboratories) {
		
		super();
		this.nome = nome;
		this.costumers = costumers;
		this.laboratories = laboratories;
		
	}
	
	
	
	public String getNome() { return nome; }
	
	
	
	public void setNome(String nome) { this.nome = nome; }
	
	
	
	public List<Costumer> getClientes() { return costumers; }
	
	
	
	public void setClientes(List<Costumer> costumers) { this.costumers = costumers; }
	
	
	
	public List<Laboratory> getLaboratorios() { return laboratories; }
	
	
	
	public void setLaboratorios(List<Laboratory> laboratories) { this.laboratories = laboratories; }
	
}
