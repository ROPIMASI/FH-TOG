package dev.ronaldomarques.focopdv.tog.domain.Entity;

import java.math.BigDecimal;



public class Product {
	
	private String ean1;
	private String nome;
	private BigDecimal preco = new BigDecimal(0);
	
	
	
	public String getEan1() { return ean1; }
	
	
	
	public void setEan1(String ean1) { this.ean1 = ean1; }
	
	
	
	public String getNome() { return nome; }
	
	
	
	public void setNome(String nome) { this.nome = nome; }
	
	
	
	public BigDecimal getPreco() { return preco; }
	
	
	
	public void setPreco(BigDecimal preco) { this.preco = preco; }
	
}
