import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Aplicacao {

	public static void main(String[] args) {
		
		/*
		 * Criação de um map do tipo HashMap. O HashMap poderia ser substituído por um LinkedHashMap 
		 * (mantém a ordem de inserção das chaves) ou um TreeMap (ordena as chaves).
		 */
		Map<Integer, Produto> m = new HashMap<Integer, Produto>();
		
		//Criação de produtos
		Produto p1 = new Produto("descricao1");
		Produto p2 = new Produto("descricao2");
		Produto p3 = new Produto("descricao3");
		
		//Coloca os produtos no map, cada um associado a uma chave numérica
		m.put(1, p1);
		m.put(2, p2);
		m.put(3, p3);
		
		//Retorna a lista de chaves do map
		Set<Integer> keys = m.keySet();
		
		//Retorna a lista de valores do map
		Collection<Produto> values = m.values();
		
		//Retorna as entradas do map (pares de chave e valor)
		Set<Map.Entry<Integer, Produto>> entries = m.entrySet();
		
		//Obtém um iterator sobre as entradas no map
		Iterator<Map.Entry<Integer, Produto>> iter = entries.iterator();
		
		//Itera sobre as entradas do map
		while(iter.hasNext()) {
			//Cada entrada possui uma chave e um valor
			Map.Entry<Integer, Produto> entry = iter.next();
			Integer key = entry.getKey();
			Produto value = entry.getValue();
			
			System.out.println(key + " => " + value);
		}
	}
}
