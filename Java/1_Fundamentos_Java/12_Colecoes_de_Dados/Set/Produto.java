
public class Produto implements Comparable {

	private int id;
	
	public Produto(int id) {
		this.id = id;
	}
	
	public String toString() {
		return String.valueOf(id);
	}
	
	public boolean equals(Object obj) {
		Produto p = (Produto) obj;
		
		if (this.id == p.id) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		return String.valueOf(id).hashCode();
	}

	public int compareTo(Object o) {
		Produto p = (Produto) o;
		
		if (this.id == p.id) {
			return 0;
		} else if (this.id > p.id) {
			return 1;
		} else {
			return -1;
		}
	}
}
