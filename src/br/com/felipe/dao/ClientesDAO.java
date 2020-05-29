package br.com.felipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.felipe.jdbc.ConnectionFactory;
import br.com.felipe.model.Clientes;
import br.com.felipe.util.WebServiceCep;

public class ClientesDAO {

	/**
	 * @author Felipe César
	 */

	private Connection conn;

	public ClientesDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public void inserirCliente(Clientes c) {
		try {
			String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getRg());
			stmt.setString(3, c.getCpf());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getTelefone());
			stmt.setString(6, c.getCelular());
			stmt.setString(7, c.getCep());
			stmt.setString(8, c.getEndereco());
			stmt.setInt(9, c.getNumero());
			stmt.setString(10, c.getComplemento());
			stmt.setString(11, c.getBairro());
			stmt.setString(12, c.getCidade());
			stmt.setString(13, c.getEstado());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
		}
	}

	public void atualizarCliente(Clientes c) {
		try {
			String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getRg());
			stmt.setString(3, c.getCpf());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getTelefone());
			stmt.setString(6, c.getCelular());
			stmt.setString(7, c.getCep());
			stmt.setString(8, c.getEndereco());
			stmt.setInt(9, c.getNumero());
			stmt.setString(10, c.getComplemento());
			stmt.setString(11, c.getBairro());
			stmt.setString(12, c.getCidade());
			stmt.setString(13, c.getEstado());
			stmt.setLong(14, c.getId());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
		}
	}

	public void apagarCliente(Clientes c) {
		try {
			String sql = "delete from tb_clientes where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, c.getId());
			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Usuário apagado com sucesso!");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
		}

	}

	public List<Clientes> listarClientes() {

		try {
			List<Clientes> lista = new ArrayList<Clientes>();
			String sql = "select * from tb_clientes";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Clientes obj = new Clientes();
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setRg(rs.getString("rg"));
				obj.setCpf(rs.getString("cpf"));
				obj.setEmail(rs.getString("email"));
				obj.setBairro(rs.getString("bairro"));
				obj.setCelular(rs.getString("celular"));
				obj.setCep(rs.getString("cep"));
				obj.setCidade(rs.getString("cidade"));
				obj.setComplemento(rs.getString("complemento"));
				obj.setEndereco(rs.getString("endereco"));
				obj.setEstado(rs.getString("estado"));
				obj.setNumero(rs.getInt("numero"));
				obj.setTelefone(rs.getString("telefone"));

				lista.add(obj);

			}
			return lista;
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
			return null;
		}
	}
	
	public Clientes pesquisaPorNome(String nome) {
		try {
			String sql = "select * from tb_clientes where nome = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			Clientes obj = new Clientes();
			if (rs.next()) {
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setRg(rs.getString("rg"));
				obj.setCpf(rs.getString("cpf"));
				obj.setEmail(rs.getString("email"));
				obj.setBairro(rs.getString("bairro"));
				obj.setCelular(rs.getString("celular"));
				obj.setCep(rs.getString("cep"));
				obj.setCidade(rs.getString("cidade"));
				obj.setComplemento(rs.getString("complemento"));
				obj.setEndereco(rs.getString("endereco"));
				obj.setEstado(rs.getString("estado"));
				obj.setNumero(rs.getInt("numero"));
				obj.setTelefone(rs.getString("telefone"));
			}
				return obj;
		} catch (Exception e) {
			return null;
		}
	}
	
	  public Clientes buscaCep(String cep) {
	       
	        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
	       

	        Clientes obj = new Clientes();

	        if (webServiceCep.wasSuccessful()) {
	            obj.setEndereco(webServiceCep.getLogradouroFull());
	            obj.setCidade(webServiceCep.getCidade());
	            obj.setBairro(webServiceCep.getBairro());
	            obj.setEstado(webServiceCep.getUf());
	            return obj;
	        } else {
	            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
	            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
	            return null;
	        }
	  }

	public List<Clientes> buscarPorNome(String nome) {
		try {
			List<Clientes> lista = new ArrayList<Clientes>();
			String sql = "select * from tb_clientes where nome like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Clientes obj = new Clientes();
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setRg(rs.getString("rg"));
				obj.setCpf(rs.getString("cpf"));
				obj.setEmail(rs.getString("email"));
				obj.setBairro(rs.getString("bairro"));
				obj.setCelular(rs.getString("celular"));
				obj.setCep(rs.getString("cep"));
				obj.setCidade(rs.getString("cidade"));
				obj.setComplemento(rs.getString("complemento"));
				obj.setEndereco(rs.getString("endereco"));
				obj.setEstado(rs.getString("estado"));
				obj.setNumero(rs.getInt("numero"));
				obj.setTelefone(rs.getString("telefone"));

				lista.add(obj);
			}
			return lista;
		} catch (SQLException erro) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro: " + erro);
			return null;
		}
	}
}
