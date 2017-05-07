package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {

	public int somar (int i, int j) throws RemoteException;
	public int subtrair (int i, int j) throws RemoteException;
}
