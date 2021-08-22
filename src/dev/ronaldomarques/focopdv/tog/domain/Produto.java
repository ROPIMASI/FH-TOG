package dev.ronaldomarques.focopdv.tog.domain;

import java.math.BigDecimal;

public class Produto {
	private String ean1;
	private String nome;
	private BigDecimal preço = new BigDecimal(0);

	public String getEan1() {
		return ean1;
	}

	public void setEan1(String ean1) {
		this.ean1 = ean1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreço() {
		return preço;
	}

	public void setPreço(BigDecimal preço) {
		this.preço = preço;
	}

}
