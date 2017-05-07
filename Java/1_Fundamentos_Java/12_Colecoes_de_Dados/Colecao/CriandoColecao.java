
public class CriandoColecao {

	public static void main(String[] args) {
		
		//Cria uma coleção e adiciona itens
		MyCollection c = new MyCollection();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(8);
		c.add(9);
		c.add(10);
		c.add(11);
		c.add(12);
		
		//Percorre a coleção mostrando os itens
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
	}
}
