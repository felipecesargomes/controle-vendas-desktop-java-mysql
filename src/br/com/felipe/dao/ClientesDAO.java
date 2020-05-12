package br.com.felipe.dao;

import java.sql.*;

import javax.swing.JOptionPane;

import br.com.felipe.jdbc.ConnectionFactory;
import br.com.felipe.model.Clientes;

public class ClientesDAO {

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

	}

	public void apagarCliente(Clientes c) {

	}

}
