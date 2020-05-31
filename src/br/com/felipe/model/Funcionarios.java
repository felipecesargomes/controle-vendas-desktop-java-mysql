package br.com.felipe.model;

import br.com.felipe.util.Tratamentos;

public class Funcionarios extends Clientes {

	/**
	 * @author Felipe César
	 */
	
	private String senha;
	private String cargo;
	private String nivelAcesso;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = Tratamentos.removerAcentosUpperCase(cargo);
	}
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = Tratamentos.removerAcentosUpperCase(nivelAcesso);
	}
	
}
