package br.com.felipe.view;

import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class FrmCliente extends JFrame {

	/**
	 * @author Felipe César
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField txtEmail;
	private MaskFormatter mascaraCelular;
	private MaskFormatter mascaraTelefoneFixo;
	private MaskFormatter mascaraCep;
	private MaskFormatter mascaraNumero;
	private MaskFormatter mascaraRg;
	private MaskFormatter mascaraCpf;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtNomePesquisa;
	private JTable table;

	public static void main(String[] args) {
		
		try {
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

	public FrmCliente() {
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
			mascaraNumero = new MaskFormatter("#######");
			mascaraRg = new MaskFormatter("#########");
			mascaraCpf = new MaskFormatter("###.###.###-##");

		} catch (java.text.ParseException excp) {
			JOptionPane.showMessageDialog(null, "Erro na formatação!");
		}

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 826, 60);
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

		JFormattedTextField txtFormatCelular = new JFormattedTextField(mascaraCelular);
		txtFormatCelular.setBounds(329, 77, 131, 20);
		painelDadosPessoais.add(txtFormatCelular);

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo:");
		lblTelefoneFixo.setBounds(476, 80, 78, 14);
		painelDadosPessoais.add(lblTelefoneFixo);

		JFormattedTextField txtFormatTel = new JFormattedTextField(mascaraTelefoneFixo);
		txtFormatTel.setBounds(555, 77, 162, 20);
		painelDadosPessoais.add(txtFormatTel);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 108, 44, 14);
		painelDadosPessoais.add(lblCep);

		JFormattedTextField txtCep = new JFormattedTextField(mascaraCep);
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

		JFormattedTextField txtFormatNumero = new JFormattedTextField(mascaraNumero);
		txtFormatNumero.setBounds(648, 105, 144, 20);
		painelDadosPessoais.add(txtFormatNumero);

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

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(735, 133, 57, 20);
		painelDadosPessoais.add(comboBox);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 167, 44, 14);
		painelDadosPessoais.add(lblRg);

		txtRg = new JFormattedTextField(mascaraRg);
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
		btnPesquisar.setBounds(259, 22, 89, 21);
		panel_1.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 782, 157);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Nome", "Email", "Celular", "Telefone Fixo", "CEP", "Endere\u00E7o",
						"Numero", "Bairro", "Cidade", "Complemento", "UF", "CPF", "RG" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Novo");
		btnNewButton.setBounds(218, 332, 89, 23);
		contentPane.add(btnNewButton);

		JButton button = new JButton("Salvar");
		button.setBounds(317, 332, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Editar");
		button_1.setBounds(416, 332, 89, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Excluir");
		button_2.setBounds(515, 332, 89, 23);
		contentPane.add(button_2);
	}
}