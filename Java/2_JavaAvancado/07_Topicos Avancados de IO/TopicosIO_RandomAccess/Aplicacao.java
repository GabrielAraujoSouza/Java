import java.io.RandomAccessFile;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		//Grava os dados no arquivo arq.bin
		RandomAccessFile rafw = new RandomAccessFile("arq.bin", "rw");

		rafw.writeDouble(10.0);
		rafw.writeBoolean(true);
		rafw.writeUTF("texto");
		rafw.close();
		
		//Lê os dados do arquivo arq.bin
		RandomAccessFile rafr = new RandomAccessFile("arq.bin", "r");
		
		//Posiciona o ponteiro na posição 8 (pula o double escrito no começo do arquivo)
		rafr.seek(8);
		
		boolean b = rafr.readBoolean();
		String s = rafr.readUTF();
		
		System.out.println(b);
		System.out.println(s);
	}
}
