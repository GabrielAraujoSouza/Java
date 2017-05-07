
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) {
		
		int[] array = new int[100000000];
		Arrays.fill(array, 1);
		
		
		SumArrayTask task = new SumArrayTask(array, 0, array.length - 1);
		
		ForkJoinPool pool = new ForkJoinPool();
		int sum = pool.invoke(task);
		System.out.println(sum);
	}
}
