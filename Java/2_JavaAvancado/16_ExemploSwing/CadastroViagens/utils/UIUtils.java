package curso.java.viagem.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JOptionPane;

/**
 * Classe com métodos utilitários para serem utilizados pela interface gráfica
 */
public class UIUtils {

	/**
	 * Centraliza a janela na tela
	 * @param window Janela a ser centralizada
	 */
	public static void centerWindow(Window window) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		// Obtém a resolução da tela
		Dimension screenSize = toolkit.getScreenSize();
		
		// Posiciona a janela no meio da tela, com base na resolução da tela
		window.setLocation(screenSize.width / 2 - window.getWidth() / 2, screenSize.height / 2 - window.getHeight() / 2);
	}
	
	/**
	 * Exibe uma caixa de diálogo de erro
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param e Exceção ocorrida. A mensagem da exceção será utilizada como mensagem na caixa de diálogo.
	 */
	public static void displayException(Component parent, Exception e) {
		// Imprime a exceção no console
		e.printStackTrace();
		
		// Exibe a caixa de diálogo
		JOptionPane.showMessageDialog(parent, e.getMessage(), "Exceção lançada", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa de diálogo de alerta
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param title Título da caixa de alerta.
	 * @param message Mensagem a ser exibida.
	 */
	public static void displayAlert(Component parent, String title, String message) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa de diálogo que exige confirmação do usuário
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param message Mensagem a ser exibida.
	 * @return true se o usuário escolheu a opção 'Sim'; false se escolheu 'Não'.
	 */
	public static boolean displayConfirmation(Component parent, String message) {
		int result = JOptionPane.showConfirmDialog(parent, message, "Confirme sua ação", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}
