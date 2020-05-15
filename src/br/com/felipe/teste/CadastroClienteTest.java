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
		felipe.setBairro("cristo");
		felipe.setCelular("(83)998636548");
		felipe.setCep("58039-632");
		felipe.setCidade("joao pessOA");
		felipe.setComplemento("CASA");
		felipe.setCpf("056.458.954-87");
		felipe.setEmail("felipe@gmail.com");
		felipe.setEndereco("RUA FULANO DE TAL");
		felipe.setEstado("PB");
		felipe.setNome("Felipe");
		felipe.setNumero(1675);
		felipe.setRg("256785");
		felipe.setTelefone("(83)998636548");
		
		//Ações
		
		//ClientesDAO c = new ClientesDAO();
		//c.inserirCliente(felipe);
		
		
		
		//Validação
		
		String bairroEsperado = "CRISTO";
		String celularEsperado = "83998636548";
		String cepEsperado = "58039632";
		String cidadeEsperado = "JOAO PESSOA";
		String complementoEsperado = "CASA";
		String cpfEsperado = new String("05645895487");
		String emailEsperado = "FELIPE@GMAIL.COM";
		String enderecoEsperado = "RUA FULANO DE TAL";
		String estadoEsperado = "PB";
		String nomeEsperado = "FELIPE";
		int numeroEsperado = 1675;
		String rgEsperado = "256785";
		String telefoneEsperado = "83998636548";
		
		Assert.assertEquals(nomeEsperado, felipe.getNome());
		Assert.assertEquals(bairroEsperado, felipe.getBairro());
		Assert.assertEquals(celularEsperado, felipe.getCelular());
		Assert.assertEquals(cidadeEsperado, felipe.getCidade());
		Assert.assertEquals(complementoEsperado, felipe.getComplemento());
		Assert.assertEquals(cpfEsperado, felipe.getCpf());
		Assert.assertEquals(emailEsperado, felipe.getEmail());
		Assert.assertEquals(enderecoEsperado, felipe.getEndereco());
		Assert.assertEquals(estadoEsperado, felipe.getEstado());
		Assert.assertEquals(numeroEsperado, felipe.getNumero());
		Assert.assertEquals(rgEsperado, felipe.getRg());
		Assert.assertEquals(telefoneEsperado, felipe.getTelefone());
		Assert.assertEquals(cepEsperado, felipe.getCep());
		
	}
	
}
