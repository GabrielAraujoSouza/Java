package curso.java.viagem.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JOptionPane;

/**
 * Classe com m�todos utilit�rios para serem utilizados pela interface gr�fica
 */
public class UIUtils {

	/**
	 * Centraliza a janela na tela
	 * @param window Janela a ser centralizada
	 */
	public static void centerWindow(Window window) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		// Obt�m a resolu��o da tela
		Dimension screenSize = toolkit.getScreenSize();
		
		// Posiciona a janela no meio da tela, com base na resolu��o da tela
		window.setLocation(screenSize.width / 2 - window.getWidth() / 2, screenSize.height / 2 - window.getHeight() / 2);
	}
	
	/**
	 * Exibe uma caixa de di�logo de erro
	 * @param parent Componente pai da caixa de di�logo. Se for fornecido, a caixa ser� alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param e Exce��o ocorrida. A mensagem da exce��o ser� utilizada como mensagem na caixa de di�logo.
	 */
	public static void displayException(Component parent, Exception e) {
		// Imprime a exce��o no console
		e.printStackTrace();
		
		// Exibe a caixa de di�logo
		JOptionPane.showMessageDialog(parent, e.getMessage(), "Exce��o lan�ada", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa de di�logo de alerta
	 * @param parent Componente pai da caixa de di�logo. Se for fornecido, a caixa ser� alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param title T�tulo da caixa de alerta.
	 * @param message Mensagem a ser exibida.
	 */
	public static void displayAlert(Component parent, String title, String message) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Exibe uma caixa de di�logo que exige confirma��o do usu�rio
	 * @param parent Componente pai da caixa de di�logo. Se for fornecido, a caixa ser� alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param message Mensagem a ser exibida.
	 * @return true se o usu�rio escolheu a op��o 'Sim'; false se escolheu 'N�o'.
	 */
	public static boolean displayConfirmation(Component parent, String message) {
		int result = JOptionPane.showConfirmDialog(parent, message, "Confirme sua a��o", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}
