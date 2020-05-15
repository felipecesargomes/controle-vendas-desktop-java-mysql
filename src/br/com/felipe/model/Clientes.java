package br.com.felipe.model;

import br.com.felipe.util.Tratamentos;

public class Clientes {

	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private String telefone;
	private String celular;
	private String cep;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = Tratamentos.removerAcentosUpperCase(nome);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = Tratamentos.removerAcentosUpperCase(rg);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = Tratamentos.removerPontos(cpf);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = Tratamentos.removerAcentosUpperCase(email);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = Tratamentos.removerPontos(telefone);
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = Tratamentos.removerPontos(celular);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = Tratamentos.removerPontos(cep);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = Tratamentos.removerAcentosUpperCase(endereco);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = Integer.parseInt(Tratamentos.removerPontos(Integer.toString(numero)));
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = Tratamentos.removerAcentosUpperCase(complemento);
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = Tratamentos.removerAcentosUpperCase(bairro);
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = Tratamentos.removerAcentosUpperCase(cidade);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = Tratamentos.removerAcentosUpperCase(estado);
	}

}
