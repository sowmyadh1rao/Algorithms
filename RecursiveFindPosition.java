package Question5;

import java.util.concurrent.RecursiveTask;

public class RecursiveFindPosition extends RecursiveTask<Integer> {
	    private double[] a;
	    private int start, end;
	    private double number;
	    
	    public RecursiveFindPosition(double[] a, int start, int end,double number) {
	        this.a = a;
	        this.start = start;
	        this.end = end;
	        this.number=number;
	    }
	    
	    @Override
	    protected Integer compute() {
	    	int position1=-1;
			int position2=-1;
			
			if(start==end) {
				if(a[start]<number) {
					return 1; 
				}
				else return 0;
			}else {
	            // Recursive case: split the task into two subtasks
	            int mid = start + (end - start) / 2;
	            RecursiveFindPosition leftTask = new RecursiveFindPosition(a, start, mid,number);
	            RecursiveFindPosition rightTask = new RecursiveFindPosition(a, mid+1, end,number);

	            leftTask.fork(); // Start the left task asynchronously
	            position1 = rightTask.compute(); // Compute the right task
	            position2 = leftTask.join(); // Wait for the left task to finish

	            return position1 + position2; // Combine results
	        }
	    }
}
