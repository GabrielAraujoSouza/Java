

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
	
	// Campo de digita��o do valor
	private JTextField valueTxt;
	
	// Campo de exibi��o do resultado ap�s a formata��o
	private JTextField resultTxt;

	public CurrencyViewer() {
		// Inicializa��o b�sica da janela
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 200);
		setTitle("Visualizador de Valores Monet�rios");
		
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
        
        // O m�todo getLocales() retorna os elementos a serem exibidos no combo box
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
        resultTxt.setEditable(false); // A caixa de texto do resultado n�o permite edi��o
        c.gridx = 1;  
        c.gridy = 2;  
        layout.setConstraints(resultTxt, c);  
        formPanel.add(resultTxt);
  
        add(BorderLayout.CENTER, formPanel);
		
		setVisible(true);
	}
	
	/*
	 * Este m�todo � chamado quando um locale � selecionado no combo box
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// Obt�m o valor digitado pelo usu�rio
		String value = valueTxt.getText();
		
		// Obt�m a string que representa o locale selecionada no combo box
		String localeStr = (String) localeCbo.getSelectedItem();
		
		// Converte a string para um objeto Locale
		Locale locale = Locale.forLanguageTag(localeStr);
		
		// Cria um objeto para formatar moedas com base no locale
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		
		try {
			// Formata o valor digitado pelo usu�rio
			String formattedValue = nf.format(Double.parseDouble(value));
			
			// Coloca o valor formatado na caixa de texto de resultado
			resultTxt.setText(formattedValue);
		
		} catch (NumberFormatException e) {
			// Se a convers�o do valor digitado pelo usu�rio em um double n�o for poss�vel,
			// deixa a caixa de texto do resultado em branco
			resultTxt.setText("");
		}
	}
	
	/*
	 * Este m�todo obt�m a lista de locales dispon�veis no Java
	 */
	private String[] getLocales() {
		// Obt�m a lista em forma de um array de Locale
		Locale[] locales = Locale.getAvailableLocales();
		
		// Criar um array de objetos String com o mesmo tamanho
		String[] localesStr = new String[locales.length];
		
		// Itera sobre cada locale, converte o locale em String e armazena no novo array
		for (int i = 0; i < locales.length; i++) {
			String lang = locales[i].getLanguage();
			String country = locales[i].getCountry();
			
			if (country.isEmpty()) {
				// Se o pa�s estiver em branco, mostra apenas a l�ngua
				localesStr[i] = lang;
			} else {
				// Sen�o mostra a l�ngua e o pa�s, com um h�fen no meio (IETF BCP 47)
				localesStr[i] = lang + "-" + country;
			}
		}
		
		// Ordena o array por ordem alfab�tica
		Arrays.sort(localesStr);
		
		// Retorna o array de objetos String
		return localesStr;
	}
	
	public static void main(String[] args) {
		new CurrencyViewer();
	}
}

