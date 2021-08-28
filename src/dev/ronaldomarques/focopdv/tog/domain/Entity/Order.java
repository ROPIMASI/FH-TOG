package dev.ronaldomarques.focopdv.tog.domain.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;



public class Order {
	
	private String id;
	private Representation rep;
	private Laboratory lab;
	private Distributor dis;
	private Costumer cli;
	private String numPedInd;
	private LocalDate data;
	private LocalDateTime hora;
	private String przPgto;
	private String numPedCli;
	private BigDecimal valTotPed;
	
	
	
	public String getId() { return id; }
	
	
	
	public void setId(String id) { this.id = id; }
	
	
	
	public Representation getRep() { return rep; }
	
	
	
	public void setRep(Representation rep) { this.rep = rep; }
	
	
	
	public Laboratory getLab() { return lab; }
	
	
	
	public void setLab(Laboratory lab) { this.lab = lab; }
	
	
	
	public Distributor getDis() { return dis; }
	
	
	
	public void setDis(Distributor dis) { this.dis = dis; }
	
	
	
	public Costumer getCli() { return cli; }
	
	
	
	public void setCli(Costumer cli) { this.cli = cli; }
	
	
	
	public String getNumPedInd() { return numPedInd; }
	
	
	
	public void setNumPedInd(String numPedInd) { this.numPedInd = numPedInd; }
	
	
	
	public LocalDate getData() { return data; }
	
	
	
	public void setData(LocalDate data) { this.data = data; }
	
	
	
	public LocalDateTime getHora() { return hora; }
	
	
	
	public void setHora(LocalDateTime hora) { this.hora = hora; }
	
	
	
	public String getPrzPgto() { return przPgto; }
	
	
	
	public void setPrzPgto(String przPgto) { this.przPgto = przPgto; }
	
	
	
	public String getNumPedCli() { return numPedCli; }
	
	
	
	public void setNumPedCli(String numPedCli) { this.numPedCli = numPedCli; }
	
	
	
	public BigDecimal getValTotPed() { return valTotPed; }
	
	
	
	public void setValTotPed(BigDecimal valTotPed) { this.valTotPed = valTotPed; }
	
}
