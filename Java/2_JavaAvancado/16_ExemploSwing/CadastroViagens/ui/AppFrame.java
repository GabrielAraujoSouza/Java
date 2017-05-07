package curso.java.viagem.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import curso.java.viagem.dao.DAOException;
import curso.java.viagem.dao.ViagemDAO;
import curso.java.viagem.entity.Viagem;
import curso.java.viagem.entity.Viagem.Tipo;
import curso.java.viagem.utils.DateUtils;
import curso.java.viagem.utils.UIUtils;
import curso.java.viagem.utils.Validator;

/**
 * Janela da aplicação
 */
public class AppFrame extends JFrame implements ActionListener  {

	// Componentes do painel de pesquisa
	private JTextField txtSearchDataIda;
	private JButton btnSearch;
	private JButton btnClear;
	private JButton btnCreate;
	
	// Componentes do painel de dados
	private Form form;
	private JTextField txtDataIda;
	private JTextField txtDataVolta;
	private JComboBox cboTipo;
	private JTextArea txtInfo;
	
	// Componentes do painel de botões
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnExit;
	
	// DAO para fazer a interação com a tabela de viagem 
	private ViagemDAO viagemDAO = new ViagemDAO();
	
	// ID da viagem carregada
	private int viagemId;
	
	/**
	 * Construtor 
	 */
	public AppFrame() {
		// Chama o construtor da superclasse fornecendo o título
		super("Gerenciador de Viagens");
		
		// Define que a aplicação é terminada quando a janela é fechada
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Define o tamanho da janela
		setSize(600, 350);
		
		// Centraliza a janela
		UIUtils.centerWindow(this);
		
		// Define que a janela não pode ser redimensionada
		setResizable(false);
		
		// Define o layout da janela
		setLayout(new BorderLayout());
		
		// Cria o painel de pesquisa
		JPanel searchPanel = createSearchPanel();
		add(BorderLayout.NORTH, searchPanel);
		
		// Cria o painel de dados
		JPanel infoPanel = createInfoPanel();
		add(BorderLayout.CENTER, infoPanel);

		// Cria o painel de botões
		JPanel buttonPanel = createButtonPannel();
		add(BorderLayout.SOUTH, buttonPanel);
		
		// Limpa o estado dos componentes
		clear();
		
		// Exibe a janela
		setVisible(true);
	}
	
	/**
	 * Cria o painel de pesquisa
	 * @return Painel de pesquisa
	 */
	private JPanel createSearchPanel() {
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// Define a borda para o painel
		searchPanel.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
		
		searchPanel.add(new JLabel("Data de ida:"));
		
		txtSearchDataIda = new JTextField(10);
		txtSearchDataIda.addActionListener(this);
		searchPanel.add(txtSearchDataIda);
		
		btnSearch = new JButton("Pesquisar");
		btnSearch.addActionListener(this);
		searchPanel.add(btnSearch);
		
		btnClear = new JButton("Limpar");
		btnClear.addActionListener(this);
		searchPanel.add(btnClear);
		
		btnCreate = new JButton("Cadastrar");
		btnCreate.addActionListener(this);
		searchPanel.add(btnCreate);
	
		return searchPanel;
	}
	
	/**
	 * Cria o painel de dados
	 * @return Painel de dados
	 */
	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel();
		form = new Form();
		infoPanel.setLayout(form.getLayout());
		
		// Define uma borda para o painel
		infoPanel.setBorder(BorderFactory.createTitledBorder("Dados da Viagem"));
		
		txtDataIda = new JTextField(10);
		form.add("Data de ida:", txtDataIda, infoPanel);
		
		txtDataVolta = new JTextField(10);
		form.add("Data de volta:", txtDataVolta, infoPanel);
		
		// Cria um combo box cujos valores são os elementos do enum Viagem.Tipo
		cboTipo = new JComboBox(Viagem.Tipo.values());
		form.add("Tipo:", cboTipo, infoPanel);
		
		txtInfo = new JTextArea(5, 40);
		
		// Habilita a quebra de linha no JTextArea
		txtInfo.setWrapStyleWord(true);
		txtInfo.setLineWrap(true);
		
		form.add("Informações:", txtInfo, infoPanel);
		
