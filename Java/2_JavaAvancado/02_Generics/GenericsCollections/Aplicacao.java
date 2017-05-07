import java.util.ArrayList;
import java.util.List;


public class Aplicacao {

	public static void main(String[] args) {
		
		//A lista aceita apenas elementos do tipo string
		List<String> l = new ArrayList<String>();
		l.add("abc");
		l.add("def");
		l.add("ghi");
		
		//Ao iterar sobre a lista, o Java já sabe que cada item é uma string
		for (String s : l) {
			System.out.println(s);
		}
	}
}
