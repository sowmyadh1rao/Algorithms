package Question5;

import java.util.Random;
import java.util.concurrent.RecursiveTask;


public class RecursiveFillZeroInArray extends RecursiveTask<double[][]> {
    private double[][] a;
    private int start, end;
    
    public RecursiveFillZeroInArray(double[][] a, int start, int end) {
        this.a = a;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected double[][] compute() {
    	if(start==end) {
    		Random r = new Random();
    		a[0][start]=r.nextDouble();
    		a[1][start]=0;
    	}else {
            // Recursive case: split the task into two subtasks
    		int mid=(start+end)/2;
    		RecursiveFillZeroInArray leftTask = new RecursiveFillZeroInArray(a, start, mid);
    		RecursiveFillZeroInArray rightTask = new RecursiveFillZeroInArray(a, mid+1, end);
    		
            leftTask.fork(); // Start the left task asynchronously
            a = rightTask.compute(); // Compute the right task
            a = leftTask.join(); // Wait for the left task to finish

        }
		return a;
    }
    
}
