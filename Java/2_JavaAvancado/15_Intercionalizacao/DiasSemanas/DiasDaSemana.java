
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DiasDaSemana extends JFrame implements ActionListener {
	
	// Criação dos objetos Locale
	private static final Locale LOCALE_US = new Locale("en", "US");
	private static final Locale LOCALE_BR = new Locale("pt", "BR");
	
	// Array de botões, onde cada um representa um dia da semana
	private JButton[] buttons = new JButton[7];
	
	// Botão de mudança de língua
	private JButton changeBtn;
	
	// Painel com os botões para os dias da semana
	private JPanel buttonsPanel;
	
	// Locale atual usado pelo ResourceBundle. Inicia com pt-BR
	private Locale currentLocale = LOCALE_BR;

	public DiasDaSemana() {
		// Definições básicas da janela
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 100);
		setLayout(new BorderLayout());
		
		// Inicializa o array de botões
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		
		// Cria o painel para os botões com layout de grade
		buttonsPanel = new JPanel(new GridLayout(1, 7, 2, 2));
		
		// Adiciona o painel no centro da tela
		add(BorderLayout.CENTER, buttonsPanel);
		
		// Cria o painel superior e adiciona o botão de mudança de língua
		JPanel changePanel = new JPanel();
		changeBtn = new JButton();
		changeBtn.addActionListener(this);
		changePanel.add(changeBtn);
		add(BorderLayout.NORTH, changePanel);
		
		// Define os textos da janela
		defineText();
		
		// Exibe a janela
		setVisible(true);
	}

	
	private void defineText() {
		// Obtém um ResourceBundle com base no Locale atual
		ResourceBundle bundle = ResourceBundle.getBundle("DiasDaSemana", currentLocale);
		
		// Define os textos para os dias da semana
		for (int i = 0; i < 7; i++) {
			String dow = bundle.getString(String.valueOf(i));
			buttons[i].setText(dow);
			buttonsPanel.add(buttons[i]);
		}
		
		// Define o texto para o botão de mudança de língua
		changeBtn.setText(bundle.getString("btn_mudar"));
		
		// Defino o título da janela
		setTitle(bundle.getString("titulo"));
	}

	/*
	 * Este método é chamado quando o botão de mudança de língua é acionado;
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Alterna o Locale corrente
		if (currentLocale == LOCALE_BR) {
			currentLocale = LOCALE_US;
		} else {
			currentLocale = LOCALE_BR;
		}
		
		// Redefine os textos na nova língua
		defineText();
	}
	
	public static void main(String[] args) {
		new DiasDaSemana();
	}
}
