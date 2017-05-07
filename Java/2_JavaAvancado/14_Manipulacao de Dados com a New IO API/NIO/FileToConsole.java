import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileToConsole {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = null;
		FileChannel inChannel = null;
		
		try {
			fis = new FileInputStream("in.txt");
			inChannel = fis.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(5);
			
			StringBuilder sb = new StringBuilder();
			while (true) {
				int bytesRead = inChannel.read(buffer);
				
				if (bytesRead < 0) {
					break;
				}
				
				buffer.flip();
				
				byte[] bytes = new byte[buffer.remaining()];
				buffer.get(bytes);
				
				String s = new String(bytes);
				sb.append(s);
				
				buffer.clear();
			}
			
			System.out.println(sb);
		
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (fis != null) {
				fis.close();
			}
		} 
	}
}
