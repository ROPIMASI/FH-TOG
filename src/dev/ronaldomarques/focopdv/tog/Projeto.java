package dev.ronaldomarques.focopdv.tog;

import java.util.List;

public class Projeto {
	private String representante;
	private List<String> laboratorios;
	private List<String> distribuidores;

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public List<String> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<String> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public List<String> getDistribuidores() {
		return distribuidores;
	}

	public void setDistribuidores(List<String> distribuidores) {
		this.distribuidores = distribuidores;
	}

}
