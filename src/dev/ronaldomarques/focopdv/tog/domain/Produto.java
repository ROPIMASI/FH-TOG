package dev.ronaldomarques.focopdv.tog.domain;

import java.math.BigDecimal;

public class Produto {
	private String ean1;
	private String nome;
	private BigDecimal pre�o = new BigDecimal(0);

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

	public BigDecimal getPre�o() {
		return pre�o;
	}

	public void setPre�o(BigDecimal pre�o) {
		this.pre�o = pre�o;
	}

}
