package rmi;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception {
		
		//Recebe uma referência à calculadora instanciada remotamente
		Calculadora c = (Calculadora) Naming.lookup("rmi://localhost:1099/calculadora");
		
		//Chama os métodos remotos
		System.out.println(c.somar(100, 50));
		System.out.println(c.subtrair(30, 20));
	}
}
