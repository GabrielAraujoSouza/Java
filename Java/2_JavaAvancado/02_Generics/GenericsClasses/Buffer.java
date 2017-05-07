import java.util.ArrayList;
import java.util.List;


//Cria uma classe buffer parametrizada usando generics
public class Buffer<T> {

	private List<T> lista = new ArrayList<T>();
	
	public void adicionar(T elemento) {
		lista.add(elemento);
	}
	
	public T remover() {
		T elemento = lista.get(0);
		lista.remove(0);
		return elemento;
	}
}
