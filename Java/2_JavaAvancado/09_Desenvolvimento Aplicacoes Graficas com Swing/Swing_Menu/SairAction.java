package swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SairAction extends AbstractAction {

	/*
	 * Este m�todo ser� invocado quando a op��o 'Sair' do menu for utilizada
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
