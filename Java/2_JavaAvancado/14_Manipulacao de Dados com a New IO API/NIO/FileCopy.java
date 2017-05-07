import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileCopy {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = null;
		FileChannel inChannel = null;
		
		FileOutputStream fos = null;
		FileChannel outChannel = null;
		
		try {
			fis = new FileInputStream("in.txt");
			inChannel = fis.getChannel();
			
			fos = new FileOutputStream("out.txt");
			outChannel = fos.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(5);
			
			while (true) {
				int bytesRead = inChannel.read(buffer);
				
				if (bytesRead < 0) {
					break;
				}
				
				buffer.flip();
				
				outChannel.write(buffer);
				
				buffer.clear();
			}
		
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (fis != null) {
				fis.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
			if (fos != null) {
				fos.close();
			}
		} 
	}
}
