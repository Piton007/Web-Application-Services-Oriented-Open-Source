package edu.upc.taller.model;

public enum StatusTecnico {
	
	//OCUPADO(0), DISPONIBLE(1)
	OCCUPIED(0), AVAILABLE(1);
	
	private final int codeStatusTecnico;
	
	StatusTecnico(int codeStatusTecnico) {
		this.codeStatusTecnico=codeStatusTecnico;
	}

	public int getCodeStatusTecnico() {
		return this.codeStatusTecnico;
	}
}
