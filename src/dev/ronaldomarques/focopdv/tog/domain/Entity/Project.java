package dev.ronaldomarques.focopdv.tog.domain.Entity;

public class Project {
	
	private Representation representation;
	private Laboratory laboratory;
	private Distributor distributor;
	private boolean onOffStatus;
	private String resourcesFolder;
	
	
	
	public Representation getRepresentation() { return this.representation; }
	
	
	
	public void setRepresentation(Representation representation) { this.representation = representation; }
	
	
	
	public Laboratory getLaboratory() { return this.laboratory; }
	
	
	
	public void setLaboratory(Laboratory laboratory) { this.laboratory = laboratory; }
	
	
	
	public Distributor getDistributor() { return this.distributor; }
	
	
	
	public void setDistributor(Distributor distributor) { this.distributor = distributor; }
	
	
	
	public boolean isOnOffStatus() { return this.onOffStatus; }
	
	
	
	public void setOnOffStatus(boolean onOffStatus) { this.onOffStatus = onOffStatus; }
	
	
	
	public String getResourcesFolder() { return this.resourcesFolder; }
	
	
	
	public void setResourcesFolder(String resourcesFolder) { this.resourcesFolder = resourcesFolder; }
	
}
