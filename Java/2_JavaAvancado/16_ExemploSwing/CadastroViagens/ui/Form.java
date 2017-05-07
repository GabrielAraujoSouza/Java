package curso.java.viagem.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Componente que representa o formul�rio de preenchimento de dados de viagem.
 */
public class Form {
	
	/**
	 * Layout utilizado pelo formul�rio
	 */
	private static final GridBagLayout layout = new GridBagLayout();

	/**
	 * Objeto GridBagConstraints, utilizado no posicionamento dos dados no formul�rio
	 */
	private GridBagConstraints c = new GridBagConstraints(0, 0, 1, 1, 0, 0,
            GridBagConstraints.LINE_END, GridBagConstraints.NONE,
            new Insets(2, 2, 2, 2), 0, 0);
	
	/**
	 * Linha do formul�rio
	 */
	private int gridY;
	
	/**
	 * Lista de componentes que fazem parte do formul�rio
	 */
	private List<Component> components = new ArrayList<Component>();
	
	/**
	 * Adiciona uma nova linha no formul�rio
	 * @param label Texto que identifica o campo
	 * @param field Componente que representa o campo a ser preenchido
	 * @param parent Container onde os componentes ser�o adicionados
	 */
	public void add(String label, Component field, Container parent) {
		// Adiciona o texto de identifica��o na primeira coluna
		c.gridx = 0;
		c.gridy = gridY;
		c.anchor = GridBagConstraints.NORTHEAST;
		JLabel labelComp = new JLabel(label);
		parent.add(labelComp, c); 
		
		// Adiciona o componente na segunda coluna da linha
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		
		if (field instanceof JTextArea) {
			// Se o componente for um JTextArea, adiciona ele dentro de um JScrollPane para que ele tenha 
			// barras de rolagem
			parent.add(new JScrollPane(field), c);
		} else {
			parent.add(field, c);
		}
		
		gridY++;
		
		components.add(labelComp);
		components.add(field);
	}
	
	/**
	 * Retorna o layout associado ao formul�rio
	 * @return Layout do formul�rio
	 */
	public LayoutManager getLayout() {
		return layout;
	}
	
	/**
	 * Habilita ou desabilita todos os componentes do formul�rio
	 * @param enabled true se for para habilitar, false para desabilitar
	 */
	public void setEnabled(boolean enabled) {
		// Itera sobre os componentes, mudando o seu estado
		for (Component component : components) {
			component.setEnabled(enabled);
		}
	}
	
	/**
	 * Limpa todos os dados do formul�rio
	 */
	public void clear() {
		// Para cada componente, faz o casting necess�rio e faz a limpeza dos textos
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			} else if (component instanceof JTextArea) {
				((JTextArea) component).setText("");
			} else if (component instanceof JComboBox) {
				((JComboBox) component).setSelectedIndex(-1);
			}
		}
	}
}
