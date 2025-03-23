package Question5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class CallingThread {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CallingThread m = new CallingThread();
		/*
		int[] a = {0,9,-7,5,7,4,12,-3};
		int[] b = {0,0,0,0,0,0,0,0};
		*/
		double n=0;
		double[][] a;
		Random r = new Random();
		
		PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\ssowm\\Desktop\\Algorithmoutput.txt"));

	      //output to the file a line
	    int parallelism = 0;
	     
		try{
		for(double i=3;i<=7;i++) {
			//if(i==3)break;
			 n=Math.pow(10, i);
			 out.println("N= "+n);
			
			// parallelism = (double) n;
			a=new double[2][(int) n];
			
			parallelism=(int) Math.round(n);
			
			out.println("Size of array A "+a[0].length);
			out.println("Size of array B "+a[1].length);
			
			for(int k=0;k<10;k++) {
				//if(k==1)break;
	        
			ForkJoinPool pool1 = new ForkJoinPool(10000);
			RecursiveFillZeroInArray task2 = new RecursiveFillZeroInArray(a, 0, a.length-1);
				
			a=pool1.invoke(task2);
			pool1.shutdown();
				
			/*
			for(int j=0;j<n;j++) {
			   a[j]=r.nextDouble();
			   b[j]=0;
		    }
		    */
			 
			/*
			 out.println("-------Before Sorting------- N= "+n);
			 out.println();
			 out.println();
			 out.println("Array A ");
			
			 for(int j=0;j<n;j++) { 
				 out.print(" "+a[j]);
			}
			 out.println();
			 out.println();
			 out.println("Array B ");
			
			for(int j=0;j<n;j++) {
				out.print(" "+b[j]);
			}
			*/
			
			long startTime = System.nanoTime();
			ForkJoinPool pool = new ForkJoinPool(10000);
			RecursiveDivideArray task1 = new RecursiveDivideArray(a[0], 0, a.length-1,a[1]);
			a[1]=pool.invoke(task1);
			pool.shutdown();
			
			long endTime = System.nanoTime();
			
			long elapsedTime = endTime - startTime;
			
			out.println();
			out.println();
			out.println("Loop "+k+" Time taken for N= "+n+" = "+elapsedTime);
			out.println("---------------------------------------");
			
			
			 /*
			 out.println();
			 out.println();
			 out.println("-------After Sorting------- N= "+n);
			

			 out.println();
			 out.println();
			 out.println("Array A ");
			for(int j=0;j<n;j++) { 
				   out.print(" "+a[j]);
			}
			 out.println();
			 out.println();
			 out.println("Array B ");
			
			for(int j=0;j<n;j++) {
				out.print(" "+b[j]);
			}
			*/
			
		}
		}
		out.close();
		}catch(Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}


