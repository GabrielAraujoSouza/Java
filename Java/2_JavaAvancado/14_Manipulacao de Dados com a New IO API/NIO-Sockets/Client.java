import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class Client {
	
	private String host;
	private int port;
	private String msg;
	private String newMsg;
	private Selector selector;
	private boolean finished;
	private ByteBuffer buffer;

	public Client(String host, int port) throws Exception {
		this.host = host;
		this.port = port;
		this.selector = Selector.open();
		this.buffer = ByteBuffer.allocate(1024);
	}
	
	public String sendMessage(String msg) throws Exception {
		this.msg = msg;
		
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		
		socketChannel.connect(new InetSocketAddress(host, port));
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		
		while(!finished) {
			selector.select();
			
			Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
			
			while (iter.hasNext()) {
				SelectionKey key = iter.next();
				
				if (key.isConnectable()) {
					connect(key);
				} else if (key.isWritable()) {
					write(key);
				} else if (key.isReadable()) {
					read(key);
				}
				
				iter.remove();
			}
		}
		
		return newMsg;
	}
	
	private void connect(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		socketChannel.finishConnect();
		socketChannel.register(selector, SelectionKey.OP_WRITE);
	}
	
	private void write(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		
		byte[] bytes = msg.getBytes();
		buffer.clear();
		buffer.put(bytes);
		buffer.flip();
		socketChannel.write(buffer);
		socketChannel.register(selector, SelectionKey.OP_READ);
	}
	
	private void read(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		
		buffer.clear();
		socketChannel.read(buffer);
		buffer.flip();
		byte[] bytes = new byte[buffer.remaining()];
		buffer.get(bytes);
		newMsg = new String(bytes);
		socketChannel.close();
		finished = true;
	}
}
