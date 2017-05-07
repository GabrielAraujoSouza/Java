package swing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Janela extends JFrame {

	public Janela() {
		setTitle("Minha Aplicacao");
		setSize(600, 300);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Cria a barra de menus
		JMenuBar menu = new JMenuBar();
		
		//Arquivo
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		
		//Editar
		JMenu menuEditar = new JMenu("Editar");
		
		//Arquivo/Novo
		JMenuItem itemNovo = new JMenuItem("Novo");
		itemNovo.setMnemonic('N');
		menuArquivo.add(itemNovo);
		
		//Arquivo/Sair
		JMenuItem itemSair = new JMenuItem(new SairAction());
		itemSair.setText("Sair");
		itemSair.setMnemonic('S');
		menuArquivo.add(itemSair);
		
		//Editar/Copiar
		JMenuItem itemCopiar = new JMenuItem("Copiar");
		itemCopiar.setMnemonic('C');
		menuEditar.add(itemCopiar);
		
		//Adiciona itens na barra de menus
		menu.add(menuArquivo);
		menu.add(menuEditar);
		
		setJMenuBar(menu);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Janela();
	}
}
