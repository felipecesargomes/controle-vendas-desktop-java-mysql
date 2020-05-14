package br.com.felipe.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.felipe.model.Clientes;

public class CadastroClienteTest {

	@Test
	public void main() {
		
		//Cenário
		
		Clientes felipe = new Clientes();
		
		felipe.setId(40L);
		felipe.setBairro("Tambau");
		felipe.setCelular("832");
		felipe.setCep("999");
		felipe.setCidade("JP");
		felipe.setComplemento("Rua");
		felipe.setCpf("22");
		felipe.setEmail("teste");
		felipe.setEndereco("OK");
		felipe.setEstado("PB");
		felipe.setNome("Felipe");
		felipe.setNumero(999);
		felipe.setRg("22");
		felipe.setTelefone("22");
		
		//Ações
		
		//ClientesDAO c = new ClientesDAO();
		//c.inserirCliente(felipe);
		
		
		
		//Validação
		
		String bairroEsperado = "CRISTO";
		String celularEsperado = "83998636548";
		String cepEsperado = "58039632";
		String cidadeEsperada = "JOAO PESSOA";
		String complementoEsperado = "CASA";
		String cpfEsperado = new String("056458954");
		String emailEsperado = "FELIPE@GMAIL.COM";
		String enderecoEsperado = "RUA FULANO DE TAL";
		String estadoEsperado = "PB";
		String nomeEsperado = "FELIPE";
		String numeroEsperado = "1675";
		String rgEsperado = "256785";
		String telefoneEsperado = "83998636548";
		
		Assert.assertEquals(nomeEsperado, felipe.getNome());
		
	}
	
}
