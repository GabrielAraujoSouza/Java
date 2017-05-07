

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyViewer extends JFrame implements ActionListener {
	
	// Combo box com os locales
	private JComboBox<String> localeCbo;
	
	// Campo de digitação do valor
	private JTextField valueTxt;
	
	// Campo de exibição do resultado após a formatação
	private JTextField resultTxt;

	public CurrencyViewer() {
		// Inicialização básica da janela
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 200);
		setTitle("Visualizador de Valores Monetários");
		
		// Cria um painel que usa um GridBagLayout para organizar os componentes
		GridBagLayout layout = new GridBagLayout();
		JPanel formPanel = new JPanel(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
		c.insets = new Insets(2, 2, 2, 2);
        
        JLabel valueLbl = new JLabel("Valor:");
        c.gridx = 0;  
        c.gridy = 0;  
        layout.setConstraints(valueLbl, c);  
        formPanel.add(valueLbl);
        
        valueTxt = new JTextField(15);
        c.gridx = 1;  
        c.gridy = 0;  
        layout.setConstraints(valueTxt, c);  
        formPanel.add(valueTxt);
        
        JLabel localeLbl = new JLabel("Locale:");
        c.gridx = 0;  
        c.gridy = 1;  
        layout.setConstraints(localeLbl, c);  
        formPanel.add(localeLbl);
        
        // O método getLocales() retorna os elementos a serem exibidos no combo box
        localeCbo = new JComboBox<String>(getLocales());
        localeCbo.addActionListener(this);
        c.gridx = 1;  
        c.gridy = 1;  
        layout.setConstraints(localeCbo, c);  
        formPanel.add(localeCbo);
        
        JLabel resultLbl = new JLabel("Resultado:");
        c.gridx = 0;  
        c.gridy = 2;  
        layout.setConstraints(resultLbl, c);  
        formPanel.add(resultLbl);
        
        resultTxt = new JTextField(15);
        resultTxt.setEditable(false); // A caixa de texto do resultado não permite edição
        c.gridx = 1;  
        c.gridy = 2;  
        layout.setConstraints(resultTxt, c);  
        formPanel.add(resultTxt);
  
        add(BorderLayout.CENTER, formPanel);
		
		setVisible(true);
	}
	
	/*
	 * Este método é chamado quando um locale é selecionado no combo box
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// Obtém o valor digitado pelo usuário
		String value = valueTxt.getText();
		
		// Obtém a string que representa o locale selecionada no combo box
		String localeStr = (String) localeCbo.getSelectedItem();
		
		// Converte a string para um objeto Locale
		Locale locale = Locale.forLanguageTag(localeStr);
		
		// Cria um objeto para formatar moedas com base no locale
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		
		try {
			// Formata o valor digitado pelo usuário
			String formattedValue = nf.format(Double.parseDouble(value));
			
			// Coloca o valor formatado na caixa de texto de resultado
			resultTxt.setText(formattedValue);
		
		} catch (NumberFormatException e) {
			// Se a conversão do valor digitado pelo usuário em um double não for possível,
			// deixa a caixa de texto do resultado em branco
			resultTxt.setText("");
		}
	}
	
	/*
	 * Este método obtém a lista de locales disponíveis no Java
	 */
	private String[] getLocales() {
		// Obtém a lista em forma de um array de Locale
		Locale[] locales = Locale.getAvailableLocales();
		
		// Criar um array de objetos String com o mesmo tamanho
		String[] localesStr = new String[locales.length];
		
		// Itera sobre cada locale, converte o locale em String e armazena no novo array
		for (int i = 0; i < locales.length; i++) {
			String lang = locales[i].getLanguage();
			String country = locales[i].getCountry();
			
			if (country.isEmpty()) {
				// Se o país estiver em branco, mostra apenas a língua
				localesStr[i] = lang;
			} else {
				// Senão mostra a língua e o país, com um hífen no meio (IETF BCP 47)
				localesStr[i] = lang + "-" + country;
			}
		}
		
		// Ordena o array por ordem alfabética
		Arrays.sort(localesStr);
		
		// Retorna o array de objetos String
		return localesStr;
	}
	
	public static void main(String[] args) {
		new CurrencyViewer();
	}
}

