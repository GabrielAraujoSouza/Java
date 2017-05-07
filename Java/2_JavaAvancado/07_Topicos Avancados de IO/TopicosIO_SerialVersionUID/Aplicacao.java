import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		serialize();
		unserialize();
	}
	
	private static void serialize() throws Exception {
		Usuario u = new Usuario();
		u.setId(1);
		u.setNome("Usuário1");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuario.bin"));
		oos.writeObject(u);
		oos.close();
	}

	private static void unserialize() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.bin"));
		Usuario u = (Usuario) ois.readObject();
		ois.close();

		System.out.println(u.getId());
		System.out.println(u.getNome());
		
	}
}
