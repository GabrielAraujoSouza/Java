import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db";

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "softblue", "softblue");
			
			stmt = conn.prepareStatement("SELECT id, nome, preco FROM Produto");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				//int id = rs.getInt("id");
				int id = rs.getInt(1);
				
				//String nome = rs.getString("nome");
				String nome = rs.getString(2);
				
				//double preco = rs.getDouble("preco");
				double preco = rs.getDouble(3);
				
				System.out.println("ID = " + id);
				System.out.println("Nome = " + nome);
				System.out.println("Preço = " + preco);
				System.out.println("-----------------");
			}
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
