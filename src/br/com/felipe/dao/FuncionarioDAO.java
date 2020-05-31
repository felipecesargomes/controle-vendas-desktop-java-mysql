package br.com.felipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.felipe.jdbc.ConnectionFactory;
import br.com.felipe.model.Funcionarios;
import br.com.felipe.util.WebServiceCep;

public class FuncionarioDAO {

	/**
	 * @author Felipe César
	 */

	private Connection conn;

	public FuncionarioDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	// Método cadastrar funcionário

	public void inserirFuncionario(Funcionarios f) {
		try {
			String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getRg());
			stmt.setString(3, f.getCpf());
			stmt.setString(4, f.getEmail());
			stmt.setString(5, f.getSenha());
			stmt.setString(6, f.getCargo());
			stmt.setString(7, f.getNivelAcesso());
			stmt.setString(8, f.getTelefone());
			stmt.setString(9, f.getCelular());
			stmt.setString(10, f.getCep());
			stmt.setString(11, f.getEndereco());
			stmt.setInt(12, f.getNumero());
			stmt.setString(13, f.getComplemento());
			stmt.setString(14, f.getBairro());
			stmt.setString(15, f.getCidade());
			stmt.setString(16, f.getEstado());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
		}
	}

	public void atualizarFuncionarios(Funcionarios f) {
		try {
			String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getRg());
			stmt.setString(3, f.getCpf());
			stmt.setString(4, f.getEmail());
			stmt.setString(5, f.getSenha());
			stmt.setString(6, f.getCargo());
			stmt.setString(7, f.getNivelAcesso());
			stmt.setString(8, f.getTelefone());
			stmt.setString(9, f.getCelular());
			stmt.setString(10, f.getCep());
			stmt.setString(11, f.getEndereco());
			stmt.setInt(12, f.getNumero());
			stmt.setString(13, f.getComplemento());
			stmt.setString(14, f.getBairro());
			stmt.setString(15, f.getCidade());
			stmt.setString(16, f.getEstado());
			stmt.setLong(14, f.getId());

			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
		}
	}

	public void apagarFuncionario(Funcionarios f) {
		try {
			String sql = "delete from tb_funcionarios where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, f.getId());
			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Usuário apagado com sucesso!");
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
		}

	}

	public List<Funcionarios> listarFuncionarios() {

		try {
			List<Funcionarios> lista = new ArrayList<Funcionarios>();
			String sql = "select * from tb_funcionarios";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionarios obj = new Funcionarios();
				obj.setId(rs.getLong("id"));
				obj.setNome(rs.getString("nome"));
				obj.setRg(rs.getString("rg"));
				obj.setCpf(rs.getString("cpf"));
				obj.setEmail(rs.getString("email"));
				obj.setSenha(rs.getString("senha"));
				obj.setCargo(rs.getString("cargo"));
				obj.setNivelAcesso(rs.getString("nivel_acesso"));
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

	public Funcionarios pesquisaPorNome(String nome) {
		try {
			String sql = "select * from tb_funcionarios where nome = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			Funcionarios obj = new Funcionarios();
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

	public Funcionarios buscaCep(String cep) {

		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Funcionarios obj = new Funcionarios();

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

	public List<Funcionarios> buscarPorNome(String nome) {
		try {
			List<Funcionarios> lista = new ArrayList<Funcionarios>();
			String sql = "select * from tb_funcionarios where nome like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionarios obj = new Funcionarios();
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
				obj.setSenha(rs.getString("senha"));
				obj.setCargo(rs.getString("cargo"));
				obj.setNivelAcesso(rs.getString("nivel_Acesso"));

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