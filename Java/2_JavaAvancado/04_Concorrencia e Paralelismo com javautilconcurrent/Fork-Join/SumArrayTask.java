
import java.util.concurrent.RecursiveTask;

public class SumArrayTask extends RecursiveTask<Integer> {
	
	private int[] array;
	private int minN;
	private int maxN;
	
	public SumArrayTask(int[] array, int minN, int maxN) {
		this.array = array;
		this.minN = minN;
		this.maxN = maxN;
	}

	@Override
	protected Integer compute() {
		int numElem = maxN - minN + 1;
		
		if (numElem < 4) {
			int partialSum = 0;
			for (int i = minN; i <= maxN; i++) {
				partialSum += array[i];
			}
			return partialSum;
		
		} else {
		
			int half = numElem / 2;
			
			SumArrayTask leftTask = new SumArrayTask(array, minN, minN + half);
			SumArrayTask rightTask = new SumArrayTask(array, minN + half + 1, maxN);
			
			leftTask.fork();
			
			int rightPartialSum = rightTask.compute();
			int leftPartialSum = leftTask.join();
			
			return leftPartialSum + rightPartialSum;
		}
	}

}
