import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;



public class Aplicacao {

	public static void main(String[] args) {
		
		//Conjunto de produtos
		Set<Produto> s1 = new HashSet<Produto>();
		
		//Cria��o de alguns produtos
		Produto p1 = new Produto(1);
		Produto p2 = new Produto(2);
		Produto p3 = new Produto(3);
		Produto p4 = new Produto(3);
		
		//Produtos sendo adicionados no conjunto
		//Como p3 e p4 possuem o mesmo ID, s�o considerados iguais (de acordo com a implementa��o do equals().
		//Logo, apenas um deles � adicionado
		s1.add(p1);
		s1.add(p2);
		s1.add(p3);
		s1.add(p4);
	
		//A implementa��o do m�todo toString() garante uma mensagem mais amig�vel ao usu�rio
		System.out.println(s1);
		
		//Conjunto de produtos, ordenado por ID
		//Ao adicionar os elementos, o m�todo compareTo() � chamado, ordenando os elementos
		Set<Produto> s2 = new TreeSet<Produto>();
		s2.add(p1);
		s2.add(p2);
		s2.add(p3);
		s2.add(p4);
		
		System.out.println(s2);
	}
}
