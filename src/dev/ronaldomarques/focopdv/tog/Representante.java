package dev.ronaldomarques.focopdv.tog;

import java.util.List;

public class Representante {
	private String nome;
	private List<Laboratorio> laboratorios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

}
