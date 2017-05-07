package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws Exception {
		
		//Cria o objeto
		Calculadora calc = new CalculadoraImpl();
		
		//Cria o registry service na porta 1099
		Registry r = LocateRegistry.createRegistry(1099);
		
		//A linha abaixo deve ser descomentada se Calculadora não estender UnicastRemoteObject
		//calc = (Calculadora) UnicastRemoteObject.exportObject(calc, 0);
		
		//Registra a calculadora no registry
		r.rebind("calculadora", calc);
		
		System.out.println("Aguardado requisições...");
	}
}