		return infoPanel;
	}
	
	/**
	 * Cria o painel de botões
	 * @return Painel de botões
	 */
	private JPanel createButtonPannel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnSave = new JButton("Gravar");
		btnSave.addActionListener(this);
		buttonPanel.add(btnSave);
		
		btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(this);
		buttonPanel.add(btnDelete);
		
		btnExit = new JButton("Sair");
		btnExit.addActionListener(this);
		buttonPanel.add(btnExit);
		
		return buttonPanel;
	}
	
	/**
	 * Faz a limpeza dos dados dos componentes e arruma o estado dos componentes
	 */
	private void clear() {
		btnSearch.setEnabled(true);
		txtSearchDataIda.setText("");
		txtSearchDataIda.setEnabled(true);
		btnCreate.setEnabled(true);
		form.clear();
		form.setEnabled(false);
		btnSave.setEnabled(false);
		btnDelete.setEnabled(false);
		txtSearchDataIda.requestFocus();
		viagemId = 0;
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == btnSearch || source == txtSearchDataIda) {
			// O botão 'Procurar' foi pressionado ou um ENTER foi pressionado na caixa de texto de data de ida
			String dataIdaStr = txtSearchDataIda.getText();
			
			// Valida se a data a ser pesquisada é válida
			if (!Validator.validateDate(dataIdaStr)) {
				UIUtils.displayAlert(this, "Erro de Validação", "A data pesquisada não é válida");
				txtSearchDataIda.requestFocus();
				return;
			}
			
			Date dataIda = DateUtils.buildDateObject(dataIdaStr);
			try {
				// Carrega a viagem a partir da data desejada
				Viagem viagem = viagemDAO.findByDataIda(dataIda);
				if (viagem != null) {
					// Uma viagem foi encontrada
					
					// Popula o formulário com base na viagem carregada do banco de dados
					populateForm(viagem);
					
					// Arruma os estados dos botões
					btnCreate.setEnabled(false);
					form.setEnabled(true);
					btnSave.setEnabled(true);
					btnDelete.setEnabled(true);
					txtSearchDataIda.setEnabled(false);
					btnSearch.setEnabled(false);
				
				} else {
					// Nenhuma viagem foi encontrada
					UIUtils.displayAlert(this, "Registro não encontrado", "Não existe uma viagem nesta data");
				}
			
			} catch (DAOException e) {
				UIUtils.displayException(this, e);
			}
			
		} else if (source == btnDelete) {
			// O botão 'Excluir' foi pressionado
		
			// Abre uma janela de confirmação
			boolean delete = UIUtils.displayConfirmation(this, "Deseja excluir este registro?");
			
			if (delete) {
				try {
					// Exclui o registro com base no ID
					viagemDAO.delete(viagemId);
				} catch (DAOException e) {
					UIUtils.displayException(this, e);
				}
				
				// Volta a tela ao estado inicial
				clear();
				
				UIUtils.displayAlert(this, "Registro excluído", "O registro foi excluído com sucesso!");
			}
			
		} else if (source == btnSave) {
			// O botão 'Gravar' foi pressionado
			
			// Valida os dados preenchidos pelo usuário no formulário
			if (validateForm()) {
				// Cria um objeto Viagem e coloca dentro dele os dados digitados no formulário
				Viagem viagem = new Viagem();
				populateObject(viagem);
				
				try {	
					if (viagemId == 0) {
						// Verifica se já não existe uma viagem cadastrada com a data inicial digitada
						if (viagemDAO.existsViagem(viagem.getDataIda())) {
							UIUtils.displayAlert(this, "Registro existente", "Já existe uma viagem iniciada neste dia");
							return;
						}
						
						// Quando o ID é 0, a viagem deve ser criada
						viagemDAO.create(viagem);
						UIUtils.displayAlert(this, "Registro inserido", "O registro foi inserido com sucesso!");
					} else {
						// Quando o ID é diferente de 0, a viagem deve ser alterada
						viagemDAO.update(viagem);
						UIUtils.displayAlert(this, "Registro alterado", "O registro foi alterado com sucesso!");
					}
					
					clear();
				
				} catch (DAOException e) {
					UIUtils.displayException(this, e);
				}
			}
			
		} else if (source == btnCreate) {
			// O botão 'Cadastrar' foi pressionado. Ajuda os estados dos botões
			btnCreate.setEnabled(false);
			form.setEnabled(true);
			btnSave.setEnabled(true);
			txtSearchDataIda.setText("");
			txtSearchDataIda.setEnabled(false);
			btnSearch.setEnabled(false);
			btnCreate.setEnabled(false);
			txtDataIda.requestFocus();
			
		} else if (source == btnClear) {
			// O botão 'Limpar' foi pressionado. Volta a tela ao estado original
			clear();
		
		} else if (source == btnExit) {
			// O botão 'Sair' foi pressionado. Fecha a janela, o que encerra a aplicação
			dispose();
		}
	}
	
	/**
	 * Popula os dados do formulário com os dados existentes no objeto Viagem
	 * @param viagem Objeto onde estão os dados
	 */
	private void populateForm(Viagem viagem) {
		viagemId = viagem.getId();
		txtDataIda.setText(DateUtils.getDateAsString(viagem.getDataIda()));
		txtDataVolta.setText(DateUtils.getDateAsString(viagem.getDataVolta()));
		cboTipo.setSelectedItem(viagem.getTipo());
		txtInfo.setText(viagem.getInfo());
	}
	
	/**
	 * Popula o objeto Viagem com base nos dados digitados no formulário
	 * @param viagem Objeto a ser populado
	 */
	private void populateObject(Viagem viagem) {
		viagem.setId(viagemId);
		viagem.setDataIda(DateUtils.buildDateObject(txtDataIda.getText()));
		viagem.setDataVolta(DateUtils.buildDateObject(txtDataVolta.getText()));
		viagem.setTipo((Tipo) cboTipo.getSelectedItem());
		viagem.setInfo(txtInfo.getText());
	}
	
	/**
	 * Valida os dados preenchidos no formulário
	 * @return true se o formulário é válido; false, caso contrário
	 */
	private boolean validateForm() {
		String dataIda = txtDataIda.getText();
		String dataVolta = txtDataVolta.getText();
		Viagem.Tipo tipo = (Viagem.Tipo) cboTipo.getSelectedItem();
		String info = txtInfo.getText();
		
		// Valida se a data de ida foi preenchida
		if (!Validator.validateRequired(dataIda)) {
			UIUtils.displayAlert(this, "Erro de validação", "A data de ida deve ser fornecida");
			txtDataIda.requestFocus();
			return false;
		}
		
		// Valida se a data de ida é válida
		if (!Validator.validateDate(dataIda)) {
			UIUtils.displayAlert(this, "Erro de validação", "A data de ida não é válida");
			txtDataIda.requestFocus();
			return false;
		}
		
		// Valida se a data de volta foi preenchida
		if (!Validator.validateRequired(dataVolta)) {
			UIUtils.displayAlert(this, "Erro de validação", "A data de volta deve ser fornecida");
			txtDataVolta.requestFocus();
			return false;
		}
		
		// Valida se a data de volta é válida
		if (!Validator.validateDate(dataVolta)) {
			UIUtils.displayAlert(this, "Erro de validação", "A data de volta não é válida");
			txtDataVolta.requestFocus();
			return false;
		}
		
		// Valida se o tipo da viagem foi preenchido
		if (!Validator.validateRequired(tipo)) {
			UIUtils.displayAlert(this, "Erro de validação", "O tipo não foi selecionado");
			txtInfo.requestFocus();
			return false;
		}
		
		// Valida se as informações da viagem não ultrapassa o número máximo de caracteres
		if (!Validator.validateMaxLength(info, 250)) {
			UIUtils.displayAlert(this, "Erro de validação", "As informações não podem exceder 250 caracteres");
			txtInfo.requestFocus();
			return false;
		}
		
		Date data1 = DateUtils.buildDateObject(dataIda);
		Date data2 = DateUtils.buildDateObject(dataVolta);
		
		// Valida se a data de volta é maior ou igual à data de ida
		if (data1.after(data2)) {
			UIUtils.displayAlert(this, "Erro de validação", "A data de volta não pode ser menor que a de ida");
			txtDataVolta.requestFocus();
			return false;
		}
		
		return true;
	}
}
