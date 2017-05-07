package swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SairAction extends AbstractAction {

	/*
	 * Este método será invocado quando a opção 'Sair' do menu for utilizada
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
