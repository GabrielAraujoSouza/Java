import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class Server {

	private int port;
	private Selector selector;
	private ByteBuffer buffer;
	private String msg;
	
	public Server(int port) throws IOException {
		this.port = port;
		selector = Selector.open();
		buffer = ByteBuffer.allocate(1024);
	}
	
	public void start() throws Exception {
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while (true) {
			selector.select();
			
			Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
			
			while (iter.hasNext()) {
				SelectionKey key = iter.next();
				
				if (key.isAcceptable()) {
					connect(key);
				
				} else if (key.isReadable()) {
					read(key);
				
				} else if (key.isWritable()) {
					write(key);
				}
				
				iter.remove();
			}
		}
	}
	
	private void connect(SelectionKey key) throws IOException {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ);
	}
	
	private void read(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		buffer.clear();
		socketChannel.read(buffer);
		buffer.flip();
		byte[] bytes = new byte[buffer.remaining()];
		buffer.get(bytes);
		msg = new String(bytes);
		socketChannel.register(selector, SelectionKey.OP_WRITE);
	}
	
	private void write(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		
		msg = new StringBuilder(msg).reverse().toString();
		byte[] bytes = msg.getBytes();
		
		buffer.clear();
		buffer.put(bytes);
		buffer.flip();
		socketChannel.write(buffer);
		socketChannel.register(selector, 0);
	}
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(4646);
		server.start();
	}
}
