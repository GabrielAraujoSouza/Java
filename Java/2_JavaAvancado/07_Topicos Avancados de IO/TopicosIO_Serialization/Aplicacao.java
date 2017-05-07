import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		//Cria um usu�rio
		Usuario u1 = new Usuario();
		u1.setId(1);
		u1.setNome("Usu�rio1");
		
		//Cria um endere�o
		Endereco e1 = new Endereco();
		e1.setNumero(100);
		e1.setRua("Rua usu�rio 1");
		u1.setEndereco(e1);
		
		//Serializa os objetos
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuario.bin"));
		oos.writeObject(u1);
		oos.close();
		
		//L� os objetos serializados
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.bin"));
		Usuario u = (Usuario) ois.readObject();
		ois.close();
		
		//Mostra os dados dos objetos
		System.out.println(u.getId());
		System.out.println(u.getNome());
		System.out.println(u.getEndereco().getRua());
		System.out.println(u.getEndereco().getNumero());
	}
}
