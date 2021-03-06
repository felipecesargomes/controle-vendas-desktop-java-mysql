package br.com.felipe.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.felipe.dao.ClientesDAO;
import br.com.felipe.model.Clientes;
import br.com.felipe.util.LimpaTela;
import br.com.felipe.util.WebServiceCep;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmCliente extends JFrame {

	/**
	 * @author Felipe C�sar
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField txtEmail;
	private MaskFormatter mascaraCelular;
	private MaskFormatter mascaraTelefoneFixo;
	private MaskFormatter mascaraCep;
	private MaskFormatter mascaraCpf;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtRg;
	private JFormattedTextField txtCpf;
	private JTextField txtNumero;
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtTel;
	private JFormattedTextField txtCep;
	private JTextField txtNomePesquisa;
	private JComboBox<String> cbUf;
	private JTable tabelaClientes;

	public static void main(String[] args) {
		
		try {
			// Foreach para escolhe o tema do windows
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows Classic".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	// Metodo Listar na Tabela (TOTAL)
	public void listar() {
		ClientesDAO dao = new ClientesDAO();
		java.util.List<Clientes> lista = dao.listarClientes();
		DefaultTableModel dados = (DefaultTableModel) tabelaClientes.getModel();
		dados.setNumRows(0);

		for (Clientes c : lista) {
			dados.addRow(new Object[] {
					c.getId(),
					c.getNome(),
					c.getEmail(),
					c.getCelular(),
					c.getTelefone(),
					c.getCep(),
					c.getEndereco(),
					c.getNumero(),
					c.getBairro(),
					c.getCidade(),
					c.getComplemento(),
					c.getEstado(),
					c.getCpf(),
					c.getRg()
			});
		}
			
	}
	
	// Metodo Lista por Nome
	public void listarPorNome() {
		String nome = "%" + txtNomePesquisa.getText() + "%";
		
		ClientesDAO dao = new ClientesDAO();
		java.util.List<Clientes> lista = dao.buscarPorNome(nome);
		DefaultTableModel dados = (DefaultTableModel) tabelaClientes.getModel();
		dados.setNumRows(0);
		
		if(!lista.isEmpty()) {
			for (Clientes c : lista) {
				dados.addRow(new Object[] {
						c.getId(),
						c.getNome(),
						c.getEmail(),
						c.getCelular(),
						c.getTelefone(),
						c.getCep(),
						c.getEndereco(),
						c.getNumero(),
						c.getBairro(),
						c.getCidade(),
						c.getComplemento(),
						c.getEstado(),
						c.getCpf(),
						c.getRg()
				});
			}
		} else {
			dados.setNumRows(0);
		}
		
			
	}

	public FrmCliente() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				listar();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			mascaraCelular = new MaskFormatter("(##)####-####");
			mascaraTelefoneFixo = new MaskFormatter("(##)####-####");
			mascaraCep = new MaskFormatter("#####-###");
			mascaraCpf = new MaskFormatter("###.###.###-##");

		} catch (java.text.ParseException excp) {
			JOptionPane.showMessageDialog(null, "Erro na formata��o!");
		}

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 834, 60);
		panel.setBackground(new Color(0, 102, 204));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel tituloCadastroCliente = new JLabel("Cadastro de Clientes");
		tituloCadastroCliente.setForeground(Color.white);
		tituloCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		tituloCadastroCliente.setBackground(Color.WHITE);
		tituloCadastroCliente.setBounds(260, 16, 307, 24);
		panel.add(tituloCadastroCliente);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 71, 807, 250);
		contentPane.add(tabbedPane_1);

		JPanel painelDadosPessoais = new JPanel();
		tabbedPane_1.addTab("Dados Pessoais", null, painelDadosPessoais, null);
		painelDadosPessoais.setLayout(null);

		JLabel codigoDadosPessoais = new JLabel("C\u00F3digo:");
		codigoDadosPessoais.setBounds(10, 26, 44, 14);
		painelDadosPessoais.add(codigoDadosPessoais);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(53, 23, 44, 20);
		painelDadosPessoais.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel nomeCodigo = new JLabel("Nome:");
		nomeCodigo.setBounds(10, 52, 44, 14);
		painelDadosPessoais.add(nomeCodigo);

		textNome = new JTextField();
		textNome.setBounds(53, 49, 216, 20);
		textNome.setHorizontalAlignment(SwingConstants.LEFT);
		painelDadosPessoais.add(textNome);
		textNome.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 80, 44, 14);
		painelDadosPessoais.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(53, 77, 216, 20);
		painelDadosPessoais.add(txtEmail);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(279, 80, 49, 14);
		painelDadosPessoais.add(lblCelular);

		txtCelular = new JFormattedTextField(mascaraCelular);
		txtCelular.setBounds(329, 77, 131, 20);
		painelDadosPessoais.add(txtCelular);

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setBounds(476, 80, 78, 14);
		painelDadosPessoais.add(lblTelefoneFixo);

		txtTel = new JFormattedTextField(mascaraTelefoneFixo);
		txtTel.setBounds(555, 77, 162, 20);
		painelDadosPessoais.add(txtTel);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 108, 44, 14);
		painelDadosPessoais.add(lblCep);

		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
			         Clientes obj =  new Clientes();
			         ClientesDAO dao = new ClientesDAO();
			         obj = dao.buscaCep(txtCep.getText());
			         
			         txtEndereco.setText(obj.getEndereco());
			         txtBairro.setText(obj.getBairro());
			         txtCidade.setText(obj.getCidade());
			         cbUf.setSelectedItem(obj.getEstado());               			         
			     }
				
			}
		});
		txtCep.setBounds(53, 105, 96, 20);
		painelDadosPessoais.add(txtCep);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(159, 108, 55, 14);
		painelDadosPessoais.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(215, 105, 369, 20);
		painelDadosPessoais.add(txtEndereco);

		JLabel lblN = new JLabel("N\u00FAmero:");
		lblN.setBounds(594, 108, 55, 14);
		painelDadosPessoais.add(lblN);

		txtNumero = new JTextField();
		txtNumero.setBounds(648, 105, 144, 20);
		txtNumero.setColumns(10);
		painelDadosPessoais.add(txtNumero);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 136, 44, 14);
		painelDadosPessoais.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(53, 133, 162, 20);
		painelDadosPessoais.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(225, 136, 37, 14);
		painelDadosPessoais.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(275, 136, 162, 20);
		painelDadosPessoais.add(txtCidade);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(451, 136, 74, 14);
		painelDadosPessoais.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(528, 133, 162, 20);
		painelDadosPessoais.add(txtComplemento);

		JLabel lblUF = new JLabel("UF:");
		lblUF.setBounds(707, 136, 19, 14);
		painelDadosPessoais.add(lblUF);

		cbUf = new JComboBox<String>();
		cbUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUf.setBounds(735, 133, 57, 20);
		painelDadosPessoais.add(cbUf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 167, 44, 14);
		painelDadosPessoais.add(lblRg);

		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(53, 164, 162, 20);
		painelDadosPessoais.add(txtRg);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(225, 167, 31, 14);
		painelDadosPessoais.add(lblCpf);

		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setColumns(10);
		txtCpf.setBounds(275, 164, 162, 20);
		painelDadosPessoais.add(txtCpf);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				ClientesDAO cdao = new ClientesDAO();
				Clientes obj = cdao.pesquisaPorNome(nome);
				if(obj.getNome() != null) {
					textCodigo.setText(obj.getId().toString());
					textNome.setText(obj.getNome());
					txtEmail.setText(obj.getEmail());
					txtCelular.setText(obj.getCelular());
					txtTel.setText(obj.getTelefone());
					txtCep.setText(obj.getCep());
					txtEndereco.setText(obj.getEndereco());
					txtNumero.setText(String.valueOf(obj.getNumero()));
					txtBairro.setText(obj.getBairro());
					txtCidade.setText(obj.getCidade());
					txtComplemento.setText(obj.getComplemento());
					cbUf.setSelectedItem(obj.getEstado());
					txtCpf.setText(obj.getCpf());
					txtRg.setText(obj.getRg());	
				} else {
					JOptionPane.showMessageDialog(null, "N�o existe esse cadastro no banco.");
				}
			}
		});
		btnPesquisa.setBounds(279, 50, 89, 18);
		painelDadosPessoais.add(btnPesquisa);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Consulta de Clientes", null, panel_1, null);
		panel_1.setLayout(null);

		txtNomePesquisa = new JTextField();
		txtNomePesquisa.setColumns(10);
		txtNomePesquisa.setBounds(53, 23, 196, 20);
		panel_1.add(txtNomePesquisa);

		JLabel nomePesquisa = new JLabel("Nome:");
		nomePesquisa.setBounds(10, 26, 44, 14);
		panel_1.add(nomePesquisa);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listarPorNome();
			}
		});
		btnPesquisar.setBounds(259, 22, 89, 21);
		panel_1.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 782, 157);
		panel_1.add(scrollPane);

		tabelaClientes = new JTable();
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane_1.setSelectedIndex(0);
				textCodigo.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0).toString());
				textNome.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1).toString());
				txtEmail.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 2).toString());
				txtCelular.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 3).toString());
				txtTel.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 4).toString());
				txtCep.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 5).toString());
				txtEndereco.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 6).toString());
				txtNumero.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 7).toString());
				txtBairro.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 8).toString());
				txtCidade.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 9).toString());
				txtComplemento.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 10).toString());
				cbUf.setSelectedItem(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 11).toString());
				txtCpf.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 12).toString());
				txtRg.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 13).toString());				
			}
		});
		tabelaClientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Nome", "Email", "Celular", "Telefone Fixo", "CEP", "Endere\u00E7o",
						"Numero", "Bairro", "Cidade", "Complemento", "UF", "CPF", "RG" }));
		scrollPane.setViewportView(tabelaClientes);

		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LimpaTela(painelDadosPessoais);
			}
		});
		btnNewButton.setBounds(218, 332, 89, 23);
		contentPane.add(btnNewButton);

		JButton botaoSalvar = new JButton("Salvar");

		botaoSalvar.setBounds(317, 332, 89, 23);
		contentPane.add(botaoSalvar);
		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Clientes c = new Clientes();
					c.setNome(textNome.getText());
					c.setRg(txtRg.getText());
					c.setCpf(txtCpf.getText());
					c.setEmail(txtEmail.getText());
					c.setTelefone(txtTel.getText());
					c.setCelular(txtCelular.getText());
					c.setCep(txtCep.getText());
					c.setEndereco(txtEndereco.getText());
					c.setNumero(Integer.parseInt(txtNumero.getText()));
					c.setComplemento(txtComplemento.getText());
					c.setBairro(txtBairro.getText());
					c.setCidade(txtCidade.getText());
					c.setEstado(cbUf.getSelectedItem().toString());
					ClientesDAO dao = new ClientesDAO();
					dao.inserirCliente(c);
					listar();
					new LimpaTela(painelDadosPessoais);

				} catch (NumberFormatException erroFormat) {
					JOptionPane.showMessageDialog(null, "Verifique o formato dos Campos.");
					System.out.println(erroFormat);
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Erro!" + erro);
				}

			}
		});

		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Clientes c = new Clientes();
					c.setNome(textNome.getText());
					c.setRg(txtRg.getText());
					c.setCpf(txtCpf.getText());
					c.setEmail(txtEmail.getText());
					c.setTelefone(txtTel.getText());
					c.setCelular(txtCelular.getText());
					c.setCep(txtCep.getText());
					c.setEndereco(txtEndereco.getText());
					c.setNumero(Integer.parseInt(txtNumero.getText()));
					c.setComplemento(txtComplemento.getText());
					c.setBairro(txtBairro.getText());
					c.setCidade(txtCidade.getText());
					c.setEstado(cbUf.getSelectedItem().toString());
					c.setId(Long.parseLong(textCodigo.getText()));
					ClientesDAO dao = new ClientesDAO();
					dao.atualizarCliente(c);
					listar();
					new LimpaTela(painelDadosPessoais);

				} catch (NumberFormatException erroFormat) {
					JOptionPane.showMessageDialog(null, "Verifique o formato dos Campos.");
					System.out.println(erroFormat);
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Erro!" + erro);
				}
			}
		});
		botaoEditar.setBounds(416, 332, 89, 23);
		contentPane.add(botaoEditar);

		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Clientes c = new Clientes();
					c.setId(Long.parseLong(textCodigo.getText()));
					ClientesDAO dao = new ClientesDAO();
					dao.apagarCliente(c);
					listar();
					new LimpaTela(painelDadosPessoais);
				} catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Erro!" + erro);
				}
			}
		});
		botaoExcluir.setBounds(515, 332, 89, 23);
		contentPane.add(botaoExcluir);
	}
}